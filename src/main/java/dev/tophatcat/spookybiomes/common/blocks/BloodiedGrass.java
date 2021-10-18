package dev.tophatcat.spookybiomes.common.blocks;

import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import dev.tophatcat.spookybiomes.init.SpookyItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.BlockLightEngine;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nonnull;
import java.util.Random;

/**
 * @author ProxyNeko
 */
public class BloodiedGrass extends GrassBlock {

    /**
     * Set the blocks properties during registration.
     *
     * @param properties Set the properties of this block while registering it.
     */
    public BloodiedGrass(Properties properties) {
        super(properties);
    }

    /**
     * @param state
     * @param world
     * @param pos
     * @return
     */
    public static boolean canBeGrass(BlockState state, ServerLevel world, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = world.getBlockState(blockpos);

        if (blockstate.getBlock() == Blocks.SNOW && state.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else {
            if (blockstate.getMaterial() != Material.AIR) {
                return false;
            } else {
                int i = BlockLightEngine.getLightBlockInto(world, state, pos, blockstate, blockpos, Direction.UP,
                        blockstate.getLightBlock(world, blockpos));
                return i < world.getMaxLightLevel();
            }
        }
    }

    /**
     * @param blockStateIn
     * @param world
     * @param pos
     * @return
     */
    public static boolean canPropagate(BlockState blockStateIn, ServerLevel world, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return canBeGrass(blockStateIn, world, pos) && !world.getFluidState(blockpos).is(FluidTags.WATER);
    }

    /**
     * Every tick, it'll attempt to spread bloodied grass onto dirt. If covered, will turn into bloodied dirt.
     *
     * @param state
     * @param world
     * @param pos
     * @param random
     */
    @Override
    public void randomTick(@Nonnull BlockState state, ServerLevel world, @Nonnull BlockPos pos,
                           @Nonnull Random random) {
        if (!world.isClientSide) {
            if (!world.isAreaLoaded(pos, 3)) {
                //Forge: prevent loading unloaded chunks when checking neighbor's light and spreading.
                return;
            }

            if (!canBeGrass(state, world, pos)) {
                //Block is covered, turn it into bloodied dirt.
                world.setBlockAndUpdate(pos, SpookyBlocks.BLOODIED_DIRT.get().defaultBlockState());
            } else {
                if (world.getMaxLocalRawBrightness(pos.above()) >= 9) {
                    //Attempt to spread grass onto neighboring bloodied dirt.
                    BlockState replacementBlock = SpookyBlocks.BLOODIED_GRASS.get().defaultBlockState();

                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.offset(random.nextInt(3)
                                - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);

                        if (world.getBlockState(blockpos).getBlock() == SpookyBlocks.BLOODIED_DIRT.get()
                                && canPropagate(replacementBlock, world, blockpos)) {
                            world.setBlockAndUpdate(blockpos, replacementBlock.setValue(SNOWY,
                                    world.getBlockState(blockpos.above()).getBlock() == Blocks.SNOW));
                        }
                    }
                }
            }
        }
    }
}
