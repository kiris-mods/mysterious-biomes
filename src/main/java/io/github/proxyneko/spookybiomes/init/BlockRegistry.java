package io.github.proxyneko.spookybiomes.init;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import io.github.proxyneko.spookybiomes.common.blocks.BaseDoor;
import io.github.proxyneko.spookybiomes.common.blocks.BaseFence;
import io.github.proxyneko.spookybiomes.common.blocks.BaseGate;
import io.github.proxyneko.spookybiomes.common.blocks.BaseLeaves;
import io.github.proxyneko.spookybiomes.common.blocks.BaseLog;
import io.github.proxyneko.spookybiomes.common.blocks.BasePlanks;
import io.github.proxyneko.spookybiomes.common.blocks.BaseSapling;
import io.github.proxyneko.spookybiomes.common.blocks.BaseSlab;
import io.github.proxyneko.spookybiomes.common.blocks.BaseStairs;
import io.github.proxyneko.spookybiomes.common.blocks.BaseTrapdoor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class BlockRegistry {

    @SubscribeEvent
    public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
        //Witchwood stuff
        event.getRegistry().registerAll
            (
                 nameBlock(new BaseLog(), "witchwood_log"),
                 nameBlock(new BaseLeaves(BlocksSB.WITCHWOOD_SAPLING), "witchwood_leaves"),
                 nameBlock(new BasePlanks(Material.WOOD), "witchwood_planks"),
                 //TODO Crash on client launch because of NPE with the leaves and log used in WorldGenWitchwoodTree
                 nameBlock(new BaseSapling(new WorldGenBigTree(true), "witchwood_sapling"), "witchwood_sapling"),
                 nameBlock(new BaseGate(), "witchwood_gate"),
                 nameBlock(new BaseDoor(Material.WOOD), "witchwood_door"),
                 nameBlock(new BaseTrapdoor(Material.WOOD), "witchwood_trapdoor"),
                 nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "witchwood_stairs"),
                 nameBlock(new BaseFence(Material.WOOD), "witchwood_fence"),
                 nameBlock(new BaseSlab.Half(Material.WOOD), "witchwood_slab"),
                 nameBlock(new BaseSlab.Double(Material.WOOD), "witchwood_double_slab"),

                 //Ghostly stuff
                 nameBlock(new BaseLog(), "ghostly_log"),
                 nameBlock(new BaseLeaves(BlocksSB.GHOSTLY_SAPLING), "ghostly_leaves"),
                 nameBlock(new BasePlanks(Material.WOOD), "ghostly_planks"),
                 //TODO Crash on client launch because of NPE with the leaves and log used in WorldGenGhostlyTree
                 nameBlock(new BaseSapling(new WorldGenBigTree(true), "ghostly_sapling"), "ghostly_sapling"),
                 nameBlock(new BaseGate(), "ghostly_gate"),
                 nameBlock(new BaseDoor(Material.WOOD), "ghostly_door"),
                 nameBlock(new BaseTrapdoor(Material.WOOD), "ghostly_trapdoor"),
                 nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "ghostly_stairs"),
                 nameBlock(new BaseFence(Material.WOOD), "ghostly_fence"),
                 nameBlock(new BaseSlab.Half(Material.WOOD), "ghostly_slab"),
                 nameBlock(new BaseSlab.Double(Material.WOOD), "ghostly_double_slab"),

                 //Oozing stuff
                 nameBlock(new BaseLog(), "oozing_log"),
                 nameBlock(new BaseLeaves(BlocksSB.OOZING_SAPLING), "oozing_leaves"),
                 nameBlock(new BasePlanks(Material.WOOD), "oozing_planks"),
                 //TODO Create a tree generator.
                 nameBlock(new BaseSapling(new WorldGenBigTree(true), "oozing_sapling"), "oozing_sapling"),
                 nameBlock(new BaseGate(), "oozing_gate"),
                 nameBlock(new BaseDoor(Material.WOOD), "oozing_door"),
                 nameBlock(new BaseTrapdoor(Material.WOOD), "oozing_trapdoor"),
                 nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "oozing_stairs"),
                 nameBlock(new BaseFence(Material.WOOD), "oozing_fence"),
                 nameBlock(new BaseSlab.Half(Material.WOOD), "oozing_slab"),
                 nameBlock(new BaseSlab.Double(Material.WOOD), "oozing_double_slab"),

                 //Blood stuff
                 nameBlock(new BaseLog(), "blood_log"),
                 nameBlock(new BaseLeaves(BlocksSB.BLOOD_SAPLING), "blood_leaves"),
                 nameBlock(new BasePlanks(Material.WOOD), "blood_planks"),
                 //TODO Create a tree generator.
                 nameBlock(new BaseSapling(new WorldGenBigTree(true), "blood_sapling"), "blood_sapling"),
                 nameBlock(new BaseGate(), "blood_gate"),
                 nameBlock(new BaseDoor(Material.WOOD), "blood_door"),
                 nameBlock(new BaseTrapdoor(Material.WOOD), "blood_trapdoor"),
                 nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "blood_stairs"),
                 nameBlock(new BaseFence(Material.WOOD), "blood_fence"),
                 nameBlock(new BaseSlab.Half(Material.WOOD), "blood_slab"),
                 nameBlock(new BaseSlab.Double(Material.WOOD), "blood_double_slab")
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
