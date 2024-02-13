/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2024
 * https://github.com/kiris-mods/mysterious-biomes/blob/dev/LICENSE.md
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
 */
package dev.tophatcat.mysteriousbiomes.core;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MysteriousFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODWOOD_TREE
        = FeatureUtils.createKey("bloodwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GHOSTLY_TREE
        = FeatureUtils.createKey("ghostly_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SORBUS_TREE
        = FeatureUtils.createKey("sorbus_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEEPING_TREE
        = FeatureUtils.createKey("seeping_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_TREE
        = FeatureUtils.createKey("walnut_tree");
}
