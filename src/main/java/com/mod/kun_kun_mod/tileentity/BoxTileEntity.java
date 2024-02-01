package com.mod.kun_kun_mod.tileentity;

import com.mod.kun_kun_mod.block.custom.BoxBlock;
import com.mod.kun_kun_mod.Kun_Kun_Mod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BoxTileEntity extends BasicLootTileEntity{
    private int playerCount;//判断玩家锁定数量，比如有多少人打开了箱子

    protected BoxTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }
    public BoxTileEntity(){
        super(ModTileEntities.BOX_TILE_ENTITY.get());
    }

    @Override
    protected ITextComponent getDefaultName() {//显示在GUI上的名字
        return new TranslationTextComponent("container."+ Kun_Kun_Mod.MOD_ID + ".box");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new ChestContainer(ContainerType.GENERIC_9X6,id,player,this,6);
    }

    @Override
    public int getSizeInventory() {
        return 54;
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()){
            if (this.playerCount < 0){
                this.playerCount = 0;
            }
            this.playerCount++;
            BlockState blockState = this.getBlockState();
            boolean open = blockState.get(BoxBlock.OPEN);
            if (!open){
                this.playDoorSound(blockState, SoundEvents.BLOCK_CHEST_OPEN);//打开时的音效
                this.setDoorState(blockState, true);//打开
            }
        }
        this.scheduleTick();
    }

    private void scheduleTick() {
        this.world.getPendingBlockTicks().scheduleTick(this.getPos(),this.getBlockState().getBlock(),5);
    }
    public void onScheduleTick(){
        int x = this.pos.getX();
        int y = this.pos.getY();
        int z = this.pos.getZ();
        World world = this.getWorld();
        if (world != null){
            this.playerCount = ChestTileEntity.calculatePlayersUsing(world,this,x,y,z);
            if (this.playerCount > 0){
                this.scheduleTick();
            }else {
                BlockState blockState = this.getBlockState();
                if (!(blockState.getBlock() instanceof BoxBlock)){
                    this.remove();
                    return;
                }
                boolean open = blockState.get(BoxBlock.OPEN);
                if (open){
                    this.playDoorSound(blockState,SoundEvents.BLOCK_CHEST_CLOSE);//关闭时的音效
                    this.setDoorState(blockState, false);//关闭
                }
            }

        }
    }

    private void playDoorSound(BlockState blockState, SoundEvent soundEvent) {
        double x = this.pos.getX() + 0.5D;
        double y = this.pos.getY() + 0.5D;
        double z = this.pos.getZ() + 0.5D;
        World world = this.getWorld();
        if(world != null)
        {
            world.playSound(null, x, y, z, soundEvent, SoundCategory.BLOCKS, 0.5F,
                    world.rand.nextFloat() * 0.1F + 0.9F);
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()){
            this.playerCount--;
        }
    }
    private void setDoorState(BlockState blockState, boolean open)
    {
        World world = this.getWorld();
        if(world != null)
        {
            world.setBlockState(this.getPos(), blockState.with(BoxBlock.OPEN, open), 3);
        }
    }

}
