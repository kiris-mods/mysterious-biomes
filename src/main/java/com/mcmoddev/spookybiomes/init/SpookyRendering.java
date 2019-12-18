package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.proxyslib.util.RegistryUtils;
import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import com.mcmoddev.spookybiomes.api.items.SpookyItemObjects;
import com.mcmoddev.spookybiomes.client.RenderTheForgottenWarlock;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID, value = Side.CLIENT)
public class SpookyRendering {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerItemModels(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTheForgottenWarlock.class,
                RenderTheForgottenWarlock::new);

        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_LOG), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_LEAVES), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_PLANKS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_SAPLING), 0);
        ModelLoader.setCustomStateMapper(SpookyBlockObjects.SORBUS_SAPLING,
                new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_GATE), 0);
        RegistryUtils.registerItemModel(SpookyItemObjects.SORBUS_DOOR, 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_TRAPDOOR), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_STAIRS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_FENCE), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SORBUS_SLAB), 0);

        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_LOG), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_LEAVES), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_PLANKS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_SAPLING), 0);
        ModelLoader.setCustomStateMapper(SpookyBlockObjects.GHOSTLY_SAPLING,
                new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_GATE), 0);
        RegistryUtils.registerItemModel(SpookyItemObjects.GHOSTLY_DOOR, 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_TRAPDOOR), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_STAIRS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_FENCE), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.GHOSTLY_SLAB), 0);

        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_LOG), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_LEAVES), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_PLANKS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_SAPLING), 0);
        ModelLoader.setCustomStateMapper(SpookyBlockObjects.SEEPING_SAPLING,
                new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_GATE), 0);
        RegistryUtils.registerItemModel(SpookyItemObjects.SEEPING_DOOR, 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_TRAPDOOR), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_STAIRS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_FENCE), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.SEEPING_SLAB), 0);

        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_LOG), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_LEAVES), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_PLANKS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_SAPLING), 0);
        ModelLoader.setCustomStateMapper(SpookyBlockObjects.BLOODWOOD_SAPLING,
                new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_GATE), 0);
        RegistryUtils.registerItemModel(SpookyItemObjects.BLOODWOOD_DOOR, 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_TRAPDOOR), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_STAIRS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_FENCE), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODWOOD_SLAB), 0);

        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODIED_GRASS), 0);
        RegistryUtils.registerItemModel(Item.getItemFromBlock(SpookyBlockObjects.BLOODIED_DIRT), 0);
    }
}
