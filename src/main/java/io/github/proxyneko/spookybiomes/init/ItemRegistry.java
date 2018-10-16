package io.github.proxyneko.spookybiomes.init;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import io.github.proxyneko.spookybiomes.server.items.ItemBaseDoor;
import io.github.proxyneko.spookybiomes.server.items.ItemBaseSlab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class ItemRegistry {

    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        //Witchwood stuff
        event.getRegistry().register(new ItemBaseDoor(BlocksSB.WITCHWOOD_DOOR));
        //Ghostly stuff
        event.getRegistry().register(new ItemBaseDoor(BlocksSB.GHOSTLY_DOOR));
        //Oozing stuff
        event.getRegistry().register(new ItemBaseDoor(BlocksSB.OOZING_DOOR));
        //Blood stuff
        event.getRegistry().register(new ItemBaseDoor(BlocksSB.BLOOD_DOOR));
    }

    @SubscribeEvent
    public static void onRegisterItemBlock(RegistryEvent.Register<Item> event) {
        //Witchwood stuff
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_LOG));
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_LEAVES));
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_PLANKS));
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_SAPLING));
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_GATE));
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_TRAPDOOR));
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_STAIRS));
        event.getRegistry().register(nameBlockItem(BlocksSB.WITCHWOOD_FENCE));
        event.getRegistry().register(new ItemBaseSlab(Material.WOOD, BlocksSB.WITCHWOOD_SLAB, BlocksSB.WITCHWOOD_DOUBLE_SLAB));

        //Ghostly stuff
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_LOG));
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_LEAVES));
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_PLANKS));
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_SAPLING));
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_GATE));
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_TRAPDOOR));
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_STAIRS));
        event.getRegistry().register(nameBlockItem(BlocksSB.GHOSTLY_FENCE));
        event.getRegistry().register(new ItemBaseSlab(Material.WOOD, BlocksSB.GHOSTLY_SLAB, BlocksSB.GHOSTLY_DOUBLE_SLAB));

        //Oozing stuff
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_LOG));
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_LEAVES));
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_PLANKS));
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_SAPLING));
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_GATE));
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_TRAPDOOR));
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_STAIRS));
        event.getRegistry().register(nameBlockItem(BlocksSB.OOZING_FENCE));
        event.getRegistry().register(new ItemBaseSlab(Material.WOOD, BlocksSB.OOZING_SLAB, BlocksSB.OOZING_DOUBLE_SLAB));

        //Blood stuff
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_LOG));
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_LEAVES));
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_PLANKS));
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_SAPLING));
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_GATE));
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_TRAPDOOR));
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_STAIRS));
        event.getRegistry().register(nameBlockItem(BlocksSB.BLOOD_FENCE));
        event.getRegistry().register(new ItemBaseSlab(Material.WOOD, BlocksSB.BLOOD_SLAB, BlocksSB.BLOOD_DOUBLE_SLAB));
    }

    private static Item nameItem(Item item, String name) {
        item
                .setRegistryName(name)
                .setTranslationKey(SpookyBiomes.MODID + "." + name)
                .setCreativeTab(SpookyBiomes.CREATIVE_TAB);
        return item;
    }

    private static ItemBlock nameBlockItem(Block block) {
        ItemBlock item = new ItemBlock(block);
        ResourceLocation name = block.getRegistryName();
        item.setRegistryName(name);
        return item;
    }
}
