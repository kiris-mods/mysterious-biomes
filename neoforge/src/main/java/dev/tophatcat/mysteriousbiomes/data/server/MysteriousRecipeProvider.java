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

import dev.tophatcat.mysteriouslands.registry.BlockRegistry;
import dev.tophatcat.mysteriouslands.registry.ItemRegistry;
import dev.tophatcat.mysteriouslands.utils.MysteriousTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

public class MysteriousRecipeProvider extends RecipeProvider {

    public MysteriousRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Planks
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.BLOOD_SOAKED_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.BLOOD_SOAKED_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.BLOOD_SOAKED_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.GHOSTLY_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.GHOSTLY_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.GHOSTLY_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SORBUS_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.SORBUS_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.SORBUS_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SEEPING_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.SEEPING_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.SEEPING_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.WALNUT_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.WALNUT_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.WALNUT_LOGS))
            .group("planks")
            .save(output);

        // Buttons
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, BlockRegistry.BLOOD_SOAKED_BUTTON.get())
            .requires(BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, BlockRegistry.GHOSTLY_BUTTON.get())
            .requires(BlockRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, BlockRegistry.SORBUS_BUTTON.get())
            .requires(BlockRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, BlockRegistry.SEEPING_BUTTON.get())
            .requires(BlockRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, BlockRegistry.WALNUT_BUTTON.get())
            .requires(BlockRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_button")
            .save(output);

        // Doors
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.BLOOD_SOAKED_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.GHOSTLY_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.SORBUS_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.SEEPING_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.WALNUT_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_door")
            .save(output);

        // Fences
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.BLOOD_SOAKED_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.GHOSTLY_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.SORBUS_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.SEEPING_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.WALNUT_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_fence")
            .save(output);

        // Gates
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.BLOOD_SOAKED_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.GHOSTLY_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.SORBUS_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.SEEPING_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.WALNUT_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);

        // Hanging signs
        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC, BlockRegistry.BLOOD_SOAKED_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs",
                RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC, BlockRegistry.GHOSTLY_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.GHOSTLY_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(BlockRegistry.GHOSTLY_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.SORBUS_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.SORBUS_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(BlockRegistry.SORBUS_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC, BlockRegistry.SEEPING_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.SEEPING_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(BlockRegistry.SEEPING_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.WALNUT_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.WALNUT_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(BlockRegistry.WALNUT_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);

        // Pressure plates
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.BLOOD_SOAKED_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.GHOSTLY_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.SORBUS_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.SEEPING_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.WALNUT_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);

        // Signs
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.BLOOD_SOAKED_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.GHOSTLY_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.SORBUS_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.SEEPING_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.WALNUT_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_sign")
            .save(output);

        // Slabs
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.BLOOD_SOAKED_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.GHOSTLY_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SORBUS_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SEEPING_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.WALNUT_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_slab")
            .save(output);

        // Stairs
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.BLOOD_SOAKED_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.GHOSTLY_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SORBUS_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SEEPING_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.WALNUT_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);

        // Trapdoors
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.BLOOD_SOAKED_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.BLOOD_SOAKED_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.GHOSTLY_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.SORBUS_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SORBUS_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, BlockRegistry.SEEPING_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.SEEPING_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BlockRegistry.WALNUT_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', BlockRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(BlockRegistry.WALNUT_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);

        // Woods
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.BLOOD_SOAKED_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.BLOOD_SOAKED_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(BlockRegistry.BLOOD_SOAKED_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.GHOSTLY_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.GHOSTLY_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(BlockRegistry.GHOSTLY_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SORBUS_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.SORBUS_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(BlockRegistry.SORBUS_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.SEEPING_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.SEEPING_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(BlockRegistry.SEEPING_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, BlockRegistry.WALNUT_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', BlockRegistry.WALNUT_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(BlockRegistry.WALNUT_LOG.get()))
            .group("bark")
            .save(output);
    }
}
