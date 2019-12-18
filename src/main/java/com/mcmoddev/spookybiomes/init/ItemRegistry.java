package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.proxyslib.items.ItemBaseSlab;
import com.mcmoddev.proxyslib.util.RegistryUtils;
import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class ItemRegistry {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                RegistryUtils.nameItem(new ItemDoor(SpookyBlockObjects.SORBUS_DOOR), SpookyBiomes.MODID,
                        "sorbus_door", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameItem(new ItemDoor(SpookyBlockObjects.GHOSTLY_DOOR), SpookyBiomes.MODID,
                        "ghostly_door", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameItem(new ItemDoor(SpookyBlockObjects.SEEPING_DOOR), SpookyBiomes.MODID,
                        "seeping_door", SpookyBiomes.CREATIVE_TAB),
                RegistryUtils.nameItem(new ItemDoor(SpookyBlockObjects.BLOODWOOD_DOOR), SpookyBiomes.MODID,
                        "bloodwood_door", SpookyBiomes.CREATIVE_TAB)
        );
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onRegisterItemBlock(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_LOG),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_LEAVES),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_PLANKS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_SAPLING),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_GATE),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_TRAPDOOR),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_STAIRS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SORBUS_FENCE),
                new ItemBaseSlab(SpookyBlockObjects.SORBUS_SLAB, SpookyBlockObjects.SORBUS_DOUBLE_SLAB),

                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_LOG),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_LEAVES),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_PLANKS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_SAPLING),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_GATE),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_TRAPDOOR),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_STAIRS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.GHOSTLY_FENCE),
                new ItemBaseSlab(SpookyBlockObjects.GHOSTLY_SLAB, SpookyBlockObjects.GHOSTLY_DOUBLE_SLAB),

                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_LOG),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_LEAVES),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_PLANKS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_SAPLING),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_GATE),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_TRAPDOOR),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_STAIRS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.SEEPING_FENCE),
                new ItemBaseSlab(SpookyBlockObjects.SEEPING_SLAB, SpookyBlockObjects.SEEPING_DOUBLE_SLAB),

                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_LOG),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_LEAVES),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_PLANKS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_SAPLING),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_GATE),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_TRAPDOOR),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_STAIRS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODWOOD_FENCE),
                new ItemBaseSlab(SpookyBlockObjects.BLOODWOOD_SLAB, SpookyBlockObjects.BLOODWOOD_DOUBLE_SLAB),

                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODIED_GRASS),
                RegistryUtils.nameBlockItem(SpookyBlockObjects.BLOODIED_DIRT)
        );
    }
}
