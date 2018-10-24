package io.github.proxyneko.spookybiomes.init;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import io.github.proxyneko.spookybiomes.api.items.ItemsSB;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class RecipeRegistry {

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<IRecipe> event) {
        //Witchwood stuff
        registerRecipe(event, new ItemStack(BlocksSB.WITCHWOOD_PLANKS, 4), "#", '#', BlocksSB.WITCHWOOD_LOG);
        registerRecipe(event, new ItemStack(BlocksSB.WITCHWOOD_GATE), "s#s", "s#s", '#', BlocksSB.WITCHWOOD_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(ItemsSB.WITCHWOOD_DOOR), "##", "##", "##", '#', BlocksSB.WITCHWOOD_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.WITCHWOOD_TRAPDOOR, 2), "###", "###", '#', BlocksSB.WITCHWOOD_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.WITCHWOOD_STAIRS, 4), "#  ", "## ", "###", '#', BlocksSB.WITCHWOOD_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.WITCHWOOD_FENCE, 3), "#s#", "#s#", '#', BlocksSB.WITCHWOOD_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(BlocksSB.WITCHWOOD_SLAB, 6), "###", '#', BlocksSB.WITCHWOOD_PLANKS);
        //TODO Broken
        registerRecipe(event, new ItemStack(Items.STICK, 4), "#", "#", '#', BlocksSB.WITCHWOOD_PLANKS);

        //Ghostly stuff
        registerRecipe(event, new ItemStack(BlocksSB.GHOSTLY_PLANKS, 4), "#", '#', BlocksSB.GHOSTLY_LOG);
        registerRecipe(event, new ItemStack(BlocksSB.GHOSTLY_GATE), "s#s", "s#s", '#', BlocksSB.GHOSTLY_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(ItemsSB.GHOSTLY_DOOR), "##", "##", "##", '#', BlocksSB.GHOSTLY_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.GHOSTLY_TRAPDOOR, 2), "###", "###", '#', BlocksSB.GHOSTLY_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.GHOSTLY_STAIRS, 4), "#  ", "## ", "###", '#', BlocksSB.GHOSTLY_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.GHOSTLY_FENCE, 3), "#s#", "#s#", '#', BlocksSB.GHOSTLY_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(BlocksSB.GHOSTLY_SLAB, 6), "###", '#', BlocksSB.GHOSTLY_PLANKS);
        //TODO Broken
        registerRecipe(event, new ItemStack(Items.STICK, 4), "#", "#", '#', BlocksSB.GHOSTLY_PLANKS);

        //Oozing stuff
        registerRecipe(event, new ItemStack(BlocksSB.OOZING_PLANKS, 4), "#", '#', BlocksSB.OOZING_LOG);
        registerRecipe(event, new ItemStack(BlocksSB.OOZING_GATE), "s#s", "s#s", '#', BlocksSB.OOZING_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(ItemsSB.OOZING_DOOR), "##", "##", "##", '#', BlocksSB.OOZING_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.OOZING_TRAPDOOR, 2), "###", "###", '#', BlocksSB.OOZING_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.OOZING_STAIRS, 4), "#  ", "## ", "###", '#', BlocksSB.OOZING_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.OOZING_FENCE, 3), "#s#", "#s#", '#', BlocksSB.OOZING_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(BlocksSB.OOZING_SLAB, 6), "###", '#', BlocksSB.OOZING_PLANKS);
        //TODO Broken
        registerRecipe(event, new ItemStack(Items.STICK, 4), "#", "#", '#', BlocksSB.OOZING_PLANKS);

        //Blood stuff
        registerRecipe(event, new ItemStack(BlocksSB.BLOOD_PLANKS, 4), "#", '#', BlocksSB.BLOOD_LOG);
        registerRecipe(event, new ItemStack(BlocksSB.BLOOD_GATE), "s#s", "s#s", '#', BlocksSB.BLOOD_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(ItemsSB.BLOOD_DOOR), "##", "##", "##", '#', BlocksSB.BLOOD_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.BLOOD_TRAPDOOR, 2), "###", "###", '#', BlocksSB.BLOOD_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.BLOOD_STAIRS, 4), "#  ", "## ", "###", '#', BlocksSB.BLOOD_PLANKS);
        registerRecipe(event, new ItemStack(BlocksSB.BLOOD_FENCE, 3), "#s#", "#s#", '#', BlocksSB.BLOOD_PLANKS, 's', Items.STICK);
        registerRecipe(event, new ItemStack(BlocksSB.BLOOD_SLAB, 6), "###", '#', BlocksSB.BLOOD_PLANKS);
        //TODO Broken
        registerRecipe(event, new ItemStack(Items.STICK, 4), "#", "#", '#', BlocksSB.BLOOD_PLANKS);
    }

    private static void registerRecipe(RegistryEvent.Register<IRecipe> event, ItemStack stack, Object... recipe) {
        event.getRegistry().register(new ShapedOreRecipe(stack.getItem().getRegistryName(), stack, recipe)
                .setRegistryName(stack.getItem().getRegistryName()));
    }
}
