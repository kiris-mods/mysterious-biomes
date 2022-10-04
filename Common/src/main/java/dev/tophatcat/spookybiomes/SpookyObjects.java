package dev.tophatcat.spookybiomes;

import com.google.common.base.Suppliers;
import dev.tophatcat.kirislib.RegHelpers;
import dev.tophatcat.kirislib.common.blocks.BasicButtonBlock;
import dev.tophatcat.kirislib.common.blocks.BasicDoorBlock;
import dev.tophatcat.kirislib.common.blocks.BasicLogBlock;
import dev.tophatcat.kirislib.common.blocks.BasicPressurePlateBlock;
import dev.tophatcat.kirislib.common.blocks.BasicSaplingBlock;
import dev.tophatcat.kirislib.common.blocks.BasicStairBlock;
import dev.tophatcat.kirislib.common.blocks.BasicTrapDoorBlock;
import dev.tophatcat.spookybiomes.blocks.BloodiedGrass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SpookyObjects {

    public static final Map<Block, ResourceLocation> BLOCKS = new LinkedHashMap<>();
    public static final Map<Item, ResourceLocation> ITEMS = new LinkedHashMap<>();
    public static final Map<SoundEvent, ResourceLocation> ENTITIES = new LinkedHashMap<>();

    public static final Supplier<Block> BLOODIED_GRASS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodied_grass", new BloodiedGrass(BlockBehaviour.Properties.of(Material.DIRT)
            .strength(0.6F).sound(SoundType.WET_GRASS).randomTicks()),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODIED_DIRT = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodied_dirt", new Block(BlockBehaviour.Properties.of(Material.DIRT)
            .strength(0.6F).sound(SoundType.ROOTED_DIRT)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_LOG_STRIPPED = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_log_stripped", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_LOG_STRIPPED = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_log_stripped", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_LOG_STRIPPED = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_log_stripped", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_LOG_STRIPPED = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_log_stripped", new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_LOG = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_log", new BasicLogBlock(BlockBehaviour.Properties.of(Material.WOOD),
            SORBUS_LOG_STRIPPED),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_LOG = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_log", new BasicLogBlock(BlockBehaviour.Properties.of(Material.WOOD),
            SEEPING_LOG_STRIPPED),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_LOG = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_log", new BasicLogBlock(BlockBehaviour.Properties.of(Material.WOOD),
            GHOSTLY_LOG_STRIPPED),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_LOG = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_log", new BasicLogBlock(BlockBehaviour.Properties.of(Material.WOOD),
            BLOODWOOD_LOG_STRIPPED),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_PLANKS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_PLANKS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_PLANKS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_PLANKS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_STAIRS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_stairs", new BasicStairBlock(SORBUS_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_STAIRS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_stairs", new BasicStairBlock(SEEPING_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_STAIRS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_stairs", new BasicStairBlock(GHOSTLY_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_STAIRS = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_stairs", new BasicStairBlock(BLOODWOOD_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_LEAVES = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_leaves", new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_LEAVES = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_leaves", new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_LEAVES = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_leaves", new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_LEAVES = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_leaves", new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_SLAB = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_slab", new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_SLAB = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_slab", new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_SLAB = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_slab", new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_SLAB = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_slab", new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_FENCE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_fence", new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_FENCE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_fence", new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_FENCE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_fence", new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_FENCE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_fence", new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    //TODO Swap out tree growers.
    public static final Supplier<Block> SORBUS_SAPLING = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_sapling", new BasicSaplingBlock(new OakTreeGrower(),
            BlockBehaviour.Properties.of(Material.WOOD).randomTicks()),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_SAPLING = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_sapling", new BasicSaplingBlock(new OakTreeGrower(),
            BlockBehaviour.Properties.of(Material.WOOD).randomTicks()),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_SAPLING = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_sapling", new BasicSaplingBlock(new OakTreeGrower(),
            BlockBehaviour.Properties.of(Material.WOOD).randomTicks()),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_SAPLING = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_sapling", new BasicSaplingBlock(new OakTreeGrower(),
            BlockBehaviour.Properties.of(Material.WOOD).randomTicks()),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_BUTTON = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_button", new BasicButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_BUTTON = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_button", new BasicButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_BUTTON = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_button", new BasicButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_BUTTON = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_button", new BasicButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_PRESSURE_PLATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_pressure_plate", new BasicPressurePlateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_PRESSURE_PLATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_pressure_plate", new BasicPressurePlateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_PRESSURE_PLATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_pressure_plate", new BasicPressurePlateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_PRESSURE_PLATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_pressure_plate", new BasicPressurePlateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_TRAPDOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_trapdoor", new BasicTrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_TRAPDOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_trapdoor", new BasicTrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_TRAPDOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_trapdoor", new BasicTrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_TRAPDOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_trapdoor", new BasicTrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_GATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_gate", new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_GATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_gate", new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_GATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_gate", new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_GATE = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_gate", new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SORBUS_DOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "sorbus_door", new BasicDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> SEEPING_DOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "seeping_door", new BasicDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> GHOSTLY_DOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "ghostly_door", new BasicDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));

    public static final Supplier<Block> BLOODWOOD_DOOR = Suppliers.memoize(() -> RegHelpers.createBlock(
        "bloodwood_door", new BasicDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)),
        SpookyBiomesCommon.MOD_ID, SpookyBiomesCommon.ITEM_TAB, true, BLOCKS, ITEMS));
}
