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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class MysteriousLootTableProvider {

    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(
            output,
            Set.of(),
            List.of(
                new LootTableProvider.SubProviderEntry(
                    MysteriousLootTables::new, LootContextParamSets.BLOCK)));
    }

    private static class MysteriousLootTables extends BlockLootSubProvider {

        protected MysteriousLootTables() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            // Misc blocks.
            dropSelf(MysteriousRegistry.BLOODIED_DIRT.get());
            add(
                MysteriousRegistry.BLOODIED_GRASS.get(),
                block ->
                    createSingleItemTableWithSilkTouch(block, MysteriousRegistry.BLOODIED_DIRT.get()));

            // Bloodwood tree family.
            dropSelf(MysteriousRegistry.BLOODWOOD_LOG.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_WOOD.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_PLANKS.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_STAIRS.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_SLAB.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_FENCE.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_GATE.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_BUTTON.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_SAPLING.get());
            dropSelf(Block.byItem(MysteriousRegistry.BLOODWOOD_SIGN.get()));
            dropSelf(MysteriousRegistry.BLOODWOOD_WALL_SIGN.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get());
            dropSelf(MysteriousRegistry.BLOODWOOD_WALL_HANGING_SIGN.get());
            add(MysteriousRegistry.BLOODWOOD_DOOR.get(), this::createDoorTable);
            add(
                MysteriousRegistry.BLOODWOOD_LEAVES.get(),
                block ->
                    createLeavesDrops(
                        MysteriousRegistry.BLOODWOOD_LEAVES.get(),
                        MysteriousRegistry.BLOODWOOD_SAPLING.get(),
                        BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Ghostly tree family.
            dropSelf(MysteriousRegistry.GHOSTLY_LOG.get());
            dropSelf(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get());
            dropSelf(MysteriousRegistry.GHOSTLY_WOOD.get());
            dropSelf(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get());
            dropSelf(MysteriousRegistry.GHOSTLY_PLANKS.get());
            dropSelf(MysteriousRegistry.GHOSTLY_STAIRS.get());
            dropSelf(MysteriousRegistry.GHOSTLY_SLAB.get());
            dropSelf(MysteriousRegistry.GHOSTLY_FENCE.get());
            dropSelf(MysteriousRegistry.GHOSTLY_GATE.get());
            dropSelf(MysteriousRegistry.GHOSTLY_BUTTON.get());
            dropSelf(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get());
            dropSelf(MysteriousRegistry.GHOSTLY_TRAPDOOR.get());
            dropSelf(MysteriousRegistry.GHOSTLY_SAPLING.get());
            dropSelf(Block.byItem(MysteriousRegistry.GHOSTLY_SIGN.get()));
            dropSelf(MysteriousRegistry.GHOSTLY_WALL_SIGN.get());
            dropSelf(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get());
            dropSelf(MysteriousRegistry.GHOSTLY_WALL_HANGING_SIGN.get());
            add(MysteriousRegistry.GHOSTLY_DOOR.get(), this::createDoorTable);
            add(
                MysteriousRegistry.GHOSTLY_LEAVES.get(),
                block ->
                    createLeavesDrops(
                        MysteriousRegistry.GHOSTLY_LEAVES.get(),
                        MysteriousRegistry.GHOSTLY_SAPLING.get(),
                        BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Seeping tree family.
            dropSelf(MysteriousRegistry.SEEPING_LOG.get());
            dropSelf(MysteriousRegistry.SEEPING_STRIPPED_LOG.get());
            dropSelf(MysteriousRegistry.SEEPING_WOOD.get());
            dropSelf(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get());
            dropSelf(MysteriousRegistry.SEEPING_PLANKS.get());
            dropSelf(MysteriousRegistry.SEEPING_STAIRS.get());
            dropSelf(MysteriousRegistry.SEEPING_SLAB.get());
            dropSelf(MysteriousRegistry.SEEPING_FENCE.get());
            dropSelf(MysteriousRegistry.SEEPING_GATE.get());
            dropSelf(MysteriousRegistry.SEEPING_BUTTON.get());
            dropSelf(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get());
            dropSelf(MysteriousRegistry.SEEPING_TRAPDOOR.get());
            dropSelf(MysteriousRegistry.SEEPING_SAPLING.get());
            dropSelf(Block.byItem(MysteriousRegistry.SEEPING_SIGN.get()));
            dropSelf(MysteriousRegistry.SEEPING_WALL_SIGN.get());
            dropSelf(MysteriousRegistry.SEEPING_HANGING_SIGN.get());
            dropSelf(MysteriousRegistry.SEEPING_WALL_HANGING_SIGN.get());
            add(MysteriousRegistry.SEEPING_DOOR.get(), this::createDoorTable);
            add(
                MysteriousRegistry.SEEPING_LEAVES.get(),
                block ->
                    createLeavesDrops(
                        MysteriousRegistry.SEEPING_LEAVES.get(),
                        MysteriousRegistry.SEEPING_SAPLING.get(),
                        BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Sorbus tree family.
            dropSelf(MysteriousRegistry.SORBUS_LOG.get());
            dropSelf(MysteriousRegistry.SORBUS_STRIPPED_LOG.get());
            dropSelf(MysteriousRegistry.SORBUS_WOOD.get());
            dropSelf(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get());
            dropSelf(MysteriousRegistry.SORBUS_PLANKS.get());
            dropSelf(MysteriousRegistry.SORBUS_STAIRS.get());
            dropSelf(MysteriousRegistry.SORBUS_SLAB.get());
            dropSelf(MysteriousRegistry.SORBUS_FENCE.get());
            dropSelf(MysteriousRegistry.SORBUS_GATE.get());
            dropSelf(MysteriousRegistry.SORBUS_BUTTON.get());
            dropSelf(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get());
            dropSelf(MysteriousRegistry.SORBUS_TRAPDOOR.get());
            dropSelf(MysteriousRegistry.SORBUS_SAPLING.get());
            dropSelf(Block.byItem(MysteriousRegistry.SORBUS_SIGN.get()));
            dropSelf(MysteriousRegistry.SORBUS_WALL_SIGN.get());
            dropSelf(MysteriousRegistry.SORBUS_HANGING_SIGN.get());
            dropSelf(MysteriousRegistry.SORBUS_WALL_HANGING_SIGN.get());
            add(MysteriousRegistry.SORBUS_DOOR.get(), this::createDoorTable);
            add(
                MysteriousRegistry.SORBUS_LEAVES.get(),
                block ->
                    createLeavesDrops(
                        MysteriousRegistry.SORBUS_LEAVES.get(),
                        MysteriousRegistry.SORBUS_SAPLING.get(),
                        BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

            // Walnut tree family.
            dropSelf(MysteriousRegistry.WALNUT_LOG.get());
            dropSelf(MysteriousRegistry.WALNUT_STRIPPED_LOG.get());
            dropSelf(MysteriousRegistry.WALNUT_WOOD.get());
            dropSelf(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get());
            dropSelf(MysteriousRegistry.WALNUT_PLANKS.get());
            dropSelf(MysteriousRegistry.WALNUT_STAIRS.get());
            dropSelf(MysteriousRegistry.WALNUT_SLAB.get());
            dropSelf(MysteriousRegistry.WALNUT_FENCE.get());
            dropSelf(MysteriousRegistry.WALNUT_GATE.get());
            dropSelf(MysteriousRegistry.WALNUT_BUTTON.get());
            dropSelf(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get());
            dropSelf(MysteriousRegistry.WALNUT_TRAPDOOR.get());
            dropSelf(MysteriousRegistry.WALNUT_SAPLING.get());
            dropSelf(Block.byItem(MysteriousRegistry.WALNUT_SIGN.get()));
            dropSelf(MysteriousRegistry.WALNUT_WALL_SIGN.get());
            dropSelf(MysteriousRegistry.WALNUT_HANGING_SIGN.get());
            dropSelf(MysteriousRegistry.WALNUT_WALL_HANGING_SIGN.get());
            add(MysteriousRegistry.WALNUT_DOOR.get(), this::createDoorTable);
            add(
                MysteriousRegistry.WALNUT_LEAVES.get(),
                block ->
                    createLeavesDrops(
                        MysteriousRegistry.WALNUT_LEAVES.get(),
                        MysteriousRegistry.WALNUT_SAPLING.get(),
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
