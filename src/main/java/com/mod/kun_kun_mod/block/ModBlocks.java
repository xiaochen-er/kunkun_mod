package com.mod.kun_kun_mod.block;

import com.mod.kun_kun_mod.Kun_Kun_Mod;
import com.mod.kun_kun_mod.block.custom.*;
import com.mod.kun_kun_mod.item.ModItems;
import com.mod.kun_kun_mod.item.ModTab;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
//模组方块添加表
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =DeferredRegister.create(ForgeRegistries.BLOCKS, Kun_Kun_Mod.MOD_ID);
    //模组方块
    public static final RegistryObject<Block> GE_GE_BLOCK = registerBlock("ge_ge_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //矿物
    public static final RegistryObject<Block> GE_GE_ORE = registerBlock("ge_ge_ore",
            () -> new Ge_Ge_Ore(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .setLightLevel(value -> 1)//方块发光等级
            ));
    //重写后的方块
    public static final RegistryObject<Block> FLAME_GE_GE_BLOCK = registerBlock("flame_ge_ge_block",
            () -> new Flame_Ge_Ge_Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //模组台阶
    public static final RegistryObject<Block> GE_GE_SLAB = registerBlock("ge_ge_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //模组楼梯
    public static final RegistryObject<Block> GE_GE_STAIRS = registerBlock("ge_ge_stairs",
            //共用的方块
            () -> new StairsBlock(() -> GE_GE_BLOCK.get().getDefaultState(),AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //模组栅栏
    public static final RegistryObject<Block> GE_GE_FENCE = registerBlock("fence/ge_ge_fence",//fence为单独建新文件夹（所有）
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //模组栅栏门
    public static final RegistryObject<Block> GE_GE_FENCE_GATE = registerBlock("fence/ge_ge_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //模组门&活板门  还需在Lazy_Mod中单独添加渲染
    public static final RegistryObject<Block> GE_GE_DOOR = registerBlock("ge_ge_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.AXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
                    .notSolid()//非实心方块
            ));
    public static final RegistryObject<Block> GE_GE_TRAPDOOR = registerBlock("ge_ge_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.AXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
                    .notSolid()//非实心方块
            ));
    //模组按钮
    public static final RegistryObject<Block> GE_GE_BUTTON = registerBlock("ge_ge_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
                    .doesNotBlockMovement()//碰撞箱体积
            ));
    //模组压力板
    public static final RegistryObject<Block> GE_GE_PRESSURE_PLATE = registerBlock("ge_ge_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,AbstractBlock.Properties.create(Material.ROCK)//(PressurePlateBlock.Sensitivity.=敏感性).+（物品）
                    .harvestLevel(2)// 挖掘等级
                    .harvestTool(ToolType.PICKAXE)// 挖掘工具
                    .setRequiresTool()// 需要正确的工具
                    .hardnessAndResistance(5.0F,6.0F)// 硬度 爆炸抗性
                    .sound(SoundType.METAL)// 声音
                    .speedFactor(0)// 站在方块上面的速度
                    .setLightLevel(value -> 15)//方块发光等级
            ));
    //模组农作物  还需在Lazy_Mod中单独添加渲染
    public static final RegistryObject<Block> LI_ZHI_TREE = BLOCKS.register("li_zhi_tree",
            () -> new Li_zhi_tree_Block(AbstractBlock.Properties.from(Blocks.CARROTS)));//继承胡萝卜属性
    //模组箱子
    public static final RegistryObject<Block> BOX = registerBlock("box",
            () -> new BoxBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(5f)
            ));
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> tRegistryObject = BLOCKS.register(name,block);
        registerBlockItem(name,tRegistryObject);
        return tRegistryObject;
    }

    private static <T extends Block> void registerBlockItem(String name,Supplier<T> block){
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties().group(ModTab.GE_GE_TAB)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
