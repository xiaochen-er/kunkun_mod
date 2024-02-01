package com.mod.kun_kun_mod.world;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mod.kun_kun_mod.world.gen.ModFlowerGeneration;
import com.mod.kun_kun_mod.world.gen.ModOreGeneration;
import com.mod.kun_kun_mod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Kun_Kun_Mod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){//生物群系加载事件
        ModTreeGeneration.generateTrees(event);//树的世界生成
        ModFlowerGeneration.generateFlowers(event);//花的世界生成
        ModOreGeneration.generateOre(event);//矿物的世界生成
    }
}
