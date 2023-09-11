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
package dev.tophatcat.mysteriousbiomes.datagen.server;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.block.Block;
import java.util.List;

public class MysteriousBlockLootTableGenerator extends FabricBlockLootTableProvider {

    public MysteriousBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        var mysteriousWoodTypes = List.of(
                MysteriousBlockTypes.BLOODWOOD,
                MysteriousBlockTypes.GHOSTLY,
                MysteriousBlockTypes.SORBUS,
                MysteriousBlockTypes.SEEPING,
                MysteriousBlockTypes.WALNUT);

        mysteriousWoodTypes.forEach(woodType -> {
            dropSelf(woodType.getTrapdoor().get());
            dropSelf(woodType.getSlab().get());
            dropSelf(woodType.getStairs().get());
            dropSelf(woodType.getPlanks().get());
            dropSelf(woodType.getLog().get());
            dropSelf(woodType.getStrippedLog().get());
            dropSelf(woodType.getWood().get());
            dropSelf(woodType.getStrippedWood().get());
            dropSelf(woodType.getGate().get());
            dropSelf(woodType.getFence().get());
            dropSelf(woodType.getButton().get());
            dropSelf(woodType.getPressurePlate().get());
            dropSelf(woodType.getSapling().get());
            dropSelf(Block.byItem(woodType.getSign().get()));
            dropSelf(woodType.getWallSign().get());
            dropSelf(woodType.getHangingSign().get());
            dropSelf(woodType.getWallHangingSign().get());
            add(woodType.getDoor().get(), this::createDoorTable);
            add(woodType.getLeaves().get(), block -> createLeavesDrops(woodType.getLeaves().get(),
                    woodType.getSapling().get(),
                    BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));
        });

        dropSelf(MysteriousContentSetup.BLOODIED_DIRT.get());
        add(MysteriousContentSetup.BLOODIED_GRASS.get(), block
                -> createSingleItemTableWithSilkTouch(block, MysteriousContentSetup.BLOODIED_DIRT.get()));
    }
}
