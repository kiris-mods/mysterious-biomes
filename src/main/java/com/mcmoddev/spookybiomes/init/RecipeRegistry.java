package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import com.mcmoddev.spookybiomes.api.items.SpookyItemObjects;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeRegistry {

    public static void registerRecipes() {
        //Sorbus stuff
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SORBUS_PLANKS, 4), "#", '#', SpookyBlockObjects.SORBUS_LOG);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SORBUS_GATE), "s#s", "s#s", '#', SpookyBlockObjects.SORBUS_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyItemObjects.SORBUS_DOOR), "##", "##", "##", '#', SpookyBlockObjects.SORBUS_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SORBUS_TRAPDOOR, 2), "###", "###", '#', SpookyBlockObjects.SORBUS_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SORBUS_STAIRS, 4), "#  ", "## ", "###", '#', SpookyBlockObjects.SORBUS_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SORBUS_FENCE, 3), "#s#", "#s#", '#', SpookyBlockObjects.SORBUS_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SORBUS_SLAB, 6), "###", '#', SpookyBlockObjects.SORBUS_PLANKS);

        //Ghostly stuff
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.GHOSTLY_PLANKS, 4), "#", '#', SpookyBlockObjects.GHOSTLY_LOG);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.GHOSTLY_GATE), "s#s", "s#s", '#', SpookyBlockObjects.GHOSTLY_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyItemObjects.GHOSTLY_DOOR), "##", "##", "##", '#', SpookyBlockObjects.GHOSTLY_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.GHOSTLY_TRAPDOOR, 2), "###", "###", '#', SpookyBlockObjects.GHOSTLY_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.GHOSTLY_STAIRS, 4), "#  ", "## ", "###", '#', SpookyBlockObjects.GHOSTLY_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.GHOSTLY_FENCE, 3), "#s#", "#s#", '#', SpookyBlockObjects.GHOSTLY_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.GHOSTLY_SLAB, 6), "###", '#', SpookyBlockObjects.GHOSTLY_PLANKS);

        //Seeping stuff
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SEEPING_PLANKS, 4), "#", '#', SpookyBlockObjects.SEEPING_LOG);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SEEPING_GATE), "s#s", "s#s", '#', SpookyBlockObjects.SEEPING_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyItemObjects.SEEPING_DOOR), "##", "##", "##", '#', SpookyBlockObjects.SEEPING_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SEEPING_TRAPDOOR, 2), "###", "###", '#', SpookyBlockObjects.SEEPING_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SEEPING_STAIRS, 4), "#  ", "## ", "###", '#', SpookyBlockObjects.SEEPING_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SEEPING_FENCE, 3), "#s#", "#s#", '#', SpookyBlockObjects.SEEPING_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.SEEPING_SLAB, 6), "###", '#', SpookyBlockObjects.SEEPING_PLANKS);

        //Blood stuff
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.BLOODWOOD_PLANKS, 4), "#", '#', SpookyBlockObjects.BLOODWOOD_LOG);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.BLOODWOOD_GATE), "s#s", "s#s", '#', SpookyBlockObjects.BLOODWOOD_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyItemObjects.BLOODWOOD_DOOR), "##", "##", "##", '#', SpookyBlockObjects.BLOODWOOD_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.BLOODWOOD_TRAPDOOR, 2), "###", "###", '#', SpookyBlockObjects.BLOODWOOD_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.BLOODWOOD_STAIRS, 4), "#  ", "## ", "###", '#', SpookyBlockObjects.BLOODWOOD_PLANKS);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.BLOODWOOD_FENCE, 3), "#s#", "#s#", '#', SpookyBlockObjects.BLOODWOOD_PLANKS, 's', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SpookyBlockObjects.BLOODWOOD_SLAB, 6), "###", '#', SpookyBlockObjects.BLOODWOOD_PLANKS);
    }
}
