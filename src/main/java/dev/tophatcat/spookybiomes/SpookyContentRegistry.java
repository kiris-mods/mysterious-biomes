package dev.tophatcat.spookybiomes;

import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import net.minecraft.block.*;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SpookyContentRegistry {

    //TODO Refactor this to use a for each system.
    public static final Map<Identifier, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<Identifier, Supplier<Item>> ITEMS = new LinkedHashMap<>();

    public SpookyContentRegistry() {
        var spookyWoodTypes = List.of(
            SpookyWoodTypes.BLOODWOOD.getName(),
            SpookyWoodTypes.GHOSTLY.getName(),
            SpookyWoodTypes.SORBUS.getName(),
            SpookyWoodTypes.SEEPING.getName());

        spookyWoodTypes.forEach(woodType -> {
            setupPillarBlock(woodType, "_log");
            setupPillarBlock(woodType, "_stripped_log");
            setupPillarBlock(woodType, "_wood");
            setupPillarBlock(woodType, "_stripped_wood");
            setupPlanksBlock(woodType);
            setupLeavesBlock(woodType);
            setupSlabBlock(woodType);
            setupFenceBlock(woodType);
            setupGateBlock(woodType);
            setupButtonBlock(woodType);
            setupPressurePlateBlock(woodType);
            setupTrapdoorBlock(woodType);
            setupDoorBlock(woodType);
        });

        //TODO Figure out why these crash when the above content exists yet getting planks is null.

        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "bloodwood_stairs"),
            () -> new StairsBlock(SpookyWoodTypes.BLOODWOOD.getPlanks().get().getDefaultState(),
                Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)), BLOCKS, ITEMS);
        /*
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "ghostly_stairs"),
            () -> new StairsBlock(SpookyWoodTypes.GHOSTLY.getPlanks().get().getDefaultState(),
                Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)), BLOCKS, ITEMS);
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "sorbus_stairs"),
            () -> new StairsBlock(SpookyWoodTypes.SORBUS.getPlanks().get().getDefaultState(),
                Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)), BLOCKS, ITEMS);
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "seeping_stairs"),
            () -> new StairsBlock(SpookyWoodTypes.SEEPING.getPlanks().get().getDefaultState(),
                Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)), BLOCKS, ITEMS);

         */

        //TODO Change the sapling generators.
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "bloodwood_sapling"),
            () -> new SaplingBlock(new OakSaplingGenerator(),
                Block.Settings.of(Material.WOOD).ticksRandomly()), BLOCKS, ITEMS);
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "ghostly_sapling"),
            () -> new SaplingBlock(new OakSaplingGenerator(),
                Block.Settings.of(Material.WOOD).ticksRandomly()), BLOCKS, ITEMS);
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "sorbus_sapling"),
            () -> new SaplingBlock(new OakSaplingGenerator(),
                Block.Settings.of(Material.WOOD).ticksRandomly()), BLOCKS, ITEMS);
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "seeping_sapling"),
            () -> new SaplingBlock(new OakSaplingGenerator(),
                Block.Settings.of(Material.WOOD).ticksRandomly()), BLOCKS, ITEMS);

        BLOODIED_GRASS.get();
        BLOODIED_DIRT.get();
    }

    public static final Supplier<Block> BLOODIED_GRASS = RegHelpers.createBlockWithItem(
        new Identifier(SpookyBiomes.MOD_ID, "bloodied_grass"),
        () -> new BloodiedGrass(AbstractBlock.Settings.of(Material.SOIL).strength(0.5F)
            .sounds(BlockSoundGroup.WET_GRASS).ticksRandomly()), BLOCKS, ITEMS);
    public static final Supplier<Block> BLOODIED_DIRT = RegHelpers.createBlockWithItem(
        new Identifier(SpookyBiomes.MOD_ID, "bloodied_dirt"),
            () -> new Block(Block.Settings.of(Material.SOIL).strength(0.5F)
                .sounds(BlockSoundGroup.ROOTED_DIRT)), BLOCKS, ITEMS);

    private void setupPillarBlock(String woodType, String blockType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + blockType),
            () -> new PillarBlock(AbstractBlock.Settings.of(Material.WOOD).strength(2.0F)), BLOCKS, ITEMS);
    }

    private void setupPlanksBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_planks"),
            () -> new Block(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)), BLOCKS, ITEMS);
    }

    private void setupLeavesBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_leaves"),
            () -> new LeavesBlock(Block.Settings.of(Material.LEAVES).strength(0.2F).nonOpaque()), BLOCKS, ITEMS);
    }

    private void setupSlabBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_slab"),
            () -> new SlabBlock(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            BLOCKS, ITEMS);
    }

    private void setupFenceBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_fence"),
            () -> new FenceBlock(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            BLOCKS, ITEMS);
    }

    private void setupGateBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_gate"),
            () -> new FenceGateBlock(Block.Settings.of(Material.WOOD).strength(2.0F, 3.0F)),
            BLOCKS, ITEMS);
    }

    private void setupButtonBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_button"),
            () -> new WoodenButtonBlock(Block.Settings.of(Material.WOOD).strength(0.5F)), BLOCKS, ITEMS);
    }

    private void setupPressurePlateBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_pressure_plate"),
            () -> new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                Block.Settings.of(Material.WOOD).strength(0.5F)), BLOCKS, ITEMS);
    }

    private void setupTrapdoorBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_trapdoor"),
            () -> new TrapdoorBlock(Block.Settings.of(Material.WOOD).strength(3.0F)), BLOCKS, ITEMS);
    }

    private void setupDoorBlock(String woodType) {
        RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, woodType + "_door"),
            () -> new DoorBlock(Block.Settings.of(Material.WOOD).strength(3.0F)), BLOCKS, ITEMS);
    }
}
