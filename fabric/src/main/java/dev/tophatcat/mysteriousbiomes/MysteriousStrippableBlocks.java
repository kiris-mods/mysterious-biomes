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
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class MysteriousStrippableBlocks {

    public MysteriousStrippableBlocks() {
        init();
    }

    private void init() {
        StrippableBlockRegistry.register(BlockRegistry.BLOOD_SOAKED_LOG.get(),
            BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get());
        StrippableBlockRegistry.register(BlockRegistry.BLOOD_SOAKED_WOOD.get(),
            BlockRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get());
        StrippableBlockRegistry.register(BlockRegistry.GHOSTLY_LOG.get(),
            BlockRegistry.GHOSTLY_STRIPPED_LOG.get());
        StrippableBlockRegistry.register(BlockRegistry.GHOSTLY_WOOD.get(),
            BlockRegistry.GHOSTLY_STRIPPED_WOOD.get());
        StrippableBlockRegistry.register(BlockRegistry.SEEPING_LOG.get(),
            BlockRegistry.SEEPING_STRIPPED_LOG.get());
        StrippableBlockRegistry.register(BlockRegistry.SEEPING_WOOD.get(),
            BlockRegistry.SEEPING_STRIPPED_WOOD.get());
        StrippableBlockRegistry.register(BlockRegistry.SORBUS_LOG.get(),
            BlockRegistry.SORBUS_STRIPPED_LOG.get());
        StrippableBlockRegistry.register(BlockRegistry.SORBUS_WOOD.get(),
            BlockRegistry.SORBUS_STRIPPED_WOOD.get());
        StrippableBlockRegistry.register(BlockRegistry.WALNUT_LOG.get(),
            BlockRegistry.WALNUT_STRIPPED_LOG.get());
        StrippableBlockRegistry.register(BlockRegistry.WALNUT_WOOD.get(),
            BlockRegistry.WALNUT_STRIPPED_WOOD.get());
    }
}
