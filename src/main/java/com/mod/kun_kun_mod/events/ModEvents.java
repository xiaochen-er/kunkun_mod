package com.mod.kun_kun_mod.events;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mod.kun_kun_mod.commands.PosCommand;
import com.mod.kun_kun_mod.commands.SetHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

//注册命令
@Mod.EventBusSubscriber(modid = Kun_Kun_Mod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event){
        new PosCommand(event.getDispatcher());
        new SetHomeCommand(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());//构造命令
    }
    //玩家死亡后保留指令数据
    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event){
        if (!event.getOriginal().getEntityWorld().isRemote()){
            event.getPlayer().getPersistentData().putIntArray(Kun_Kun_Mod.MOD_ID+"pos",
                    event.getOriginal().getPersistentData().getIntArray(Kun_Kun_Mod.MOD_ID+"pos"));
        }
        if (!event.getOriginal().getEntityWorld().isRemote()){
            event.getPlayer().getPersistentData().putIntArray(Kun_Kun_Mod.MOD_ID+"home",
                    event.getOriginal().getPersistentData().getIntArray(Kun_Kun_Mod.MOD_ID+"home"));
        }
    }
}
