/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.mysteriousbiomes;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Methods to assist in the registering of blocks, items and sounds without having lines full of duplicated code.
 *
 * @author KiriCattus
 */
//TODO Remove before releasing, leaving it here for Up to finish his work without trouble.
@Deprecated
public class RegHelpers {

    public static <T extends Block> Supplier<T> createBlock(
        ResourceLocation identifier, Supplier<T> block, Map<ResourceLocation, Supplier<T>> blockMap) {
        var wrapped = Suppliers.memoize(block::get);
        blockMap.put(identifier, wrapped);
        return wrapped;
    }

    public static <T extends Block> Supplier<T> createBlockWithItem(
        ResourceLocation identifier, CreativeModeTab group, Supplier<T> block, Map<ResourceLocation, Supplier<T>> blockMap,
        Map<ResourceLocation, Supplier<Item>> itemMap) {
        var wrapped = Suppliers.memoize(block::get);
        blockMap.put(identifier, wrapped);
        createBasicItem(identifier, () -> new BlockItem(wrapped.get(),
            new Item.Properties().tab(group)), itemMap);
        return wrapped;
    }

    public static <T extends Item> Supplier<T> createBasicItem(
        ResourceLocation identifier, Supplier<T> item, Map<ResourceLocation, Supplier<T>> itemMap) {
        var wrapped = Suppliers.memoize(item::get);
        itemMap.put(identifier, wrapped);
        return wrapped;
    }

    public static SoundEvent createSound(ResourceLocation identifier, Map<SoundEvent, ResourceLocation> soundMap) {
        var soundEvent = new SoundEvent(identifier);
        soundMap.put(soundEvent, identifier);
        return soundEvent;
    }
}
