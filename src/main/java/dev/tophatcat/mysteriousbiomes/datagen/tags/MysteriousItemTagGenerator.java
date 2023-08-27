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
package dev.tophatcat.mysteriousbiomes.datagen.tags;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousBlockTypes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MysteriousItemTagGenerator extends FabricTagProvider.ItemTagProvider {

    public MysteriousItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup>
            completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(MysteriousItemTags.PLANKS)
            .add(MysteriousBlockTypes.BLOODWOOD.getPlanks().get().asItem().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getPlanks().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getPlanks().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getPlanks().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getPlanks().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_BUTTONS)
            .add(MysteriousBlockTypes.BLOODWOOD.getButton().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getButton().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getButton().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getButton().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getButton().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_DOORS)
            .add(MysteriousBlockTypes.BLOODWOOD.getDoor().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getDoor().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getDoor().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getDoor().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getDoor().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_STAIRS)
            .add(MysteriousBlockTypes.BLOODWOOD.getStairs().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getStairs().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getStairs().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getStairs().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getStairs().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_SLABS)
            .add(MysteriousBlockTypes.BLOODWOOD.getSlab().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getSlab().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getSlab().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getSlab().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getSlab().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_FENCES)
            .add(MysteriousBlockTypes.BLOODWOOD.getFence().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getFence().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getFence().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getFence().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getFence().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.SAPLINGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getSapling().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getSapling().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getSapling().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getSapling().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getSapling().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.LOGS)
            .addTag(MysteriousItemTags.LOGS_THAT_BURN);

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_PRESSURE_PLATES)
            .add(MysteriousBlockTypes.BLOODWOOD.getPressurePlate().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getPressurePlate().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getPressurePlate().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getPressurePlate().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getPressurePlate().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.LEAVES)
            .add(MysteriousBlockTypes.BLOODWOOD.getLeaves().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getLeaves().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getLeaves().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getLeaves().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getLeaves().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_TRAPDOORS)
            .add(MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getTrapdoor().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getTrapdoor().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getTrapdoor().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getTrapdoor().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.STANDING_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getSign().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getSign().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getSign().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getSign().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getSign().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WALL_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getWallSign().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getWallSign().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getWallSign().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getWallSign().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getWallSign().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.CEILING_HANGING_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getHangingSign().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getHangingSign().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getHangingSign().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getHangingSign().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getHangingSign().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WALL_HANGING_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getWallHangingSign().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getWallHangingSign().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getWallHangingSign().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getWallHangingSign().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getWallHangingSign().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.FENCE_GATES)
            .add(MysteriousBlockTypes.BLOODWOOD.getGate().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getGate().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getGate().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getGate().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getGate().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.DIRT)
            .add(MysteriousContentSetup.BLOODIED_DIRT.get().asItem())
            .add(MysteriousContentSetup.BLOODIED_GRASS.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.BUTTONS).addTag(MysteriousItemTags.WOODEN_BUTTONS);
        getOrCreateTagBuilder(MysteriousItemTags.DOORS).addTag(MysteriousItemTags.WOODEN_DOORS);

        getOrCreateTagBuilder(MysteriousItemTags.BLOODWOOD_LOGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getLog().get().asItem())
            .add(MysteriousBlockTypes.BLOODWOOD.getStrippedLog().get().asItem())
            .add(MysteriousBlockTypes.BLOODWOOD.getWood().get().asItem())
            .add(MysteriousBlockTypes.BLOODWOOD.getStrippedWood().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.GHOSTLY_LOGS)
            .add(MysteriousBlockTypes.GHOSTLY.getLog().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getStrippedLog().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getWood().get().asItem())
            .add(MysteriousBlockTypes.GHOSTLY.getStrippedWood().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.SORBUS_LOGS)
            .add(MysteriousBlockTypes.SORBUS.getLog().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getStrippedLog().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getWood().get().asItem())
            .add(MysteriousBlockTypes.SORBUS.getStrippedWood().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.SEEPING_LOGS)
            .add(MysteriousBlockTypes.SEEPING.getLog().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getStrippedLog().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getWood().get().asItem())
            .add(MysteriousBlockTypes.SEEPING.getStrippedWood().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.SAKURA_LOGS)
            .add(MysteriousBlockTypes.SAKURA.getLog().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getStrippedLog().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getWood().get().asItem())
            .add(MysteriousBlockTypes.SAKURA.getStrippedWood().get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.LOGS_THAT_BURN)
            .addTag(MysteriousItemTags.BLOODWOOD_LOGS)
            .addTag(MysteriousItemTags.GHOSTLY_LOGS)
            .addTag(MysteriousItemTags.SORBUS_LOGS)
            .addTag(MysteriousItemTags.SEEPING_LOGS)
            .addTag(MysteriousItemTags.SAKURA_LOGS);

        getOrCreateTagBuilder(MysteriousItemTags.PRESSURE_PLATES)
            .addTag(MysteriousItemTags.WOODEN_PRESSURE_PLATES);

        getOrCreateTagBuilder(MysteriousItemTags.STAIRS)
            .addTag(MysteriousItemTags.WOODEN_STAIRS);

        getOrCreateTagBuilder(MysteriousItemTags.SLABS)
            .addTag(MysteriousItemTags.WOODEN_SLABS);

        getOrCreateTagBuilder(MysteriousItemTags.TRAPDOORS)
            .addTag(MysteriousItemTags.WOODEN_TRAPDOORS);

        getOrCreateTagBuilder(MysteriousItemTags.SIGNS)
            .addTag(MysteriousItemTags.STANDING_SIGNS)
            .addTag(MysteriousItemTags.WALL_SIGNS);

        getOrCreateTagBuilder(MysteriousItemTags.ALL_HANGING_SIGNS)
            .addTag(MysteriousItemTags.CEILING_HANGING_SIGNS)
            .addTag(MysteriousItemTags.WALL_HANGING_SIGNS);

        getOrCreateTagBuilder(MysteriousItemTags.ALL_SIGNS)
            .addTag(MysteriousItemTags.SIGNS)
            .addTag(MysteriousItemTags.ALL_HANGING_SIGNS);

        getOrCreateTagBuilder(MysteriousItemTags.FENCES)
            .addTag(MysteriousItemTags.WOODEN_FENCES);
    }
}
