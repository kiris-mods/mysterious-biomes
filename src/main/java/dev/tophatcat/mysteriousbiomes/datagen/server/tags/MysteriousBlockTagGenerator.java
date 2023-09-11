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

import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class MysteriousBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public MysteriousBlockTagGenerator(FabricDataOutput output,
                                       CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(MysteriousBlockTags.PLANKS)
            .add(MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
            .add(MysteriousBlockTypes.GHOSTLY.getPlanks().get())
            .add(MysteriousBlockTypes.SEEPING.getPlanks().get())
            .add(MysteriousBlockTypes.SORBUS.getPlanks().get())
            .add(MysteriousBlockTypes.WALNUT.getPlanks().get());

        tag(MysteriousBlockTags.WOODEN_BUTTONS)
            .add(MysteriousBlockTypes.BLOODWOOD.getButton().get())
            .add(MysteriousBlockTypes.GHOSTLY.getButton().get())
            .add(MysteriousBlockTypes.SEEPING.getButton().get())
            .add(MysteriousBlockTypes.SORBUS.getButton().get())
            .add(MysteriousBlockTypes.WALNUT.getButton().get());

        tag(MysteriousBlockTags.WOODEN_DOORS)
            .add(MysteriousBlockTypes.BLOODWOOD.getDoor().get())
            .add(MysteriousBlockTypes.GHOSTLY.getDoor().get())
            .add(MysteriousBlockTypes.SEEPING.getDoor().get())
            .add(MysteriousBlockTypes.SORBUS.getDoor().get())
            .add(MysteriousBlockTypes.WALNUT.getDoor().get());

        tag(MysteriousBlockTags.WOODEN_STAIRS)
            .add(MysteriousBlockTypes.BLOODWOOD.getStairs().get())
            .add(MysteriousBlockTypes.GHOSTLY.getStairs().get())
            .add(MysteriousBlockTypes.SEEPING.getStairs().get())
            .add(MysteriousBlockTypes.SORBUS.getStairs().get())
            .add(MysteriousBlockTypes.WALNUT.getStairs().get());

        tag(MysteriousBlockTags.WOODEN_SLABS)
            .add(MysteriousBlockTypes.BLOODWOOD.getSlab().get())
            .add(MysteriousBlockTypes.GHOSTLY.getSlab().get())
            .add(MysteriousBlockTypes.SEEPING.getSlab().get())
            .add(MysteriousBlockTypes.SORBUS.getSlab().get())
            .add(MysteriousBlockTypes.WALNUT.getSlab().get());

        tag(MysteriousBlockTags.WOODEN_FENCES)
            .add(MysteriousBlockTypes.BLOODWOOD.getFence().get())
            .add(MysteriousBlockTypes.GHOSTLY.getFence().get())
            .add(MysteriousBlockTypes.SEEPING.getFence().get())
            .add(MysteriousBlockTypes.SORBUS.getFence().get())
            .add(MysteriousBlockTypes.WALNUT.getFence().get());

        tag(MysteriousBlockTags.SAPLINGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getSapling().get())
            .add(MysteriousBlockTypes.GHOSTLY.getSapling().get())
            .add(MysteriousBlockTypes.SEEPING.getSapling().get())
            .add(MysteriousBlockTypes.SORBUS.getSapling().get())
            .add(MysteriousBlockTypes.WALNUT.getSapling().get());

        tag(MysteriousBlockTags.LOGS)
            .addTag(MysteriousBlockTags.LOGS_THAT_BURN);

        tag(MysteriousBlockTags.OVERWORLD_NATURAL_LOGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getLog().get())
            .add(MysteriousBlockTypes.GHOSTLY.getLog().get())
            .add(MysteriousBlockTypes.SEEPING.getLog().get())
            .add(MysteriousBlockTypes.SORBUS.getLog().get())
            .add(MysteriousBlockTypes.WALNUT.getLog().get());

        tag(MysteriousBlockTags.WOODEN_PRESSURE_PLATES)
            .add(MysteriousBlockTypes.BLOODWOOD.getPressurePlate().get())
            .add(MysteriousBlockTypes.GHOSTLY.getPressurePlate().get())
            .add(MysteriousBlockTypes.SEEPING.getPressurePlate().get())
            .add(MysteriousBlockTypes.SORBUS.getPressurePlate().get())
            .add(MysteriousBlockTypes.WALNUT.getPressurePlate().get());

        tag(MysteriousBlockTags.LEAVES)
            .add(MysteriousBlockTypes.BLOODWOOD.getLeaves().get())
            .add(MysteriousBlockTypes.GHOSTLY.getLeaves().get())
            .add(MysteriousBlockTypes.SEEPING.getLeaves().get())
            .add(MysteriousBlockTypes.SORBUS.getLeaves().get())
            .add(MysteriousBlockTypes.WALNUT.getLeaves().get());

        tag(MysteriousBlockTags.WOODEN_TRAPDOORS)
            .add(MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get())
            .add(MysteriousBlockTypes.GHOSTLY.getTrapdoor().get())
            .add(MysteriousBlockTypes.SEEPING.getTrapdoor().get())
            .add(MysteriousBlockTypes.SORBUS.getTrapdoor().get())
            .add(MysteriousBlockTypes.WALNUT.getTrapdoor().get());

        tag(MysteriousBlockTags.STANDING_SIGNS)
            .add(Block.byItem(MysteriousBlockTypes.BLOODWOOD.getSign().get()))
            .add(Block.byItem(MysteriousBlockTypes.GHOSTLY.getSign().get()))
            .add(Block.byItem(MysteriousBlockTypes.SEEPING.getSign().get()))
            .add(Block.byItem(MysteriousBlockTypes.SORBUS.getSign().get()))
            .add(Block.byItem(MysteriousBlockTypes.WALNUT.getSign().get()));

        tag(MysteriousBlockTags.WALL_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getWallSign().get())
            .add(MysteriousBlockTypes.GHOSTLY.getWallSign().get())
            .add(MysteriousBlockTypes.SEEPING.getWallSign().get())
            .add(MysteriousBlockTypes.SORBUS.getWallSign().get())
            .add(MysteriousBlockTypes.WALNUT.getWallSign().get());

        tag(MysteriousBlockTags.CEILING_HANGING_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getHangingSign().get())
            .add(MysteriousBlockTypes.GHOSTLY.getHangingSign().get())
            .add(MysteriousBlockTypes.SEEPING.getHangingSign().get())
            .add(MysteriousBlockTypes.SORBUS.getHangingSign().get())
            .add(MysteriousBlockTypes.WALNUT.getHangingSign().get());

        tag(MysteriousBlockTags.WALL_HANGING_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getWallHangingSign().get())
            .add(MysteriousBlockTypes.GHOSTLY.getWallHangingSign().get())
            .add(MysteriousBlockTypes.SEEPING.getWallHangingSign().get())
            .add(MysteriousBlockTypes.SORBUS.getWallHangingSign().get())
            .add(MysteriousBlockTypes.WALNUT.getWallHangingSign().get());

        tag(MysteriousBlockTags.FENCE_GATES)
            .add(MysteriousBlockTypes.BLOODWOOD.getGate().get())
            .add(MysteriousBlockTypes.GHOSTLY.getGate().get())
            .add(MysteriousBlockTypes.SEEPING.getGate().get())
            .add(MysteriousBlockTypes.SORBUS.getGate().get())
            .add(MysteriousBlockTypes.WALNUT.getGate().get());

        tag(MysteriousBlockTags.DIRT)
            .add(MysteriousContentSetup.BLOODIED_DIRT.get())
            .add(MysteriousContentSetup.BLOODIED_GRASS.get());

        tag(MysteriousBlockTags.BUTTONS).addTag(MysteriousBlockTags.WOODEN_BUTTONS);
        tag(MysteriousBlockTags.DOORS).addTag(MysteriousBlockTags.WOODEN_DOORS);

        tag(MysteriousBlockTags.BLOODWOOD_LOGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getLog().get())
            .add(MysteriousBlockTypes.BLOODWOOD.getStrippedLog().get())
            .add(MysteriousBlockTypes.BLOODWOOD.getWood().get())
            .add(MysteriousBlockTypes.BLOODWOOD.getStrippedWood().get());

        tag(MysteriousBlockTags.GHOSTLY_LOGS)
            .add(MysteriousBlockTypes.GHOSTLY.getLog().get())
            .add(MysteriousBlockTypes.GHOSTLY.getStrippedLog().get())
            .add(MysteriousBlockTypes.GHOSTLY.getWood().get())
            .add(MysteriousBlockTypes.GHOSTLY.getStrippedWood().get());

        tag(MysteriousBlockTags.SORBUS_LOGS)
            .add(MysteriousBlockTypes.SORBUS.getLog().get())
            .add(MysteriousBlockTypes.SORBUS.getStrippedLog().get())
            .add(MysteriousBlockTypes.SORBUS.getWood().get())
            .add(MysteriousBlockTypes.SORBUS.getStrippedWood().get());

        tag(MysteriousBlockTags.SEEPING_LOGS)
            .add(MysteriousBlockTypes.SEEPING.getLog().get())
            .add(MysteriousBlockTypes.SEEPING.getStrippedLog().get())
            .add(MysteriousBlockTypes.SEEPING.getWood().get())
            .add(MysteriousBlockTypes.SEEPING.getStrippedWood().get());

        tag(MysteriousBlockTags.WALNUT_LOGS)
            .add(MysteriousBlockTypes.WALNUT.getLog().get())
            .add(MysteriousBlockTypes.WALNUT.getStrippedLog().get())
            .add(MysteriousBlockTypes.WALNUT.getWood().get())
            .add(MysteriousBlockTypes.WALNUT.getStrippedWood().get());

        tag(MysteriousBlockTags.LOGS_THAT_BURN)
            .addTag(MysteriousBlockTags.BLOODWOOD_LOGS)
            .addTag(MysteriousBlockTags.GHOSTLY_LOGS)
            .addTag(MysteriousBlockTags.SORBUS_LOGS)
            .addTag(MysteriousBlockTags.SEEPING_LOGS)
            .addTag(MysteriousBlockTags.WALNUT_LOGS);

        tag(MysteriousBlockTags.PRESSURE_PLATES)
            .addTag(MysteriousBlockTags.WOODEN_PRESSURE_PLATES);

        tag(MysteriousBlockTags.STAIRS)
            .addTag(MysteriousBlockTags.WOODEN_STAIRS);

        tag(MysteriousBlockTags.SLABS)
            .addTag(MysteriousBlockTags.WOODEN_SLABS);

        tag(MysteriousBlockTags.TRAPDOORS)
            .addTag(MysteriousBlockTags.WOODEN_TRAPDOORS);

        tag(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.STANDING_SIGNS)
            .addTag(MysteriousBlockTags.WALL_SIGNS);

        tag(MysteriousBlockTags.ALL_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.CEILING_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.WALL_HANGING_SIGNS);

        tag(MysteriousBlockTags.ALL_SIGNS)
            .addTag(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.ALL_HANGING_SIGNS);

        tag(MysteriousBlockTags.FENCES)
            .addTag(MysteriousBlockTags.WOODEN_FENCES);

        tag(MysteriousBlockTags.AXE_MINEABLE)
            .addTag(MysteriousBlockTags.ALL_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.WOODEN_TRAPDOORS)
            .addTag(MysteriousBlockTags.WOODEN_STAIRS)
            .addTag(MysteriousBlockTags.WOODEN_SLABS)
            .addTag(MysteriousBlockTags.WOODEN_PRESSURE_PLATES)
            .addTag(MysteriousBlockTags.WOODEN_FENCES)
            .addTag(MysteriousBlockTags.WOODEN_DOORS)
            .addTag(MysteriousBlockTags.WOODEN_BUTTONS)
            .addTag(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.SAPLINGS)
            .addTag(MysteriousBlockTags.PLANKS)
            .addTag(MysteriousBlockTags.LOGS)
            .addTag(MysteriousBlockTags.FENCE_GATES);

        tag(MysteriousBlockTags.HOE_MINEABLE)
            .addTag(MysteriousBlockTags.LEAVES);

        tag(MysteriousBlockTags.SHOVEL_MINEABLE)
            .add(MysteriousContentSetup.BLOODIED_GRASS.get())
            .add(MysteriousContentSetup.BLOODIED_DIRT.get());
    }
}
