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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class MysteriousLootTableProvider {

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(
            MysteriousLootTables::new, LootContextParamSets.BLOCK)), provider);
    }

    private static class MysteriousLootTables extends BlockLootSubProvider {

        protected MysteriousLootTables(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        protected void generate() {
            // Misc blocks.
            dropSelf(BlockRegistry.BLOOD_SOAKED_DIRT.get());
            add(BlockRegistry.BLOOD_SOAKED_GRASS.get(), block -> createSingleItemTableWithSilkTouch(block,
                BlockRegistry.BLOOD_SOAKED_DIRT.get()));

            // Blood soaked tree family.
            dropSelf(BlockRegistry.BLOOD_SOAKED_LOG.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_WOOD.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_PLANKS.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_STAIRS.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_SLAB.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_FENCE.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_GATE.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_BUTTON.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_PRESSURE_PLATE.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_TRAPDOOR.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_SAPLING.get());
            dropSelf(Block.byItem(ItemRegistry.BLOOD_SOAKED_SIGN.get()));
            dropSelf(BlockRegistry.BLOOD_SOAKED_WALL_SIGN.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_HANGING_SIGN.get());
            dropSelf(BlockRegistry.BLOOD_SOAKED_WALL_HANGING_SIGN.get());
            add(BlockRegistry.BLOOD_SOAKED_DOOR.get(), this::createDoorTable);
            add(BlockRegistry.BLOOD_SOAKED_LEAVES.get(), block -> createLeavesDrops(
                BlockRegistry.BLOOD_SOAKED_LEAVES.get(), BlockRegistry.BLOOD_SOAKED_SAPLING.get(),
                BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Ghostly tree family.
            dropSelf(BlockRegistry.GHOSTLY_LOG.get());
            dropSelf(BlockRegistry.GHOSTLY_STRIPPED_LOG.get());
            dropSelf(BlockRegistry.GHOSTLY_WOOD.get());
            dropSelf(BlockRegistry.GHOSTLY_STRIPPED_WOOD.get());
            dropSelf(BlockRegistry.GHOSTLY_PLANKS.get());
            dropSelf(BlockRegistry.GHOSTLY_STAIRS.get());
            dropSelf(BlockRegistry.GHOSTLY_SLAB.get());
            dropSelf(BlockRegistry.GHOSTLY_FENCE.get());
            dropSelf(BlockRegistry.GHOSTLY_GATE.get());
            dropSelf(BlockRegistry.GHOSTLY_BUTTON.get());
            dropSelf(BlockRegistry.GHOSTLY_PRESSURE_PLATE.get());
            dropSelf(BlockRegistry.GHOSTLY_TRAPDOOR.get());
            dropSelf(BlockRegistry.GHOSTLY_SAPLING.get());
            dropSelf(Block.byItem(ItemRegistry.GHOSTLY_SIGN.get()));
            dropSelf(BlockRegistry.GHOSTLY_WALL_SIGN.get());
            dropSelf(BlockRegistry.GHOSTLY_HANGING_SIGN.get());
            dropSelf(BlockRegistry.GHOSTLY_WALL_HANGING_SIGN.get());
            add(BlockRegistry.GHOSTLY_DOOR.get(), this::createDoorTable);
            add(BlockRegistry.GHOSTLY_LEAVES.get(), block -> createLeavesDrops(
                BlockRegistry.GHOSTLY_LEAVES.get(), BlockRegistry.GHOSTLY_SAPLING.get(),
                BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Seeping tree family.
            dropSelf(BlockRegistry.SEEPING_LOG.get());
            dropSelf(BlockRegistry.SEEPING_STRIPPED_LOG.get());
            dropSelf(BlockRegistry.SEEPING_WOOD.get());
            dropSelf(BlockRegistry.SEEPING_STRIPPED_WOOD.get());
            dropSelf(BlockRegistry.SEEPING_PLANKS.get());
            dropSelf(BlockRegistry.SEEPING_STAIRS.get());
            dropSelf(BlockRegistry.SEEPING_SLAB.get());
            dropSelf(BlockRegistry.SEEPING_FENCE.get());
            dropSelf(BlockRegistry.SEEPING_GATE.get());
            dropSelf(BlockRegistry.SEEPING_BUTTON.get());
            dropSelf(BlockRegistry.SEEPING_PRESSURE_PLATE.get());
            dropSelf(BlockRegistry.SEEPING_TRAPDOOR.get());
            dropSelf(BlockRegistry.SEEPING_SAPLING.get());
            dropSelf(Block.byItem(ItemRegistry.SEEPING_SIGN.get()));
            dropSelf(BlockRegistry.SEEPING_WALL_SIGN.get());
            dropSelf(BlockRegistry.SEEPING_HANGING_SIGN.get());
            dropSelf(BlockRegistry.SEEPING_WALL_HANGING_SIGN.get());
            add(BlockRegistry.SEEPING_DOOR.get(), this::createDoorTable);
            add(BlockRegistry.SEEPING_LEAVES.get(), block -> createLeavesDrops(
                BlockRegistry.SEEPING_LEAVES.get(), BlockRegistry.SEEPING_SAPLING.get(),
                BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Sorbus tree family.
            dropSelf(BlockRegistry.SORBUS_LOG.get());
            dropSelf(BlockRegistry.SORBUS_STRIPPED_LOG.get());
            dropSelf(BlockRegistry.SORBUS_WOOD.get());
            dropSelf(BlockRegistry.SORBUS_STRIPPED_WOOD.get());
            dropSelf(BlockRegistry.SORBUS_PLANKS.get());
            dropSelf(BlockRegistry.SORBUS_STAIRS.get());
            dropSelf(BlockRegistry.SORBUS_SLAB.get());
            dropSelf(BlockRegistry.SORBUS_FENCE.get());
            dropSelf(BlockRegistry.SORBUS_GATE.get());
            dropSelf(BlockRegistry.SORBUS_BUTTON.get());
            dropSelf(BlockRegistry.SORBUS_PRESSURE_PLATE.get());
            dropSelf(BlockRegistry.SORBUS_TRAPDOOR.get());
            dropSelf(BlockRegistry.SORBUS_SAPLING.get());
            dropSelf(Block.byItem(ItemRegistry.SORBUS_SIGN.get()));
            dropSelf(BlockRegistry.SORBUS_WALL_SIGN.get());
            dropSelf(BlockRegistry.SORBUS_HANGING_SIGN.get());
            dropSelf(BlockRegistry.SORBUS_WALL_HANGING_SIGN.get());
            add(BlockRegistry.SORBUS_DOOR.get(), this::createDoorTable);
            add(BlockRegistry.SORBUS_LEAVES.get(), block -> createLeavesDrops(
                BlockRegistry.SORBUS_LEAVES.get(), BlockRegistry.SORBUS_SAPLING.get(),
                BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Walnut tree family.
            dropSelf(BlockRegistry.WALNUT_LOG.get());
            dropSelf(BlockRegistry.WALNUT_STRIPPED_LOG.get());
            dropSelf(BlockRegistry.WALNUT_WOOD.get());
            dropSelf(BlockRegistry.WALNUT_STRIPPED_WOOD.get());
            dropSelf(BlockRegistry.WALNUT_PLANKS.get());
            dropSelf(BlockRegistry.WALNUT_STAIRS.get());
            dropSelf(BlockRegistry.WALNUT_SLAB.get());
            dropSelf(BlockRegistry.WALNUT_FENCE.get());
            dropSelf(BlockRegistry.WALNUT_GATE.get());
            dropSelf(BlockRegistry.WALNUT_BUTTON.get());
            dropSelf(BlockRegistry.WALNUT_PRESSURE_PLATE.get());
            dropSelf(BlockRegistry.WALNUT_TRAPDOOR.get());
            dropSelf(BlockRegistry.WALNUT_SAPLING.get());
            dropSelf(Block.byItem(ItemRegistry.WALNUT_SIGN.get()));
            dropSelf(BlockRegistry.WALNUT_WALL_SIGN.get());
            dropSelf(BlockRegistry.WALNUT_HANGING_SIGN.get());
            dropSelf(BlockRegistry.WALNUT_WALL_HANGING_SIGN.get());
            add(BlockRegistry.WALNUT_DOOR.get(), this::createDoorTable);
            add(BlockRegistry.WALNUT_LEAVES.get(), block -> createLeavesDrops(
                BlockRegistry.WALNUT_LEAVES.get(), BlockRegistry.WALNUT_SAPLING.get(),
                BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return BuiltInRegistries.BLOCK.entrySet().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(MysteriousCommon.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        }
    }
}
