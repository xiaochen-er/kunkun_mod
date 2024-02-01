package com.mod.kun_kun_mod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
//物品重写
//该项目为重写一个物品属性，以下项目为手持重写物品右键固定方块使其有概率变为其他方块
public class Ge_Ge_Item extends Item {
    public Ge_Ge_Item(Properties Properties) {
        super(Properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();//事件
        if (!world.isRemote){
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());//判断空值，避免出错
            chageBlock(context,playerEntity,context.getWorld());
            stack.damageItem(0,playerEntity,player -> player.sendBreakAnimation(context.getHand()));
        }//damageItem=使用一次损坏多少耐久度
        return super.onItemUseFirst(stack, context);
    }

    private void chageBlock(ItemUseContext context, PlayerEntity playerEntity, World world) {
        BlockPos blockPos = context.getPos();
        BlockState blockState1 = Blocks.BEDROCK.getDefaultState();// BEDROCK=基岩，鸽鸽拥有强大的力量，能有概率将草方块变成基岩
        BlockState blockState2 = world.getBlockState(blockPos);
        if (random.nextFloat() > 0.025F) {//random=概率
            madeEntitySlow(playerEntity);// GRASS_BLOCK=草方块，GRASS_PATH=草径，意思是通过方法把草块变成草径
        } else if (blockState2.getBlock() == Blocks.GRASS_BLOCK) {
            world.setBlockState(blockPos,blockState1);
        }
    }

    private void madeEntitySlow(PlayerEntity playerEntity) {
        playerEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS,500));//给予buff属性 持续时间 20tik=1s
    }

    //物品信息
    @Override
    public void addInformation(ItemStack itemStack, @Nullable World world, List<ITextComponent> textComponents, ITooltipFlag tooltipFlag) {
        if (Screen.hasControlDown()){//按下指定按键时（Screen.has）
            textComponents.add(new TranslationTextComponent("tooltip.kun_kun_mod.ge_ge_item_ctrl"));//按下Ctrl时显示
        }else {
            textComponents.add(new TranslationTextComponent("tooltip.kun_kun_mod.ge_ge_item"));//默认状态下显示
        }
        super.addInformation(itemStack, world, textComponents, tooltipFlag);
    }
}
