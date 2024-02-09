/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2024
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
package dev.tophatcat.mysteriousbiomes.datagen.server;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousTags;
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

        public MysteriousItemTags(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagsProvider.TagLookup<Block>> blockLookup,
            ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, blockLookup, MysteriousCommon.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ItemTags.PLANKS)
                .add(MysteriousRegistry.BLOODWOOD_PLANKS.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_PLANKS.get().asItem())
                .add(MysteriousRegistry.SEEPING_PLANKS.get().asItem())
                .add(MysteriousRegistry.SORBUS_PLANKS.get().asItem())
                .add(MysteriousRegistry.WALNUT_PLANKS.get().asItem());

            tag(ItemTags.WOODEN_BUTTONS)
                .add(MysteriousRegistry.BLOODWOOD_BUTTON.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_BUTTON.get().asItem())
                .add(MysteriousRegistry.SEEPING_BUTTON.get().asItem())
                .add(MysteriousRegistry.SORBUS_BUTTON.get().asItem())
                .add(MysteriousRegistry.WALNUT_BUTTON.get().asItem());

            tag(ItemTags.WOODEN_DOORS)
                .add(MysteriousRegistry.BLOODWOOD_DOOR.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_DOOR.get().asItem())
                .add(MysteriousRegistry.SEEPING_DOOR.get().asItem())
                .add(MysteriousRegistry.SORBUS_DOOR.get().asItem())
                .add(MysteriousRegistry.WALNUT_DOOR.get().asItem());

            tag(ItemTags.WOODEN_STAIRS)
                .add(MysteriousRegistry.BLOODWOOD_STAIRS.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_STAIRS.get().asItem())
                .add(MysteriousRegistry.SEEPING_STAIRS.get().asItem())
                .add(MysteriousRegistry.SORBUS_STAIRS.get().asItem())
                .add(MysteriousRegistry.WALNUT_STAIRS.get().asItem());

            tag(ItemTags.WOODEN_SLABS)
                .add(MysteriousRegistry.BLOODWOOD_SLAB.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_SLAB.get().asItem())
                .add(MysteriousRegistry.SEEPING_SLAB.get().asItem())
                .add(MysteriousRegistry.SORBUS_SLAB.get().asItem())
                .add(MysteriousRegistry.WALNUT_SLAB.get().asItem());

            tag(ItemTags.WOODEN_FENCES)
                .add(MysteriousRegistry.BLOODWOOD_FENCE.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_FENCE.get().asItem())
                .add(MysteriousRegistry.SEEPING_FENCE.get().asItem())
                .add(MysteriousRegistry.SORBUS_FENCE.get().asItem())
                .add(MysteriousRegistry.WALNUT_FENCE.get().asItem());

            tag(ItemTags.SAPLINGS)
                .add(MysteriousRegistry.BLOODWOOD_SAPLING.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_SAPLING.get().asItem())
                .add(MysteriousRegistry.SEEPING_SAPLING.get().asItem())
                .add(MysteriousRegistry.SORBUS_SAPLING.get().asItem())
                .add(MysteriousRegistry.WALNUT_SAPLING.get().asItem());

            tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get().asItem())
                .add(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get().asItem())
                .add(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get().asItem())
                .add(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get().asItem());

            tag(ItemTags.LEAVES)
                .add(MysteriousRegistry.BLOODWOOD_LEAVES.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_LEAVES.get().asItem())
                .add(MysteriousRegistry.SEEPING_LEAVES.get().asItem())
                .add(MysteriousRegistry.SORBUS_LEAVES.get().asItem())
                .add(MysteriousRegistry.WALNUT_LEAVES.get().asItem());

            tag(ItemTags.WOODEN_TRAPDOORS)
                .add(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_TRAPDOOR.get().asItem())
                .add(MysteriousRegistry.SEEPING_TRAPDOOR.get().asItem())
                .add(MysteriousRegistry.SORBUS_TRAPDOOR.get().asItem())
                .add(MysteriousRegistry.WALNUT_TRAPDOOR.get().asItem());

            tag(ItemTags.FENCE_GATES)
                .add(MysteriousRegistry.BLOODWOOD_GATE.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_GATE.get().asItem())
                .add(MysteriousRegistry.SEEPING_GATE.get().asItem())
                .add(MysteriousRegistry.SORBUS_GATE.get().asItem())
                .add(MysteriousRegistry.WALNUT_GATE.get().asItem());

            tag(ItemTags.DIRT)
                .add(MysteriousRegistry.BLOODIED_DIRT.get().asItem())
                .add(MysteriousRegistry.BLOODIED_GRASS.get().asItem());

            tag(MysteriousTags.MysteriousItems.BLOODWOOD_LOGS)
                .add(MysteriousRegistry.BLOODWOOD_LOG.get().asItem())
                .add(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get().asItem())
                .add(MysteriousRegistry.BLOODWOOD_WOOD.get().asItem())
                .add(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get().asItem());

            tag(MysteriousTags.MysteriousItems.GHOSTLY_LOGS)
                .add(MysteriousRegistry.GHOSTLY_LOG.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_WOOD.get().asItem())
                .add(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get().asItem());

            tag(MysteriousTags.MysteriousItems.SORBUS_LOGS)
                .add(MysteriousRegistry.SORBUS_LOG.get().asItem())
                .add(MysteriousRegistry.SORBUS_STRIPPED_LOG.get().asItem())
                .add(MysteriousRegistry.SORBUS_WOOD.get().asItem())
                .add(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get().asItem());

            tag(MysteriousTags.MysteriousItems.SEEPING_LOGS)
                .add(MysteriousRegistry.SEEPING_LOG.get().asItem())
                .add(MysteriousRegistry.SEEPING_STRIPPED_LOG.get().asItem())
                .add(MysteriousRegistry.SEEPING_WOOD.get().asItem())
                .add(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get().asItem());

            tag(MysteriousTags.MysteriousItems.WALNUT_LOGS)
                .add(MysteriousRegistry.WALNUT_LOG.get().asItem())
                .add(MysteriousRegistry.WALNUT_STRIPPED_LOG.get().asItem())
                .add(MysteriousRegistry.WALNUT_WOOD.get().asItem())
                .add(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get().asItem());

            tag(ItemTags.LOGS_THAT_BURN)
                .addTag(MysteriousTags.MysteriousItems.BLOODWOOD_LOGS)
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
                .add(MysteriousRegistry.BLOODWOOD_PLANKS.get())
                .add(MysteriousRegistry.GHOSTLY_PLANKS.get())
                .add(MysteriousRegistry.SEEPING_PLANKS.get())
                .add(MysteriousRegistry.SORBUS_PLANKS.get())
                .add(MysteriousRegistry.WALNUT_PLANKS.get());

            tag(BlockTags.WOODEN_BUTTONS)
                .add(MysteriousRegistry.BLOODWOOD_BUTTON.get())
                .add(MysteriousRegistry.GHOSTLY_BUTTON.get())
                .add(MysteriousRegistry.SEEPING_BUTTON.get())
                .add(MysteriousRegistry.SORBUS_BUTTON.get())
                .add(MysteriousRegistry.WALNUT_BUTTON.get());

            tag(BlockTags.WOODEN_DOORS)
                .add(MysteriousRegistry.BLOODWOOD_DOOR.get())
                .add(MysteriousRegistry.GHOSTLY_DOOR.get())
                .add(MysteriousRegistry.SEEPING_DOOR.get())
                .add(MysteriousRegistry.SORBUS_DOOR.get())
                .add(MysteriousRegistry.WALNUT_DOOR.get());

            tag(BlockTags.WOODEN_STAIRS)
                .add(MysteriousRegistry.BLOODWOOD_STAIRS.get())
                .add(MysteriousRegistry.GHOSTLY_STAIRS.get())
                .add(MysteriousRegistry.SEEPING_STAIRS.get())
                .add(MysteriousRegistry.SORBUS_STAIRS.get())
                .add(MysteriousRegistry.WALNUT_STAIRS.get());

            tag(BlockTags.WOODEN_SLABS)
                .add(MysteriousRegistry.BLOODWOOD_SLAB.get())
                .add(MysteriousRegistry.GHOSTLY_SLAB.get())
                .add(MysteriousRegistry.SEEPING_SLAB.get())
                .add(MysteriousRegistry.SORBUS_SLAB.get())
                .add(MysteriousRegistry.WALNUT_SLAB.get());

            tag(BlockTags.WOODEN_FENCES)
                .add(MysteriousRegistry.BLOODWOOD_FENCE.get())
                .add(MysteriousRegistry.GHOSTLY_FENCE.get())
                .add(MysteriousRegistry.SEEPING_FENCE.get())
                .add(MysteriousRegistry.SORBUS_FENCE.get())
                .add(MysteriousRegistry.WALNUT_FENCE.get());

            tag(BlockTags.SAPLINGS)
                .add(MysteriousRegistry.BLOODWOOD_SAPLING.get())
                .add(MysteriousRegistry.GHOSTLY_SAPLING.get())
                .add(MysteriousRegistry.SEEPING_SAPLING.get())
                .add(MysteriousRegistry.SORBUS_SAPLING.get())
                .add(MysteriousRegistry.WALNUT_SAPLING.get());

            tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get())
                .add(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get())
                .add(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get())
                .add(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get())
                .add(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get());

            tag(BlockTags.LEAVES)
                .add(MysteriousRegistry.BLOODWOOD_LEAVES.get())
                .add(MysteriousRegistry.GHOSTLY_LEAVES.get())
                .add(MysteriousRegistry.SEEPING_LEAVES.get())
                .add(MysteriousRegistry.SORBUS_LEAVES.get())
                .add(MysteriousRegistry.WALNUT_LEAVES.get());

            tag(BlockTags.WOODEN_TRAPDOORS)
                .add(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get())
                .add(MysteriousRegistry.GHOSTLY_TRAPDOOR.get())
                .add(MysteriousRegistry.SEEPING_TRAPDOOR.get())
                .add(MysteriousRegistry.SORBUS_TRAPDOOR.get())
                .add(MysteriousRegistry.WALNUT_TRAPDOOR.get());

            tag(BlockTags.FENCE_GATES)
                .add(MysteriousRegistry.BLOODWOOD_GATE.get())
                .add(MysteriousRegistry.GHOSTLY_GATE.get())
                .add(MysteriousRegistry.SEEPING_GATE.get())
                .add(MysteriousRegistry.SORBUS_GATE.get())
                .add(MysteriousRegistry.WALNUT_GATE.get());

            tag(BlockTags.DIRT)
                .add(MysteriousRegistry.BLOODIED_DIRT.get())
                .add(MysteriousRegistry.BLOODIED_GRASS.get());

            tag(MysteriousTags.MysteriousBlocks.BLOODWOOD_LOGS)
                .add(MysteriousRegistry.BLOODWOOD_LOG.get())
                .add(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get())
                .add(MysteriousRegistry.BLOODWOOD_WOOD.get())
                .add(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.GHOSTLY_LOGS)
                .add(MysteriousRegistry.GHOSTLY_LOG.get())
                .add(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get())
                .add(MysteriousRegistry.GHOSTLY_WOOD.get())
                .add(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.SORBUS_LOGS)
                .add(MysteriousRegistry.SORBUS_LOG.get())
                .add(MysteriousRegistry.SORBUS_STRIPPED_LOG.get())
                .add(MysteriousRegistry.SORBUS_WOOD.get())
                .add(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.SEEPING_LOGS)
                .add(MysteriousRegistry.SEEPING_LOG.get())
                .add(MysteriousRegistry.SEEPING_STRIPPED_LOG.get())
                .add(MysteriousRegistry.SEEPING_WOOD.get())
                .add(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get());

            tag(MysteriousTags.MysteriousBlocks.WALNUT_LOGS)
                .add(MysteriousRegistry.WALNUT_LOG.get())
                .add(MysteriousRegistry.WALNUT_STRIPPED_LOG.get())
                .add(MysteriousRegistry.WALNUT_WOOD.get())
                .add(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get());

            tag(BlockTags.LOGS_THAT_BURN)
                .addTag(MysteriousTags.MysteriousBlocks.BLOODWOOD_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.GHOSTLY_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.SORBUS_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.SEEPING_LOGS)
                .addTag(MysteriousTags.MysteriousBlocks.WALNUT_LOGS);

            tag(MysteriousTags.MysteriousBlocks.SIGNS)
                .add(MysteriousRegistry.BLOODWOOD_WALL_SIGN.get())
                .add(MysteriousRegistry.GHOSTLY_WALL_SIGN.get())
                .add(MysteriousRegistry.SEEPING_WALL_SIGN.get())
                .add(MysteriousRegistry.SORBUS_WALL_SIGN.get())
                .add(MysteriousRegistry.WALNUT_WALL_SIGN.get())
                .add(MysteriousRegistry.BLOODWOOD_FLOOR_SIGN.get())
                .add(MysteriousRegistry.GHOSTLY_FLOOR_SIGN.get())
                .add(MysteriousRegistry.SEEPING_FLOOR_SIGN.get())
                .add(MysteriousRegistry.SORBUS_FLOOR_SIGN.get())
                .add(MysteriousRegistry.WALNUT_FLOOR_SIGN.get());

            tag(MysteriousTags.MysteriousBlocks.HANGING_SIGNS)
                .add(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get())
                .add(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get())
                .add(MysteriousRegistry.SEEPING_HANGING_SIGN.get())
                .add(MysteriousRegistry.SORBUS_HANGING_SIGN.get())
                .add(MysteriousRegistry.WALNUT_HANGING_SIGN.get())
                .add(MysteriousRegistry.BLOODWOOD_WALL_HANGING_SIGN.get())
                .add(MysteriousRegistry.GHOSTLY_WALL_HANGING_SIGN.get())
                .add(MysteriousRegistry.SEEPING_WALL_HANGING_SIGN.get())
                .add(MysteriousRegistry.SORBUS_WALL_HANGING_SIGN.get())
                .add(MysteriousRegistry.WALNUT_WALL_HANGING_SIGN.get());

            tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(MysteriousTags.MysteriousBlocks.SIGNS)
                .addTag(MysteriousTags.MysteriousBlocks.HANGING_SIGNS);

            tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(MysteriousRegistry.BLOODIED_DIRT.get())
                .add(MysteriousRegistry.BLOODIED_GRASS.get());
        }
    }
}
