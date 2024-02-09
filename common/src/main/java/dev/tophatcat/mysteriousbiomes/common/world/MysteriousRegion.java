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
package dev.tophatcat.mysteriousbiomes.common.world;

import com.mojang.datafixers.util.Pair;
import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class MysteriousRegion extends Region {

    public MysteriousRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(
        Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(
            mapper,
            builder -> {
                builder.replaceBiome(Biomes.SAVANNA, MysteriousCommon.BLOODIED_PLAINS);
                builder.replaceBiome(Biomes.SAVANNA_PLATEAU, MysteriousCommon.GHOSTLY_WOODLANDS);
                builder.replaceBiome(Biomes.WINDSWEPT_SAVANNA, MysteriousCommon.SORBUS_HIGHLANDS);
                builder.replaceBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS, MysteriousCommon.SEEPING_FOREST);
            });
    }
}
