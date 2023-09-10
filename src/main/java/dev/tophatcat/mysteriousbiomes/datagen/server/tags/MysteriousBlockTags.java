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
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class MysteriousBlockTags {

    public static final TagKey<Block> DIRT = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("dirt"));
    public static final TagKey<Block> PLANKS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("planks"));
    public static final TagKey<Block> WOODEN_BUTTONS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wooden_buttons"));
    public static final TagKey<Block> BUTTONS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("buttons"));
    public static final TagKey<Block> WOODEN_DOORS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wooden_doors"));
    public static final TagKey<Block> WOODEN_STAIRS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wooden_stairs"));
    public static final TagKey<Block> WOODEN_SLABS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wooden_slabs"));
    public static final TagKey<Block> WOODEN_FENCES = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wooden_fences"));
    public static final TagKey<Block> WOODEN_PRESSURE_PLATES = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wooden_pressure_plates"));
    public static final TagKey<Block> PRESSURE_PLATES = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("pressure_plates"));
    public static final TagKey<Block> WOODEN_TRAPDOORS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wooden_trapdoors"));
    public static final TagKey<Block> DOORS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("doors"));
    public static final TagKey<Block> SAPLINGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("saplings"));
    public static final TagKey<Block> LOGS_THAT_BURN = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("logs_that_burn"));
    public static final TagKey<Block> OVERWORLD_NATURAL_LOGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("overworld_natural_logs"));
    public static final TagKey<Block> LOGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("logs"));
    public static final TagKey<Block> BLOODWOOD_LOGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier(MysteriousBiomes.MOD_ID, "bloodwood_logs"));
    public static final TagKey<Block> GHOSTLY_LOGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier(MysteriousBiomes.MOD_ID, "ghostly_logs"));
    public static final TagKey<Block> SEEPING_LOGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier(MysteriousBiomes.MOD_ID, "seeping_logs"));
    public static final TagKey<Block> SORBUS_LOGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier(MysteriousBiomes.MOD_ID, "sorbus_logs"));
    public static final TagKey<Block> WALNUT_LOGS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier(MysteriousBiomes.MOD_ID, "walnut_logs"));
    public static final TagKey<Block> STAIRS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("stairs"));
    public static final TagKey<Block> SLABS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("slabs"));
    public static final TagKey<Block> LEAVES = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("leaves"));
    public static final TagKey<Block> TRAPDOORS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("trapdoors"));
    public static final TagKey<Block> FENCES = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("fences"));
    public static final TagKey<Block> STANDING_SIGNS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("standing_signs"));
    public static final TagKey<Block> WALL_SIGNS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wall_signs"));
    public static final TagKey<Block> SIGNS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("signs"));
    public static final TagKey<Block> CEILING_HANGING_SIGNS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("ceiling_hanging_signs"));
    public static final TagKey<Block> WALL_HANGING_SIGNS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("wall_hanging_signs"));
    public static final TagKey<Block> ALL_HANGING_SIGNS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("all_hanging_signs"));
    public static final TagKey<Block> ALL_SIGNS = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("all_signs"));
    public static final TagKey<Block> FENCE_GATES = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("fence_gates"));
    public static final TagKey<Block> AXE_MINEABLE = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("mineable/axe"));
    public static final TagKey<Block> HOE_MINEABLE = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("mineable/hoe"));
    public static final TagKey<Block> SHOVEL_MINEABLE = TagKey.of(RegistryKeys.BLOCK,
            new Identifier("mineable/shovel"));
}
