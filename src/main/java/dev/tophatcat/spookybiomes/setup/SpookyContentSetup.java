package dev.tophatcat.spookybiomes.setup;

import dev.tophatcat.spookybiomes.RegHelpers;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SpookyContentSetup {

    public static final Map<Identifier, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<Identifier, Supplier<Item>> ITEMS = new LinkedHashMap<>();

    public static Supplier<Block> BLOODIED_GRASS = null;
    public static Supplier<Block> BLOODIED_DIRT = null;

    public SpookyContentSetup() {
        var spookyWoodTypes = List.of(
            SpookyWoodTypes.BLOODWOOD,
            SpookyWoodTypes.GHOSTLY,
            SpookyWoodTypes.SORBUS,
            SpookyWoodTypes.SEEPING);

        spookyWoodTypes.forEach(woodType -> {
            woodType.log = SetupHelpers.setupPillarBlock(woodType.getName(), "_log");
            woodType.stripped_log = SetupHelpers.setupPillarBlock(woodType.getName(), "_stripped_log");
            woodType.wood = SetupHelpers.setupPillarBlock(woodType.getName(), "_wood");
            woodType.stripped_wood = SetupHelpers.setupPillarBlock(woodType.getName(), "_stripped_wood");
            woodType.planks = SetupHelpers.setupPlanksBlock(woodType.getName());
            woodType.stairs = SetupHelpers.setupStairsBlock(woodType.getName(),
                woodType.getPlanks().get().getDefaultState());
            woodType.leaves = SetupHelpers.setupLeavesBlock(woodType.getName());
            woodType.slab = SetupHelpers.setupSlabBlock(woodType.getName());
            woodType.fence = SetupHelpers.setupFenceBlock(woodType.getName());
            woodType.gate = SetupHelpers.setupGateBlock(woodType.getName());
            woodType.button = SetupHelpers.setupButtonBlock(woodType.getName());
            woodType.pressure_plate = SetupHelpers.setupPressurePlateBlock(woodType.getName());
            woodType.trapdoor = SetupHelpers.setupTrapdoorBlock(woodType.getName());
            woodType.door = SetupHelpers.setupDoorBlock(woodType.getName());
        });

        //TODO Change the sapling generators.
        SpookyWoodTypes.BLOODWOOD.sapling = SetupHelpers.setupSaplingBlock("bloodwood_sapling",
            new OakSaplingGenerator());
        SpookyWoodTypes.GHOSTLY.sapling = SetupHelpers.setupSaplingBlock("ghostly_sapling",
            new OakSaplingGenerator());
        SpookyWoodTypes.SORBUS.sapling = SetupHelpers.setupSaplingBlock("sorbus_sapling",
            new OakSaplingGenerator());
        SpookyWoodTypes.SEEPING.sapling = SetupHelpers.setupSaplingBlock("seeping_sapling",
            new OakSaplingGenerator());

        BLOODIED_GRASS = RegHelpers.createBlockWithItem(new Identifier(SpookyBiomes.MOD_ID, "bloodied_grass"),
            () -> new BloodiedGrass(Block.Settings.of(Material.SOIL).strength(0.5F).sounds(BlockSoundGroup.WET_GRASS)
                .ticksRandomly()), BLOCKS, ITEMS);
        BLOODIED_DIRT = RegHelpers.createBlockWithItem(
            new Identifier(SpookyBiomes.MOD_ID, "bloodied_dirt"), () -> new Block(Block.Settings.of(Material.SOIL)
                .strength(0.5F).sounds(BlockSoundGroup.ROOTED_DIRT)), BLOCKS, ITEMS);
    }
}
