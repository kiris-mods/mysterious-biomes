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

import dev.tophatcat.mysteriousbiomes.init.MysteriousRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class MysteriousItemTagGenerator extends FabricTagProvider.ItemTagProvider {

    public MysteriousItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider>
        completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(MysteriousItemTags.PLANKS)
            .add(MysteriousRegistry.BLOODWOOD_PLANKS.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_PLANKS.get().asItem())
            .add(MysteriousRegistry.SEEPING_PLANKS.get().asItem())
            .add(MysteriousRegistry.SORBUS_PLANKS.get().asItem())
            .add(MysteriousRegistry.WALNUT_PLANKS.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_BUTTONS)
            .add(MysteriousRegistry.BLOODWOOD_BUTTON.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_BUTTON.get().asItem())
            .add(MysteriousRegistry.SEEPING_BUTTON.get().asItem())
            .add(MysteriousRegistry.SORBUS_BUTTON.get().asItem())
            .add(MysteriousRegistry.WALNUT_BUTTON.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_DOORS)
            .add(MysteriousRegistry.BLOODWOOD_DOOR.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_DOOR.get().asItem())
            .add(MysteriousRegistry.SEEPING_DOOR.get().asItem())
            .add(MysteriousRegistry.SORBUS_DOOR.get().asItem())
            .add(MysteriousRegistry.WALNUT_DOOR.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_STAIRS)
            .add(MysteriousRegistry.BLOODWOOD_STAIRS.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_STAIRS.get().asItem())
            .add(MysteriousRegistry.SEEPING_STAIRS.get().asItem())
            .add(MysteriousRegistry.SORBUS_STAIRS.get().asItem())
            .add(MysteriousRegistry.WALNUT_STAIRS.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_SLABS)
            .add(MysteriousRegistry.BLOODWOOD_SLAB.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_SLAB.get().asItem())
            .add(MysteriousRegistry.SEEPING_SLAB.get().asItem())
            .add(MysteriousRegistry.SORBUS_SLAB.get().asItem())
            .add(MysteriousRegistry.WALNUT_SLAB.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_FENCES)
            .add(MysteriousRegistry.BLOODWOOD_FENCE.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_FENCE.get().asItem())
            .add(MysteriousRegistry.SEEPING_FENCE.get().asItem())
            .add(MysteriousRegistry.SORBUS_FENCE.get().asItem())
            .add(MysteriousRegistry.WALNUT_FENCE.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.SAPLINGS)
            .add(MysteriousRegistry.BLOODWOOD_SAPLING.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_SAPLING.get().asItem())
            .add(MysteriousRegistry.SEEPING_SAPLING.get().asItem())
            .add(MysteriousRegistry.SORBUS_SAPLING.get().asItem())
            .add(MysteriousRegistry.WALNUT_SAPLING.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.LOGS)
            .addTag(MysteriousItemTags.LOGS_THAT_BURN);

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_PRESSURE_PLATES)
            .add(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get().asItem())
            .add(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get().asItem())
            .add(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get().asItem())
            .add(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.LEAVES)
            .add(MysteriousRegistry.BLOODWOOD_LEAVES.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_LEAVES.get().asItem())
            .add(MysteriousRegistry.SEEPING_LEAVES.get().asItem())
            .add(MysteriousRegistry.SORBUS_LEAVES.get().asItem())
            .add(MysteriousRegistry.WALNUT_LEAVES.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WOODEN_TRAPDOORS)
            .add(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_TRAPDOOR.get().asItem())
            .add(MysteriousRegistry.SEEPING_TRAPDOOR.get().asItem())
            .add(MysteriousRegistry.SORBUS_TRAPDOOR.get().asItem())
            .add(MysteriousRegistry.WALNUT_TRAPDOOR.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.STANDING_SIGNS)
            .add(MysteriousRegistry.BLOODWOOD_SIGN.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_SIGN.get().asItem())
            .add(MysteriousRegistry.SEEPING_SIGN.get().asItem())
            .add(MysteriousRegistry.SORBUS_SIGN.get().asItem())
            .add(MysteriousRegistry.WALNUT_SIGN.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WALL_SIGNS)
            .add(MysteriousRegistry.BLOODWOOD_WALL_SIGN.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_WALL_SIGN.get().asItem())
            .add(MysteriousRegistry.SEEPING_WALL_SIGN.get().asItem())
            .add(MysteriousRegistry.SORBUS_WALL_SIGN.get().asItem())
            .add(MysteriousRegistry.WALNUT_WALL_SIGN.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.CEILING_HANGING_SIGNS)
            .add(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.SEEPING_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.SORBUS_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.WALNUT_HANGING_SIGN.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WALL_HANGING_SIGNS)
            .add(MysteriousRegistry.BLOODWOOD_WALL_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_WALL_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.SEEPING_WALL_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.SORBUS_WALL_HANGING_SIGN.get().asItem())
            .add(MysteriousRegistry.WALNUT_WALL_HANGING_SIGN.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.FENCE_GATES)
            .add(MysteriousRegistry.BLOODWOOD_GATE.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_GATE.get().asItem())
            .add(MysteriousRegistry.SEEPING_GATE.get().asItem())
            .add(MysteriousRegistry.SORBUS_GATE.get().asItem())
            .add(MysteriousRegistry.WALNUT_GATE.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.DIRT)
            .add(MysteriousRegistry.BLOODIED_DIRT.get().asItem())
            .add(MysteriousRegistry.BLOODIED_GRASS.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.BUTTONS).addTag(MysteriousItemTags.WOODEN_BUTTONS);
        getOrCreateTagBuilder(MysteriousItemTags.DOORS).addTag(MysteriousItemTags.WOODEN_DOORS);

        getOrCreateTagBuilder(MysteriousItemTags.BLOODWOOD_LOGS)
            .add(MysteriousRegistry.BLOODWOOD_LOG.get().asItem())
            .add(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get().asItem())
            .add(MysteriousRegistry.BLOODWOOD_WOOD.get().asItem())
            .add(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.GHOSTLY_LOGS)
            .add(MysteriousRegistry.GHOSTLY_LOG.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_WOOD.get().asItem())
            .add(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.SORBUS_LOGS)
            .add(MysteriousRegistry.SORBUS_LOG.get().asItem())
            .add(MysteriousRegistry.SORBUS_STRIPPED_LOG.get().asItem())
            .add(MysteriousRegistry.SORBUS_WOOD.get().asItem())
            .add(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.SEEPING_LOGS)
            .add(MysteriousRegistry.SEEPING_LOG.get().asItem())
            .add(MysteriousRegistry.SEEPING_STRIPPED_LOG.get().asItem())
            .add(MysteriousRegistry.SEEPING_WOOD.get().asItem())
            .add(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.WALNUT_LOGS)
            .add(MysteriousRegistry.WALNUT_LOG.get().asItem())
            .add(MysteriousRegistry.WALNUT_STRIPPED_LOG.get().asItem())
            .add(MysteriousRegistry.WALNUT_WOOD.get().asItem())
            .add(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get().asItem());

        getOrCreateTagBuilder(MysteriousItemTags.LOGS_THAT_BURN)
            .addTag(MysteriousItemTags.BLOODWOOD_LOGS)
            .addTag(MysteriousItemTags.GHOSTLY_LOGS)
            .addTag(MysteriousItemTags.SORBUS_LOGS)
            .addTag(MysteriousItemTags.SEEPING_LOGS)
            .addTag(MysteriousItemTags.WALNUT_LOGS);

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
