package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.proxyslib.items.ItemBaseSlab;
import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class ItemRegistry {

    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                //Sorbus stuff
                nameItem(new ItemDoor(BlocksSB.SORBUS_DOOR), "sorbus_door"),
                //Ghostly stuff
                nameItem(new ItemDoor(BlocksSB.GHOSTLY_DOOR), "ghostly_door"),
                //Oozing stuff
                nameItem(new ItemDoor(BlocksSB.SEEPING_DOOR), "seeping_door"),
                //Blood stuff
                nameItem(new ItemDoor(BlocksSB.BLOODWOOD_DOOR), "bloodwood_door")
        );
    }

    @SubscribeEvent
    public static void onRegisterItemBlock(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                //Witchwood stuff
                nameBlockItem(BlocksSB.SORBUS_LOG),
                nameBlockItem(BlocksSB.SORBUS_LEAVES),
                nameBlockItem(BlocksSB.SORBUS_PLANKS),
                nameBlockItem(BlocksSB.SORBUS_SAPLING),
                nameBlockItem(BlocksSB.SORBUS_GATE),
                nameBlockItem(BlocksSB.SORBUS_TRAPDOOR),
                nameBlockItem(BlocksSB.SORBUS_STAIRS),
                nameBlockItem(BlocksSB.SORBUS_FENCE),
                new ItemBaseSlab(BlocksSB.SORBUS_SLAB, BlocksSB.SORBUS_DOUBLE_SLAB),

                //Ghostly stuff
                nameBlockItem(BlocksSB.GHOSTLY_LOG),
                nameBlockItem(BlocksSB.GHOSTLY_LEAVES),
                nameBlockItem(BlocksSB.GHOSTLY_PLANKS),
                nameBlockItem(BlocksSB.GHOSTLY_SAPLING),
                nameBlockItem(BlocksSB.GHOSTLY_GATE),
                nameBlockItem(BlocksSB.GHOSTLY_TRAPDOOR),
                nameBlockItem(BlocksSB.GHOSTLY_STAIRS),
                nameBlockItem(BlocksSB.GHOSTLY_FENCE),
                new ItemBaseSlab(BlocksSB.GHOSTLY_SLAB, BlocksSB.GHOSTLY_DOUBLE_SLAB),

                //Oozing stuff
                nameBlockItem(BlocksSB.SEEPING_LOG),
                nameBlockItem(BlocksSB.SEEPING_LEAVES),
                nameBlockItem(BlocksSB.SEEPING_PLANKS),
                nameBlockItem(BlocksSB.SEEPING_SAPLING),
                nameBlockItem(BlocksSB.SEEPING_GATE),
                nameBlockItem(BlocksSB.SEEPING_TRAPDOOR),
                nameBlockItem(BlocksSB.SEEPING_STAIRS),
                nameBlockItem(BlocksSB.SEEPING_FENCE),
                new ItemBaseSlab(BlocksSB.SEEPING_SLAB, BlocksSB.SEEPING_DOUBLE_SLAB),

                //Blood stuff
                nameBlockItem(BlocksSB.BLOODWOOD_LOG),
                nameBlockItem(BlocksSB.BLOODWOOD_LEAVES),
                nameBlockItem(BlocksSB.BLOODWOOD_PLANKS),
                nameBlockItem(BlocksSB.BLOODWOOD_SAPLING),
                nameBlockItem(BlocksSB.BLOODWOOD_GATE),
                nameBlockItem(BlocksSB.BLOODWOOD_TRAPDOOR),
                nameBlockItem(BlocksSB.BLOODWOOD_STAIRS),
                nameBlockItem(BlocksSB.BLOODWOOD_FENCE),
                new ItemBaseSlab(BlocksSB.BLOODWOOD_SLAB, BlocksSB.BLOODWOOD_DOUBLE_SLAB)
        );
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
