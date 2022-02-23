/*
 * Spooky Biomes - https://tophatcat.dev/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
package dev.tophatcat.spookybiomes.common.generation;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class BloodiedTreeGrower extends SpookyBiomesTreeGrower {

    @Override
    protected ConfiguredFeature<?, ?> getDynamicConfiguredFeature(final Registry<ConfiguredFeature<?, ?>>
        configuredFeatureRegistry, Random random, boolean alternative) {
        if (random.nextInt(10) == 0) {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID,
                "bloodied_tree_big"));
        } else {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID,
                "bloodied_tree"));
        }
    }
}
