/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2024
 * https://github.com/kiris-mods/mysterious-biomes/blob/dev/LICENSE.md
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
 */
package dev.tophatcat.mysteriousbiomes.datagen.client;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MysteriousItemModelProvider extends ItemModelProvider {

    public MysteriousItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MysteriousCommon.MOD_ID, existingFileHelper);
    }

    protected void simpleBlockItemModel(Block block) {
        var name = getName(block);
        withExistingParent(name, modLoc("block/" + name));
    }

    protected void simpleTrapdoorBlockItemModel(Block block) {
        var name = getName(block);
        withExistingParent(name, modLoc("block/" + name + "_bottom"));
    }

    protected void simpleSaplingItemModel(Block block) {
        var name = getName(block);
        singleTexture(
            name,
            new ResourceLocation("minecraft", "item/generated"),
            "layer0",
            modLoc("block/" + name));
    }

    protected String getName(Block item) {
        return BuiltInRegistries.BLOCK.getKey(item).getPath();
    }

    @Override
    protected void registerModels() {
        simpleBlockItemModel(MysteriousRegistry.BLOODIED_GRASS.get());
        simpleBlockItemModel(MysteriousRegistry.BLOODIED_DIRT.get());

        // Logs
        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_LOG.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_LOG.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_LOG.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_LOG.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_LOG.get());

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_STRIPPED_LOG.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_STRIPPED_LOG.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_STRIPPED_LOG.get());

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_WOOD.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_WOOD.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_WOOD.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_WOOD.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_WOOD.get());

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get());

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_PLANKS.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_PLANKS.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_PLANKS.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_PLANKS.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_PLANKS.get());

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_STAIRS.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_STAIRS.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_STAIRS.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_STAIRS.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_STAIRS.get());

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_LEAVES.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_LEAVES.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_LEAVES.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_LEAVES.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_LEAVES.get());

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_SLAB.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_SLAB.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_SLAB.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_SLAB.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_SLAB.get());

        fenceInventory(
            getName(MysteriousRegistry.BLOODWOOD_FENCE.get()),
            new ResourceLocation(
                MysteriousCommon.MOD_ID,
                "block/" + getName(MysteriousRegistry.BLOODWOOD_PLANKS.get())));
        fenceInventory(
            getName(MysteriousRegistry.GHOSTLY_FENCE.get()),
            new ResourceLocation(
                MysteriousCommon.MOD_ID, "block/" + getName(MysteriousRegistry.GHOSTLY_PLANKS.get())));
        fenceInventory(
            getName(MysteriousRegistry.SEEPING_FENCE.get()),
            new ResourceLocation(
                MysteriousCommon.MOD_ID, "block/" + getName(MysteriousRegistry.SEEPING_PLANKS.get())));
        fenceInventory(
            getName(MysteriousRegistry.SORBUS_FENCE.get()),
            new ResourceLocation(
                MysteriousCommon.MOD_ID, "block/" + getName(MysteriousRegistry.SORBUS_PLANKS.get())));
        // fenceInventory(getName(MysteriousRegistry.WALNUT_FENCE.get()),
        //    new ResourceLocation(MysteriousCommon.MOD_ID, "block/"
        //        + getName(MysteriousRegistry.WALNUT_PLANKS.get())));

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_GATE.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_GATE.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_GATE.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_GATE.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_GATE.get());

        buttonInventory(
            "bloodwood_button",
            new ResourceLocation(MysteriousCommon.MOD_ID, "block/bloodwood_planks"));
        buttonInventory(
            "ghostly_button", new ResourceLocation(MysteriousCommon.MOD_ID, "block/ghostly_planks"));
        buttonInventory(
            "seeping_button", new ResourceLocation(MysteriousCommon.MOD_ID, "block/seeping_planks"));
        buttonInventory(
            "sorbus_button", new ResourceLocation(MysteriousCommon.MOD_ID, "block/sorbus_planks"));
        // buttonInventory("walnut_button", new ResourceLocation(
        //    MysteriousCommon.MOD_ID, "block/walnut_planks"));

        simpleBlockItemModel(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get());
        simpleBlockItemModel(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get());
        simpleBlockItemModel(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get());
        simpleBlockItemModel(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get());
        // simpleBlockItemModel(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get());

        simpleTrapdoorBlockItemModel(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get());
        simpleTrapdoorBlockItemModel(MysteriousRegistry.GHOSTLY_TRAPDOOR.get());
        simpleTrapdoorBlockItemModel(MysteriousRegistry.SEEPING_TRAPDOOR.get());
        simpleTrapdoorBlockItemModel(MysteriousRegistry.SORBUS_TRAPDOOR.get());
        // simpleTrapdoorBlockItemModel(MysteriousRegistry.WALNUT_TRAPDOOR.get());

        basicItem(MysteriousRegistry.BLOODWOOD_DOOR.get().asItem());
        basicItem(MysteriousRegistry.GHOSTLY_DOOR.get().asItem());
        basicItem(MysteriousRegistry.SEEPING_DOOR.get().asItem());
        basicItem(MysteriousRegistry.SORBUS_DOOR.get().asItem());
        // basicItem(MysteriousRegistry.WALNUT_DOOR.get().asItem());

        simpleSaplingItemModel(MysteriousRegistry.BLOODWOOD_SAPLING.get());
        simpleSaplingItemModel(MysteriousRegistry.GHOSTLY_SAPLING.get());
        simpleSaplingItemModel(MysteriousRegistry.SEEPING_SAPLING.get());
        simpleSaplingItemModel(MysteriousRegistry.SORBUS_SAPLING.get());
        // simpleSaplingItemModel(MysteriousRegistry.WALNUT_SAPLING.get());

        basicItem(MysteriousRegistry.BLOODWOOD_SIGN.get());
        basicItem(MysteriousRegistry.GHOSTLY_SIGN.get());
        basicItem(MysteriousRegistry.SEEPING_SIGN.get());
        basicItem(MysteriousRegistry.SORBUS_SIGN.get());
        // basicItem(MysteriousRegistry.WALNUT_SIGN.get());

        // TODO Enable these once we have textures, data generation fails without them.
        // basicItem(MysteriousRegistry.BLOODWOOD_HANGING_SIGN_ITEM.get());
        // basicItem(MysteriousRegistry.GHOSTLY_HANGING_SIGN_ITEM.get());
        // basicItem(MysteriousRegistry.SEEPING_HANGING_SIGN_ITEM.get());
        // basicItem(MysteriousRegistry.SORBUS_HANGING_SIGN_ITEM.get());
        // basicItem(MysteriousRegistry.WALNUT_HANGING_SIGN_ITEM.get());
    }
}
