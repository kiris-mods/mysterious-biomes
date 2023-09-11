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
import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import java.util.List;
import java.util.function.Consumer;

public class MysteriousRecipeGenerator extends FabricRecipeProvider {

    public MysteriousRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        var mysteriousWoodTypes = List.of(
                MysteriousBlockTypes.BLOODWOOD,
                MysteriousBlockTypes.GHOSTLY,
                MysteriousBlockTypes.SORBUS,
                MysteriousBlockTypes.SEEPING,
                MysteriousBlockTypes.WALNUT);

        mysteriousWoodTypes.forEach(woodType -> {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,
                            woodType.getButton().get())
                    .requires(woodType.getPlanks().get())
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_button")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                            woodType.getDoor().get(), 3)
                    .pattern("WW")
                    .pattern("WW")
                    .pattern("WW")
                    .define('W', woodType.getPlanks().get())
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_door")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                            woodType.getFence().get(), 3)
                    .pattern("WSW")
                    .pattern("WSW")
                    .define('W', woodType.getPlanks().get())
                    .define('S', Items.STICK)
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_fence")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                            woodType.getGate().get())
                    .pattern("SWS")
                    .pattern("SWS")
                    .define('W', woodType.getPlanks().get())
                    .define('S', Items.STICK)
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_fence_gate")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                            woodType.getHangingSign().get(), 6)
                    .pattern("X X")
                    .pattern("WWW")
                    .pattern("WWW")
                    .define('W', woodType.getStrippedLog().get())
                    .define('X', Items.CHAIN)
                    .unlockedBy("has_stripped_logs",
                            FabricRecipeProvider.has(woodType.getStrippedLog().get()))
                    .group("hanging_sign")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                            woodType.getPressurePlate().get())
                    .pattern("WW")
                    .define('W', woodType.getPlanks().get())
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_pressure_plate")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                            woodType.getSign().get(), 3)
                    .pattern("WWW")
                    .pattern("WWW")
                    .pattern(" S ")
                    .define('W', woodType.getPlanks().get())
                    .define('S', Items.STICK)
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_sign")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                            woodType.getSlab().get(), 6)
                    .pattern("WWW")
                    .define('W', woodType.getPlanks().get())
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_slab")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                            woodType.getStairs().get(), 4)
                    .pattern("W  ")
                    .pattern("WW ")
                    .pattern("WWW")
                    .define('W', woodType.getPlanks().get())
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_stairs")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,
                            woodType.getTrapdoor().get(), 2)
                    .pattern("WWW")
                    .pattern("WWW")
                    .define('W', woodType.getPlanks().get())
                    .unlockedBy("has_planks",
                            FabricRecipeProvider.has(woodType.getPlanks().get()))
                    .group("wooden_trapdoor")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                            woodType.getWood().get(), 3)
                    .pattern("WW")
                    .pattern("WW")
                    .define('W', woodType.getLog().get())
                    .unlockedBy("has_log",
                            FabricRecipeProvider.has(woodType.getLog().get()))
                    .group("bark")
                    .save(exporter);
        });
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.BLOODWOOD.getPlanks().get(), 4)
                .requires(MysteriousItemTags.BLOODWOOD_LOGS)
                .unlockedBy("has_log",
                        FabricRecipeProvider.has(MysteriousItemTags.BLOODWOOD_LOGS))
                .group("planks")
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.GHOSTLY.getPlanks().get(), 4)
                .requires(MysteriousItemTags.GHOSTLY_LOGS)
                .unlockedBy("has_log",
                        FabricRecipeProvider.has(MysteriousItemTags.GHOSTLY_LOGS))
                .group("planks")
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SORBUS.getPlanks().get(), 4)
                .requires(MysteriousItemTags.SORBUS_LOGS)
                .unlockedBy("has_log",
                        FabricRecipeProvider.has(MysteriousItemTags.SORBUS_LOGS))
                .group("planks")
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SEEPING.getPlanks().get(), 4)
                .requires(MysteriousItemTags.SEEPING_LOGS)
                .unlockedBy("has_log",
                        FabricRecipeProvider.has(MysteriousItemTags.SEEPING_LOGS))
                .group("planks")
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.WALNUT.getPlanks().get(), 4)
                .requires(MysteriousItemTags.WALNUT_LOGS)
                .unlockedBy("has_log",
                        FabricRecipeProvider.has(MysteriousItemTags.WALNUT_LOGS))
                .group("planks")
                .save(exporter);
    }
}
