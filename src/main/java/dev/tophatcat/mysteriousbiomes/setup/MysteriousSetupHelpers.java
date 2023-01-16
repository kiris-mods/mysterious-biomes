package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.RegHelpers;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class MysteriousSetupHelpers {

    public static Supplier<Block> setupSaplingBlock(String name, SaplingGenerator generator) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, name), MysteriousBiomes.ITEM_TAB,
            () -> new SaplingBlock(generator, Block.Settings.of(Material.WOOD).ticksRandomly().noCollision()),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPillarBlock(String woodType, String blockType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + blockType),
            MysteriousBiomes.ITEM_TAB, () -> new PillarBlock(Block.Settings.of(Material.WOOD).strength(2.0F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPlanksBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_planks"),
            MysteriousBiomes.ITEM_TAB, () -> new Block(Block.Settings.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupStairsBlock(String woodType, BlockState blockState) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_stairs"),
            MysteriousBiomes.ITEM_TAB, () -> new StairsBlock(blockState, Block.Settings.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupLeavesBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_leaves"),
            MysteriousBiomes.ITEM_TAB, () -> new LeavesBlock(Block.Settings.of(Material.LEAVES).strength(0.2F).nonOpaque()),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSlabBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_slab"),
            MysteriousBiomes.ITEM_TAB, () -> new SlabBlock(Block.Settings.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupFenceBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_fence"),
            MysteriousBiomes.ITEM_TAB, () -> new FenceBlock(Block.Settings.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupGateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_gate"),
            MysteriousBiomes.ITEM_TAB,
            () -> new FenceGateBlock(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupButtonBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_button"),
            MysteriousBiomes.ITEM_TAB, () -> new WoodenButtonBlock(Block.Settings.of(Material.WOOD).strength(0.5F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPressurePlateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_pressure_plate"),
            MysteriousBiomes.ITEM_TAB, () -> new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                Block.Settings.of(Material.WOOD).strength(0.5F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupTrapdoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_trapdoor"),
            MysteriousBiomes.ITEM_TAB, () -> new TrapdoorBlock(Block.Settings.of(Material.WOOD).strength(3.0F).nonOpaque()),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupDoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType + "_door"),
            MysteriousBiomes.ITEM_TAB, () -> new DoorBlock(Block.Settings.of(Material.WOOD).strength(3.0F).nonOpaque()),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }
}
