package com.mod.kun_kun_mod.block.custom.trees;

import com.mod.kun_kun_mod.world.gen.ModConfiguredFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class Li_zhi_tree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean b) {
        return ModConfiguredFeatures.LI_ZHI_SAPLING;
    }
}
