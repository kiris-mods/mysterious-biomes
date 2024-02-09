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

import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousTags;
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

    public MysteriousRecipeProvider(
        PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Planks
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.BLOODWOOD_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.BLOODWOOD_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.BLOODWOOD_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.GHOSTLY_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.GHOSTLY_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.GHOSTLY_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SORBUS_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.SORBUS_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.SORBUS_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SEEPING_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.SEEPING_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.SEEPING_LOGS))
            .group("planks")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.WALNUT_PLANKS.get(), 4)
            .requires(MysteriousTags.MysteriousItems.WALNUT_LOGS)
            .unlockedBy("has_log", RecipeProvider.has(MysteriousTags.MysteriousItems.WALNUT_LOGS))
            .group("planks")
            .save(output);

        // Buttons
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, MysteriousRegistry.BLOODWOOD_BUTTON.get())
            .requires(MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, MysteriousRegistry.GHOSTLY_BUTTON.get())
            .requires(MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, MysteriousRegistry.SORBUS_BUTTON.get())
            .requires(MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, MysteriousRegistry.SEEPING_BUTTON.get())
            .requires(MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_button")
            .save(output);
        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.REDSTONE, MysteriousRegistry.WALNUT_BUTTON.get())
            .requires(MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_button")
            .save(output);

        // Doors
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.BLOODWOOD_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.GHOSTLY_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.SORBUS_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.SEEPING_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_door")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.WALNUT_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_door")
            .save(output);

        // Fences
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.BLOODWOOD_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.GHOSTLY_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.SORBUS_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.SEEPING_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_fence")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.WALNUT_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_fence")
            .save(output);

        // Gates
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.BLOODWOOD_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.GHOSTLY_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.SORBUS_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.SEEPING_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.WALNUT_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(output);

        // Hanging signs
        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC, MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs",
                RecipeProvider.has(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC, MysteriousRegistry.GHOSTLY_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.SORBUS_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(MysteriousRegistry.SORBUS_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC, MysteriousRegistry.SEEPING_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(MysteriousRegistry.SEEPING_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.WALNUT_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy(
                "has_stripped_logs", RecipeProvider.has(MysteriousRegistry.WALNUT_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(output);

        // Pressure plates
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.SORBUS_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.SEEPING_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.WALNUT_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(output);

        // Signs
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.BLOODWOOD_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.GHOSTLY_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.SORBUS_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.SEEPING_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_sign")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysteriousRegistry.WALNUT_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_sign")
            .save(output);

        // Slabs
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.BLOODWOOD_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.GHOSTLY_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SORBUS_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SEEPING_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_slab")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.WALNUT_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_slab")
            .save(output);

        // Stairs
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.BLOODWOOD_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.GHOSTLY_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SORBUS_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SEEPING_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.WALNUT_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_stairs")
            .save(output);

        // Trapdoors
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.BLOODWOOD_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.GHOSTLY_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.SORBUS_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.REDSTONE, MysteriousRegistry.SEEPING_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MysteriousRegistry.WALNUT_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks", RecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(output);

        // Woods
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.BLOODWOOD_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.BLOODWOOD_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(MysteriousRegistry.BLOODWOOD_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.GHOSTLY_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.GHOSTLY_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(MysteriousRegistry.GHOSTLY_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SORBUS_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SORBUS_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(MysteriousRegistry.SORBUS_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.SEEPING_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SEEPING_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(MysteriousRegistry.SEEPING_LOG.get()))
            .group("bark")
            .save(output);
        ShapedRecipeBuilder.shaped(
                RecipeCategory.BUILDING_BLOCKS, MysteriousRegistry.WALNUT_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.WALNUT_LOG.get())
            .unlockedBy("has_log", RecipeProvider.has(MysteriousRegistry.WALNUT_LOG.get()))
            .group("bark")
            .save(output);
    }
}
