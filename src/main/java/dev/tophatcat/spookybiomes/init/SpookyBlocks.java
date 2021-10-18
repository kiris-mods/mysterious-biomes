package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.RegistrationHelpers;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedTreeGrower;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpookyBlocks {

    public static final DeferredRegister<Block> BLOCKS
        = DeferredRegister.create(ForgeRegistries.BLOCKS, SpookyBiomes.MOD_ID);

    public static final RegistryObject<Block>
    //Misc blocks
    BLOODIED_GRASS = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
        "bloodied_grass", () -> new BloodiedGrass(Properties.of(Material.DIRT).sound(SoundType.GRAVEL))),

    BLOODIED_DIRT = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
            "bloodied_dirt", () -> new Block(Block.Properties.of(Material.DIRT).sound(SoundType.GRAVEL))),

    //Sorbus blocks
    SORBUS_LOG_STRIPPED = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS,SpookyItems.ITEMS,
        "sorbus_log_stripped", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD))),

    SORBUS_LOG = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
            "sorbus_log", () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SORBUS_LEAVES = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
            "sorbus_leaves", () -> new LeavesBlock(Block.Properties.of(Material.LEAVES)
                .sound(SoundType.GRASS).noOcclusion())),

    SORBUS_PLANKS = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
            "sorbus_planks", () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SORBUS_SAPLING = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
            "sorbus_sapling", () -> new SaplingBlock(new OakTreeGrower(), Block.Properties.of(Material.GRASS)
                .sound(SoundType.GRASS))),

    SORBUS_GATE = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "sorbus_gate",
        () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SORBUS_DOOR = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "sorbus_door",
        () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SORBUS_TRAPDOOR = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
        "sorbus_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SORBUS_STAIRS = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "sorbus_stairs",
        () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(), Block.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD))),

    SORBUS_FENCE = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "sorbus_fence",
        () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SORBUS_SLAB = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "sorbus_slab",
        () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    //Ghostly blocks
    GHOSTLY_LOG_STRIPPED = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS,SpookyItems.ITEMS,
        "ghostly_log_stripped", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD))),

    GHOSTLY_LOG = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_log",
        () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    GHOSTLY_LEAVES = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_leaves",
        () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS).noOcclusion())),

    GHOSTLY_PLANKS = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_planks",
        () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    GHOSTLY_SAPLING = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
        "ghostly_sapling", () -> new SaplingBlock(new OakTreeGrower(), Block.Properties.of(Material.GRASS)
            .sound(SoundType.GRASS))),

    GHOSTLY_GATE = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_gate",
        () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    GHOSTLY_DOOR = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_door",
        () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).noOcclusion())),

    GHOSTLY_TRAPDOOR = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
        "ghostly_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD).noOcclusion())),

    GHOSTLY_STAIRS = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_stairs",
        () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(), Block.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD))),

    GHOSTLY_FENCE = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_fence",
        () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    GHOSTLY_SLAB = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "ghostly_slab",
        () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    //Seeping blocks
    SEEPING_LOG_STRIPPED = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS,SpookyItems.ITEMS,
        "seeping_log_stripped", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD))),

    SEEPING_LOG = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_log",
        () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SEEPING_LEAVES = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_leaves",
        () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS).noOcclusion())),

    SEEPING_PLANKS = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_planks",
        () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SEEPING_SAPLING = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
        "seeping_sapling", () -> new SaplingBlock(new OakTreeGrower(), Block.Properties.of(Material.GRASS)
            .sound(SoundType.GRASS))),

    SEEPING_GATE = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_gate",
        () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SEEPING_DOOR = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_door",
        () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SEEPING_TRAPDOOR = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS,
        "seeping_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SEEPING_STAIRS = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_stairs",
        () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(), Block.Properties.of(Material.WOOD)
                .sound(SoundType.WOOD))),

    SEEPING_FENCE = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_fence",
        () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    SEEPING_SLAB = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "seeping_slab",
        () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    //Bloodwood blocks
    BLOODWOOD_LOG_STRIPPED = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS,SpookyItems.ITEMS,
        "bloodwood_log_stripped", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD))),

    BLOODWOOD_LOG = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_log",
        () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    BLOODWOOD_LEAVES
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_leaves",
        () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS).noOcclusion())),

    BLOODWOOD_PLANKS
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_planks",
        () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    BLOODWOOD_SAPLING
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_sapling",
        () -> new SaplingBlock(new BloodiedTreeGrower(),
            Block.Properties.of(Material.GRASS).sound(SoundType.GRASS).noOcclusion())),

    BLOODWOOD_GATE
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_gate",
        () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    BLOODWOOD_DOOR
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_door",
        () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).noOcclusion())),

    BLOODWOOD_TRAPDOOR
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_trapdoor",
        () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).noOcclusion())),

    BLOODWOOD_STAIRS
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_stairs",
        () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
            Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    BLOODWOOD_FENCE
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_fence",
        () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD))),

    BLOODWOOD_SLAB
        = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, SpookyItems.ITEMS, "bloodwood_slab",
        () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));
}
