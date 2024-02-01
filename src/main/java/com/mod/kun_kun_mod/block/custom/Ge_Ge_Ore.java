package com.mod.kun_kun_mod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class Ge_Ge_Ore extends Block {
    public Ge_Ge_Ore(Properties Properties) {
        super(Properties);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return 25;//给与掉落经验
    }
}
