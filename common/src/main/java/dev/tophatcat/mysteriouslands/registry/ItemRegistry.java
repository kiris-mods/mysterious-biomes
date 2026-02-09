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
import dev.tophatcat.mysteriouslands.utils.RegistryTools;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;

public class ItemRegistry {

    public static void init() {
        MysteriousLandsCommon.LOGGER.debug("Registering items for Mysterious Lands...");
    }

    //Spawn eggs
    //public static final Supplier<SpawnEggItem> THE_FORGOTTEN_WARLOCK_SPAWN_EGG = RegistryTools.registerItem(
    //    "the_forgotten_warlock_spawn_egg", MysteriousCommon.COMMON_PLATFORM.makeSpawnEgg(
    //        new SpawnEggItem.Properties().spawnEgg(EntityRegistry.THE_FORGOTTEN_WARLOCK.get())));

    // Logs
    public static final Supplier<Item> BLOOD_SOAKED_LOG = RegistryTools.registerItem("blood_soaked_log",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_LOG = RegistryTools.registerItem("ghostly_log",
        () -> new BlockItem(BlockRegistry.GHOSTLY_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_LOG = RegistryTools.registerItem("seeping_log",
        () -> new BlockItem(BlockRegistry.SEEPING_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_LOG = RegistryTools.registerItem("sorbus_log",
        () -> new BlockItem(BlockRegistry.SORBUS_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_LOG = RegistryTools.registerItem("walnut_log",
        () -> new BlockItem(BlockRegistry.WALNUT_LOG.get(), new Item.Properties()));

    // Stripped logs
    public static final Supplier<Item> BLOOD_SOAKED_STRIPPED_LOG = RegistryTools.registerItem("blood_soaked_stripped_log",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_STRIPPED_LOG = RegistryTools.registerItem("ghostly_stripped_log",
        () -> new BlockItem(BlockRegistry.GHOSTLY_STRIPPED_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_STRIPPED_LOG = RegistryTools.registerItem("seeping_stripped_log",
        () -> new BlockItem(BlockRegistry.SEEPING_STRIPPED_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_STRIPPED_LOG = RegistryTools.registerItem("sorbus_stripped_log",
        () -> new BlockItem(BlockRegistry.SORBUS_STRIPPED_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_STRIPPED_LOG = RegistryTools.registerItem("walnut_stripped_log",
        () -> new BlockItem(BlockRegistry.WALNUT_STRIPPED_LOG.get(), new Item.Properties()));

    // Woods
    public static final Supplier<Item> BLOOD_SOAKED_WOOD = RegistryTools.registerItem("blood_soaked_wood",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_WOOD = RegistryTools.registerItem("ghostly_wood",
        () -> new BlockItem(BlockRegistry.GHOSTLY_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_WOOD = RegistryTools.registerItem("seeping_wood",
        () -> new BlockItem(BlockRegistry.SEEPING_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_WOOD = RegistryTools.registerItem("sorbus_wood",
        () -> new BlockItem(BlockRegistry.SORBUS_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_WOOD = RegistryTools.registerItem("walnut_wood",
        () -> new BlockItem(BlockRegistry.WALNUT_WOOD.get(), new Item.Properties()));

    //Stripped woods
    public static final Supplier<Item> BLOOD_SOAKED_STRIPPED_WOOD = RegistryTools.registerItem("blood_soaked_stripped_wood",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_STRIPPED_WOOD = RegistryTools.registerItem("ghostly_stripped_wood",
        () -> new BlockItem(BlockRegistry.GHOSTLY_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_STRIPPED_WOOD = RegistryTools.registerItem("seeping_stripped_wood",
        () -> new BlockItem(BlockRegistry.SEEPING_STRIPPED_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_STRIPPED_WOOD = RegistryTools.registerItem("sorbus_stripped_wood",
        () -> new BlockItem(BlockRegistry.SORBUS_STRIPPED_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_STRIPPED_WOOD = RegistryTools.registerItem("walnut_stripped_wood",
        () -> new BlockItem(BlockRegistry.WALNUT_STRIPPED_WOOD.get(), new Item.Properties()));

    // Planks
    public static final Supplier<Item> BLOOD_SOAKED_PLANKS = RegistryTools.registerItem("blood_soaked_planks",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_PLANKS.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_PLANKS = RegistryTools.registerItem("ghostly_planks",
        () -> new BlockItem(BlockRegistry.GHOSTLY_PLANKS.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_PLANKS = RegistryTools.registerItem("seeping_planks",
        () -> new BlockItem(BlockRegistry.SEEPING_PLANKS.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_PLANKS = RegistryTools.registerItem("sorbus_planks",
        () -> new BlockItem(BlockRegistry.SORBUS_PLANKS.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_PLANKS = RegistryTools.registerItem("walnut_planks",
        () -> new BlockItem(BlockRegistry.WALNUT_PLANKS.get(), new Item.Properties()));

    // Stairs
    public static final Supplier<Item> BLOOD_SOAKED_STAIRS = RegistryTools.registerItem("blood_soaked_stairs",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_STAIRS = RegistryTools.registerItem("ghostly_stairs",
        () -> new BlockItem(BlockRegistry.GHOSTLY_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_STAIRS = RegistryTools.registerItem("seeping_stairs",
        () -> new BlockItem(BlockRegistry.SEEPING_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_STAIRS = RegistryTools.registerItem("sorbus_stairs",
        () -> new BlockItem(BlockRegistry.SORBUS_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_STAIRS = RegistryTools.registerItem("walnut_stairs",
        () -> new BlockItem(BlockRegistry.WALNUT_STAIRS.get(), new Item.Properties()));

    // Leaves
    public static final Supplier<Item> BLOOD_SOAKED_LEAVES = RegistryTools.registerItem("blood_soaked_leaves",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_LEAVES.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_LEAVES = RegistryTools.registerItem("ghostly_leaves",
        () -> new BlockItem(BlockRegistry.GHOSTLY_LEAVES.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_LEAVES = RegistryTools.registerItem("seeping_leaves",
        () -> new BlockItem(BlockRegistry.SEEPING_LEAVES.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_LEAVES = RegistryTools.registerItem("sorbus_leaves",
        () -> new BlockItem(BlockRegistry.SORBUS_LEAVES.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_LEAVES = RegistryTools.registerItem("walnut_leaves",
        () -> new BlockItem(BlockRegistry.WALNUT_LEAVES.get(), new Item.Properties()));

    // Slabs
    public static final Supplier<Item> BLOOD_SOAKED_SLAB = RegistryTools.registerItem("blood_soaked_slab",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_SLAB = RegistryTools.registerItem("ghostly_slab",
        () -> new BlockItem(BlockRegistry.GHOSTLY_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_SLAB = RegistryTools.registerItem("seeping_slab",
        () -> new BlockItem(BlockRegistry.SEEPING_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_SLAB = RegistryTools.registerItem("sorbus_slab",
        () -> new BlockItem(BlockRegistry.SORBUS_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_SLAB = RegistryTools.registerItem("walnut_slab",
        () -> new BlockItem(BlockRegistry.WALNUT_SLAB.get(), new Item.Properties()));

    // Fences
    public static final Supplier<Item> BLOOD_SOAKED_FENCE = RegistryTools.registerItem("blood_soaked_fence",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_FENCE = RegistryTools.registerItem("ghostly_fence",
        () -> new BlockItem(BlockRegistry.GHOSTLY_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_FENCE = RegistryTools.registerItem("seeping_fence",
        () -> new BlockItem(BlockRegistry.SEEPING_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_FENCE = RegistryTools.registerItem("sorbus_fence",
        () -> new BlockItem(BlockRegistry.SORBUS_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_FENCE = RegistryTools.registerItem("walnut_fence",
        () -> new BlockItem(BlockRegistry.WALNUT_FENCE.get(), new Item.Properties()));

    // Gates
    public static final Supplier<Item> BLOOD_SOAKED_GATE = RegistryTools.registerItem("blood_soaked_gate",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_GATE = RegistryTools.registerItem("ghostly_gate",
        () -> new BlockItem(BlockRegistry.GHOSTLY_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_GATE = RegistryTools.registerItem("seeping_gate",
        () -> new BlockItem(BlockRegistry.SEEPING_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_GATE = RegistryTools.registerItem("sorbus_gate",
        () -> new BlockItem(BlockRegistry.SORBUS_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_GATE = RegistryTools.registerItem("walnut_gate",
        () -> new BlockItem(BlockRegistry.WALNUT_GATE.get(), new Item.Properties()));

    // Buttons
    public static final Supplier<Item> BLOOD_SOAKED_BUTTON = RegistryTools.registerItem("blood_soaked_button",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_BUTTON.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_BUTTON = RegistryTools.registerItem("ghostly_button",
        () -> new BlockItem(BlockRegistry.GHOSTLY_BUTTON.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_BUTTON = RegistryTools.registerItem("seeping_button",
        () -> new BlockItem(BlockRegistry.SEEPING_BUTTON.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_BUTTON = RegistryTools.registerItem("sorbus_button",
        () -> new BlockItem(BlockRegistry.SORBUS_BUTTON.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_BUTTON = RegistryTools.registerItem("walnut_button",
        () -> new BlockItem(BlockRegistry.WALNUT_BUTTON.get(), new Item.Properties()));

    // Pressure plates
    public static final Supplier<Item> BLOOD_SOAKED_PRESSURE_PLATE = RegistryTools.registerItem("blood_soaked_pressure_plate",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_PRESSURE_PLATE = RegistryTools.registerItem("ghostly_pressure_plate",
        () -> new BlockItem(BlockRegistry.GHOSTLY_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_PRESSURE_PLATE = RegistryTools.registerItem("seeping_pressure_plate",
        () -> new BlockItem(BlockRegistry.SEEPING_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_PRESSURE_PLATE = RegistryTools.registerItem("sorbus_pressure_plate",
        () -> new BlockItem(BlockRegistry.SORBUS_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_PRESSURE_PLATE = RegistryTools.registerItem("walnut_pressure_plate",
        () -> new BlockItem(BlockRegistry.WALNUT_PRESSURE_PLATE.get(), new Item.Properties()));

    // Trapdoors
    public static final Supplier<Item> BLOOD_SOAKED_TRAPDOOR = RegistryTools.registerItem("blood_soaked_trapdoor",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_TRAPDOOR = RegistryTools.registerItem("ghostly_trapdoor",
        () -> new BlockItem(BlockRegistry.GHOSTLY_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_TRAPDOOR = RegistryTools.registerItem("seeping_trapdoor",
        () -> new BlockItem(BlockRegistry.SEEPING_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_TRAPDOOR = RegistryTools.registerItem("sorbus_trapdoor",
        () -> new BlockItem(BlockRegistry.SORBUS_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_TRAPDOOR = RegistryTools.registerItem("walnut_trapdoor",
        () -> new BlockItem(BlockRegistry.WALNUT_TRAPDOOR.get(), new Item.Properties()));

    // Doors
    public static final Supplier<Item> BLOOD_SOAKED_DOOR = RegistryTools.registerItem("blood_soaked_door",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_DOOR.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_DOOR = RegistryTools.registerItem("ghostly_door",
        () -> new BlockItem(BlockRegistry.GHOSTLY_DOOR.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_DOOR = RegistryTools.registerItem("seeping_door",
        () -> new BlockItem(BlockRegistry.SEEPING_DOOR.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_DOOR = RegistryTools.registerItem("sorbus_door",
        () -> new BlockItem(BlockRegistry.SORBUS_DOOR.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_DOOR = RegistryTools.registerItem("walnut_door",
        () -> new BlockItem(BlockRegistry.WALNUT_DOOR.get(), new Item.Properties()));

    // Saplings
    public static final Supplier<Item> BLOOD_SOAKED_SAPLING = RegistryTools.registerItem("blood_soaked_sapling",
        () -> new BlockItem(BlockRegistry.BLOOD_SOAKED_SAPLING.get(), new Item.Properties()));
    public static final Supplier<Item> GHOSTLY_SAPLING = RegistryTools.registerItem("ghostly_sapling",
        () -> new BlockItem(BlockRegistry.GHOSTLY_SAPLING.get(), new Item.Properties()));
    public static final Supplier<Item> SEEPING_SAPLING = RegistryTools.registerItem("seeping_sapling",
        () -> new BlockItem(BlockRegistry.SEEPING_SAPLING.get(), new Item.Properties()));
    public static final Supplier<Item> SORBUS_SAPLING = RegistryTools.registerItem("sorbus_sapling",
        () -> new BlockItem(BlockRegistry.SORBUS_SAPLING.get(), new Item.Properties()));
    public static final Supplier<Item> WALNUT_SAPLING = RegistryTools.registerItem("walnut_sapling",
        () -> new BlockItem(BlockRegistry.WALNUT_SAPLING.get(), new Item.Properties()));

    // Sign items
    public static final Supplier<SignItem> BLOOD_SOAKED_SIGN = RegistryTools.createSign(
        "blood_soaked_sign", BlockRegistry.BLOOD_SOAKED_FLOOR_SIGN, BlockRegistry.BLOOD_SOAKED_WALL_SIGN);
    public static final Supplier<SignItem> GHOSTLY_SIGN = RegistryTools.createSign(
        "ghostly_sign", BlockRegistry.GHOSTLY_FLOOR_SIGN, BlockRegistry.GHOSTLY_WALL_SIGN);
    public static final Supplier<SignItem> SEEPING_SIGN = RegistryTools.createSign(
        "seeping_sign", BlockRegistry.SEEPING_FLOOR_SIGN, BlockRegistry.SEEPING_WALL_SIGN);
    public static final Supplier<SignItem> SORBUS_SIGN = RegistryTools.createSign(
        "sorbus_sign", BlockRegistry.SORBUS_FLOOR_SIGN, BlockRegistry.SORBUS_WALL_SIGN);
    public static final Supplier<SignItem> WALNUT_SIGN = RegistryTools.createSign(
        "walnut_sign", BlockRegistry.WALNUT_FLOOR_SIGN, BlockRegistry.WALNUT_WALL_SIGN);

    // Hanging sign items
    public static final Supplier<HangingSignItem> BLOOD_SOAKED_HANGING_SIGN = RegistryTools.createHangingSign(
        "blood_soaked_hanging_sign", BlockRegistry.BLOOD_SOAKED_HANGING_SIGN, BlockRegistry.BLOOD_SOAKED_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> GHOSTLY_HANGING_SIGN = RegistryTools.createHangingSign(
        "ghostly_hanging_sign", BlockRegistry.GHOSTLY_HANGING_SIGN, BlockRegistry.GHOSTLY_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> SEEPING_HANGING_SIGN = RegistryTools.createHangingSign(
        "seeping_hanging_sign", BlockRegistry.SEEPING_HANGING_SIGN, BlockRegistry.SEEPING_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> SORBUS_HANGING_SIGN = RegistryTools.createHangingSign(
        "sorbus_hanging_sign", BlockRegistry.SORBUS_HANGING_SIGN, BlockRegistry.SORBUS_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> WALNUT_HANGING_SIGN = RegistryTools.createHangingSign(
        "walnut_hanging_sign", BlockRegistry.WALNUT_HANGING_SIGN, BlockRegistry.WALNUT_WALL_HANGING_SIGN);
}
