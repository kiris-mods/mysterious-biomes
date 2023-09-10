/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
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
package dev.tophatcat.mysteriousbiomes.datagen.server.tags;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MysteriousItemTags {

    public static final TagKey<Item> DIRT = TagKey.of(RegistryKeys.ITEM,
            new Identifier("dirt"));
    public static final TagKey<Item> PLANKS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("planks"));
    public static final TagKey<Item> WOODEN_BUTTONS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wooden_buttons"));
    public static final TagKey<Item> BUTTONS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("buttons"));
    public static final TagKey<Item> WOODEN_DOORS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wooden_doors"));
    public static final TagKey<Item> WOODEN_STAIRS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wooden_stairs"));
    public static final TagKey<Item> WOODEN_SLABS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wooden_slabs"));
    public static final TagKey<Item> WOODEN_FENCES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wooden_fences"));
    public static final TagKey<Item> WOODEN_PRESSURE_PLATES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wooden_pressure_plates"));
    public static final TagKey<Item> PRESSURE_PLATES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("pressure_plates"));
    public static final TagKey<Item> WOODEN_TRAPDOORS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wooden_trapdoors"));
    public static final TagKey<Item> DOORS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("doors"));
    public static final TagKey<Item> SAPLINGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("saplings"));
    public static final TagKey<Item> LOGS_THAT_BURN = TagKey.of(RegistryKeys.ITEM,
            new Identifier("logs_that_burn"));
    public static final TagKey<Item> LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("logs"));
    public static final TagKey<Item> BLOODWOOD_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(MysteriousBiomes.MOD_ID, "bloodwood_logs"));
    public static final TagKey<Item> GHOSTLY_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(MysteriousBiomes.MOD_ID, "ghostly_logs"));
    public static final TagKey<Item> SEEPING_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(MysteriousBiomes.MOD_ID, "seeping_logs"));
    public static final TagKey<Item> SORBUS_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(MysteriousBiomes.MOD_ID, "sorbus_logs"));
    public static final TagKey<Item> WALNUT_LOGS = TagKey.of(RegistryKeys.ITEM,
            new Identifier(MysteriousBiomes.MOD_ID, "walnut_logs"));
    public static final TagKey<Item> STAIRS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("stairs"));
    public static final TagKey<Item> SLABS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("slabs"));
    public static final TagKey<Item> LEAVES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("leaves"));
    public static final TagKey<Item> TRAPDOORS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("trapdoors"));
    public static final TagKey<Item> FENCES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("fences"));
    public static final TagKey<Item> STANDING_SIGNS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("standing_signs"));
    public static final TagKey<Item> WALL_SIGNS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wall_signs"));
    public static final TagKey<Item> SIGNS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("signs"));
    public static final TagKey<Item> CEILING_HANGING_SIGNS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("ceiling_hanging_signs"));
    public static final TagKey<Item> WALL_HANGING_SIGNS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("wall_hanging_signs"));
    public static final TagKey<Item> ALL_HANGING_SIGNS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("all_hanging_signs"));
    public static final TagKey<Item> ALL_SIGNS = TagKey.of(RegistryKeys.ITEM,
            new Identifier("all_signs"));
    public static final TagKey<Item> FENCE_GATES = TagKey.of(RegistryKeys.ITEM,
            new Identifier("fence_gates"));
}
