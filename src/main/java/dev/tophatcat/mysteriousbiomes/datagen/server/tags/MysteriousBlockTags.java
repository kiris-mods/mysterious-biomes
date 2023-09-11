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
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class MysteriousBlockTags {

    public static final TagKey<Block> DIRT = TagKey.create(Registries.BLOCK,
            new ResourceLocation("dirt"));
    public static final TagKey<Block> PLANKS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("planks"));
    public static final TagKey<Block> WOODEN_BUTTONS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wooden_buttons"));
    public static final TagKey<Block> BUTTONS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("buttons"));
    public static final TagKey<Block> WOODEN_DOORS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wooden_doors"));
    public static final TagKey<Block> WOODEN_STAIRS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wooden_stairs"));
    public static final TagKey<Block> WOODEN_SLABS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wooden_slabs"));
    public static final TagKey<Block> WOODEN_FENCES = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wooden_fences"));
    public static final TagKey<Block> WOODEN_PRESSURE_PLATES = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wooden_pressure_plates"));
    public static final TagKey<Block> PRESSURE_PLATES = TagKey.create(Registries.BLOCK,
            new ResourceLocation("pressure_plates"));
    public static final TagKey<Block> WOODEN_TRAPDOORS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wooden_trapdoors"));
    public static final TagKey<Block> DOORS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("doors"));
    public static final TagKey<Block> SAPLINGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("saplings"));
    public static final TagKey<Block> LOGS_THAT_BURN = TagKey.create(Registries.BLOCK,
            new ResourceLocation("logs_that_burn"));
    public static final TagKey<Block> OVERWORLD_NATURAL_LOGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("overworld_natural_logs"));
    public static final TagKey<Block> LOGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("logs"));
    public static final TagKey<Block> BLOODWOOD_LOGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation(MysteriousBiomes.MOD_ID, "bloodwood_logs"));
    public static final TagKey<Block> GHOSTLY_LOGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation(MysteriousBiomes.MOD_ID, "ghostly_logs"));
    public static final TagKey<Block> SEEPING_LOGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation(MysteriousBiomes.MOD_ID, "seeping_logs"));
    public static final TagKey<Block> SORBUS_LOGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation(MysteriousBiomes.MOD_ID, "sorbus_logs"));
    public static final TagKey<Block> WALNUT_LOGS = TagKey.create(Registries.BLOCK,
            new ResourceLocation(MysteriousBiomes.MOD_ID, "walnut_logs"));
    public static final TagKey<Block> STAIRS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("stairs"));
    public static final TagKey<Block> SLABS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("slabs"));
    public static final TagKey<Block> LEAVES = TagKey.create(Registries.BLOCK,
            new ResourceLocation("leaves"));
    public static final TagKey<Block> TRAPDOORS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("trapdoors"));
    public static final TagKey<Block> FENCES = TagKey.create(Registries.BLOCK,
            new ResourceLocation("fences"));
    public static final TagKey<Block> STANDING_SIGNS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("standing_signs"));
    public static final TagKey<Block> WALL_SIGNS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wall_signs"));
    public static final TagKey<Block> SIGNS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("signs"));
    public static final TagKey<Block> CEILING_HANGING_SIGNS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("ceiling_hanging_signs"));
    public static final TagKey<Block> WALL_HANGING_SIGNS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("wall_hanging_signs"));
    public static final TagKey<Block> ALL_HANGING_SIGNS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("all_hanging_signs"));
    public static final TagKey<Block> ALL_SIGNS = TagKey.create(Registries.BLOCK,
            new ResourceLocation("all_signs"));
    public static final TagKey<Block> FENCE_GATES = TagKey.create(Registries.BLOCK,
            new ResourceLocation("fence_gates"));
    public static final TagKey<Block> AXE_MINEABLE = TagKey.create(Registries.BLOCK,
            new ResourceLocation("mineable/axe"));
    public static final TagKey<Block> HOE_MINEABLE = TagKey.create(Registries.BLOCK,
            new ResourceLocation("mineable/hoe"));
    public static final TagKey<Block> SHOVEL_MINEABLE = TagKey.create(Registries.BLOCK,
            new ResourceLocation("mineable/shovel"));
}
