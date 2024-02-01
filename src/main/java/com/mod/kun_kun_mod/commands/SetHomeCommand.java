package com.mod.kun_kun_mod.commands;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class SetHomeCommand {
    public SetHomeCommand(CommandDispatcher<CommandSource> dispatcher){
        //命令结构/set home
        dispatcher.register(Commands.literal("set").then(Commands.literal("home").executes((command) ->{
            return setHome(command.getSource());
        })));
        //命令结构/home
        dispatcher.register(Commands.literal("home").executes((command) ->{
            return Home(command.getSource());
        }));
    }
    private int setHome(CommandSource source)throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        BlockPos blockPos = player.getPosition();
        String home = "("+blockPos.getX()+","+blockPos.getY()+","+blockPos.getZ()+")";//输出屏幕坐标
        source.sendFeedback(new StringTextComponent("\u6210\u529f\u8bbe\u7f6e\u5bb6\u7684\u5750\u6807\u4e3a"+home),true);//输出屏幕文字
        player.getPersistentData().putIntArray(Kun_Kun_Mod.MOD_ID+"home",new int[]{blockPos.getX(), blockPos.getY(), blockPos.getZ()});//玩家数据data
        return 1;
    }
    private int Home(CommandSource source)throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        boolean home =player.getPersistentData().getIntArray(Kun_Kun_Mod.MOD_ID+"home").length!=0;
        if (home){
            int[] playerPos = player.getPersistentData().getIntArray(Kun_Kun_Mod.MOD_ID+"home");
            player.setPositionAndUpdate(playerPos[0],playerPos[1],playerPos[2]);
            source.sendFeedback(new StringTextComponent("\u60a8\u5df2\u6210\u529f\u56de\u5bb6"),true);//输出屏幕文字
            return 1;
        }else {
            source.sendFeedback(new StringTextComponent("\u60a8\u8fd8\u6ca1\u6709\u8bbe\u7f6e\u5bb6"),true);
            return -1;
        }
    }
}
