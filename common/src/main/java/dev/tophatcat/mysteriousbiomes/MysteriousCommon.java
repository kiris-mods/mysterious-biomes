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
package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.platform.Services;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousWoodType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysteriousCommon {

    // TODO
    // This stuff needs to be added back/remade for 1.20+
    // Updated model (or just grow The Forbidden Warlock to be 3 blocks high and wider for now)
    // Mist doesn't work at all, like we have no code for it at all because it's all from 1.12.2.
    // (Hire someone in to do this.
    // Biomes just don't generate, don't have working biomes.json stuff.
    // Need to figure out how to do trees in general.
    // Structures?
    // Flammable blocks.
    // Strippable logs
    // Fuel blocks.
    // Saplings.

    // TODO
    // Future content to be mulled over and implemented if the final rough idea is good enough.
    // Blood slime, grows for every 2 hits it does to the player until it's the same size as a regular
    // green slime.
    // Blood slime item drop that only drops if Haema is installed?
    // Mist poisons you as well as blinds you if you don't have the correct charm to enter the biome.
    // (Poison toggled via config for servers and should have a chat warning of sorts)
    // Charm of Poison Protection. (Protects against poison damage when in certain biomes)
    // Charm of Vision. (Lets you see further in biomes with dense mist)

    public static final String MOD_ID = "mysteriousbiomes";
    public static final String MOD_NAME = "Mysterious Biomes";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final ResourceKey<Biome> BLOODIED_PLAINS =
        ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "bloodied_plains"));
    public static final ResourceKey<Biome> GHOSTLY_WOODLANDS =
        ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "ghostly_woodlands"));
    public static final ResourceKey<Biome> SEEPING_FOREST =
        ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "seeping_forest"));
    public static final ResourceKey<Biome> SORBUS_HIGHLANDS =
        ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "sorbus_highlands"));

    public static void init() {
        LOG.debug(
            "We are currently loaded via the {} mod loader in a {} environment!",
            Services.PLATFORM.getPlatformName(),
            Services.PLATFORM.getEnvironmentName());

        MysteriousRegistry.init();
        MysteriousWoodType.init();
    }
}
