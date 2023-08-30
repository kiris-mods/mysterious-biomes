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

import java.util.function.Consumer;

public class MysteriousRecipeGenerator extends FabricRecipeProvider {

    public MysteriousRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.BLOODWOOD.getButton().get())
                .input(MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getButton().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getButton().get()))
                .group("wooden_button")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.BLOODWOOD.getDoor().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getDoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getDoor().get()))
                .group("wooden_door")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.BLOODWOOD.getFence().get(), 3)
                .pattern("WSW")
                .pattern("WSW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getFence().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getFence().get()))
                .group("wooden_fence")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.BLOODWOOD.getGate().get())
                .pattern("SWS")
                .pattern("SWS")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getGate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getGate().get()))
                .group("wooden_fence_gate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.BLOODWOOD.getHangingSign().get(), 6)
                .pattern("X X")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getStrippedLog().get())
                .input('X', Items.CHAIN)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getHangingSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getHangingSign().get()))
                .group("hanging_sign")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.BLOODWOOD.getPlanks().get(), 4)
                .input(MysteriousItemTags.BLOODWOOD_LOGS)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getPlanks().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getPlanks().get()))
                .group("planks")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.BLOODWOOD.getPressurePlate().get())
                .pattern("WW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getPressurePlate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getPressurePlate().get()))
                .group("wooden_pressure_plate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.BLOODWOOD.getSign().get(), 3)
                .pattern("WWW")
                .pattern("WWW")
                .pattern(" S ")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getSign().get()))
                .group("wooden_sign")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.BLOODWOOD.getSlab().get(), 6)
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getSlab().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getSlab().get()))
                .group("wooden_slab")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.BLOODWOOD.getStairs().get(), 4)
                .pattern("W  ")
                .pattern("WW ")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getStairs().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getStairs().get()))
                .group("wooden_stairs")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get(), 2)
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get()))
                .group("wooden_trapdoor")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.BLOODWOOD.getWood().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.BLOODWOOD.getLog().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getWood().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getWood().get()))
                .group("bark")
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.GHOSTLY.getButton().get())
                .input(MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getButton().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getButton().get()))
                .group("wooden_button")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.GHOSTLY.getDoor().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getDoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getDoor().get()))
                .group("wooden_door")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.GHOSTLY.getFence().get(), 3)
                .pattern("WSW")
                .pattern("WSW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getFence().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getFence().get()))
                .group("wooden_fence")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.GHOSTLY.getGate().get())
                .pattern("SWS")
                .pattern("SWS")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getGate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getGate().get()))
                .group("wooden_fence_gate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.GHOSTLY.getHangingSign().get(), 6)
                .pattern("X X")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getStrippedLog().get())
                .input('X', Items.CHAIN)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getHangingSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getHangingSign().get()))
                .group("hanging_sign")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.GHOSTLY.getPlanks().get(), 4)
                .input(MysteriousItemTags.BLOODWOOD_LOGS)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getPlanks().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getPlanks().get()))
                .group("planks")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.GHOSTLY.getPressurePlate().get())
                .pattern("WW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getPressurePlate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getPressurePlate().get()))
                .group("wooden_pressure_plate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.GHOSTLY.getSign().get(), 3)
                .pattern("WWW")
                .pattern("WWW")
                .pattern(" S ")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getSign().get()))
                .group("wooden_sign")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.GHOSTLY.getSlab().get(), 6)
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.BLOODWOOD.getSlab().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.BLOODWOOD.getSlab().get()))
                .group("wooden_slab")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.GHOSTLY.getStairs().get(), 4)
                .pattern("W  ")
                .pattern("WW ")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getStairs().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getStairs().get()))
                .group("wooden_stairs")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.GHOSTLY.getTrapdoor().get(), 2)
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getTrapdoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getTrapdoor().get()))
                .group("wooden_trapdoor")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.GHOSTLY.getWood().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.GHOSTLY.getLog().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.GHOSTLY.getWood().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.GHOSTLY.getWood().get()))
                .group("bark")
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SEEPING.getButton().get())
                .input(MysteriousBlockTypes.SEEPING.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getButton().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getButton().get()))
                .group("wooden_button")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SEEPING.getDoor().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getDoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getDoor().get()))
                .group("wooden_door")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SEEPING.getFence().get(), 3)
                .pattern("WSW")
                .pattern("WSW")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getFence().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getFence().get()))
                .group("wooden_fence")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SEEPING.getGate().get())
                .pattern("SWS")
                .pattern("SWS")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getGate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getGate().get()))
                .group("wooden_fence_gate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SEEPING.getHangingSign().get(), 6)
                .pattern("X X")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SEEPING.getStrippedLog().get())
                .input('X', Items.CHAIN)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getHangingSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getHangingSign().get()))
                .group("hanging_sign")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SEEPING.getPlanks().get(), 4)
                .input(MysteriousItemTags.SEEPING_LOGS)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getPlanks().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getPlanks().get()))
                .group("planks")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SEEPING.getPressurePlate().get())
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getPressurePlate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getPressurePlate().get()))
                .group("wooden_pressure_plate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SEEPING.getSign().get(), 3)
                .pattern("WWW")
                .pattern("WWW")
                .pattern(" S ")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getSign().get()))
                .group("wooden_sign")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SEEPING.getSlab().get(), 6)
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getSlab().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getSlab().get()))
                .group("wooden_slab")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SEEPING.getStairs().get(), 4)
                .pattern("W  ")
                .pattern("WW ")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getStairs().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getStairs().get()))
                .group("wooden_stairs")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SEEPING.getTrapdoor().get(), 2)
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SEEPING.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getTrapdoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getTrapdoor().get()))
                .group("wooden_trapdoor")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SEEPING.getWood().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SEEPING.getLog().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SEEPING.getWood().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SEEPING.getWood().get()))
                .group("bark")
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SORBUS.getButton().get())
                .input(MysteriousBlockTypes.SORBUS.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getButton().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getButton().get()))
                .group("wooden_button")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SORBUS.getDoor().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getDoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getDoor().get()))
                .group("wooden_door")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SORBUS.getFence().get(), 3)
                .pattern("WSW")
                .pattern("WSW")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getFence().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getFence().get()))
                .group("wooden_fence")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SORBUS.getGate().get())
                .pattern("SWS")
                .pattern("SWS")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getGate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getGate().get()))
                .group("wooden_fence_gate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SORBUS.getHangingSign().get(), 6)
                .pattern("X X")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SORBUS.getStrippedLog().get())
                .input('X', Items.CHAIN)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getHangingSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getHangingSign().get()))
                .group("hanging_sign")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SORBUS.getPlanks().get(), 4)
                .input(MysteriousItemTags.SORBUS_LOGS)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getPlanks().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getPlanks().get()))
                .group("planks")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SORBUS.getPressurePlate().get())
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getPressurePlate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getPressurePlate().get()))
                .group("wooden_pressure_plate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SORBUS.getSign().get(), 3)
                .pattern("WWW")
                .pattern("WWW")
                .pattern(" S ")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getSign().get()))
                .group("wooden_sign")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SORBUS.getSlab().get(), 6)
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getSlab().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getSlab().get()))
                .group("wooden_slab")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SORBUS.getStairs().get(), 4)
                .pattern("W  ")
                .pattern("WW ")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getStairs().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getStairs().get()))
                .group("wooden_stairs")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SORBUS.getTrapdoor().get(), 2)
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SORBUS.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getTrapdoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getTrapdoor().get()))
                .group("wooden_trapdoor")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SORBUS.getWood().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SORBUS.getLog().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SORBUS.getWood().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SORBUS.getWood().get()))
                .group("bark")
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SAKURA.getButton().get())
                .input(MysteriousBlockTypes.SAKURA.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getButton().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getButton().get()))
                .group("wooden_button")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SAKURA.getDoor().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getDoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getDoor().get()))
                .group("wooden_door")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SAKURA.getFence().get(), 3)
                .pattern("WSW")
                .pattern("WSW")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getFence().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getFence().get()))
                .group("wooden_fence")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SAKURA.getGate().get())
                .pattern("SWS")
                .pattern("SWS")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getGate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getGate().get()))
                .group("wooden_fence_gate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SAKURA.getHangingSign().get(), 6)
                .pattern("X X")
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SAKURA.getStrippedLog().get())
                .input('X', Items.CHAIN)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getHangingSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getHangingSign().get()))
                .group("hanging_sign")
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SAKURA.getPlanks().get(), 4)
                .input(MysteriousItemTags.SAKURA_LOGS)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getPlanks().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getPlanks().get()))
                .group("planks")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SAKURA.getPressurePlate().get())
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getPressurePlate().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getPressurePlate().get()))
                .group("wooden_pressure_plate")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,
                        MysteriousBlockTypes.SAKURA.getSign().get(), 3)
                .pattern("WWW")
                .pattern("WWW")
                .pattern(" S ")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .input('S', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getSign().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getSign().get()))
                .group("wooden_sign")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SAKURA.getSlab().get(), 6)
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getSlab().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getSlab().get()))
                .group("wooden_slab")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SAKURA.getStairs().get(), 4)
                .pattern("W  ")
                .pattern("WW ")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getStairs().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getStairs().get()))
                .group("wooden_stairs")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,
                        MysteriousBlockTypes.SAKURA.getTrapdoor().get(), 2)
                .pattern("WWW")
                .pattern("WWW")
                .input('W', MysteriousBlockTypes.SAKURA.getPlanks().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getTrapdoor().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getTrapdoor().get()))
                .group("wooden_trapdoor")
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,
                        MysteriousBlockTypes.SAKURA.getWood().get(), 3)
                .pattern("WW")
                .pattern("WW")
                .input('W', MysteriousBlockTypes.SAKURA.getLog().get())
                .criterion(FabricRecipeProvider.hasItem(MysteriousBlockTypes.SAKURA.getWood().get()),
                        FabricRecipeProvider.conditionsFromItem(MysteriousBlockTypes.SAKURA.getWood().get()))
                .group("bark")
                .offerTo(exporter);
    }
}
