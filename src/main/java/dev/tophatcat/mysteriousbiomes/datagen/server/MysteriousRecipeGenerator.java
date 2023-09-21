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

import dev.tophatcat.mysteriousbiomes.datagen.server.tags.MysteriousItemTags;
import dev.tophatcat.mysteriousbiomes.init.MysteriousRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class MysteriousRecipeGenerator extends FabricRecipeProvider {

    public MysteriousRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        //Bloodwood tree family.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.BLOODWOOD_PLANKS.get(), 4)
            .requires(MysteriousItemTags.BLOODWOOD_LOGS)
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousItemTags.BLOODWOOD_LOGS))
            .group("planks")
            .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,
                MysteriousRegistry.BLOODWOOD_BUTTON.get())
            .requires(MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_button")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.BLOODWOOD_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_door")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.BLOODWOOD_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_fence")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.BLOODWOOD_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy("has_stripped_logs",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.BLOODWOOD_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.BLOODWOOD_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_slab")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.BLOODWOOD_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_stairs")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.BLOODWOOD_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.BLOODWOOD_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.BLOODWOOD_LOG.get())
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousRegistry.BLOODWOOD_LOG.get()))
            .group("bark")
            .save(exporter);

        //TODO Duplicate the above with the correct woods.
        //Ghostly tree family.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.GHOSTLY_PLANKS.get(), 4)
            .requires(MysteriousItemTags.GHOSTLY_LOGS)
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousItemTags.GHOSTLY_LOGS))
            .group("planks")
            .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,
                MysteriousRegistry.GHOSTLY_BUTTON.get())
            .requires(MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_button")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.GHOSTLY_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_door")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.GHOSTLY_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_fence")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.GHOSTLY_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.GHOSTLY_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy("has_stripped_logs",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.GHOSTLY_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.GHOSTLY_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_slab")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.GHOSTLY_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_stairs")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.GHOSTLY_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.GHOSTLY_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.GHOSTLY_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.GHOSTLY_LOG.get())
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousRegistry.GHOSTLY_LOG.get()))
            .group("bark")
            .save(exporter);

        //Sorbus tree family.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SORBUS_PLANKS.get(), 4)
            .requires(MysteriousItemTags.SORBUS_LOGS)
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousItemTags.SORBUS_LOGS))
            .group("planks")
            .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,
                MysteriousRegistry.SORBUS_BUTTON.get())
            .requires(MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_button")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SORBUS_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_door")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.SORBUS_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_fence")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SORBUS_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.SORBUS_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy("has_stripped_logs",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SORBUS_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.SORBUS_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SORBUS_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_slab")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SORBUS_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_stairs")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SORBUS_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SORBUS_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SORBUS_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SORBUS_LOG.get())
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousRegistry.SORBUS_LOG.get()))
            .group("bark")
            .save(exporter);

        //Seeping tree family.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SEEPING_PLANKS.get(), 4)
            .requires(MysteriousItemTags.SEEPING_LOGS)
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousItemTags.SEEPING_LOGS))
            .group("planks")
            .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,
                MysteriousRegistry.SEEPING_BUTTON.get())
            .requires(MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_button")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SEEPING_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_door")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.SEEPING_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_fence")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SEEPING_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.SEEPING_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy("has_stripped_logs",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SEEPING_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.SEEPING_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SEEPING_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_slab")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SEEPING_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_stairs")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.SEEPING_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.SEEPING_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.SEEPING_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.SEEPING_LOG.get())
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousRegistry.SEEPING_LOG.get()))
            .group("bark")
            .save(exporter);

        //Walnut tree family.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.WALNUT_PLANKS.get(), 4)
            .requires(MysteriousItemTags.WALNUT_LOGS)
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousItemTags.WALNUT_LOGS))
            .group("planks")
            .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,
                MysteriousRegistry.WALNUT_BUTTON.get())
            .requires(MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_button")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.WALNUT_DOOR.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_door")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.WALNUT_FENCE.get(), 3)
            .pattern("WSW")
            .pattern("WSW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_fence")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.WALNUT_GATE.get())
            .pattern("SWS")
            .pattern("SWS")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_fence_gate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.WALNUT_HANGING_SIGN.get(), 6)
            .pattern("X X")
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_STRIPPED_LOG.get())
            .define('X', Items.CHAIN)
            .unlockedBy("has_stripped_logs",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_STRIPPED_LOG.get()))
            .group("hanging_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.WALNUT_PRESSURE_PLATE.get())
            .pattern("WW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_pressure_plate")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                MysteriousRegistry.WALNUT_SIGN.get(), 3)
            .pattern("WWW")
            .pattern("WWW")
            .pattern(" S ")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .define('S', Items.STICK)
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_sign")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.WALNUT_SLAB.get(), 6)
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_slab")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.WALNUT_STAIRS.get(), 4)
            .pattern("W  ")
            .pattern("WW ")
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_stairs")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                MysteriousRegistry.WALNUT_TRAPDOOR.get(), 2)
            .pattern("WWW")
            .pattern("WWW")
            .define('W', MysteriousRegistry.WALNUT_PLANKS.get())
            .unlockedBy("has_planks",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_PLANKS.get()))
            .group("wooden_trapdoor")
            .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                MysteriousRegistry.WALNUT_WOOD.get(), 3)
            .pattern("WW")
            .pattern("WW")
            .define('W', MysteriousRegistry.WALNUT_LOG.get())
            .unlockedBy("has_log",
                FabricRecipeProvider.has(MysteriousRegistry.WALNUT_LOG.get()))
            .group("bark")
            .save(exporter);
    }
}
