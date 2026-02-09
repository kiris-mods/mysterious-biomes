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
package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriouslands.registry.BlockRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class MysteriousFlammableBlocks {

    public MysteriousFlammableBlocks() {
        init();
    }

    private static void init() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(BlockRegistry.BLOOD_SOAKED_LOG.get(), 5, 5);
        registry.add(BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get(), 5, 5);
        registry.add(BlockRegistry.BLOOD_SOAKED_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.BLOOD_SOAKED_PLANKS.get(), 5, 20);
        registry.add(BlockRegistry.BLOOD_SOAKED_LEAVES.get(), 30, 60);
        registry.add(BlockRegistry.BLOOD_SOAKED_SLAB.get(), 5, 20);
        registry.add(BlockRegistry.BLOOD_SOAKED_GATE.get(), 5, 20);
        registry.add(BlockRegistry.BLOOD_SOAKED_FENCE.get(), 5, 20);
        registry.add(BlockRegistry.BLOOD_SOAKED_STAIRS.get(), 5, 20);

        registry.add(BlockRegistry.GHOSTLY_LOG.get(), 5, 5);
        registry.add(BlockRegistry.GHOSTLY_STRIPPED_LOG.get(), 5, 5);
        registry.add(BlockRegistry.GHOSTLY_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.GHOSTLY_STRIPPED_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.GHOSTLY_PLANKS.get(), 5, 20);
        registry.add(BlockRegistry.GHOSTLY_LEAVES.get(), 30, 60);
        registry.add(BlockRegistry.GHOSTLY_SLAB.get(), 5, 20);
        registry.add(BlockRegistry.GHOSTLY_GATE.get(), 5, 20);
        registry.add(BlockRegistry.GHOSTLY_FENCE.get(), 5, 20);
        registry.add(BlockRegistry.GHOSTLY_STAIRS.get(), 5, 20);

        registry.add(BlockRegistry.SEEPING_LOG.get(), 5, 5);
        registry.add(BlockRegistry.SEEPING_STRIPPED_LOG.get(), 5, 5);
        registry.add(BlockRegistry.SEEPING_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.SEEPING_STRIPPED_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.SEEPING_PLANKS.get(), 5, 20);
        registry.add(BlockRegistry.SEEPING_LEAVES.get(), 30, 60);
        registry.add(BlockRegistry.SEEPING_SLAB.get(), 5, 20);
        registry.add(BlockRegistry.SEEPING_GATE.get(), 5, 20);
        registry.add(BlockRegistry.SEEPING_FENCE.get(), 5, 20);
        registry.add(BlockRegistry.SEEPING_STAIRS.get(), 5, 20);

        registry.add(BlockRegistry.SORBUS_LOG.get(), 5, 5);
        registry.add(BlockRegistry.SORBUS_STRIPPED_LOG.get(), 5, 5);
        registry.add(BlockRegistry.SORBUS_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.SORBUS_STRIPPED_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.SORBUS_PLANKS.get(), 5, 20);
        registry.add(BlockRegistry.SORBUS_LEAVES.get(), 30, 60);
        registry.add(BlockRegistry.SORBUS_SLAB.get(), 5, 20);
        registry.add(BlockRegistry.SORBUS_GATE.get(), 5, 20);
        registry.add(BlockRegistry.SORBUS_FENCE.get(), 5, 20);
        registry.add(BlockRegistry.SORBUS_STAIRS.get(), 5, 20);

        registry.add(BlockRegistry.WALNUT_LOG.get(), 5, 5);
        registry.add(BlockRegistry.WALNUT_STRIPPED_LOG.get(), 5, 5);
        registry.add(BlockRegistry.WALNUT_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.WALNUT_STRIPPED_WOOD.get(), 5, 5);
        registry.add(BlockRegistry.WALNUT_PLANKS.get(), 5, 20);
        registry.add(BlockRegistry.WALNUT_LEAVES.get(), 30, 60);
        registry.add(BlockRegistry.WALNUT_SLAB.get(), 5, 20);
        registry.add(BlockRegistry.WALNUT_GATE.get(), 5, 20);
        registry.add(BlockRegistry.WALNUT_FENCE.get(), 5, 20);
        registry.add(BlockRegistry.WALNUT_STAIRS.get(), 5, 20);
    }
}
