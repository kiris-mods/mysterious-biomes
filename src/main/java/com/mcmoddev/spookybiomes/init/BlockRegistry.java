package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.proxyslib.blocks.*;
import com.mcmoddev.proxyslib.util.RegistryUtils;
import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.tosort.BaseDirt;
import com.mcmoddev.spookybiomes.tosort.BaseGrass;
import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import com.mcmoddev.spookybiomes.common.world.gen.features.WorldGenBloodTree;
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
                RegistryUtils.nameBlock(new BaseLog(), SpookyBiomes.MODID, "sorbus_log", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseLeaves(() -> BlocksSB.SORBUS_SAPLING), SpookyBiomes.MODID, "sorbus_leaves", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BasePlanks(Material.WOOD), SpookyBiomes.MODID, "sorbus_planks", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSapling(new WorldGenSorbusTree(true)), SpookyBiomes.MODID, "sorbus_sapling", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseGate(), SpookyBiomes.MODID, "sorbus_gate", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseDoor(Material.WOOD), SpookyBiomes.MODID, "sorbus_door", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseTrapdoor(Material.WOOD), SpookyBiomes.MODID, "sorbus_trapdoor", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), SpookyBiomes.MODID, "sorbus_stairs", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseFence(Material.WOOD, MapColor.ORANGE_STAINED_HARDENED_CLAY), SpookyBiomes.MODID, "sorbus_fence", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Half(Material.WOOD), SpookyBiomes.MODID, "sorbus_slab", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Double(Material.WOOD), SpookyBiomes.MODID, "sorbus_double_slab", SpookyBiomes.CREATIVE_TAB),

                //Ghostly stuff
                RegistryUtils.nameBlock(new BaseLog(), SpookyBiomes.MODID, "ghostly_log", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseLeaves(() -> BlocksSB.GHOSTLY_SAPLING), SpookyBiomes.MODID, "ghostly_leaves", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BasePlanks(Material.WOOD), SpookyBiomes.MODID, "ghostly_planks", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSapling(new WorldGenGhostlyTree(true)), SpookyBiomes.MODID, "ghostly_sapling", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseGate(), SpookyBiomes.MODID, "ghostly_gate", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseDoor(Material.WOOD), SpookyBiomes.MODID, "ghostly_door", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseTrapdoor(Material.WOOD), SpookyBiomes.MODID, "ghostly_trapdoor", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), SpookyBiomes.MODID, "ghostly_stairs", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseFence(Material.WOOD, MapColor.SNOW), SpookyBiomes.MODID, "ghostly_fence", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Half(Material.WOOD), SpookyBiomes.MODID, "ghostly_slab", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Double(Material.WOOD), SpookyBiomes.MODID, "ghostly_double_slab", SpookyBiomes.CREATIVE_TAB),

                //Seeping stuff
                RegistryUtils.nameBlock(new BaseLog(), SpookyBiomes.MODID, "seeping_log", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseLeaves(() -> BlocksSB.SEEPING_SAPLING), SpookyBiomes.MODID, "seeping_leaves", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BasePlanks(Material.WOOD), SpookyBiomes.MODID, "seeping_planks", SpookyBiomes.CREATIVE_TAB),
                //TODO Create a tree generator.
                RegistryUtils.nameBlock(new BaseSapling(new WorldGenBigTree(false)), SpookyBiomes.MODID, "seeping_sapling", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseGate(), SpookyBiomes.MODID, "seeping_gate", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseDoor(Material.WOOD), SpookyBiomes.MODID, "seeping_door", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseTrapdoor(Material.WOOD), SpookyBiomes.MODID, "seeping_trapdoor", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), SpookyBiomes.MODID, "seeping_stairs", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseFence(Material.WOOD, MapColor.GREEN), SpookyBiomes.MODID, "seeping_fence", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Half(Material.WOOD), SpookyBiomes.MODID, "seeping_slab", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Double(Material.WOOD), SpookyBiomes.MODID, "seeping_double_slab", SpookyBiomes.CREATIVE_TAB),

                //Bloodwood stuff
                RegistryUtils.nameBlock(new BaseLog(), SpookyBiomes.MODID, "bloodwood_log", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseLeaves(() -> BlocksSB.BLOODWOOD_SAPLING), SpookyBiomes.MODID, "bloodwood_leaves", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new Block(Material.WOOD), SpookyBiomes.MODID, "bloodwood_planks", SpookyBiomes.CREATIVE_TAB),
                //TODO Create a tree generator.
                RegistryUtils.nameBlock(new BaseSapling(new WorldGenBloodTree(true, false)), SpookyBiomes.MODID, "bloodwood_sapling", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseGate(), SpookyBiomes.MODID, "bloodwood_gate", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseDoor(Material.WOOD), SpookyBiomes.MODID, "bloodwood_door", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseTrapdoor(Material.WOOD), SpookyBiomes.MODID, "bloodwood_trapdoor", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseStairs(new BasePlanks(Material.WOOD)), SpookyBiomes.MODID, "bloodwood_stairs", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseFence(Material.WOOD, MapColor.RED), SpookyBiomes.MODID, "bloodwood_fence", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Half(Material.WOOD), SpookyBiomes.MODID, "bloodwood_slab", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseSlab.Double(Material.WOOD), SpookyBiomes.MODID, "bloodwood_double_slab", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseGrass(), SpookyBiomes.MODID, "bloodied_grass", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameBlock(new BaseDirt(Material.GROUND), SpookyBiomes.MODID, "bloodied_dirt", SpookyBiomes.CREATIVE_TAB)
        );
    }
}
