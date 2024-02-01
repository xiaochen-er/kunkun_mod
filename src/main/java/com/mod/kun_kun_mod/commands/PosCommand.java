package com.mod.kun_kun_mod.commands;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class PosCommand {
    public PosCommand(CommandDispatcher<CommandSource> dispatcher){
        //命令结构/return pos
        dispatcher.register(Commands.literal("return").then(Commands.literal("pos").executes((command) ->{
            return returnPos(command.getSource());
        })));
        //命令结构/pos set
        dispatcher.register(Commands.literal("pos").then(Commands.literal("set").executes((command) ->{
            return setPos(command.getSource());
        })));
    }
    private int returnPos(CommandSource source)throws CommandSyntaxException{
        ServerPlayerEntity player = source.asPlayer();
        boolean hasPos =player.getPersistentData().getIntArray(Kun_Kun_Mod.MOD_ID+"pos").length!=0;
        if (hasPos){
            int[] playerPos = player.getPersistentData().getIntArray(Kun_Kun_Mod.MOD_ID+"pos");
            player.setPositionAndUpdate(playerPos[0],playerPos[1],playerPos[2]);
            return 1;
        }else {
            source.sendFeedback(new StringTextComponent("No Pos has been saved"),true);
            return -1;
        }
    }
    private int setPos(CommandSource source)throws CommandSyntaxException{
        ServerPlayerEntity player = source.asPlayer();
        BlockPos blockPos = player.getPosition();
        String pos = "("+blockPos.getX()+","+blockPos.getY()+","+blockPos.getZ()+")";//输出屏幕坐标
        source.sendFeedback(new StringTextComponent("Set Pos at:"+pos),true);//输出屏幕文字
        player.getPersistentData().putIntArray(Kun_Kun_Mod.MOD_ID+"pos",new int[]{blockPos.getX(), blockPos.getY(), blockPos.getZ()});//玩家数据data
        return 1;
    }
}
