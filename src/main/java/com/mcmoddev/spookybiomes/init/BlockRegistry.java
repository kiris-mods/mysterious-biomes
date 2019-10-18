package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.proxyslib.blocks.*;
import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import com.mcmoddev.spookybiomes.common.world.gen.features.WorldGenGhostlyTree;
import com.mcmoddev.spookybiomes.common.world.gen.features.WorldGenSorbusTree;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class BlockRegistry {

    @SubscribeEvent
    public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                //Sorbus stuff
                nameBlock(new BaseLog(), "sorbus_log"),
                nameBlock(new BaseLeaves(() -> BlocksSB.SORBUS_SAPLING), "sorbus_leaves"),
                nameBlock(new BasePlanks(Material.WOOD), "sorbus_planks"),
                nameBlock(new BaseSapling(new WorldGenSorbusTree(true)), "sorbus_sapling"),
                nameBlock(new BaseGate(), "sorbus_gate"),
                nameBlock(new BaseDoor(Material.WOOD), "sorbus_door"),
                nameBlock(new BaseTrapdoor(Material.WOOD), "sorbus_trapdoor"),
                nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "sorbus_stairs"),
                nameBlock(new BaseFence(Material.WOOD, MapColor.ORANGE_STAINED_HARDENED_CLAY), "sorbus_fence"),
                nameBlock(new BaseSlab.Half(Material.WOOD), "sorbus_slab"),
                nameBlock(new BaseSlab.Double(Material.WOOD), "sorbus_double_slab"),

                //Ghostly stuff
                nameBlock(new BaseLog(), "ghostly_log"),
                nameBlock(new BaseLeaves(() -> BlocksSB.GHOSTLY_SAPLING), "ghostly_leaves"),
                nameBlock(new BasePlanks(Material.WOOD), "ghostly_planks"),
                nameBlock(new BaseSapling(new WorldGenGhostlyTree(true)), "ghostly_sapling"),
                nameBlock(new BaseGate(), "ghostly_gate"),
                nameBlock(new BaseDoor(Material.WOOD), "ghostly_door"),
                nameBlock(new BaseTrapdoor(Material.WOOD), "ghostly_trapdoor"),
                nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "ghostly_stairs"),
                nameBlock(new BaseFence(Material.WOOD, MapColor.SNOW), "ghostly_fence"),
                nameBlock(new BaseSlab.Half(Material.WOOD), "ghostly_slab"),
                nameBlock(new BaseSlab.Double(Material.WOOD), "ghostly_double_slab"),

                //Seeping stuff
                nameBlock(new BaseLog(), "seeping_log"),
                nameBlock(new BaseLeaves(() -> BlocksSB.SEEPING_SAPLING), "seeping_leaves"),
                nameBlock(new BasePlanks(Material.WOOD), "seeping_planks"),
                //TODO Create a tree generator.
                nameBlock(new BaseSapling(new WorldGenBigTree(true)), "seeping_sapling"),
                nameBlock(new BaseGate(), "seeping_gate"),
                nameBlock(new BaseDoor(Material.WOOD), "seeping_door"),
                nameBlock(new BaseTrapdoor(Material.WOOD), "seeping_trapdoor"),
                nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "seeping_stairs"),
                nameBlock(new BaseFence(Material.WOOD, MapColor.GREEN), "seeping_fence"),
                nameBlock(new BaseSlab.Half(Material.WOOD), "seeping_slab"),
                nameBlock(new BaseSlab.Double(Material.WOOD), "seeping_double_slab"),

                //Bloodwood stuff
                nameBlock(new BaseLog(), "bloodwood_log"),
                nameBlock(new BaseLeaves(() -> BlocksSB.BLOODWOOD_SAPLING), "bloodwood_leaves"),
                nameBlock(new Block(Material.WOOD), "bloodwood_planks"),
                //TODO Create a tree generator.
                nameBlock(new BaseSapling(new WorldGenBigTree(true)), "bloodwood_sapling"),
                nameBlock(new BaseGate(), "bloodwood_gate"),
                nameBlock(new BaseDoor(Material.WOOD), "bloodwood_door"),
                nameBlock(new BaseTrapdoor(Material.WOOD), "bloodwood_trapdoor"),
                nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "bloodwood_stairs"),
                nameBlock(new BaseFence(Material.WOOD, MapColor.RED), "bloodwood_fence"),
                nameBlock(new BaseSlab.Half(Material.WOOD), "bloodwood_slab"),
                nameBlock(new BaseSlab.Double(Material.WOOD), "bloodwood_double_slab")
        );
    }

    private static Block nameBlock(Block block, String name) {
        block
                .setRegistryName(name)
                .setTranslationKey(SpookyBiomes.MODID + "." + name)
                .setCreativeTab(SpookyBiomes.CREATIVE_TAB);
        return block;
    }
}
