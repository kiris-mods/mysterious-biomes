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
package dev.tophatcat.spookybiomes;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Methods to assist in the registering of blocks without having lines full of duplicated code.
 *
 * @author KiriCattus
 */
public class RegHelpers {

    /**
     * @param identifier The identifier of the mod and block together. e.g. new Identifier("kirislib", "test_block")
     * @param block      The block class/Type, e.g. () new BigBadBlock()
     * @param blockMap   The mods block map to store blocks ready for registration.
     * @param <T>        .
     * @return The block we are currently creating.
     */
    public static <T extends Block> Supplier<T> createBlock(
        Identifier identifier, Supplier<T> block, Map<Identifier, Supplier<T>> blockMap) {
        var wrapped = Suppliers.memoize(block::get);
        blockMap.put(identifier, wrapped);
        return wrapped;
    }

    /**
     * @param identifier The identifier of the mod and block together. e.g. new Identifier("kirislib", "test_block")
     * @param block      The block class/Type, e.g. () new BigBadBlock()
     * @param blockMap   Your mods block map to store blocks ready for registration.
     * @param itemMap    Your mods item map to store items ready for registration.
     * @param <T>        .
     * @return The block we are currently creating.
     */
    public static <T extends Block> Supplier<T> createBlockWithItem(
        Identifier identifier, Supplier<T> block, Map<Identifier, Supplier<T>> blockMap,
        Map<Identifier, Supplier<Item>> itemMap) {
        var wrapped = Suppliers.memoize(block::get);
        blockMap.put(identifier, wrapped);
        createBasicItem(identifier, () -> new BlockItem(wrapped.get(),
            new Item.Settings().group(SpookyBiomes.ITEM_TAB)), itemMap);
        return wrapped;
    }

    /**
     * @param identifier The identifier of the mod and item together. e.g. new Identifier("kirislib", "test_item")
     * @param item       The item class/Type, e.g. () -> new BigBadHammerItem()
     * @param itemMap    Your mods item map to store items ready for registration.
     * @param <T>        .
     * @return The item we are creating.
     */
    public static <T extends Item> Supplier<T> createBasicItem(
        Identifier identifier, Supplier<T> item, Map<Identifier, Supplier<T>> itemMap) {
        var wrapped = Suppliers.memoize(item::get);
        itemMap.put(identifier, wrapped);
        return wrapped;
    }

    /**
     * @param identifier The mod and sound name together. e.g. new Identifier("kirislib", "test_sound")
     * @param soundMap   Your mods soundMap to store your sounds ready for registration.
     * @return The sound we are creating.
     */
    public static SoundEvent createSound(Identifier identifier, Map<SoundEvent, Identifier> soundMap) {
        var soundEvent = new SoundEvent(identifier);
        soundMap.put(soundEvent, identifier);
        return soundEvent;
    }
}
