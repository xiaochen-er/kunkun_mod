package com.mod.kun_kun_mod.world.gen;

import com.mod.kun_kun_mod.block.ModTree;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;

//树苗种植
public class ModConfiguredFeatures {
    //树的生成，套用金合欢树的生成代码
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LI_ZHI_SAPLING = register("li_zhi_sapling",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder
            (new SimpleBlockStateProvider(ModTree.LI_ZHI_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModTree.LI_ZHI_LEAVES.get().getDefaultState()),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(5, 2, 2),
                    new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build()));
    //花的生成
    public static final ConfiguredFeature<?, ?> LI_ZHI_FLOWER = register("li_zhi_flower",
            Feature.FLOWER.withConfiguration(
            (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModTree.LI_ZHI_FLOWER.get().getDefaultState()),
                    SimpleBlockPlacer.PLACER))
                    .tries(64).build())
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(2));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return (ConfiguredFeature) Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
