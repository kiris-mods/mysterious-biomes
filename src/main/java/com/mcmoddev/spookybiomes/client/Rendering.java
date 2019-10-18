package com.mcmoddev.spookybiomes.client;

import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import com.mcmoddev.spookybiomes.api.items.ItemsSB;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID, value = Side.CLIENT)
public class Rendering {

    @SubscribeEvent
    public static void registerItemModel(ModelRegistryEvent event) {
        //Entities
        RenderingRegistry.registerEntityRenderingHandler(EntityTheForgottenWarlock.class, RenderTheForgottenWarlock::new);

        //Sorbus stuff
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_LOG), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_LEAVES), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_PLANKS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_SAPLING), 0);
        ModelLoader.setCustomStateMapper(BlocksSB.SORBUS_SAPLING, new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_GATE), 0);
        registerItemModel(ItemsSB.SORBUS_DOOR, 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_TRAPDOOR), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_STAIRS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_FENCE), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SORBUS_SLAB), 0);

        //Ghostly stuff
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_LOG), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_LEAVES), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_PLANKS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_SAPLING), 0);
        ModelLoader.setCustomStateMapper(BlocksSB.GHOSTLY_SAPLING, new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_GATE), 0);
        registerItemModel(ItemsSB.GHOSTLY_DOOR, 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_TRAPDOOR), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_STAIRS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_FENCE), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.GHOSTLY_SLAB), 0);

        //SEEPING stuff
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_LOG), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_LEAVES), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_PLANKS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_SAPLING), 0);
        ModelLoader.setCustomStateMapper(BlocksSB.SEEPING_SAPLING, new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_GATE), 0);
        registerItemModel(ItemsSB.SEEPING_DOOR, 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_TRAPDOOR), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_STAIRS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_FENCE), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.SEEPING_SLAB), 0);

        //Blood stuff
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_LOG), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_LEAVES), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_PLANKS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_SAPLING), 0);
        ModelLoader.setCustomStateMapper(BlocksSB.BLOODWOOD_SAPLING, new StateMap.Builder().ignore(new IProperty[]{BlockSapling.TYPE}).build());
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_GATE), 0);
        registerItemModel(ItemsSB.BLOODWOOD_DOOR, 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_TRAPDOOR), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_STAIRS), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_FENCE), 0);
        registerItemModel(Item.getItemFromBlock(BlocksSB.BLOODWOOD_SLAB), 0);
    }

    private static void registerItemModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
