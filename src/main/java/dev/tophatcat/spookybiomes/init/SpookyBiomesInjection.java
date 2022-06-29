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
package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpookyBiomesInjection {

    public static final DeferredRegister<Biome> BIOMES
        = DeferredRegister.create(ForgeRegistries.BIOMES, SpookyBiomes.MOD_ID);

    // Dummy biomes to make BiomeManager not blow up and for the json biomes to overwrite biome in world.
    static {
        BIOMES.register("bloodied_hills", OverworldBiomes::theVoid);
        BIOMES.register("ghostly_forest", OverworldBiomes::theVoid);
        BIOMES.register("seeping_forest", OverworldBiomes::theVoid);
        BIOMES.register("sorbus_forest", OverworldBiomes::theVoid);

        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "bloodied_hills")),
                5));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "ghostly_forest")),
                5));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "seeping_forest")),
                5));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "sorbus_forest")),
                5));
    }
}
