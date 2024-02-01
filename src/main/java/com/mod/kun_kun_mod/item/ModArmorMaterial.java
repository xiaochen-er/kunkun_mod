package com.mod.kun_kun_mod.item;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    //new int[] { 2, 5, 6, 2} 靴子，护腿，胸甲，头盔 图标/2 顺序不变     SoundEvents.盔甲声音
    LI_ZHI_ARMOR("li_zhi_armor", 7, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0F, 0.0F, () -> {
        return Ingredient.fromItems(ModItems.LI_ZHI_TREE.get());
    }),
    GE_GE_ARMOR("ge_ge_armor", 50, new int[]{5, 10, 15, 5}, 25, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.5F, 2.5F, () -> {
        return Ingredient.fromItems(ModItems.GE_GE_ITEM.get());
    });

    private static final int[] MAX_GE_GE_ARRAY = new int[]{15, 20, 25, 10};//耐久基础值
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue(repairMaterial);
    }

    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_GE_GE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return (Ingredient)this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return Kun_Kun_Mod.MOD_ID+":"+this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
