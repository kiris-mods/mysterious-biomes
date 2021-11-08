/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2016-2021 <ProxyNeko>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.common.blocks;

import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.BlockLightEngine;

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
