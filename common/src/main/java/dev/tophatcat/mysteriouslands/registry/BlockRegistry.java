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

import dev.tophatcat.mysteriousbiomes.utils.MysteriousWoodType;
import dev.tophatcat.mysteriouslands.MysteriousLandsCommon;
import dev.tophatcat.mysteriouslands.utils.RegistryTools;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.function.Supplier;

public class BlockRegistry {

    public static void init() {
        MysteriousLandsCommon.LOGGER.debug("Registering blocks for Mysterious Lands...");
    }

    // Logs
    public static final Supplier<RotatedPillarBlock> BLOOD_SOAKED_LOG
        = RegistryTools.createPillarBlock("blood_soaked_log");
    public static final Supplier<RotatedPillarBlock> GHOSTLY_LOG
        = RegistryTools.createPillarBlock("ghostly_log");
    public static final Supplier<RotatedPillarBlock> SEEPING_LOG
        = RegistryTools.createPillarBlock("seeping_log");
    public static final Supplier<RotatedPillarBlock> SORBUS_LOG
        = RegistryTools.createPillarBlock("sorbus_log");
    public static final Supplier<RotatedPillarBlock> WALNUT_LOG
        = RegistryTools.createPillarBlock("walnut_log");

    // Stripped logs
    public static final Supplier<RotatedPillarBlock> BLOOD_SOAKED_STRIPPED_LOG
        = RegistryTools.createPillarBlock("blood_soaked_stripped_log");
    public static final Supplier<RotatedPillarBlock> GHOSTLY_STRIPPED_LOG
        = RegistryTools.createPillarBlock("ghostly_stripped_log");
    public static final Supplier<RotatedPillarBlock> SEEPING_STRIPPED_LOG
        = RegistryTools.createPillarBlock("seeping_stripped_log");
    public static final Supplier<RotatedPillarBlock> SORBUS_STRIPPED_LOG
        = RegistryTools.createPillarBlock("sorbus_stripped_log");
    public static final Supplier<RotatedPillarBlock> WALNUT_STRIPPED_LOG
        = RegistryTools.createPillarBlock("walnut_stripped_log");

    // Woods
    public static final Supplier<RotatedPillarBlock> BLOOD_SOAKED_WOOD
        = RegistryTools.createPillarBlock("blood_soaked_wood");
    public static final Supplier<RotatedPillarBlock> GHOSTLY_WOOD
        = RegistryTools.createPillarBlock("ghostly_wood");
    public static final Supplier<RotatedPillarBlock> SEEPING_WOOD
        = RegistryTools.createPillarBlock("seeping_wood");
    public static final Supplier<RotatedPillarBlock> SORBUS_WOOD
        = RegistryTools.createPillarBlock("sorbus_wood");
    public static final Supplier<RotatedPillarBlock> WALNUT_WOOD
        = RegistryTools.createPillarBlock("walnut_wood");

    // Stripped woods
    public static final Supplier<RotatedPillarBlock> BLOOD_SOAKED_STRIPPED_WOOD
        = RegistryTools.createPillarBlock("blood_soaked_stripped_wood");
    public static final Supplier<RotatedPillarBlock> GHOSTLY_STRIPPED_WOOD
        = RegistryTools.createPillarBlock("ghostly_stripped_wood");
    public static final Supplier<RotatedPillarBlock> SEEPING_STRIPPED_WOOD
        = RegistryTools.createPillarBlock("seeping_stripped_wood");
    public static final Supplier<RotatedPillarBlock> SORBUS_STRIPPED_WOOD
        = RegistryTools.createPillarBlock("sorbus_stripped_wood");
    public static final Supplier<RotatedPillarBlock> WALNUT_STRIPPED_WOOD
        = RegistryTools.createPillarBlock("walnut_stripped_wood");

    // Planks
    public static final Supplier<Block> BLOOD_SOAKED_PLANKS = RegistryTools.createPlanksBlock("blood_soaked_planks");
    public static final Supplier<Block> GHOSTLY_PLANKS = RegistryTools.createPlanksBlock("ghostly_planks");
    public static final Supplier<Block> SEEPING_PLANKS = RegistryTools.createPlanksBlock("seeping_planks");
    public static final Supplier<Block> SORBUS_PLANKS = RegistryTools.createPlanksBlock("sorbus_planks");
    public static final Supplier<Block> WALNUT_PLANKS = RegistryTools.createPlanksBlock("walnut_planks");

    // Stairs
    public static final Supplier<StairBlock> BLOOD_SOAKED_STAIRS = RegistryTools.createStairsBlock(
        "blood_soaked_stairs", BLOOD_SOAKED_PLANKS);
    public static final Supplier<StairBlock> GHOSTLY_STAIRS = RegistryTools.createStairsBlock(
        "ghostly_stairs", GHOSTLY_PLANKS);
    public static final Supplier<StairBlock> SEEPING_STAIRS = RegistryTools.createStairsBlock(
        "seeping_stairs", SEEPING_PLANKS);
    public static final Supplier<StairBlock> SORBUS_STAIRS = RegistryTools.createStairsBlock(
        "sorbus_stairs", SORBUS_PLANKS);
    public static final Supplier<StairBlock> WALNUT_STAIRS = RegistryTools.createStairsBlock(
        "walnut_stairs", WALNUT_PLANKS);

    // Leaves
    public static final Supplier<Block> BLOOD_SOAKED_LEAVES = RegistryTools.createLeavesBlock("blood_soaked_leaves");
    public static final Supplier<Block> GHOSTLY_LEAVES = RegistryTools.createLeavesBlock("ghostly_leaves");
    public static final Supplier<Block> SEEPING_LEAVES = RegistryTools.createLeavesBlock("seeping_leaves");
    public static final Supplier<Block> SORBUS_LEAVES = RegistryTools.createLeavesBlock("sorbus_leaves");
    public static final Supplier<Block> WALNUT_LEAVES = RegistryTools.createLeavesBlock("walnut_leaves");

    // Slabs
    public static final Supplier<SlabBlock> BLOOD_SOAKED_SLAB = RegistryTools.createSlabBlock("blood_soaked_slab");
    public static final Supplier<SlabBlock> GHOSTLY_SLAB = RegistryTools.createSlabBlock("ghostly_slab");
    public static final Supplier<SlabBlock> SEEPING_SLAB = RegistryTools.createSlabBlock("seeping_slab");
    public static final Supplier<SlabBlock> SORBUS_SLAB = RegistryTools.createSlabBlock("sorbus_slab");
    public static final Supplier<SlabBlock> WALNUT_SLAB = RegistryTools.createSlabBlock("walnut_slab");

    // Fences
    public static final Supplier<FenceBlock> BLOOD_SOAKED_FENCE = RegistryTools.createFenceBlock("blood_soaked_fence");
    public static final Supplier<FenceBlock> GHOSTLY_FENCE = RegistryTools.createFenceBlock("ghostly_fence");
    public static final Supplier<FenceBlock> SEEPING_FENCE = RegistryTools.createFenceBlock("seeping_fence");
    public static final Supplier<FenceBlock> SORBUS_FENCE = RegistryTools.createFenceBlock("sorbus_fence");
    public static final Supplier<FenceBlock> WALNUT_FENCE = RegistryTools.createFenceBlock("walnut_fence");

    // Gates
    public static final Supplier<FenceGateBlock> BLOOD_SOAKED_GATE = RegistryTools.createGateBlock("blood_soaked_gate");
    public static final Supplier<FenceGateBlock> GHOSTLY_GATE = RegistryTools.createGateBlock("ghostly_gate");
    public static final Supplier<FenceGateBlock> SEEPING_GATE = RegistryTools.createGateBlock("seeping_gate");
    public static final Supplier<FenceGateBlock> SORBUS_GATE = RegistryTools.createGateBlock("sorbus_gate");
    public static final Supplier<FenceGateBlock> WALNUT_GATE = RegistryTools.createGateBlock("walnut_gate");

    // Buttons
    public static final Supplier<ButtonBlock> BLOOD_SOAKED_BUTTON = RegistryTools.createButtonBlock("blood_soaked_button");
    public static final Supplier<ButtonBlock> GHOSTLY_BUTTON = RegistryTools.createButtonBlock("ghostly_button");
    public static final Supplier<ButtonBlock> SEEPING_BUTTON = RegistryTools.createButtonBlock("seeping_button");
    public static final Supplier<ButtonBlock> SORBUS_BUTTON = RegistryTools.createButtonBlock("sorbus_button");
    public static final Supplier<ButtonBlock> WALNUT_BUTTON = RegistryTools.createButtonBlock("walnut_button");

    // Pressure plates
    public static final Supplier<PressurePlateBlock> BLOOD_SOAKED_PRESSURE_PLATE
        = RegistryTools.createPressurePlateBlock("blood_soaked_pressure_plate");
    public static final Supplier<PressurePlateBlock> GHOSTLY_PRESSURE_PLATE
        = RegistryTools.createPressurePlateBlock("ghostly_pressure_plate");
    public static final Supplier<PressurePlateBlock> SEEPING_PRESSURE_PLATE
        = RegistryTools.createPressurePlateBlock("seeping_pressure_plate");
    public static final Supplier<PressurePlateBlock> SORBUS_PRESSURE_PLATE
        = RegistryTools.createPressurePlateBlock("sorbus_pressure_plate");
    public static final Supplier<PressurePlateBlock> WALNUT_PRESSURE_PLATE
        = RegistryTools.createPressurePlateBlock("walnut_pressure_plate");

    // Trapdoors
    public static final Supplier<TrapDoorBlock> BLOOD_SOAKED_TRAPDOOR
        = RegistryTools.createTrapdoorBlock("blood_soaked_trapdoor");
    public static final Supplier<TrapDoorBlock> GHOSTLY_TRAPDOOR
        = RegistryTools.createTrapdoorBlock("ghostly_trapdoor");
    public static final Supplier<TrapDoorBlock> SEEPING_TRAPDOOR
        = RegistryTools.createTrapdoorBlock("seeping_trapdoor");
    public static final Supplier<TrapDoorBlock> SORBUS_TRAPDOOR
        = RegistryTools.createTrapdoorBlock("sorbus_trapdoor");
    public static final Supplier<TrapDoorBlock> WALNUT_TRAPDOOR
        = RegistryTools.createTrapdoorBlock("walnut_trapdoor");

    // Doors
    public static final Supplier<DoorBlock> BLOOD_SOAKED_DOOR = RegistryTools.createDoorBlock("blood_soaked_door");
    public static final Supplier<DoorBlock> GHOSTLY_DOOR = RegistryTools.createDoorBlock("ghostly_door");
    public static final Supplier<DoorBlock> SEEPING_DOOR = RegistryTools.createDoorBlock("seeping_door");
    public static final Supplier<DoorBlock> SORBUS_DOOR = RegistryTools.createDoorBlock("sorbus_door");
    public static final Supplier<DoorBlock> WALNUT_DOOR = RegistryTools.createDoorBlock("walnut_door");

    // Saplings
    // TODO Make our own tree growers and fancy trees.
    public static final Supplier<SaplingBlock> BLOOD_SOAKED_SAPLING
        = RegistryTools.createSaplingBlock("blood_soaked_sapling", TreeGrower.BIRCH);
    public static final Supplier<SaplingBlock> GHOSTLY_SAPLING
        = RegistryTools.createSaplingBlock("ghostly_sapling", TreeGrower.BIRCH);
    public static final Supplier<SaplingBlock> SEEPING_SAPLING
        = RegistryTools.createSaplingBlock("seeping_sapling", TreeGrower.BIRCH);
    public static final Supplier<SaplingBlock> SORBUS_SAPLING
        = RegistryTools.createSaplingBlock("sorbus_sapling", TreeGrower.BIRCH);
    public static final Supplier<SaplingBlock> WALNUT_SAPLING
        = RegistryTools.createSaplingBlock("walnut_sapling", TreeGrower.BIRCH);

    // Floor signs
    public static final Supplier<StandingSignBlock> BLOOD_SOAKED_FLOOR_SIGN = RegistryTools.createStandingSignBlock(
        "blood_soaked_sign", MysteriousWoodType.BLOOD_SOAKED_TYPE);
    public static final Supplier<StandingSignBlock> GHOSTLY_FLOOR_SIGN = RegistryTools.createStandingSignBlock(
        "ghostly_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<StandingSignBlock> SEEPING_FLOOR_SIGN = RegistryTools.createStandingSignBlock(
        "seeping_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<StandingSignBlock> SORBUS_FLOOR_SIGN = RegistryTools.createStandingSignBlock(
        "sorbus_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<StandingSignBlock> WALNUT_FLOOR_SIGN = RegistryTools.createStandingSignBlock(
        "walnut_sign", MysteriousWoodType.WALNUT_TYPE);

    // Wall signs
    public static final Supplier<WallSignBlock> BLOOD_SOAKED_WALL_SIGN = RegistryTools.createWallSignBlock(
        "blood_soaked_wall_sign", MysteriousWoodType.BLOOD_SOAKED_TYPE);
    public static final Supplier<WallSignBlock> GHOSTLY_WALL_SIGN = RegistryTools.createWallSignBlock(
        "ghostly_wall_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<WallSignBlock> SEEPING_WALL_SIGN = RegistryTools.createWallSignBlock(
        "seeping_wall_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<WallSignBlock> SORBUS_WALL_SIGN = RegistryTools.createWallSignBlock(
        "sorbus_wall_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<WallSignBlock> WALNUT_WALL_SIGN = RegistryTools.createWallSignBlock(
        "walnut_wall_sign", MysteriousWoodType.WALNUT_TYPE);

    // Hanging signs
    public static final Supplier<CeilingHangingSignBlock> BLOOD_SOAKED_HANGING_SIGN = RegistryTools.createHangingSignBlock(
        "blood_soaked_hanging_sign", MysteriousWoodType.BLOOD_SOAKED_TYPE);
    public static final Supplier<CeilingHangingSignBlock> GHOSTLY_HANGING_SIGN = RegistryTools.createHangingSignBlock(
        "ghostly_hanging_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<CeilingHangingSignBlock> SEEPING_HANGING_SIGN = RegistryTools.createHangingSignBlock(
        "seeping_hanging_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<CeilingHangingSignBlock> SORBUS_HANGING_SIGN = RegistryTools.createHangingSignBlock(
        "sorbus_hanging_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<CeilingHangingSignBlock> WALNUT_HANGING_SIGN = RegistryTools.createHangingSignBlock(
        "walnut_hanging_sign", MysteriousWoodType.WALNUT_TYPE);

    // Wall hanging signs
    public static final Supplier<WallHangingSignBlock> BLOOD_SOAKED_WALL_HANGING_SIGN
        = RegistryTools.createWallHangingSignBlock("blood_soaked_wall_hanging_sign", MysteriousWoodType.BLOOD_SOAKED_TYPE);
    public static final Supplier<WallHangingSignBlock> GHOSTLY_WALL_HANGING_SIGN
        = RegistryTools.createWallHangingSignBlock("ghostly_wall_hanging_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<WallHangingSignBlock> SEEPING_WALL_HANGING_SIGN
        = RegistryTools.createWallHangingSignBlock("seeping_wall_hanging_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<WallHangingSignBlock> SORBUS_WALL_HANGING_SIGN
        = RegistryTools.createWallHangingSignBlock("sorbus_wall_hanging_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<WallHangingSignBlock> WALNUT_WALL_HANGING_SIGN
        = RegistryTools.createWallHangingSignBlock("walnut_wall_hanging_sign", MysteriousWoodType.WALNUT_TYPE);
}
