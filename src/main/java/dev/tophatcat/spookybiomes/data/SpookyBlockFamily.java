package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.world.level.block.*;

import java.util.function.Supplier;

/**
 * A family of blocks for a wood type.
 *
 * <p>This is used in the various data providers to repeat the same processes for each block in a family, instead of
 * duplicating code for defining and operating on each family.</p>
 */
record SpookyBlockFamily(Supplier<? extends Block> planks,
                         Supplier<? extends SlabBlock> slab,
                         Supplier<? extends StairBlock> stairs,
                         Supplier<? extends FenceBlock> fence,
                         Supplier<? extends FenceGateBlock> fenceGate,
                         Supplier<? extends DoorBlock> door,
                         Supplier<? extends TrapDoorBlock> trapdoor,
                         Supplier<? extends RotatedPillarBlock> log,
                         Supplier<? extends RotatedPillarBlock> strippedLog,
                         Supplier<? extends LeavesBlock> leaves,
                         Supplier<? extends SaplingBlock> sapling) {

    public static final SpookyBlockFamily SORBUS = new SpookyBlockFamily(
        SpookyBlocks.SORBUS_PLANKS,
        SpookyBlocks.SORBUS_SLAB,
        SpookyBlocks.SORBUS_STAIRS,
        SpookyBlocks.SORBUS_FENCE,
        SpookyBlocks.SORBUS_GATE,
        SpookyBlocks.SORBUS_DOOR,
        SpookyBlocks.SORBUS_TRAPDOOR,
        SpookyBlocks.SORBUS_LOG,
        SpookyBlocks.SORBUS_LOG_STRIPPED,
        SpookyBlocks.SORBUS_LEAVES,
        SpookyBlocks.SORBUS_SAPLING
    );

    public static final SpookyBlockFamily GHOSTLY = new SpookyBlockFamily(
        SpookyBlocks.GHOSTLY_PLANKS,
        SpookyBlocks.GHOSTLY_SLAB,
        SpookyBlocks.GHOSTLY_STAIRS,
        SpookyBlocks.GHOSTLY_FENCE,
        SpookyBlocks.GHOSTLY_GATE,
        SpookyBlocks.GHOSTLY_DOOR,
        SpookyBlocks.GHOSTLY_TRAPDOOR,
        SpookyBlocks.GHOSTLY_LOG,
        SpookyBlocks.GHOSTLY_LOG_STRIPPED,
        SpookyBlocks.GHOSTLY_LEAVES,
        SpookyBlocks.GHOSTLY_SAPLING
    );

    public static final SpookyBlockFamily SEEPING = new SpookyBlockFamily(
        SpookyBlocks.SEEPING_PLANKS,
        SpookyBlocks.SEEPING_SLAB,
        SpookyBlocks.SEEPING_STAIRS,
        SpookyBlocks.SEEPING_FENCE,
        SpookyBlocks.SEEPING_GATE,
        SpookyBlocks.SEEPING_DOOR,
        SpookyBlocks.SEEPING_TRAPDOOR,
        SpookyBlocks.SEEPING_LOG,
        SpookyBlocks.SEEPING_LOG_STRIPPED,
        SpookyBlocks.SEEPING_LEAVES,
        SpookyBlocks.SEEPING_SAPLING
    );

    public static final SpookyBlockFamily BLOODWOOD = new SpookyBlockFamily(
        SpookyBlocks.BLOODWOOD_PLANKS,
        SpookyBlocks.BLOODWOOD_SLAB,
        SpookyBlocks.BLOODWOOD_STAIRS,
        SpookyBlocks.BLOODWOOD_FENCE,
        SpookyBlocks.BLOODWOOD_GATE,
        SpookyBlocks.BLOODWOOD_DOOR,
        SpookyBlocks.BLOODWOOD_TRAPDOOR,
        SpookyBlocks.BLOODWOOD_LOG,
        SpookyBlocks.BLOODWOOD_LOG_STRIPPED,
        SpookyBlocks.BLOODWOOD_LEAVES,
        SpookyBlocks.BLOODWOOD_SAPLING
    );
}
