/*
 * Spooky Biomes - https://tophatcat.dev/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.data;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static dev.tophatcat.spookybiomes.data.SpookyBlockStates.path;

public class SpookyRecipes extends RecipeProvider {
    public SpookyRecipes(final DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        for (SpookyBlockFamily family : SpookyBlockFamily.FAMILIES) {
            final Block planks = family.planks().get();
            final String planksTriggerName = "has_planks";
            final InventoryChangeTrigger.TriggerInstance planksTrigger = has(planks);

            // Button
            ShapelessRecipeBuilder.shapeless(family.button().get())
                .requires(planks)
                .group("wooden_button")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.button().get()));

            // Door
            ShapedRecipeBuilder.shaped(family.door().get(), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', planks)
                .group("wooden_door")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.door().get()));

            // Fence
            ShapedRecipeBuilder.shaped(family.fence().get(), 3)
                .pattern("#s#")
                .pattern("#s#")
                .define('#', planks)
                .define('s', Tags.Items.RODS_WOODEN)
                .group("wooden_fence")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.fence().get()));

            // Fence Gate
            ShapedRecipeBuilder.shaped(family.fenceGate().get())
                .pattern("s#s")
                .pattern("s#s")
                .define('#', planks)
                .define('s', Tags.Items.RODS_WOODEN)
                .group("wooden_fence_gate")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.fenceGate().get()));

            // Planks
            ShapelessRecipeBuilder.shapeless(planks, 4)
                .requires(family.logsItemTag())
                .group("planks")
                .unlockedBy("has_" + path(family.log().get()), has(family.logsItemTag()))
                .save(consumer, path(planks));

            // Pressure Plate
            ShapedRecipeBuilder.shaped(family.pressurePlate().get())
                .pattern("##")
                .define('#', planks)
                .group("wooden_pressure_plate")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.pressurePlate().get()));

            // Sign
            ShapedRecipeBuilder.shaped(family.standingSign().get(), 3)
                .group("sign")
                .define('#', planks)
                .define('X', Tags.Items.RODS_WOODEN)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.standingSign().get()));

            // Slab
            ShapedRecipeBuilder.shaped(family.slab().get(), 6)
                .pattern("###")
                .define('#', planks)
                .group("wooden_slab")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.slab().get()));

            // Stairs
            ShapedRecipeBuilder.shaped(family.stairs().get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', planks)
                .group("wooden_stairs")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.stairs().get()));

            // Trapdoor
            ShapedRecipeBuilder.shaped(family.trapdoor().get(), 2)
                .pattern("###")
                .pattern("###")
                .define('#', planks)
                .group("wooden_trapdoor")
                .unlockedBy(planksTriggerName, planksTrigger)
                .save(consumer, path(family.trapdoor().get()));
        }
    }
}
