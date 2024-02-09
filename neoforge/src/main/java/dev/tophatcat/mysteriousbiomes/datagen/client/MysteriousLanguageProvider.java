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

import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MysteriousLanguageProvider extends LanguageProvider {

    public MysteriousLanguageProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    protected void addTranslations() {
        // Creative tab.
        add("item_group.mysteriousbiomes.mysterious_tab", "Mysterious Biomes");

        // Entities.
        addEntityType(MysteriousRegistry.THE_FORGOTTEN_WARLOCK, "The Forgotten Warlock");

        // Misc blocks
        addBlock(MysteriousRegistry.BLOODIED_DIRT, "Bloodied Dirt");
        addBlock(MysteriousRegistry.BLOODIED_GRASS, "Bloodied Grass");

        // Logs
        addBlock(MysteriousRegistry.BLOODWOOD_LOG, "Bloodwood Log");
        addBlock(MysteriousRegistry.GHOSTLY_LOG, "Ghostly Log");
        addBlock(MysteriousRegistry.SEEPING_LOG, "Seeping Log");
        addBlock(MysteriousRegistry.SORBUS_LOG, "Sorbus Log");
        addBlock(MysteriousRegistry.WALNUT_LOG, "Walnut Log");

        // Woods
        addBlock(MysteriousRegistry.BLOODWOOD_WOOD, "Bloodwood Wood");
        addBlock(MysteriousRegistry.GHOSTLY_WOOD, "Ghostly Wood");
        addBlock(MysteriousRegistry.SEEPING_WOOD, "Seeping Wood");
        addBlock(MysteriousRegistry.SORBUS_WOOD, "Sorbus Wood");
        addBlock(MysteriousRegistry.WALNUT_WOOD, "Walnut Wood");

        // Stripped logs
        addBlock(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG, "Bloodwood Stripped Log");
        addBlock(MysteriousRegistry.GHOSTLY_STRIPPED_LOG, "Ghostly Stripped Log");
        addBlock(MysteriousRegistry.SEEPING_STRIPPED_LOG, "Seeping Stripped Log");
        addBlock(MysteriousRegistry.SORBUS_STRIPPED_LOG, "Sorbus Stripped Log");
        addBlock(MysteriousRegistry.WALNUT_STRIPPED_LOG, "Walnut Stripped Log");

        // Stripped woods
        addBlock(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD, "Bloodwood Stripped Wood");
        addBlock(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD, "Ghostly Stripped Wood");
        addBlock(MysteriousRegistry.SEEPING_STRIPPED_WOOD, "Seeping Stripped Wood");
        addBlock(MysteriousRegistry.SORBUS_STRIPPED_WOOD, "Sorbus Stripped Wood");
        addBlock(MysteriousRegistry.WALNUT_STRIPPED_WOOD, "Walnut Stripped Wood");

        // Buttons
        addBlock(MysteriousRegistry.BLOODWOOD_BUTTON, "Bloodwood Button");
        addBlock(MysteriousRegistry.GHOSTLY_BUTTON, "Ghostly Button");
        addBlock(MysteriousRegistry.SEEPING_BUTTON, "Seeping Button");
        addBlock(MysteriousRegistry.SORBUS_BUTTON, "Sorbus Button");
        addBlock(MysteriousRegistry.WALNUT_BUTTON, "Walnut Button");

        // Doors
        addBlock(MysteriousRegistry.BLOODWOOD_DOOR, "Bloodwood Door");
        addBlock(MysteriousRegistry.GHOSTLY_DOOR, "Ghostly Door");
        addBlock(MysteriousRegistry.SEEPING_DOOR, "Seeping Door");
        addBlock(MysteriousRegistry.SORBUS_DOOR, "Sorbus Door");
        addBlock(MysteriousRegistry.WALNUT_DOOR, "Walnut Door");

        // Fences
        addBlock(MysteriousRegistry.BLOODWOOD_FENCE, "Bloodwood Fence");
        addBlock(MysteriousRegistry.GHOSTLY_FENCE, "Ghostly Fence");
        addBlock(MysteriousRegistry.SEEPING_FENCE, "Seeping Fence");
        addBlock(MysteriousRegistry.SORBUS_FENCE, "Sorbus Fence");
        addBlock(MysteriousRegistry.WALNUT_FENCE, "Walnut Fence");

        // Gates
        addBlock(MysteriousRegistry.BLOODWOOD_GATE, "Bloodwood Gate");
        addBlock(MysteriousRegistry.GHOSTLY_GATE, "Ghostly Gate");
        addBlock(MysteriousRegistry.SEEPING_GATE, "Seeping Gate");
        addBlock(MysteriousRegistry.SORBUS_GATE, "Sorbus Gate");
        addBlock(MysteriousRegistry.WALNUT_GATE, "Walnut Gate");

        // Leaves
        addBlock(MysteriousRegistry.BLOODWOOD_LEAVES, "Bloodwood Leaves");
        addBlock(MysteriousRegistry.GHOSTLY_LEAVES, "Ghostly Leaves");
        addBlock(MysteriousRegistry.SEEPING_LEAVES, "Seeping Leaves");
        addBlock(MysteriousRegistry.SORBUS_LEAVES, "Sorbus Leaves");
        addBlock(MysteriousRegistry.WALNUT_LEAVES, "Walnut Leaves");

        // Planks
        addBlock(MysteriousRegistry.BLOODWOOD_PLANKS, "Bloodwood Planks");
        addBlock(MysteriousRegistry.GHOSTLY_PLANKS, "Ghostly Planks");
        addBlock(MysteriousRegistry.SEEPING_PLANKS, "Seeping Planks");
        addBlock(MysteriousRegistry.SORBUS_PLANKS, "Sorbus Planks");
        addBlock(MysteriousRegistry.WALNUT_PLANKS, "Walnut Planks");

        // Pressure plates
        addBlock(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE, "Bloodwood Pressure Plate");
        addBlock(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE, "Ghostly Pressure Plate");
        addBlock(MysteriousRegistry.SEEPING_PRESSURE_PLATE, "Seeping Pressure Plate");
        addBlock(MysteriousRegistry.SORBUS_PRESSURE_PLATE, "Sorbus Pressure Plate");
        addBlock(MysteriousRegistry.WALNUT_PRESSURE_PLATE, "Walnut Pressure Plate");

        // Saplings
        addBlock(MysteriousRegistry.BLOODWOOD_SAPLING, "Bloodwood Sapling");
        addBlock(MysteriousRegistry.GHOSTLY_SAPLING, "Ghostly Sapling");
        addBlock(MysteriousRegistry.SEEPING_SAPLING, "Seeping Sapling");
        addBlock(MysteriousRegistry.SORBUS_SAPLING, "Sorbus Sapling");
        addBlock(MysteriousRegistry.WALNUT_SAPLING, "Walnut Sapling");

        // Signs
        addItem(MysteriousRegistry.BLOODWOOD_SIGN, "Bloodwood Sign");
        addItem(MysteriousRegistry.GHOSTLY_SIGN, "Ghostly Sign");
        addItem(MysteriousRegistry.SEEPING_SIGN, "Seeping Sign");
        addItem(MysteriousRegistry.SORBUS_SIGN, "Sorbus Sign");
        addItem(MysteriousRegistry.WALNUT_SIGN, "Walnut Sign");

        // Hanging signs
        addBlock(MysteriousRegistry.BLOODWOOD_HANGING_SIGN, "Bloodwood Hanging Sign");
        addBlock(MysteriousRegistry.GHOSTLY_HANGING_SIGN, "Ghostly Hanging Sign");
        addBlock(MysteriousRegistry.SEEPING_HANGING_SIGN, "Seeping Hanging Sign");
        addBlock(MysteriousRegistry.SORBUS_HANGING_SIGN, "Sorbus Hanging Sign");
        addBlock(MysteriousRegistry.WALNUT_HANGING_SIGN, "Walnut Hanging Sign");

        // Slabs
        addBlock(MysteriousRegistry.BLOODWOOD_SLAB, "Bloodwood Slab");
        addBlock(MysteriousRegistry.GHOSTLY_SLAB, "Ghostly Slab");
        addBlock(MysteriousRegistry.SEEPING_SLAB, "Seeping Slab");
        addBlock(MysteriousRegistry.SORBUS_SLAB, "Sorbus Slab");
        addBlock(MysteriousRegistry.WALNUT_SLAB, "Walnut Slab");

        // Stairs
        addBlock(MysteriousRegistry.BLOODWOOD_STAIRS, "Bloodwood Stairs");
        addBlock(MysteriousRegistry.GHOSTLY_STAIRS, "Ghostly Stairs");
        addBlock(MysteriousRegistry.SEEPING_STAIRS, "Seeping Stairs");
        addBlock(MysteriousRegistry.SORBUS_STAIRS, "Sorbus Stairs");
        addBlock(MysteriousRegistry.WALNUT_STAIRS, "Walnut Stairs");

        // Trapdoors
        addBlock(MysteriousRegistry.BLOODWOOD_TRAPDOOR, "Bloodwood Trapdoor");
        addBlock(MysteriousRegistry.GHOSTLY_TRAPDOOR, "Ghostly Trapdoor");
        addBlock(MysteriousRegistry.SEEPING_TRAPDOOR, "Seeping Trapdoor");
        addBlock(MysteriousRegistry.SORBUS_TRAPDOOR, "Sorbus Trapdoor");
        addBlock(MysteriousRegistry.WALNUT_TRAPDOOR, "Walnut Trapdoor");
    }
}
