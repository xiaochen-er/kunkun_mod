package com.mod.kun_kun_mod.world.gen;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

//树的世界生成参数
public class ModTreeGeneration {
    public static void generateTrees(final BiomeLoadingEvent event){
        RegistryKey<Biome>key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY,event.getName());//获取生物群系的键值
        Set<BiomeDictionary.Type>types = BiomeDictionary.getTypes(key);
        if (types.contains(BiomeDictionary.Type.PLAINS)){//types.contains包含,生成在平原上
            List<Supplier<ConfiguredFeature<?,?>>>base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            base.add(() -> ModConfiguredFeatures.LI_ZHI_SAPLING
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .withPlacement(Placement.COUNT_EXTRA.configure(
                            new AtSurfaceWithExtraConfig(1,0.25F,2)
                    )));
        }
    }
}
