/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2013-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
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

import dev.tophatcat.spookybiomes.SpookyContentRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import org.jetbrains.annotations.NotNull;

public class BloodiedGrass extends GrassBlock {

    public BloodiedGrass(Settings properties) {
        super(properties);
    }

    public static boolean canBeGrass(BlockState state, ServerWorld world, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = world.getBlockState(blockpos);

        if (blockstate.isOf(Blocks.SNOW) && blockstate.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else {
            if (blockstate.getFluidState().getLevel() == 8) {
                return false;
            } else {
                int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockstate, blockpos, Direction.UP,
                    blockstate.getOpacity(world, blockpos));
                return i < world.getMaxLightLevel();
            }
        }
    }

    public static boolean canPropagate(BlockState blockStateIn, ServerWorld world, BlockPos pos) {
        BlockPos blockpos = pos.up();
        return canBeGrass(blockStateIn, world, pos) && !world.getFluidState(blockpos).isIn(FluidTags.WATER);
    }

    /**
     * Every tick, it'll attempt to spread bloodied grass onto dirt. If covered, will turn into bloodied dirt.
     */
    @Override
    public void randomTick(@NotNull BlockState state, ServerWorld world, @NotNull BlockPos pos,
                           @NotNull RandomGenerator random) {
        if (!world.isClient) {
            //TODO Check if Quilt has anything for this.
            //if (!world.isAreaLoaded(pos, 3)) {
                //Forge: prevent loading unloaded chunks when checking neighbor's light and spreading.
            //    return;
            //}

            if (!canBeGrass(state, world, pos)) {
                //Block is covered, turn it into bloodied dirt.
                world.setBlockState(pos, SpookyContentRegistry.BLOODIED_DIRT.get().getDefaultState());
            } else {
                if (world.getLightLevel(pos.up()) >= 9) {
                    //Attempt to spread grass onto neighboring bloodied dirt.
                    BlockState replacementBlock = SpookyContentRegistry.BLOODIED_GRASS.get().getDefaultState();

                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.add(random.nextInt(3)
                            - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);

                        if (world.getBlockState(blockpos).getBlock() == SpookyContentRegistry.BLOODIED_DIRT.get()
                            && canPropagate(replacementBlock, world, blockpos)) {
                            world.setBlockState(blockpos, replacementBlock.with(SNOWY,
                                world.getBlockState(blockpos.up()).getBlock() == Blocks.SNOW));
                        }
                    }
                }
            }
        }
    }
}
