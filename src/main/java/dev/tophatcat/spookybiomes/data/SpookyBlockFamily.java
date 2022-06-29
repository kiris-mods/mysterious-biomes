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
package dev.tophatcat.spookybiomes.data;

import com.google.common.collect.ImmutableList;
import dev.tophatcat.spookybiomes.common.SpookyTags;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * A family of blocks for a wood type.
 *
 * <p>This is used in the various data providers to repeat the same processes for each block in a family, instead of
 * duplicating code for defining and operating on each family.</p>
 */
record SpookyBlockFamily(Supplier<? extends Block> planks,
                         Supplier<? extends SlabBlock> slab,
                         Supplier<? extends StairBlock> stairs,
                         Supplier<? extends PressurePlateBlock> pressurePlate,
                         Supplier<? extends ButtonBlock> button,
                         Supplier<? extends FenceBlock> fence,
                         Supplier<? extends FenceGateBlock> fenceGate,
                         Supplier<? extends DoorBlock> door,
                         Supplier<? extends TrapDoorBlock> trapdoor,
                         Supplier<? extends StandingSignBlock> standingSign,
                         Supplier<? extends WallSignBlock> wallSign,
                         Supplier<? extends RotatedPillarBlock> log,
                         Supplier<? extends RotatedPillarBlock> strippedLog,
                         Supplier<? extends LeavesBlock> leaves,
                         Supplier<? extends SaplingBlock> sapling,
                         Tag.Named<Block> logsBlockTag,
                         Tag.Named<Item> logsItemTag) {
    public static final SpookyBlockFamily SORBUS = new SpookyBlockFamily(
        SpookyBlocks.SORBUS_PLANKS,
        SpookyBlocks.SORBUS_SLAB, SpookyBlocks.SORBUS_STAIRS,
        SpookyBlocks.SORBUS_PRESSURE_PLATE, SpookyBlocks.SORBUS_BUTTON,
        SpookyBlocks.SORBUS_FENCE, SpookyBlocks.SORBUS_GATE,
        SpookyBlocks.SORBUS_DOOR, SpookyBlocks.SORBUS_TRAPDOOR,
        SpookyBlocks.SORBUS_SIGN, SpookyBlocks.SORBUS_WALL_SIGN,
        SpookyBlocks.SORBUS_LOG, SpookyBlocks.SORBUS_LOG_STRIPPED,
        SpookyBlocks.SORBUS_LEAVES, SpookyBlocks.SORBUS_SAPLING,
        SpookyTags.Blocks.SORBUS_LOGS, SpookyTags.Items.SORBUS_LOGS
    );

    public static final SpookyBlockFamily GHOSTLY = new SpookyBlockFamily(
        SpookyBlocks.GHOSTLY_PLANKS,
        SpookyBlocks.GHOSTLY_SLAB, SpookyBlocks.GHOSTLY_STAIRS,
        SpookyBlocks.GHOSTLY_PRESSURE_PLATE, SpookyBlocks.GHOSTLY_BUTTON,
        SpookyBlocks.GHOSTLY_FENCE, SpookyBlocks.GHOSTLY_GATE,
        SpookyBlocks.GHOSTLY_DOOR, SpookyBlocks.GHOSTLY_TRAPDOOR,
        SpookyBlocks.GHOSTLY_SIGN, SpookyBlocks.GHOSTLY_WALL_SIGN,
        SpookyBlocks.GHOSTLY_LOG, SpookyBlocks.GHOSTLY_LOG_STRIPPED,
        SpookyBlocks.GHOSTLY_LEAVES, SpookyBlocks.GHOSTLY_SAPLING,
        SpookyTags.Blocks.GHOSTLY_LOGS, SpookyTags.Items.GHOSTLY_LOGS
    );

    public static final SpookyBlockFamily SEEPING = new SpookyBlockFamily(
        SpookyBlocks.SEEPING_PLANKS,
        SpookyBlocks.SEEPING_SLAB, SpookyBlocks.SEEPING_STAIRS,
        SpookyBlocks.SEEPING_PRESSURE_PLATE, SpookyBlocks.SEEPING_BUTTON,
        SpookyBlocks.SEEPING_FENCE, SpookyBlocks.SEEPING_GATE,
        SpookyBlocks.SEEPING_DOOR, SpookyBlocks.SEEPING_TRAPDOOR,
        SpookyBlocks.SEEPING_SIGN, SpookyBlocks.SEEPING_WALL_SIGN,
        SpookyBlocks.SEEPING_LOG, SpookyBlocks.SEEPING_LOG_STRIPPED,
        SpookyBlocks.SEEPING_LEAVES, SpookyBlocks.SEEPING_SAPLING,
        SpookyTags.Blocks.SEEPING_LOGS, SpookyTags.Items.SEEPING_LOGS
    );

    public static final SpookyBlockFamily BLOODWOOD = new SpookyBlockFamily(
        SpookyBlocks.BLOODWOOD_PLANKS,
        SpookyBlocks.BLOODWOOD_SLAB, SpookyBlocks.BLOODWOOD_STAIRS,
        SpookyBlocks.BLOODWOOD_PRESSURE_PLATE, SpookyBlocks.BLOODWOOD_BUTTON,
        SpookyBlocks.BLOODWOOD_FENCE, SpookyBlocks.BLOODWOOD_GATE,
        SpookyBlocks.BLOODWOOD_DOOR, SpookyBlocks.BLOODWOOD_TRAPDOOR,
        SpookyBlocks.BLOODWOOD_SIGN, SpookyBlocks.BLOODWOOD_WALL_SIGN,
        SpookyBlocks.BLOODWOOD_LOG, SpookyBlocks.BLOODWOOD_LOG_STRIPPED,
        SpookyBlocks.BLOODWOOD_LEAVES, SpookyBlocks.BLOODWOOD_SAPLING,
        SpookyTags.Blocks.BLOODWOOD_LOGS, SpookyTags.Items.BLOODWOOD_LOGS
    );

    public static final Collection<SpookyBlockFamily> FAMILIES = ImmutableList.of(SORBUS, GHOSTLY, SEEPING, BLOODWOOD);
}
