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
package dev.tophatcat.mysteriousbiomes.utils;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MysteriousTags {

    public static final class MysteriousBlocks {
        public static final TagKey<Block> BLOODWOOD_LOGS =
            TagKey.create(
                Registries.BLOCK, new ResourceLocation(MysteriousCommon.MOD_ID, "bloodwood_logs"));
        public static final TagKey<Block> GHOSTLY_LOGS =
            TagKey.create(
                Registries.BLOCK, new ResourceLocation(MysteriousCommon.MOD_ID, "ghostly_logs"));
        public static final TagKey<Block> SEEPING_LOGS =
            TagKey.create(
                Registries.BLOCK, new ResourceLocation(MysteriousCommon.MOD_ID, "seeping_logs"));
        public static final TagKey<Block> SORBUS_LOGS =
            TagKey.create(
                Registries.BLOCK, new ResourceLocation(MysteriousCommon.MOD_ID, "sorbus_logs"));
        public static final TagKey<Block> WALNUT_LOGS =
            TagKey.create(
                Registries.BLOCK, new ResourceLocation(MysteriousCommon.MOD_ID, "walnut_logs"));

        // Needed for our mixin for signs to be placable in the world.
        public static final TagKey<Block> SIGNS =
            TagKey.create(Registries.BLOCK, new ResourceLocation(MysteriousCommon.MOD_ID, "signs"));
        public static final TagKey<Block> HANGING_SIGNS =
            TagKey.create(
                Registries.BLOCK, new ResourceLocation(MysteriousCommon.MOD_ID, "hanging_signs"));
    }

    public static final class MysteriousItems {
        public static final TagKey<Item> BLOODWOOD_LOGS =
            TagKey.create(
                Registries.ITEM, new ResourceLocation(MysteriousCommon.MOD_ID, "bloodwood_logs"));
        public static final TagKey<Item> GHOSTLY_LOGS =
            TagKey.create(
                Registries.ITEM, new ResourceLocation(MysteriousCommon.MOD_ID, "ghostly_logs"));
        public static final TagKey<Item> SEEPING_LOGS =
            TagKey.create(
                Registries.ITEM, new ResourceLocation(MysteriousCommon.MOD_ID, "seeping_logs"));
        public static final TagKey<Item> SORBUS_LOGS =
            TagKey.create(
                Registries.ITEM, new ResourceLocation(MysteriousCommon.MOD_ID, "sorbus_logs"));
        public static final TagKey<Item> WALNUT_LOGS =
            TagKey.create(
                Registries.ITEM, new ResourceLocation(MysteriousCommon.MOD_ID, "walnut_logs"));
    }
}
