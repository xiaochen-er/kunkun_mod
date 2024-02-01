package com.mod.kun_kun_mod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
//创造模式物品栏
public class ModTab {
    public static final ItemGroup GE_GE_TAB = new ItemGroup("ge_ge_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.GE_GE_ITEM.get());
        }
    };
    public static final ItemGroup LI_ZHI_TAB = new ItemGroup("li_zhi_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.LI_ZHI_TREE.get());
        }
    };
}
