package dev.tophatcat.spookybiomes.setup;

import dev.tophatcat.spookybiomes.RegHelpers;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class SetupHelpers {

    public static Supplier<Block> setupSaplingBlock(String name, SaplingGenerator generator) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, name),
            () -> new SaplingBlock(generator, Block.Settings.of(Material.WOOD).ticksRandomly()),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPillarBlock(String woodType, String blockType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + blockType),
            () -> new PillarBlock(Block.Settings.of(Material.WOOD).strength(2.0F)),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPlanksBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_planks"),
            () -> new Block(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupStairsBlock(String woodType, BlockState blockState) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_stairs"),
            () -> new StairsBlock(blockState, Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupLeavesBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_leaves"),
            () -> new LeavesBlock(Block.Settings.of(Material.LEAVES).strength(0.2F).nonOpaque()),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSlabBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_slab"),
            () -> new SlabBlock(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupFenceBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_fence"),
            () -> new FenceBlock(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupGateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_gate"),
            () -> new FenceGateBlock(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupButtonBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_button"),
            () -> new WoodenButtonBlock(Block.Settings.of(Material.WOOD).strength(0.5F)),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPressurePlateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_pressure_plate"),
            () -> new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                Block.Settings.of(Material.WOOD).strength(0.5F)), SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupTrapdoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_trapdoor"),
            () -> new TrapdoorBlock(Block.Settings.of(Material.WOOD).strength(3.0F).nonOpaque()),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }

    public static Supplier<Block> setupDoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_door"),
            () -> new DoorBlock(Block.Settings.of(Material.WOOD).strength(3.0F).nonOpaque()),
            SpookyContentSetup.BLOCKS, SpookyContentSetup.ITEMS);
    }
}
