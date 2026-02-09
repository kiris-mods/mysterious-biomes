/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2025
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
package dev.tophatcat.mysteriousbiomes.data.client;

import dev.tophatcat.mysteriouslands.MysteriousLandsCommon;
import dev.tophatcat.mysteriouslands.registry.BlockRegistry;
import dev.tophatcat.mysteriouslands.registry.EntityRegistry;
import dev.tophatcat.mysteriouslands.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MysteriousLanguageProvider extends LanguageProvider {

    public MysteriousLanguageProvider(PackOutput output) {
        super(output, MysteriousLandsCommon.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Creative tab.
        add("item_group.mysteriousbiomes.mysterious_tab", "Mysterious Lands");

        // Logs
        addBlock(BlockRegistry.BLOOD_SOAKED_LOG, "Blood Soaked Log");
        addBlock(BlockRegistry.GHOSTLY_LOG, "Ghostly Log");
        addBlock(BlockRegistry.SEEPING_LOG, "Seeping Log");
        addBlock(BlockRegistry.SORBUS_LOG, "Sorbus Log");
        addBlock(BlockRegistry.WALNUT_LOG, "Walnut Log");

        // Woods
        addBlock(BlockRegistry.BLOOD_SOAKED_WOOD, "Blood Soaked Wood");
        addBlock(BlockRegistry.GHOSTLY_WOOD, "Ghostly Wood");
        addBlock(BlockRegistry.SEEPING_WOOD, "Seeping Wood");
        addBlock(BlockRegistry.SORBUS_WOOD, "Sorbus Wood");
        addBlock(BlockRegistry.WALNUT_WOOD, "Walnut Wood");

        // Stripped logs
        addBlock(BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG, "Blood Soaked Stripped Log");
        addBlock(BlockRegistry.GHOSTLY_STRIPPED_LOG, "Ghostly Stripped Log");
        addBlock(BlockRegistry.SEEPING_STRIPPED_LOG, "Seeping Stripped Log");
        addBlock(BlockRegistry.SORBUS_STRIPPED_LOG, "Sorbus Stripped Log");
        addBlock(BlockRegistry.WALNUT_STRIPPED_LOG, "Walnut Stripped Log");

        // Stripped woods
        addBlock(BlockRegistry.BLOOD_SOAKED_STRIPPED_WOOD, "Blood Soaked Stripped Wood");
        addBlock(BlockRegistry.GHOSTLY_STRIPPED_WOOD, "Ghostly Stripped Wood");
        addBlock(BlockRegistry.SEEPING_STRIPPED_WOOD, "Seeping Stripped Wood");
        addBlock(BlockRegistry.SORBUS_STRIPPED_WOOD, "Sorbus Stripped Wood");
        addBlock(BlockRegistry.WALNUT_STRIPPED_WOOD, "Walnut Stripped Wood");

        // Buttons
        addBlock(BlockRegistry.BLOOD_SOAKED_BUTTON, "Blood Soaked Button");
        addBlock(BlockRegistry.GHOSTLY_BUTTON, "Ghostly Button");
        addBlock(BlockRegistry.SEEPING_BUTTON, "Seeping Button");
        addBlock(BlockRegistry.SORBUS_BUTTON, "Sorbus Button");
        addBlock(BlockRegistry.WALNUT_BUTTON, "Walnut Button");

        // Doors
        addBlock(BlockRegistry.BLOOD_SOAKED_DOOR, "Blood Soaked Door");
        addBlock(BlockRegistry.GHOSTLY_DOOR, "Ghostly Door");
        addBlock(BlockRegistry.SEEPING_DOOR, "Seeping Door");
        addBlock(BlockRegistry.SORBUS_DOOR, "Sorbus Door");
        addBlock(BlockRegistry.WALNUT_DOOR, "Walnut Door");

        // Fences
        addBlock(BlockRegistry.BLOOD_SOAKED_FENCE, "Blood Soaked Fence");
        addBlock(BlockRegistry.GHOSTLY_FENCE, "Ghostly Fence");
        addBlock(BlockRegistry.SEEPING_FENCE, "Seeping Fence");
        addBlock(BlockRegistry.SORBUS_FENCE, "Sorbus Fence");
        addBlock(BlockRegistry.WALNUT_FENCE, "Walnut Fence");

        // Gates
        addBlock(BlockRegistry.BLOOD_SOAKED_GATE, "Blood Soaked Gate");
        addBlock(BlockRegistry.GHOSTLY_GATE, "Ghostly Gate");
        addBlock(BlockRegistry.SEEPING_GATE, "Seeping Gate");
        addBlock(BlockRegistry.SORBUS_GATE, "Sorbus Gate");
        addBlock(BlockRegistry.WALNUT_GATE, "Walnut Gate");

        // Leaves
        addBlock(BlockRegistry.BLOOD_SOAKED_LEAVES, "Blood Soaked Leaves");
        addBlock(BlockRegistry.GHOSTLY_LEAVES, "Ghostly Leaves");
        addBlock(BlockRegistry.SEEPING_LEAVES, "Seeping Leaves");
        addBlock(BlockRegistry.SORBUS_LEAVES, "Sorbus Leaves");
        addBlock(BlockRegistry.WALNUT_LEAVES, "Walnut Leaves");

        // Planks
        addBlock(BlockRegistry.BLOOD_SOAKED_PLANKS, "Blood Soaked Planks");
        addBlock(BlockRegistry.GHOSTLY_PLANKS, "Ghostly Planks");
        addBlock(BlockRegistry.SEEPING_PLANKS, "Seeping Planks");
        addBlock(BlockRegistry.SORBUS_PLANKS, "Sorbus Planks");
        addBlock(BlockRegistry.WALNUT_PLANKS, "Walnut Planks");

        // Pressure plates
        addBlock(BlockRegistry.BLOOD_SOAKED_PRESSURE_PLATE, "Blood Soaked Pressure Plate");
        addBlock(BlockRegistry.GHOSTLY_PRESSURE_PLATE, "Ghostly Pressure Plate");
        addBlock(BlockRegistry.SEEPING_PRESSURE_PLATE, "Seeping Pressure Plate");
        addBlock(BlockRegistry.SORBUS_PRESSURE_PLATE, "Sorbus Pressure Plate");
        addBlock(BlockRegistry.WALNUT_PRESSURE_PLATE, "Walnut Pressure Plate");

        // Saplings
        addBlock(BlockRegistry.BLOOD_SOAKED_SAPLING, "Blood Soaked Sapling");
        addBlock(BlockRegistry.GHOSTLY_SAPLING, "Ghostly Sapling");
        addBlock(BlockRegistry.SEEPING_SAPLING, "Seeping Sapling");
        addBlock(BlockRegistry.SORBUS_SAPLING, "Sorbus Sapling");
        addBlock(BlockRegistry.WALNUT_SAPLING, "Walnut Sapling");

        // Signs
        addItem(ItemRegistry.BLOOD_SOAKED_SIGN, "Blood Soaked Sign");
        addItem(ItemRegistry.GHOSTLY_SIGN, "Ghostly Sign");
        addItem(ItemRegistry.SEEPING_SIGN, "Seeping Sign");
        addItem(ItemRegistry.SORBUS_SIGN, "Sorbus Sign");
        addItem(ItemRegistry.WALNUT_SIGN, "Walnut Sign");

        // Hanging signs
        addBlock(BlockRegistry.BLOOD_SOAKED_HANGING_SIGN, "Blood Soaked Hanging Sign");
        addBlock(BlockRegistry.GHOSTLY_HANGING_SIGN, "Ghostly Hanging Sign");
        addBlock(BlockRegistry.SEEPING_HANGING_SIGN, "Seeping Hanging Sign");
        addBlock(BlockRegistry.SORBUS_HANGING_SIGN, "Sorbus Hanging Sign");
        addBlock(BlockRegistry.WALNUT_HANGING_SIGN, "Walnut Hanging Sign");

        // Slabs
        addBlock(BlockRegistry.BLOOD_SOAKED_SLAB, "Blood Soaked Slab");
        addBlock(BlockRegistry.GHOSTLY_SLAB, "Ghostly Slab");
        addBlock(BlockRegistry.SEEPING_SLAB, "Seeping Slab");
        addBlock(BlockRegistry.SORBUS_SLAB, "Sorbus Slab");
        addBlock(BlockRegistry.WALNUT_SLAB, "Walnut Slab");

        // Stairs
        addBlock(BlockRegistry.BLOOD_SOAKED_STAIRS, "Blood Soaked Stairs");
        addBlock(BlockRegistry.GHOSTLY_STAIRS, "Ghostly Stairs");
        addBlock(BlockRegistry.SEEPING_STAIRS, "Seeping Stairs");
        addBlock(BlockRegistry.SORBUS_STAIRS, "Sorbus Stairs");
        addBlock(BlockRegistry.WALNUT_STAIRS, "Walnut Stairs");

        // Trapdoors
        addBlock(BlockRegistry.BLOOD_SOAKED_TRAPDOOR, "Blood Soaked Trapdoor");
        addBlock(BlockRegistry.GHOSTLY_TRAPDOOR, "Ghostly Trapdoor");
        addBlock(BlockRegistry.SEEPING_TRAPDOOR, "Seeping Trapdoor");
        addBlock(BlockRegistry.SORBUS_TRAPDOOR, "Sorbus Trapdoor");
        addBlock(BlockRegistry.WALNUT_TRAPDOOR, "Walnut Trapdoor");
    }
}
