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
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class MysteriousRecipeGenerator extends FabricRecipeProvider {

    public MysteriousRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        var mysteriousWoodTypes = List.of(
                MysteriousBlockTypes.BLOODWOOD,
                MysteriousBlockTypes.GHOSTLY,
                MysteriousBlockTypes.SORBUS,
                MysteriousBlockTypes.SEEPING,
                MysteriousBlockTypes.WALNUT);

        mysteriousWoodTypes.forEach(woodType -> {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                            woodType.getButton().get())
                    .input(woodType.getPlanks().get())
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_button")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                            woodType.getDoor().get(), 3)
                    .pattern("WW")
                    .pattern("WW")
                    .pattern("WW")
                    .input('W', woodType.getPlanks().get())
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_door")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                            woodType.getFence().get(), 3)
                    .pattern("WSW")
                    .pattern("WSW")
                    .input('W', woodType.getPlanks().get())
                    .input('S', Items.STICK)
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_fence")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                            woodType.getGate().get())
                    .pattern("SWS")
                    .pattern("SWS")
                    .input('W', woodType.getPlanks().get())
                    .input('S', Items.STICK)
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_fence_gate")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                            woodType.getHangingSign().get(), 6)
                    .pattern("X X")
                    .pattern("WWW")
                    .pattern("WWW")
                    .input('W', woodType.getStrippedLog().get())
                    .input('X', Items.CHAIN)
                    .criterion("has_stripped_logs",
                            FabricRecipeProvider.conditionsFromItem(woodType.getStrippedLog().get()))
                    .group("hanging_sign")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                            woodType.getPressurePlate().get())
                    .pattern("WW")
                    .input('W', woodType.getPlanks().get())
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_pressure_plate")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                            woodType.getSign().get(), 3)
                    .pattern("WWW")
                    .pattern("WWW")
                    .pattern(" S ")
                    .input('W', woodType.getPlanks().get())
                    .input('S', Items.STICK)
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_sign")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                            woodType.getSlab().get(), 6)
                    .pattern("WWW")
                    .input('W', woodType.getPlanks().get())
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_slab")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                            woodType.getStairs().get(), 4)
                    .pattern("W  ")
                    .pattern("WW ")
                    .pattern("WWW")
                    .input('W', woodType.getPlanks().get())
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_stairs")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                            woodType.getTrapdoor().get(), 2)
                    .pattern("WWW")
                    .pattern("WWW")
                    .input('W', woodType.getPlanks().get())
                    .criterion("has_planks",
                            FabricRecipeProvider.conditionsFromItem(woodType.getPlanks().get()))
                    .group("wooden_trapdoor")
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                            woodType.getWood().get(), 3)
                    .pattern("WW")
                    .pattern("WW")
                    .input('W', woodType.getLog().get())
                    .criterion("has_log",
                            FabricRecipeProvider.conditionsFromItem(woodType.getLog().get()))
                    .group("bark")
                    .offerTo(exporter);
        });
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.BLOODWOOD.getPlanks().get(), 4)
                .input(MysteriousItemTags.BLOODWOOD_LOGS)
                .criterion("has_log",
                        FabricRecipeProvider.conditionsFromTag(MysteriousItemTags.BLOODWOOD_LOGS))
                .group("planks")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.GHOSTLY.getPlanks().get(), 4)
                .input(MysteriousItemTags.GHOSTLY_LOGS)
                .criterion("has_log",
                        FabricRecipeProvider.conditionsFromTag(MysteriousItemTags.GHOSTLY_LOGS))
                .group("planks")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SORBUS.getPlanks().get(), 4)
                .input(MysteriousItemTags.SORBUS_LOGS)
                .criterion("has_log",
                        FabricRecipeProvider.conditionsFromTag(MysteriousItemTags.SORBUS_LOGS))
                .group("planks")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SEEPING.getPlanks().get(), 4)
                .input(MysteriousItemTags.SEEPING_LOGS)
                .criterion("has_log",
                        FabricRecipeProvider.conditionsFromTag(MysteriousItemTags.SEEPING_LOGS))
                .group("planks")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.WALNUT.getPlanks().get(), 4)
                .input(MysteriousItemTags.WALNUT_LOGS)
                .criterion("has_log",
                        FabricRecipeProvider.conditionsFromTag(MysteriousItemTags.WALNUT_LOGS))
                .group("planks")
                .offerTo(exporter);
    }
}
