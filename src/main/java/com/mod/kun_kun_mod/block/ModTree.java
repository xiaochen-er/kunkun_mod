package com.mod.kun_kun_mod.block;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mod.kun_kun_mod.block.custom.trees.Li_zhi_tree;
import com.mod.kun_kun_mod.item.ModItems;
import com.mod.kun_kun_mod.item.ModTab;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModTree {
    public static final DeferredRegister<Block> BLOCKS =DeferredRegister.create(ForgeRegistries.BLOCKS, Kun_Kun_Mod.MOD_ID);
    //模组树木，斧头去皮方法在Kun_Kun_Mod中添加
    public static final RegistryObject<Block> LI_ZHI_WOOD = registerBlock("trees/li_zhi_wood",//木头
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.ACACIA_WOOD)
                    .harvestLevel(0)// 挖掘等级
                    .harvestTool(ToolType.AXE)// 挖掘工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    public static final RegistryObject<Block> LI_ZHI_LOG = registerBlock("trees/li_zhi_log",//原木
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.ACACIA_LOG)
                    .harvestLevel(0)// 挖掘等级
                    .harvestTool(ToolType.AXE)// 挖掘工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    public static final RegistryObject<Block> LI_ZHI_PLANKS = registerBlock("trees/li_zhi_planks",//木板
            () -> new Block(AbstractBlock.Properties.from(Blocks.ACACIA_PLANKS)
                    .harvestLevel(0)// 挖掘等级
                    .harvestTool(ToolType.AXE)// 挖掘工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    public static final RegistryObject<Block> STRIPPED_LI_ZHI_WOOD = registerBlock("trees/stripped_li_zhi_wood",//去皮木头
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_ACACIA_LOG)
                    .harvestLevel(0)// 挖掘等级
                    .harvestTool(ToolType.AXE)// 挖掘工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    public static final RegistryObject<Block> STRIPPED_LI_ZHI_LOG = registerBlock("trees/stripped_li_zhi_log",//去皮原木
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_ACACIA_LOG)
                    .harvestLevel(0)// 挖掘等级
                    .harvestTool(ToolType.AXE)// 挖掘工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    public static final RegistryObject<Block> LI_ZHI_LEAVES = registerBlock("trees/li_zhi_leaves",//树叶
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F,6.0F)// 硬度 爆炸抗性
                    .tickRandomly()//tick随机
                    .sound(SoundType.PLANT)//树叶放置声音
                    .notSolid()//非实心
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    public static final RegistryObject<Block> LI_ZHI_SAPLING = registerBlock("trees/li_zhi_sapling",//树苗
            () -> new SaplingBlock(new Li_zhi_tree(),AbstractBlock.Properties.from(Blocks.ACACIA_SAPLING)
                    .sound(SoundType.METAL)// 声音
                    .notSolid()//非实心
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //花
    public static final RegistryObject<Block> LI_ZHI_FLOWER = registerBlock("li_zhi_flower",//花
            () -> new FlowerBlock(Effects.HASTE,2, AbstractBlock.Properties.from(Blocks.DANDELION)
                    .notSolid()//非实心
            ));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> tRegistryObject = BLOCKS.register(name,block);
        registerBlockItem(name,tRegistryObject);
        return tRegistryObject;
    }

    private static <T extends Block> void registerBlockItem(String name,Supplier<T> block){
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties().group(ModTab.GE_GE_TAB)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}


