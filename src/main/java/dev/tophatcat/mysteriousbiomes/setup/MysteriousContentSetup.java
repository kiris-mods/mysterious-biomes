package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.kirislib.RegHelpers;
import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.common.blocks.BloodiedGrass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.material.Material;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MysteriousContentSetup {

    public static final Map<ResourceLocation, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<ResourceLocation, Supplier<Item>> ITEMS = new LinkedHashMap<>();

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
            woodType.stripped_log = MysteriousSetupHelpers.setupPillarBlock(woodType.getName(),
                "_stripped_log");
            woodType.wood = MysteriousSetupHelpers.setupPillarBlock(woodType.getName(), "_wood");
            woodType.stripped_wood = MysteriousSetupHelpers.setupPillarBlock(woodType.getName(),
                "_stripped_wood");
            woodType.planks = MysteriousSetupHelpers.setupPlanksBlock(woodType.getName());
            woodType.stairs = MysteriousSetupHelpers.setupStairsBlock(woodType.getName(),
                woodType.getPlanks().get().defaultBlockState());
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
            new OakTreeGrower());
        MysteriousWoodTypes.GHOSTLY.sapling = MysteriousSetupHelpers.setupSaplingBlock("ghostly_sapling",
            new OakTreeGrower());
        MysteriousWoodTypes.SORBUS.sapling = MysteriousSetupHelpers.setupSaplingBlock("sorbus_sapling",
            new OakTreeGrower());
        MysteriousWoodTypes.SEEPING.sapling = MysteriousSetupHelpers.setupSaplingBlock("seeping_sapling",
            new OakTreeGrower());
        MysteriousWoodTypes.SAKURA.sapling = MysteriousSetupHelpers.setupSaplingBlock("sakura_sapling",
            new OakTreeGrower());

        MysteriousWoodTypes.BLOODWOOD.floor_sign = MysteriousSetupHelpers.setupFloorSignBlock("bloodwood_sign",
            MysteriousBiomes.BLOODWOOD_WOOD_TYPE);
        MysteriousWoodTypes.GHOSTLY.floor_sign = MysteriousSetupHelpers.setupFloorSignBlock("ghostly_sign",
            MysteriousBiomes.GHOSTLY_WOOD_TYPE);
        MysteriousWoodTypes.SORBUS.floor_sign = MysteriousSetupHelpers.setupFloorSignBlock("sorbus_sign",
            MysteriousBiomes.SORBUS_WOOD_TYPE);
        MysteriousWoodTypes.SEEPING.floor_sign = MysteriousSetupHelpers.setupFloorSignBlock("seeping_sign",
            MysteriousBiomes.SEEPING_WOOD_TYPE);
        MysteriousWoodTypes.SAKURA.floor_sign = MysteriousSetupHelpers.setupFloorSignBlock("sakura_sign",
            MysteriousBiomes.SAKURA_WOOD_TYPE);

        MysteriousWoodTypes.BLOODWOOD.wall_sign = MysteriousSetupHelpers.setupWallSignBlock("bloodwood_wall_sign",
            MysteriousBiomes.BLOODWOOD_WOOD_TYPE);
        MysteriousWoodTypes.GHOSTLY.wall_sign = MysteriousSetupHelpers.setupWallSignBlock("ghostly_wall_sign",
            MysteriousBiomes.GHOSTLY_WOOD_TYPE);
        MysteriousWoodTypes.SORBUS.wall_sign = MysteriousSetupHelpers.setupWallSignBlock("sorbus_wall_sign",
            MysteriousBiomes.SORBUS_WOOD_TYPE);
        MysteriousWoodTypes.SEEPING.wall_sign = MysteriousSetupHelpers.setupWallSignBlock("seeping_wall_sign",
            MysteriousBiomes.SEEPING_WOOD_TYPE);
        MysteriousWoodTypes.SAKURA.wall_sign = MysteriousSetupHelpers.setupWallSignBlock("sakura_wall_sign",
            MysteriousBiomes.SAKURA_WOOD_TYPE);

        MysteriousWoodTypes.BLOODWOOD.sign = MysteriousSetupHelpers.setupSignItem("bloodwood_sign",
            MysteriousWoodTypes.BLOODWOOD.getFloorSign().get(), MysteriousWoodTypes.BLOODWOOD.getWallSign().get());
        MysteriousWoodTypes.GHOSTLY.sign = MysteriousSetupHelpers.setupSignItem("ghostly_sign",
            MysteriousWoodTypes.GHOSTLY.getFloorSign().get(), MysteriousWoodTypes.GHOSTLY.getWallSign().get());
        MysteriousWoodTypes.SORBUS.sign = MysteriousSetupHelpers.setupSignItem("sorbus_sign",
            MysteriousWoodTypes.SORBUS.getFloorSign().get(), MysteriousWoodTypes.SORBUS.getWallSign().get());
        MysteriousWoodTypes.SEEPING.sign = MysteriousSetupHelpers.setupSignItem("seeping_sign",
            MysteriousWoodTypes.SEEPING.getFloorSign().get(), MysteriousWoodTypes.SEEPING.getWallSign().get());
        MysteriousWoodTypes.SAKURA.sign = MysteriousSetupHelpers.setupSignItem("sakura_sign",
            MysteriousWoodTypes.SAKURA.getFloorSign().get(), MysteriousWoodTypes.SAKURA.getWallSign().get());

        BLOODIED_GRASS = RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID,
                "bloodied_grass"), MysteriousBiomes.ITEM_TAB, () -> new BloodiedGrass(Block.Properties
            .of(Material.DIRT).strength(0.5F).sound(SoundType.WET_GRASS).randomTicks()), BLOCKS, ITEMS);
        BLOODIED_DIRT = RegHelpers.createBlockWithItem(
            new ResourceLocation(MysteriousBiomes.MOD_ID, "bloodied_dirt"), MysteriousBiomes.ITEM_TAB,
            () -> new Block(Block.Properties.of(Material.DIRT).strength(0.5F).sound(SoundType.ROOTED_DIRT)),
            BLOCKS, ITEMS);
    }
}
