package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.RegHelpers;
import dev.tophatcat.mysteriousbiomes.common.blocks.BloodiedGrass;
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

public class MysteriousContentSetup {

    public static final Map<Identifier, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<Identifier, Supplier<Item>> ITEMS = new LinkedHashMap<>();

    public static Supplier<Block> BLOODIED_GRASS = null;
    public static Supplier<Block> BLOODIED_DIRT = null;

    public MysteriousContentSetup() {
        var spookyWoodTypes = List.of(
            MysteriousWoodTypes.BLOODWOOD,
            MysteriousWoodTypes.GHOSTLY,
            MysteriousWoodTypes.SORBUS,
            MysteriousWoodTypes.SEEPING,
            MysteriousWoodTypes.SAKURA);

        spookyWoodTypes.forEach(woodType -> {
            woodType.log = MysteriousSetupHelpers.setupPillarBlock(woodType.getName(), "_log");
            woodType.stripped_log = MysteriousSetupHelpers.setupPillarBlock(woodType.getName(), "_stripped_log");
            woodType.wood = MysteriousSetupHelpers.setupPillarBlock(woodType.getName(), "_wood");
            woodType.stripped_wood = MysteriousSetupHelpers.setupPillarBlock(woodType.getName(), "_stripped_wood");
            woodType.planks = MysteriousSetupHelpers.setupPlanksBlock(woodType.getName());
            woodType.stairs = MysteriousSetupHelpers.setupStairsBlock(woodType.getName(),
                woodType.getPlanks().get().getDefaultState());
            woodType.leaves = MysteriousSetupHelpers.setupLeavesBlock(woodType.getName());
            woodType.slab = MysteriousSetupHelpers.setupSlabBlock(woodType.getName());
            woodType.fence = MysteriousSetupHelpers.setupFenceBlock(woodType.getName());
            woodType.gate = MysteriousSetupHelpers.setupGateBlock(woodType.getName());
            woodType.button = MysteriousSetupHelpers.setupButtonBlock(woodType.getName());
            woodType.pressure_plate = MysteriousSetupHelpers.setupPressurePlateBlock(woodType.getName());
            woodType.trapdoor = MysteriousSetupHelpers.setupTrapdoorBlock(woodType.getName());
            woodType.door = MysteriousSetupHelpers.setupDoorBlock(woodType.getName());
        });

        //TODO Change the sapling generators.
        MysteriousWoodTypes.BLOODWOOD.sapling = MysteriousSetupHelpers.setupSaplingBlock("bloodwood_sapling",
            new OakSaplingGenerator());
        MysteriousWoodTypes.GHOSTLY.sapling = MysteriousSetupHelpers.setupSaplingBlock("ghostly_sapling",
            new OakSaplingGenerator());
        MysteriousWoodTypes.SORBUS.sapling = MysteriousSetupHelpers.setupSaplingBlock("sorbus_sapling",
            new OakSaplingGenerator());
        MysteriousWoodTypes.SEEPING.sapling = MysteriousSetupHelpers.setupSaplingBlock("seeping_sapling",
            new OakSaplingGenerator());
        MysteriousWoodTypes.SAKURA.sapling = MysteriousSetupHelpers.setupSaplingBlock("sakura_sapling",
            new OakSaplingGenerator());

        BLOODIED_GRASS = RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, "bloodied_grass"),
            MysteriousBiomes.ITEM_TAB, () -> new BloodiedGrass(Block.Settings.of(Material.SOIL).strength(0.5F)
                .sounds(BlockSoundGroup.WET_GRASS).ticksRandomly()), BLOCKS, ITEMS);
        BLOODIED_DIRT = RegHelpers.createBlockWithItem(
            new Identifier(MysteriousBiomes.MOD_ID, "bloodied_dirt"), MysteriousBiomes.ITEM_TAB,
            () -> new Block(Block.Settings.of(Material.SOIL).strength(0.5F).sounds(BlockSoundGroup.ROOTED_DIRT)),
            BLOCKS, ITEMS);
    }
}
