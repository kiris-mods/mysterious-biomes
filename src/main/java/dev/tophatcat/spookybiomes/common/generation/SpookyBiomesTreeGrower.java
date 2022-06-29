/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
package dev.tophatcat.spookybiomes.common.generation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nonnull;
import java.util.Random;

public abstract class SpookyBiomesTreeGrower extends AbstractTreeGrower {

    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean alternative) {
        return null;
    }

    protected abstract ConfiguredFeature<?, ?> getDynamicConfiguredFeature(Registry<ConfiguredFeature<?, ?>>
                                                                               configuredFeatureRegistry, Random random, boolean alternative);

    @Override
    public boolean growTree(ServerLevel serverLevel, @Nonnull ChunkGenerator chunkGenerator, @Nonnull BlockPos blockPos,
                            @Nonnull BlockState blockState, @Nonnull Random random) {
        ConfiguredFeature<?, ?> configuredFeature = this.getDynamicConfiguredFeature(serverLevel.registryAccess()
            .registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY), random, this.hasFlowers(serverLevel, blockPos));
        if (configuredFeature == null) {
            return false;
        } else {
            serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 4);
            if (configuredFeature.place(serverLevel, chunkGenerator, random, blockPos)) {
                return true;
            } else {
                serverLevel.setBlock(blockPos, blockState, 4);
                return false;
            }
        }
    }

    private boolean hasFlowers(LevelAccessor level, BlockPos blockPos) {
        for (BlockPos blockpos : BlockPos.MutableBlockPos.betweenClosed(blockPos.below().north(2).west(2),
            blockPos.above().south(2).east(2))) {
            if (level.getBlockState(blockpos).is(BlockTags.FLOWERS)) {
                return true;
            }
        }

        return false;
    }
}
