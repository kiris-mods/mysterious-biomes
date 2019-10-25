package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.proxyslib.items.ItemBaseSlab;
import com.mcmoddev.proxyslib.util.RegistryUtils;
import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class ItemRegistry {

    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                //Sorbus stuff
                RegistryUtils.nameItem(new ItemDoor(BlocksSB.SORBUS_DOOR), SpookyBiomes.MODID, "sorbus_door", SpookyBiomes.CREATIVE_TAB),
                //Ghostly stuff
                RegistryUtils.nameItem(new ItemDoor(BlocksSB.GHOSTLY_DOOR), SpookyBiomes.MODID, "ghostly_door", SpookyBiomes.CREATIVE_TAB),
                //Oozing stuff
                RegistryUtils.nameItem(new ItemDoor(BlocksSB.SEEPING_DOOR), SpookyBiomes.MODID, "seeping_door", SpookyBiomes.CREATIVE_TAB),
                //Blood stuff
                RegistryUtils.nameItem(new ItemDoor(BlocksSB.BLOODWOOD_DOOR), SpookyBiomes.MODID, "bloodwood_door", SpookyBiomes.CREATIVE_TAB)
        );
    }

    @SubscribeEvent
    public static void onRegisterItemBlock(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                //Witchwood stuff
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_LOG),
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_LEAVES),
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_PLANKS),
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_SAPLING),
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_GATE),
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_TRAPDOOR),
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_STAIRS),
                RegistryUtils.nameBlockItem(BlocksSB.SORBUS_FENCE),
                new ItemBaseSlab(BlocksSB.SORBUS_SLAB, BlocksSB.SORBUS_DOUBLE_SLAB),

                //Ghostly stuff
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_LOG),
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_LEAVES),
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_PLANKS),
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_SAPLING),
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_GATE),
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_TRAPDOOR),
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_STAIRS),
                RegistryUtils.nameBlockItem(BlocksSB.GHOSTLY_FENCE),
                new ItemBaseSlab(BlocksSB.GHOSTLY_SLAB, BlocksSB.GHOSTLY_DOUBLE_SLAB),

                //Oozing stuff
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_LOG),
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_LEAVES),
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_PLANKS),
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_SAPLING),
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_GATE),
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_TRAPDOOR),
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_STAIRS),
                RegistryUtils.nameBlockItem(BlocksSB.SEEPING_FENCE),
                new ItemBaseSlab(BlocksSB.SEEPING_SLAB, BlocksSB.SEEPING_DOUBLE_SLAB),

                //Blood stuff
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_LOG),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_LEAVES),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_PLANKS),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_SAPLING),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_GATE),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_TRAPDOOR),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_STAIRS),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODWOOD_FENCE),
                new ItemBaseSlab(BlocksSB.BLOODWOOD_SLAB, BlocksSB.BLOODWOOD_DOUBLE_SLAB),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODIED_GRASS),
                RegistryUtils.nameBlockItem(BlocksSB.BLOODIED_DIRT)
        );
    }
}
