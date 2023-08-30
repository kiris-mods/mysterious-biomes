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

import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;

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
                MysteriousBlockTypes.SAKURA);

        mysteriousWoodTypes.forEach(woodType -> {
            addDrop(woodType.getTrapdoor().get());
            addDrop(woodType.getSlab().get());
            addDrop(woodType.getStairs().get());
            addDrop(woodType.getPlanks().get());
            addDrop(woodType.getLog().get());
            addDrop(woodType.getStrippedLog().get());
            addDrop(woodType.getWood().get());
            addDrop(woodType.getStrippedWood().get());
            addDrop(woodType.getGate().get());
            addDrop(woodType.getFence().get());
            addDrop(woodType.getButton().get());
            addDrop(woodType.getPressurePlate().get());
            addDrop(woodType.getSapling().get());
            addDrop(Block.getBlockFromItem(woodType.getSign().get()));
            addDrop(woodType.getWallSign().get());
            addDrop(woodType.getHangingSign().get());
            addDrop(woodType.getWallHangingSign().get());
            addDrop(woodType.getDoor().get(), this::doorDrops);
            addDrop(woodType.getLeaves().get(), block -> leavesDrops(woodType.getLeaves().get(),
                    woodType.getSapling().get(),
                    BlockLootTableGenerator.SAPLING_DROP_CHANCE));
        });

        addDrop(MysteriousContentSetup.BLOODIED_DIRT.get());
        addDrop(MysteriousContentSetup.BLOODIED_GRASS.get(), block
                -> drops(block, MysteriousContentSetup.BLOODIED_DIRT.get()));
    }
}
