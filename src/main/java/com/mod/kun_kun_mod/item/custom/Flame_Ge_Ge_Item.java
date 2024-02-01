package com.mod.kun_kun_mod.item.custom;

import com.mod.kun_kun_mod.util.KunKunTags;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class Flame_Ge_Ge_Item extends Item {

    public Flame_Ge_Ge_Item(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        if (!world.isRemote){
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());//判断空值，避免出错
            BlockState blockState = world.getBlockState(context.getPos());
            lightFire(blockState,context,playerEntity);
            stack.damageItem(1,playerEntity,player -> player.sendBreakAnimation(context.getHand()));
        }//damageItem=使用一次损坏多少耐久度
        return super.onItemUseFirst(stack, context);
    }

    private static void lightFire(BlockState blockState, ItemUseContext context, PlayerEntity playerEntity) {
        boolean playerEntityNotOnFire = !playerEntity.isBurning();//判断实体是否着火
        if (random.nextFloat() > 0.5f){//random=概率
            lightEntityOnFire(playerEntity,10);//点燃实体时间
        } else if (playerEntityNotOnFire && blockIsRight(blockState)) {
            gainFRAndDB(playerEntity,context.getWorld(),context.getPos());
        }else {
            lightGround(context);
        }
    }

    private static void lightGround(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();

        BlockPos blockpos1 = blockpos.offset(context.getFace());
        if (AbstractFireBlock.canLightBlock(world, blockpos1, context.getPlacementHorizontalFacing())) {
            world.playSound(playerentity, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);

            BlockState blockstate1 = AbstractFireBlock.getFireForPlacement(world, blockpos1);
            world.setBlockState(blockpos1, blockstate1, 11);

        }//点燃地面方法，打火石点火代码
    }

    private static void gainFRAndDB(PlayerEntity playerEntity, World world, BlockPos pos) {
        playerEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,500));//给予buff属性 持续时间 20tik=1s
        world.destroyBlock(pos,true);//破坏后是否掉落方块
    }

    private static boolean blockIsRight(BlockState blockState) {
        return blockState.isIn(KunKunTags.Blocks.J_N_T_M_BLOCK);
    }//isIn = 判断是否在文件内 注册Tags使用

    public static void lightEntityOnFire(Entity entity, int second) {
        entity.setFire(second);//点燃实体  可被其他调用
    }

    //物品信息
    @Override
    public void addInformation(ItemStack itemStack, @Nullable World world, List<ITextComponent> textComponents, ITooltipFlag tooltipFlag)
    {
        if (Screen.hasShiftDown()){//按下指定按键时（Screen.has）
            textComponents.add(new TranslationTextComponent("tooltip.kun_kun_mod.ge_ge_item_shift"));//按下Shift时显示
        }
        if (Screen.hasControlDown()){//按下指定按键时（Screen.has）
            textComponents.add(new TranslationTextComponent("tooltip.kun_kun_mod.ge_ge_item_ctrl"));//按下Ctrl时显示
        }

        if (Screen.hasAltDown()){//按下指定按键时（Screen.has）
            textComponents.add(new TranslationTextComponent("tooltip.kun_kun_mod.ge_ge_item_alt"));//按下Alt时显示
        }
        else {
            textComponents.add(new TranslationTextComponent("tooltip.kun_kun_mod.ge_ge_item"));//默认状态下显示
        }
        super.addInformation(itemStack, world, textComponents, tooltipFlag);
    }
}
