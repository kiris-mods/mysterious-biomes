/*
 * Spooky Biomes - https://tophatcat.dev/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Register our Items to the game here.
 *
 * @author KiriCattus
 */
public class SpookyItems {

    public static final DeferredRegister<Item> ITEMS
        = DeferredRegister.create(ForgeRegistries.ITEMS, SpookyBiomes.MOD_ID);

    public static final RegistryObject<SignItem> SORBUS_SIGN = ITEMS.register("sorbus_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.SORBUS_SIGN.get(), SpookyBlocks.SORBUS_WALL_SIGN.get()));

    public static final RegistryObject<SignItem> GHOSTLY_SIGN = ITEMS.register("ghostly_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.GHOSTLY_SIGN.get(), SpookyBlocks.GHOSTLY_WALL_SIGN.get()));

    public static final RegistryObject<SignItem> SEEPING_SIGN = ITEMS.register("seeping_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.SEEPING_SIGN.get(), SpookyBlocks.SEEPING_WALL_SIGN.get()));

    public static final RegistryObject<SignItem> BLOODWOOD_SIGN = ITEMS.register("bloodwood_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.BLOODWOOD_SIGN.get(), SpookyBlocks.BLOODWOOD_WALL_SIGN.get()));
}
