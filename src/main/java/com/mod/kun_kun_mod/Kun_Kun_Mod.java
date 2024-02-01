package com.mod.kun_kun_mod;

import com.google.common.collect.ImmutableMap;
import com.mod.kun_kun_mod.block.ModBlocks;
import com.mod.kun_kun_mod.block.ModTree;
import com.mod.kun_kun_mod.item.ModItems;
import com.mod.kun_kun_mod.tileentity.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Kun_Kun_Mod.MOD_ID)
public class Kun_Kun_Mod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "kun_kun_mod";

    public Kun_Kun_Mod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTree.register(eventBus);
        ModTileEntities.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        event.enqueueWork(()->{
            AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block,Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)//斧头去皮方法
                    .put(ModTree.LI_ZHI_LOG.get(),ModTree.STRIPPED_LI_ZHI_LOG.get())
                    .put(ModTree.LI_ZHI_WOOD.get(),ModTree.STRIPPED_LI_ZHI_WOOD.get()).build();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(()->{
            RenderTypeLookup.setRenderLayer(ModBlocks.GE_GE_DOOR.get(),RenderType.getCutout());//门
            RenderTypeLookup.setRenderLayer(ModBlocks.GE_GE_TRAPDOOR.get(),RenderType.getCutout());//活板门
            RenderTypeLookup.setRenderLayer(ModBlocks.LI_ZHI_TREE.get(),RenderType.getCutout());//农作物
            RenderTypeLookup.setRenderLayer(ModTree.LI_ZHI_LEAVES.get(),RenderType.getCutout());//树叶
            RenderTypeLookup.setRenderLayer(ModTree.LI_ZHI_SAPLING.get(),RenderType.getCutout());//树苗
            RenderTypeLookup.setRenderLayer(ModTree.LI_ZHI_FLOWER.get(),RenderType.getCutout());//花
        });//需要单独渲染
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("kun_kun_mod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
