package com.mod.kun_kun_mod.block.custom;

import com.mod.kun_kun_mod.item.custom.Flame_Ge_Ge_Item;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Flame_Ge_Ge_Block extends Block {
    public Flame_Ge_Ge_Block(Properties Properties) {
        super(Properties);
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {//Entity entity 所有实体
        Flame_Ge_Ge_Item.lightEntityOnFire(entity,10);//时间 / 调用Flame_Ge_Ge_Item的点燃实体
        super.onEntityWalk(world,pos,entity);
    }
}
