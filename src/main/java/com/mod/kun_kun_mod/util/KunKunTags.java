package com.mod.kun_kun_mod.util;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class KunKunTags {
    //注册forgeTags可被其他模组调用，也可在合成表配方中调用
    //方块Tags
    public static class Blocks{
        //使用Tags
        public static final Tags.IOptionalNamedTag<Block> J_N_T_M_BLOCK =createTag("j_n_t_m_block");//minecraft Tags
        //注册Tags
        private static Tags.IOptionalNamedTag<Block> createTag(String name){//注册给minecraft的tags
            return BlockTags.createOptional(new ResourceLocation(Kun_Kun_Mod.MOD_ID,name));//资源文件夹的定位
        }
        private static Tags.IOptionalNamedTag<Block> createForgeTag(String name){//注册给forge的tags
            return BlockTags.createOptional(new ResourceLocation("forge",name));//资源文件夹的定位
        }
    }
    //物品Tags

    public static class Items{
        //使用Tags
        public static final Tags.IOptionalNamedTag<Item> GE_GE_ITEM =createForgeTag("ge_ge/ge_ge_item");//forge Tags,json文件可细分目录如: 文件/物品 = ge_ge/ge_ge_item
        //注册Tags
        private static Tags.IOptionalNamedTag<Item> createTag(String name){//注册给minecraft的tags
            return ItemTags.createOptional(new ResourceLocation(Kun_Kun_Mod.MOD_ID,name));//资源文件夹的定位,data.kun_kun_mod
        }
        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name){//注册给forge的tags
            return ItemTags.createOptional(new ResourceLocation("forge",name));//资源文件夹的定位,data.forge
        }
    }
}
