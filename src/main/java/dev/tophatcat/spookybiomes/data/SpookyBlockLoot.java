/*
 * Spooky Biomes - https://tophatcat.dev/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;

import javax.annotation.Nonnull;

public class SpookyBlockLoot extends BlockLoot {
    protected static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        dropSelf(SpookyBlocks.BLOODIED_DIRT.get());
        add(SpookyBlocks.BLOODIED_GRASS.get(), b -> createSingleItemTableWithSilkTouch(b, SpookyBlocks.BLOODIED_DIRT.get()));

        for (SpookyBlockFamily family : SpookyBlockFamily.FAMILIES) {
            dropSelf(family.planks().get());
            add(family.slab().get(), BlockLoot::createSlabItemTable);
            dropSelf(family.stairs().get());
            dropSelf(family.pressurePlate().get());
            dropSelf(family.button().get());
            dropSelf(family.fence().get());
            dropSelf(family.fenceGate().get());
            add(family.door().get(), BlockLoot::createDoorTable);
            dropSelf(family.trapdoor().get());
            dropSelf(family.standingSign().get());
            dropSelf(family.log().get());
            dropSelf(family.strippedLog().get());
            dropSelf(family.sapling().get());
            add(family.leaves().get(), b -> createLeavesDrops(b, family.sapling().get(), NORMAL_LEAVES_SAPLING_CHANCES));
        }
    }

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SpookyBlocks.BLOCKS.getEntries().stream()
            .map(RegistryObject::get)
            .toList();
    }
}
