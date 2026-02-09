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
package dev.tophatcat.mysteriouslands.registry;

import dev.tophatcat.mysteriouslands.MysteriousLandsCommon;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class CreativeTabRegistry {

    public static void init() {
        MysteriousLandsCommon.LOGGER.debug("Registering creative tabs...");
    }

    public static final Supplier<CreativeModeTab> MYSTERIOUS_TA
        = MysteriousLandsCommon.COMMON_PLATFORM.registerCreativeModeTab(
        "mysterious_tab", () -> MysteriousLandsCommon.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("item_group." + MysteriousLandsCommon.MOD_ID + ".mysterious_tab"))
            .icon(() -> new ItemStack(ItemRegistry.GHOSTLY_SAPLING.get()))
            .displayItems((enabledFeatures, entries) -> {

                // Logs
                entries.accept(ItemRegistry.BLOOD_SOAKED_LOG.get());
                entries.accept(ItemRegistry.GHOSTLY_LOG.get());
                entries.accept(ItemRegistry.SEEPING_LOG.get());
                entries.accept(ItemRegistry.SORBUS_LOG.get());
                entries.accept(ItemRegistry.WALNUT_LOG.get());

                // Stripped logs
                entries.accept(ItemRegistry.BLOOD_SOAKED_STRIPPED_LOG.get());
                entries.accept(ItemRegistry.GHOSTLY_STRIPPED_LOG.get());
                entries.accept(ItemRegistry.SEEPING_STRIPPED_LOG.get());
                entries.accept(ItemRegistry.SORBUS_STRIPPED_LOG.get());
                entries.accept(ItemRegistry.WALNUT_STRIPPED_LOG.get());

                // Woods
                entries.accept(ItemRegistry.BLOOD_SOAKED_WOOD.get());
                entries.accept(ItemRegistry.GHOSTLY_WOOD.get());
                entries.accept(ItemRegistry.SEEPING_WOOD.get());
                entries.accept(ItemRegistry.SORBUS_WOOD.get());
                entries.accept(ItemRegistry.WALNUT_WOOD.get());

                // Stripped woods
                entries.accept(ItemRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get());
                entries.accept(ItemRegistry.GHOSTLY_STRIPPED_WOOD.get());
                entries.accept(ItemRegistry.SEEPING_STRIPPED_WOOD.get());
                entries.accept(ItemRegistry.SORBUS_STRIPPED_WOOD.get());
                entries.accept(ItemRegistry.WALNUT_STRIPPED_WOOD.get());

                // Planks
                entries.accept(ItemRegistry.BLOOD_SOAKED_PLANKS.get());
                entries.accept(ItemRegistry.GHOSTLY_PLANKS.get());
                entries.accept(ItemRegistry.SEEPING_PLANKS.get());
                entries.accept(ItemRegistry.SORBUS_PLANKS.get());
                entries.accept(ItemRegistry.WALNUT_PLANKS.get());

                // Stairs
                entries.accept(ItemRegistry.BLOOD_SOAKED_STAIRS.get());
                entries.accept(ItemRegistry.GHOSTLY_STAIRS.get());
                entries.accept(ItemRegistry.SEEPING_STAIRS.get());
                entries.accept(ItemRegistry.SORBUS_STAIRS.get());
                entries.accept(ItemRegistry.WALNUT_STAIRS.get());

                // Leaves
                entries.accept(ItemRegistry.BLOOD_SOAKED_LEAVES.get());
                entries.accept(ItemRegistry.GHOSTLY_LEAVES.get());
                entries.accept(ItemRegistry.SEEPING_LEAVES.get());
                entries.accept(ItemRegistry.SORBUS_LEAVES.get());
                entries.accept(ItemRegistry.WALNUT_LEAVES.get());

                // Slabs
                entries.accept(ItemRegistry.BLOOD_SOAKED_SLAB.get());
                entries.accept(ItemRegistry.GHOSTLY_SLAB.get());
                entries.accept(ItemRegistry.SEEPING_SLAB.get());
                entries.accept(ItemRegistry.SORBUS_SLAB.get());
                entries.accept(ItemRegistry.WALNUT_SLAB.get());

                // Fences
                entries.accept(ItemRegistry.BLOOD_SOAKED_FENCE.get());
                entries.accept(ItemRegistry.GHOSTLY_FENCE.get());
                entries.accept(ItemRegistry.SEEPING_FENCE.get());
                entries.accept(ItemRegistry.SORBUS_FENCE.get());
                entries.accept(ItemRegistry.WALNUT_FENCE.get());

                // Gates
                entries.accept(ItemRegistry.BLOOD_SOAKED_GATE.get());
                entries.accept(ItemRegistry.GHOSTLY_GATE.get());
                entries.accept(ItemRegistry.SEEPING_GATE.get());
                entries.accept(ItemRegistry.SORBUS_GATE.get());
                entries.accept(ItemRegistry.WALNUT_GATE.get());

                // Buttons
                entries.accept(ItemRegistry.BLOOD_SOAKED_BUTTON.get());
                entries.accept(ItemRegistry.GHOSTLY_BUTTON.get());
                entries.accept(ItemRegistry.SEEPING_BUTTON.get());
                entries.accept(ItemRegistry.SORBUS_BUTTON.get());
                entries.accept(ItemRegistry.WALNUT_BUTTON.get());

                // Pressure plates
                entries.accept(ItemRegistry.BLOOD_SOAKED_PRESSURE_PLATE.get());
                entries.accept(ItemRegistry.GHOSTLY_PRESSURE_PLATE.get());
                entries.accept(ItemRegistry.SEEPING_PRESSURE_PLATE.get());
                entries.accept(ItemRegistry.SORBUS_PRESSURE_PLATE.get());
                entries.accept(ItemRegistry.WALNUT_PRESSURE_PLATE.get());

                // Trapdoor
                entries.accept(ItemRegistry.BLOOD_SOAKED_TRAPDOOR.get());
                entries.accept(ItemRegistry.GHOSTLY_TRAPDOOR.get());
                entries.accept(ItemRegistry.SEEPING_TRAPDOOR.get());
                entries.accept(ItemRegistry.SORBUS_TRAPDOOR.get());
                entries.accept(ItemRegistry.WALNUT_TRAPDOOR.get());

                // Door
                entries.accept(ItemRegistry.BLOOD_SOAKED_DOOR.get());
                entries.accept(ItemRegistry.GHOSTLY_DOOR.get());
                entries.accept(ItemRegistry.SEEPING_DOOR.get());
                entries.accept(ItemRegistry.SORBUS_DOOR.get());
                entries.accept(ItemRegistry.WALNUT_DOOR.get());

                // Saplings
                entries.accept(ItemRegistry.BLOOD_SOAKED_SAPLING.get());
                entries.accept(ItemRegistry.GHOSTLY_SAPLING.get());
                entries.accept(ItemRegistry.SEEPING_SAPLING.get());
                entries.accept(ItemRegistry.SORBUS_SAPLING.get());
                entries.accept(ItemRegistry.WALNUT_SAPLING.get());

                // Signs
                entries.accept(ItemRegistry.BLOOD_SOAKED_SIGN.get());
                entries.accept(ItemRegistry.GHOSTLY_SIGN.get());
                entries.accept(ItemRegistry.SEEPING_SIGN.get());
                entries.accept(ItemRegistry.SORBUS_SIGN.get());
                entries.accept(ItemRegistry.WALNUT_SIGN.get());

                // Hanging Signs
                entries.accept(ItemRegistry.BLOOD_SOAKED_HANGING_SIGN.get());
                entries.accept(ItemRegistry.GHOSTLY_HANGING_SIGN.get());
                entries.accept(ItemRegistry.SEEPING_HANGING_SIGN.get());
                entries.accept(ItemRegistry.SORBUS_HANGING_SIGN.get());
                entries.accept(ItemRegistry.WALNUT_HANGING_SIGN.get());

                // Mob eggs
                //entries.accept(ItemRegistry.THE_FORGOTTEN_WARLOCK_SPAWN_EGG.get());
            })
            .build());
}
