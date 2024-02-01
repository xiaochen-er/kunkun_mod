package com.mod.kun_kun_mod.tileentity;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mod.kun_kun_mod.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(
            ForgeRegistries.TILE_ENTITIES, Kun_Kun_Mod.MOD_ID);

    public static final RegistryObject<TileEntityType<BoxTileEntity>> BOX_TILE_ENTITY = TILE_ENTITY.register(
            "box_tile_entity",() ->TileEntityType.Builder.create(BoxTileEntity::new,ModBlocks.BOX.get()).build(null));

    public static void register(IEventBus eventBus){
        TILE_ENTITY.register(eventBus);
    }
}
