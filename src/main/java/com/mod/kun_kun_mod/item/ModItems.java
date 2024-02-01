package com.mod.kun_kun_mod.item;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mod.kun_kun_mod.block.ModBlocks;
import com.mod.kun_kun_mod.item.custom.Flame_Ge_Ge_Item;
import com.mod.kun_kun_mod.item.custom.Ge_Ge_Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
//模组物品添加表
public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Kun_Kun_Mod.MOD_ID);

    //模组物品
    public static final RegistryObject<Item> GE_GE_ITEM = ITEMS.register("ge_ge_item",
            () -> new Ge_Ge_Item(new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> FLAME_GE_GE_ITEM = ITEMS.register("flame_ge_ge_item",
            () -> new Flame_Ge_Ge_Item(new Item.Properties().group(ModTab.LI_ZHI_TAB).maxDamage(500)));
    //模组工具
    public static final RegistryObject<Item> GE_GE_SWORD = ITEMS.register("tools/ge_ge_sword",//单独建立tools文件夹存放模型
            () -> new SwordItem(ModItemTier.GE_GE_TIER,21,21.0F,new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> GE_GE_PICKAXE = ITEMS.register("tools/ge_ge_pickaxe",
            () -> new PickaxeItem(ModItemTier.GE_GE_TIER,6,-1.5F,new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> GE_GE_AXE = ITEMS.register("tools/ge_ge_axe",
            () -> new AxeItem(ModItemTier.GE_GE_TIER,26,-1.5F,new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> GE_GE_SHOVEL = ITEMS.register("tools/ge_ge_shovel",
            () -> new ShovelItem(ModItemTier.GE_GE_TIER,6,-1.5F,new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> GE_GE_HOE = ITEMS.register("tools/ge_ge_hoe",
            () -> new HoeItem(ModItemTier.GE_GE_TIER,6,-1.5F,new Item.Properties().group(ModTab.GE_GE_TAB)));
    //模组盔甲
    public static final RegistryObject<Item> GE_GE_HELMET = ITEMS.register("equip/ge_ge_helmet",
            () -> new ArmorItem(ModArmorMaterial.GE_GE_ARMOR, EquipmentSlotType.HEAD,new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> GE_GE_CHESTPLATE = ITEMS.register("equip/ge_ge_chestplate",
            () -> new ArmorItem(ModArmorMaterial.GE_GE_ARMOR, EquipmentSlotType.CHEST,new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> GE_GE_LEGGINGS = ITEMS.register("equip/ge_ge_leggings",
            () -> new ArmorItem(ModArmorMaterial.GE_GE_ARMOR, EquipmentSlotType.LEGS,new Item.Properties().group(ModTab.GE_GE_TAB)));
    public static final RegistryObject<Item> GE_GE_BOOTS = ITEMS.register("equip/ge_ge_boots",
            () -> new ArmorItem(ModArmorMaterial.GE_GE_ARMOR, EquipmentSlotType.FEET,new Item.Properties().group(ModTab.GE_GE_TAB)));
    //模组马铠
    public static final RegistryObject<Item> GE_GE_HORSE_ARMOR = ITEMS.register("ge_ge_horse_armor",
            () -> new HorseArmorItem(25,"ge_ge",new Item.Properties().group(ModTab.GE_GE_TAB)));
    //模组农作物
    public static final RegistryObject<Item> LI_ZHI_TREE = ITEMS.register("li_zhi_tree",
            () -> new BlockItem(ModBlocks.LI_ZHI_TREE.get(),new Item.Properties().food(new Food.Builder()
                    .hunger(5)//回复饱食度
                    .saturation(0.1F).effect(new EffectInstance(Effects.SPEED,2400,2),0.5F)//效果类型/持续时间除以20/效果等级 + 1/概率
                    .fastToEat()//快速食用
                    .build()//结束时加上该段
            ).group(ModTab.LI_ZHI_TAB)));
    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
