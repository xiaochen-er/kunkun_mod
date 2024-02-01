package com.mod.kun_kun_mod.world.gen;

import com.mod.kun_kun_mod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {
    GE_GE_ORE(Lazy.of(ModBlocks.GE_GE_ORE),8,25,50);
    private final Lazy<Block> block;
    private final int maxVeinSize;//矿脉大小
    private final int minHeight;//最小生成高度
    private final int maxHeight;//最大生成高度
    OreType(Lazy<Block> block,int maxVeinSize,int minHeight,int maxHeight){
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
    public Lazy<Block> getBlock(){return block;}
    public int getMaxVeinSize(){return maxVeinSize;}
    public int getMinHeight(){return minHeight;}
    public int getMaxHeight() {return maxHeight;}
    public static OreType get(Block block){
        for (OreType ore : values()){
            if(block == ore.block){
                return ore;
            }
        }
        return null;
    }
}
