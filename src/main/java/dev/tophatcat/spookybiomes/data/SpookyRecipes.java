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
import static net.minecraft.advancements.critereon.ItemPredicate.Builder.item;

public class SpookyRecipes extends RecipeProvider {
    public SpookyRecipes(final DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull final Consumer<FinishedRecipe> consumer) {
        for (SpookyBlockFamily family : SpookyBlockFamily.FAMILIES) {
            final Block planks = family.planks().get();
            final String planksTriggerName = "has_planks";
            final InventoryChangeTrigger.TriggerInstance planksTrigger = InventoryChangeTrigger.TriggerInstance.hasItems(planks);

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
                .unlockedBy("has_" + path(family.log().get()),
                    InventoryChangeTrigger.TriggerInstance.hasItems(item().of(family.logsItemTag()).build()))
                .save(consumer, path(planks));

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
