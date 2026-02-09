/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/mysterious-biomes/blob/dev/LICENSE.md
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
 */
package dev.tophatcat.mysteriousbiomes.data.server;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriouslands.registry.BlockRegistry;
import dev.tophatcat.mysteriouslands.registry.ItemRegistry;
import dev.tophatcat.mysteriouslands.utils.MysteriousTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MysteriousTagProvider {

    public static class MysteriousItemTags extends ItemTagsProvider {

        public MysteriousItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagsProvider.TagLookup<Block>> blockLookup, ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, blockLookup, MysteriousCommon.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ItemTags.PLANKS)
                .add(ItemRegistry.BLOOD_SOAKED_PLANKS.get())
                .add(ItemRegistry.GHOSTLY_PLANKS.get())
                .add(ItemRegistry.SEEPING_PLANKS.get())
                .add(ItemRegistry.SORBUS_PLANKS.get())
                .add(ItemRegistry.WALNUT_PLANKS.get());

            tag(ItemTags.WOODEN_BUTTONS)
                .add(ItemRegistry.BLOOD_SOAKED_BUTTON.get())
                .add(ItemRegistry.GHOSTLY_BUTTON.get())
                .add(ItemRegistry.SEEPING_BUTTON.get())
                .add(ItemRegistry.SORBUS_BUTTON.get())
                .add(ItemRegistry.WALNUT_BUTTON.get());

            tag(ItemTags.WOODEN_DOORS)
                .add(ItemRegistry.BLOOD_SOAKED_DOOR.get())
                .add(ItemRegistry.GHOSTLY_DOOR.get())
                .add(ItemRegistry.SEEPING_DOOR.get())
                .add(ItemRegistry.SORBUS_DOOR.get())
                .add(ItemRegistry.WALNUT_DOOR.get());

            tag(ItemTags.WOODEN_STAIRS)
                .add(ItemRegistry.BLOOD_SOAKED_STAIRS.get())
                .add(ItemRegistry.GHOSTLY_STAIRS.get())
                .add(ItemRegistry.SEEPING_STAIRS.get())
                .add(ItemRegistry.SORBUS_STAIRS.get())
                .add(ItemRegistry.WALNUT_STAIRS.get());

            tag(ItemTags.WOODEN_SLABS)
                .add(ItemRegistry.BLOOD_SOAKED_SLAB.get())
                .add(ItemRegistry.GHOSTLY_SLAB.get())
                .add(ItemRegistry.SEEPING_SLAB.get())
                .add(ItemRegistry.SORBUS_SLAB.get())
                .add(ItemRegistry.WALNUT_SLAB.get());

            tag(ItemTags.WOODEN_FENCES)
                .add(ItemRegistry.BLOOD_SOAKED_FENCE.get())
                .add(ItemRegistry.GHOSTLY_FENCE.get())
                .add(ItemRegistry.SEEPING_FENCE.get())
                .add(ItemRegistry.SORBUS_FENCE.get())
                .add(ItemRegistry.WALNUT_FENCE.get());

            tag(ItemTags.SAPLINGS)
                .add(ItemRegistry.BLOOD_SOAKED_SAPLING.get())
                .add(ItemRegistry.GHOSTLY_SAPLING.get())
                .add(ItemRegistry.SEEPING_SAPLING.get())
                .add(ItemRegistry.SORBUS_SAPLING.get())
                .add(ItemRegistry.WALNUT_SAPLING.get());

            tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ItemRegistry.BLOOD_SOAKED_PRESSURE_PLATE.get())
                .add(ItemRegistry.GHOSTLY_PRESSURE_PLATE.get())
                .add(ItemRegistry.SEEPING_PRESSURE_PLATE.get())
                .add(ItemRegistry.SORBUS_PRESSURE_PLATE.get())
                .add(ItemRegistry.WALNUT_PRESSURE_PLATE.get());

            tag(ItemTags.LEAVES)
                .add(ItemRegistry.BLOOD_SOAKED_LEAVES.get())
                .add(ItemRegistry.GHOSTLY_LEAVES.get())
                .add(ItemRegistry.SEEPING_LEAVES.get())
                .add(ItemRegistry.SORBUS_LEAVES.get())
                .add(ItemRegistry.WALNUT_LEAVES.get());

            tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ItemRegistry.BLOOD_SOAKED_TRAPDOOR.get())
                .add(ItemRegistry.GHOSTLY_TRAPDOOR.get())
                .add(ItemRegistry.SEEPING_TRAPDOOR.get())
                .add(ItemRegistry.SORBUS_TRAPDOOR.get())
                .add(ItemRegistry.WALNUT_TRAPDOOR.get());

            tag(ItemTags.FENCE_GATES)
                .add(ItemRegistry.BLOOD_SOAKED_GATE.get())
                .add(ItemRegistry.GHOSTLY_GATE.get())
                .add(ItemRegistry.SEEPING_GATE.get())
                .add(ItemRegistry.SORBUS_GATE.get())
                .add(ItemRegistry.WALNUT_GATE.get());

            tag(ItemTags.DIRT)
                .add(ItemRegistry.BLOOD_SOAKED_DIRT.get())
                .add(ItemRegistry.BLOOD_SOAKED_GRASS.get());

            tag(MysteriousTags.MysteriousItems.BLOOD_SOAKED_LOGS)
                .add(ItemRegistry.BLOOD_SOAKED_LOG.get())
                .add(ItemRegistry.BLOOD_SOAKED_STRIPPED_LOG.get())
                .add(ItemRegistry.BLOOD_SOAKED_WOOD.get())
                .add(ItemRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousItems.GHOSTLY_LOGS)
                .add(ItemRegistry.GHOSTLY_LOG.get())
                .add(ItemRegistry.GHOSTLY_STRIPPED_LOG.get())
                .add(ItemRegistry.GHOSTLY_WOOD.get())
                .add(ItemRegistry.GHOSTLY_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousItems.SORBUS_LOGS)
                .add(ItemRegistry.SORBUS_LOG.get())
                .add(ItemRegistry.SORBUS_STRIPPED_LOG.get())
                .add(ItemRegistry.SORBUS_WOOD.get())
                .add(ItemRegistry.SORBUS_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousItems.SEEPING_LOGS)
                .add(ItemRegistry.SEEPING_LOG.get())
                .add(ItemRegistry.SEEPING_STRIPPED_LOG.get())
                .add(ItemRegistry.SEEPING_WOOD.get())
                .add(ItemRegistry.SEEPING_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousItems.WALNUT_LOGS)
                .add(ItemRegistry.WALNUT_LOG.get())
                .add(ItemRegistry.WALNUT_STRIPPED_LOG.get())
                .add(ItemRegistry.WALNUT_WOOD.get())
                .add(ItemRegistry.WALNUT_STRIPPED_WOOD.get());

            tag(ItemTags.LOGS_THAT_BURN)
                .addTag(MysteriousTags.MysteriousItems.BLOOD_SOAKED_LOGS)
                .addTag(MysteriousTags.MysteriousItems.GHOSTLY_LOGS)
                .addTag(MysteriousTags.MysteriousItems.SORBUS_LOGS)
                .addTag(MysteriousTags.MysteriousItems.SEEPING_LOGS)
                .addTag(MysteriousTags.MysteriousItems.WALNUT_LOGS);
        }
    }

    public static class MysteriousBlockTags extends BlockTagsProvider {

        public MysteriousBlockTags(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            ExistingFileHelper existingHelper) {
            super(output, lookupProvider, MysteriousCommon.MOD_ID, existingHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BlockTags.PLANKS)
                .add(BlockRegistry.BLOOD_SOAKED_PLANKS.get())
                .add(BlockRegistry.GHOSTLY_PLANKS.get())
                .add(BlockRegistry.SEEPING_PLANKS.get())
                .add(BlockRegistry.SORBUS_PLANKS.get())
                .add(BlockRegistry.WALNUT_PLANKS.get());

            tag(BlockTags.WOODEN_BUTTONS)
                .add(BlockRegistry.BLOOD_SOAKED_BUTTON.get())
                .add(BlockRegistry.GHOSTLY_BUTTON.get())
                .add(BlockRegistry.SEEPING_BUTTON.get())
                .add(BlockRegistry.SORBUS_BUTTON.get())
                .add(BlockRegistry.WALNUT_BUTTON.get());

            tag(BlockTags.WOODEN_DOORS)
                .add(BlockRegistry.BLOOD_SOAKED_DOOR.get())
                .add(BlockRegistry.GHOSTLY_DOOR.get())
                .add(BlockRegistry.SEEPING_DOOR.get())
                .add(BlockRegistry.SORBUS_DOOR.get())
                .add(BlockRegistry.WALNUT_DOOR.get());

            tag(BlockTags.WOODEN_STAIRS)
                .add(BlockRegistry.BLOOD_SOAKED_STAIRS.get())
                .add(BlockRegistry.GHOSTLY_STAIRS.get())
                .add(BlockRegistry.SEEPING_STAIRS.get())
                .add(BlockRegistry.SORBUS_STAIRS.get())
                .add(BlockRegistry.WALNUT_STAIRS.get());

            tag(BlockTags.WOODEN_SLABS)
                .add(BlockRegistry.BLOOD_SOAKED_SLAB.get())
                .add(BlockRegistry.GHOSTLY_SLAB.get())
                .add(BlockRegistry.SEEPING_SLAB.get())
                .add(BlockRegistry.SORBUS_SLAB.get())
                .add(BlockRegistry.WALNUT_SLAB.get());

            tag(BlockTags.WOODEN_FENCES)
                .add(BlockRegistry.BLOOD_SOAKED_FENCE.get())
                .add(BlockRegistry.GHOSTLY_FENCE.get())
                .add(BlockRegistry.SEEPING_FENCE.get())
                .add(BlockRegistry.SORBUS_FENCE.get())
                .add(BlockRegistry.WALNUT_FENCE.get());

            tag(BlockTags.SAPLINGS)
                .add(BlockRegistry.BLOOD_SOAKED_SAPLING.get())
                .add(BlockRegistry.GHOSTLY_SAPLING.get())
                .add(BlockRegistry.SEEPING_SAPLING.get())
                .add(BlockRegistry.SORBUS_SAPLING.get())
                .add(BlockRegistry.WALNUT_SAPLING.get());

            tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(BlockRegistry.BLOOD_SOAKED_PRESSURE_PLATE.get())
                .add(BlockRegistry.GHOSTLY_PRESSURE_PLATE.get())
                .add(BlockRegistry.SEEPING_PRESSURE_PLATE.get())
                .add(BlockRegistry.SORBUS_PRESSURE_PLATE.get())
                .add(BlockRegistry.WALNUT_PRESSURE_PLATE.get());

            tag(BlockTags.LEAVES)
                .add(BlockRegistry.BLOOD_SOAKED_LEAVES.get())
                .add(BlockRegistry.GHOSTLY_LEAVES.get())
                .add(BlockRegistry.SEEPING_LEAVES.get())
                .add(BlockRegistry.SORBUS_LEAVES.get())
                .add(BlockRegistry.WALNUT_LEAVES.get());

            tag(BlockTags.WOODEN_TRAPDOORS)
                .add(BlockRegistry.BLOOD_SOAKED_TRAPDOOR.get())
                .add(BlockRegistry.GHOSTLY_TRAPDOOR.get())
                .add(BlockRegistry.SEEPING_TRAPDOOR.get())
                .add(BlockRegistry.SORBUS_TRAPDOOR.get())
                .add(BlockRegistry.WALNUT_TRAPDOOR.get());

            tag(BlockTags.FENCE_GATES)
                .add(BlockRegistry.BLOOD_SOAKED_GATE.get())
                .add(BlockRegistry.GHOSTLY_GATE.get())
                .add(BlockRegistry.SEEPING_GATE.get())
                .add(BlockRegistry.SORBUS_GATE.get())
                .add(BlockRegistry.WALNUT_GATE.get());

            tag(BlockTags.DIRT)
                .add(BlockRegistry.BLOOD_SOAKED_DIRT.get())
                .add(BlockRegistry.BLOOD_SOAKED_GRASS.get());

            tag(MysteriousTags.MysteriousBlocks.BLOOD_SOAKED_LOGS)
                .add(BlockRegistry.BLOOD_SOAKED_LOG.get())
                .add(BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get())
                .add(BlockRegistry.BLOOD_SOAKED_WOOD.get())
                .add(BlockRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.GHOSTLY_LOGS)
                .add(BlockRegistry.GHOSTLY_LOG.get())
                .add(BlockRegistry.GHOSTLY_STRIPPED_LOG.get())
                .add(BlockRegistry.GHOSTLY_WOOD.get())
                .add(BlockRegistry.GHOSTLY_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.SORBUS_LOGS)
                .add(BlockRegistry.SORBUS_LOG.get())
                .add(BlockRegistry.SORBUS_STRIPPED_LOG.get())
                .add(BlockRegistry.SORBUS_WOOD.get())
                .add(BlockRegistry.SORBUS_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.SEEPING_LOGS)
                .add(BlockRegistry.SEEPING_LOG.get())
                .add(BlockRegistry.SEEPING_STRIPPED_LOG.get())
                .add(BlockRegistry.SEEPING_WOOD.get())
                .add(BlockRegistry.SEEPING_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.WALNUT_LOGS)
                .add(BlockRegistry.WALNUT_LOG.get())
                .add(BlockRegistry.WALNUT_STRIPPED_LOG.get())
                .add(BlockRegistry.WALNUT_WOOD.get())
                .add(BlockRegistry.WALNUT_STRIPPED_WOOD.get());

            tag(BlockTags.LOGS_THAT_BURN)
                .addTag(MysteriousTags.MysteriousBlocks.BLOOD_SOAKED_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.GHOSTLY_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.SORBUS_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.SEEPING_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.WALNUT_LOGS);

            tag(MysteriousTags.MysteriousBlocks.SIGNS)
                .add(BlockRegistry.BLOOD_SOAKED_WALL_SIGN.get())
                .add(BlockRegistry.GHOSTLY_WALL_SIGN.get())
                .add(BlockRegistry.SEEPING_WALL_SIGN.get())
                .add(BlockRegistry.SORBUS_WALL_SIGN.get())
                .add(BlockRegistry.WALNUT_WALL_SIGN.get())
                .add(BlockRegistry.BLOOD_SOAKED_FLOOR_SIGN.get())
                .add(BlockRegistry.GHOSTLY_FLOOR_SIGN.get())
                .add(BlockRegistry.SEEPING_FLOOR_SIGN.get())
                .add(BlockRegistry.SORBUS_FLOOR_SIGN.get())
                .add(BlockRegistry.WALNUT_FLOOR_SIGN.get());

            tag(MysteriousTags.MysteriousBlocks.HANGING_SIGNS)
                .add(BlockRegistry.BLOOD_SOAKED_HANGING_SIGN.get())
                .add(BlockRegistry.GHOSTLY_HANGING_SIGN.get())
                .add(BlockRegistry.SEEPING_HANGING_SIGN.get())
                .add(BlockRegistry.SORBUS_HANGING_SIGN.get())
                .add(BlockRegistry.WALNUT_HANGING_SIGN.get())
                .add(BlockRegistry.BLOOD_SOAKED_WALL_HANGING_SIGN.get())
                .add(BlockRegistry.GHOSTLY_WALL_HANGING_SIGN.get())
                .add(BlockRegistry.SEEPING_WALL_HANGING_SIGN.get())
                .add(BlockRegistry.SORBUS_WALL_HANGING_SIGN.get())
                .add(BlockRegistry.WALNUT_WALL_HANGING_SIGN.get());

            tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(MysteriousTags.MysteriousBlocks.SIGNS)
                .addTag(MysteriousTags.MysteriousBlocks.HANGING_SIGNS);

            tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockRegistry.BLOOD_SOAKED_DIRT.get())
                .add(BlockRegistry.BLOOD_SOAKED_GRASS.get());
        }
    }
}
