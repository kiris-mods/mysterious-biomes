package dev.tophatcat.spookybiomes.blocks;

import dev.tophatcat.spookybiomes.SpookyObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.BlockLightEngine;
import org.jetbrains.annotations.NotNull;

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

        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else {
            if (blockstate.getFluidState().getAmount() == 8) {
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
     * @param level
     * @param pos
     * @param random
     */
    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level,
                           @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (!level.isClientSide) {
            if (!level.hasChunksAt(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
                //Forge: prevent loading unloaded chunks when checking neighbor's light and spreading.
                //Almost mimic Forge patch that does the same thing so that I can use it on other loaders.
                return;
            }

            if (!canBeGrass(state, level, pos)) {
                //Block is covered, turn it into bloodied dirt.
                level.setBlockAndUpdate(pos, SpookyObjects.BLOODIED_DIRT.get().defaultBlockState());
            } else {
                if (!level.hasChunksAt(pos.offset(-3, -3, -3), pos.offset(3, 3, 3))) {
                    //Forge: prevent loading unloaded chunks when checking neighbor's light and spreading.
                    //Almost mimic Forge patch that does the same thing so that I can use it on other loaders.
                    return;
                }

                if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
                    //Attempt to spread grass onto neighboring bloodied dirt.
                    BlockState replacementBlock = SpookyObjects.BLOODIED_GRASS.get().defaultBlockState();

                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.offset(random.nextInt(3)
                            - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);

                        if (level.getBlockState(blockpos).getBlock() == SpookyObjects.BLOODIED_DIRT
                            && canPropagate(replacementBlock, level, blockpos)) {
                            level.setBlockAndUpdate(blockpos, replacementBlock.setValue(SNOWY,
                                level.getBlockState(blockpos.above()).getBlock() == Blocks.SNOW));
                        }
                    }
                }
            }
        }
    }
}
