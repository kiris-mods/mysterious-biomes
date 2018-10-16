package io.github.proxyneko.spookybiomes.init;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import io.github.proxyneko.spookybiomes.server.blocks.*;
import io.github.proxyneko.spookybiomes.server.world.gen.features.WorldGenGhostlyTree;
import io.github.proxyneko.spookybiomes.server.world.gen.features.WorldGenWitchwoodTree;
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
        event.getRegistry().register(nameBlock(new BaseLog(), "witchwood_log"));
        event.getRegistry().register(nameBlock(new BaseLeaves(BlocksSB.WITCHWOOD_SAPLING), "witchwood_leaves"));
        event.getRegistry().register(nameBlock(new BasePlanks(Material.WOOD), "witchwood_planks"));
        //TODO Crash on client launch because of NPE with the leaves and log used in WorldGenWitchwoodTree
        event.getRegistry().register(nameBlock(new BaseSapling(new WorldGenBigTree(true), "witchwood_sapling"), "witchwood_sapling"));
        event.getRegistry().register(nameBlock(new BaseGate(), "witchwood_gate"));
        event.getRegistry().register(nameBlock(new BaseDoor(Material.WOOD), "witchwood_door"));
        event.getRegistry().register(nameBlock(new BaseTrapdoor(Material.WOOD), "witchwood_trapdoor"));
        event.getRegistry().register(nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "witchwood_stairs"));
        event.getRegistry().register(nameBlock(new BaseFence(Material.WOOD), "witchwood_fence"));
        event.getRegistry().register(nameBlock(new BaseSlab.Half(Material.WOOD), "witchwood_slab"));
        event.getRegistry().register(nameBlock(new BaseSlab.Double(Material.WOOD), "witchwood_double_slab"));

        //Ghostly stuff
        event.getRegistry().register(nameBlock(new BaseLog(), "ghostly_log"));
        event.getRegistry().register(nameBlock(new BaseLeaves(BlocksSB.GHOSTLY_SAPLING), "ghostly_leaves"));
        event.getRegistry().register(nameBlock(new BasePlanks(Material.WOOD), "ghostly_planks"));
        //TODO Crash on client launch because of NPE with the leaves and log used in WorldGenGhostlyTree
        event.getRegistry().register(nameBlock(new BaseSapling(new WorldGenBigTree(true), "ghostly_sapling"), "ghostly_sapling"));
        event.getRegistry().register(nameBlock(new BaseGate(), "ghostly_gate"));
        event.getRegistry().register(nameBlock(new BaseDoor(Material.WOOD), "ghostly_door"));
        event.getRegistry().register(nameBlock(new BaseTrapdoor(Material.WOOD), "ghostly_trapdoor"));
        event.getRegistry().register(nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "ghostly_stairs"));
        event.getRegistry().register(nameBlock(new BaseFence(Material.WOOD), "ghostly_fence"));
        event.getRegistry().register(nameBlock(new BaseSlab.Half(Material.WOOD), "ghostly_slab"));
        event.getRegistry().register(nameBlock(new BaseSlab.Double(Material.WOOD), "ghostly_double_slab"));

        //Oozing stuff
        event.getRegistry().register(nameBlock(new BaseLog(), "oozing_log"));
        event.getRegistry().register(nameBlock(new BaseLeaves(BlocksSB.OOZING_SAPLING), "oozing_leaves"));
        event.getRegistry().register(nameBlock(new BasePlanks(Material.WOOD), "oozing_planks"));
        //TODO Create a tree generator.
        event.getRegistry().register(nameBlock(new BaseSapling(new WorldGenBigTree(true), "oozing_sapling"), "oozing_sapling"));
        event.getRegistry().register(nameBlock(new BaseGate(), "oozing_gate"));
        event.getRegistry().register(nameBlock(new BaseDoor(Material.WOOD), "oozing_door"));
        event.getRegistry().register(nameBlock(new BaseTrapdoor(Material.WOOD), "oozing_trapdoor"));
        event.getRegistry().register(nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "oozing_stairs"));
        event.getRegistry().register(nameBlock(new BaseFence(Material.WOOD), "oozing_fence"));
        event.getRegistry().register(nameBlock(new BaseSlab.Half(Material.WOOD), "oozing_slab"));
        event.getRegistry().register(nameBlock(new BaseSlab.Double(Material.WOOD), "oozing_double_slab"));

        //Blood stuff
        event.getRegistry().register(nameBlock(new BaseLog(), "blood_log"));
        event.getRegistry().register(nameBlock(new BaseLeaves(BlocksSB.BLOOD_SAPLING), "blood_leaves"));
        event.getRegistry().register(nameBlock(new BasePlanks(Material.WOOD), "blood_planks"));
        //TODO Create a tree generator.
        event.getRegistry().register(nameBlock(new BaseSapling(new WorldGenBigTree(true), "blood_sapling"), "blood_sapling"));
        event.getRegistry().register(nameBlock(new BaseGate(), "blood_gate"));
        event.getRegistry().register(nameBlock(new BaseDoor(Material.WOOD), "blood_door"));
        event.getRegistry().register(nameBlock(new BaseTrapdoor(Material.WOOD), "blood_trapdoor"));
        event.getRegistry().register(nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), "blood_stairs"));
        event.getRegistry().register(nameBlock(new BaseFence(Material.WOOD), "blood_fence"));
        event.getRegistry().register(nameBlock(new BaseSlab.Half(Material.WOOD), "blood_slab"));
        event.getRegistry().register(nameBlock(new BaseSlab.Double(Material.WOOD), "blood_double_slab"));
    }

    private static Block nameBlock(Block block, String name) {
        block
                .setRegistryName(name)
                .setTranslationKey(SpookyBiomes.MODID + "." + name)
                .setCreativeTab(SpookyBiomes.CREATIVE_TAB);
        return block;
    }
}
