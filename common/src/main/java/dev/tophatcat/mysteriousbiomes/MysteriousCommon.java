/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2025
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

import dev.tophatcat.mysteriouslands.platform.IPlatform;
import dev.tophatcat.mysteriouslands.registry.BlockRegistry;
import dev.tophatcat.mysteriouslands.registry.CreativeTabRegistry;
import dev.tophatcat.mysteriouslands.registry.EntityRegistry;
import dev.tophatcat.mysteriouslands.registry.ItemRegistry;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousWoodType;
import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated
public class MysteriousCommon {

    public static final String MOD_ID = "mysteriousbiomes";
    public static final String MOD_NAME = "Mysterious Biomes";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final IPlatform COMMON_PLATFORM = ServiceLoader.load(IPlatform.class).findFirst().orElseThrow();

    public static final ResourceKey<Biome> BLOOD_SOAKED_PLAINS = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "blood_soaked_plains"));
    public static final ResourceKey<Biome> GHOSTLY_WOODLANDS = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "ghostly_woodlands"));
    public static final ResourceKey<Biome> SEEPING_FOREST = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "seeping_forest"));
    public static final ResourceKey<Biome> SORBUS_HIGHLANDS = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "sorbus_highlands"));
    public static final ResourceKey<Biome> WALNUT_WOODLANDS = ResourceKey.create(Registries.BIOME,
        ResourceLocation.fromNamespaceAndPath(MOD_ID, "walnut_woodlands"));

    public static void init() {
        LOG.debug("We are currently loaded via the {} mod loader in a {} environment!",
            COMMON_PLATFORM.getPlatformName(),
            COMMON_PLATFORM.getEnvironmentName());
    }

    public static void setupBlockEntities() {
        // FIXME one of the access transformers must not be working here for .validBlocks
        Set<Block> signBlocks = new HashSet<>(BlockEntityType.SIGN.validBlocks);
        Set<Block> hangingSignBlocks = new HashSet<>(BlockEntityType.HANGING_SIGN.validBlocks);

        signBlocks.add(BlockRegistry.BLOOD_SOAKED_FLOOR_SIGN.get());
        signBlocks.add(BlockRegistry.BLOOD_SOAKED_WALL_SIGN.get());
        signBlocks.add(BlockRegistry.GHOSTLY_FLOOR_SIGN.get());
        signBlocks.add(BlockRegistry.GHOSTLY_WALL_SIGN.get());
        signBlocks.add(BlockRegistry.SEEPING_FLOOR_SIGN.get());
        signBlocks.add(BlockRegistry.SEEPING_WALL_SIGN.get());
        signBlocks.add(BlockRegistry.SORBUS_FLOOR_SIGN.get());
        signBlocks.add(BlockRegistry.SORBUS_WALL_SIGN.get());
        signBlocks.add(BlockRegistry.WALNUT_FLOOR_SIGN.get());
        signBlocks.add(BlockRegistry.WALNUT_WALL_SIGN.get());

        hangingSignBlocks.add(BlockRegistry.BLOOD_SOAKED_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.BLOOD_SOAKED_WALL_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.GHOSTLY_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.GHOSTLY_WALL_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.SEEPING_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.SEEPING_WALL_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.SORBUS_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.SORBUS_WALL_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.WALNUT_HANGING_SIGN.get());
        hangingSignBlocks.add(BlockRegistry.WALNUT_WALL_HANGING_SIGN.get());

        BlockEntityType.SIGN.validBlocks = signBlocks;
        BlockEntityType.HANGING_SIGN.validBlocks = hangingSignBlocks;
    }
}
