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
package dev.tophatcat.mysteriousbiomes.core;

import com.google.common.base.Suppliers;
import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.mysteriousbiomes.common.entity.TheForgottenWarlockEntity;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousUtils;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousWoodType;
import java.util.function.Supplier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.grower.OakTreeGrower;

public class MysteriousRegistry {

    //Entities
    public static final Supplier<EntityType<TheForgottenWarlockEntity>> THE_FORGOTTEN_WARLOCK =
        MysteriousUtils.createEntity("the_forgotten_warlock",
            Suppliers.memoize(() -> EntityType.Builder.of(TheForgottenWarlockEntity::new, MobCategory.MONSTER)
                .sized(0.75F, 2.30F).clientTrackingRange(10)
                .build(MysteriousCommon.MOD_ID + ":the_forgotten_warlock")));
    //Grass
    public static final Supplier<Block> BLOODIED_GRASS = MysteriousUtils.createBlock(MysteriousCommon.MOD_ID,
        "bloodied_grass", Suppliers.memoize(() -> new BloodiedGrass(Block.Properties.of()
            .strength(0.5F).sound(SoundType.WET_GRASS).randomTicks())), true);
    public static final Supplier<Block> BLOODIED_DIRT = MysteriousUtils.createBlock(MysteriousCommon.MOD_ID,
        "bloodied_dirt", Suppliers.memoize(() -> new Block(Block.Properties.copy(Blocks.DIRT)
            .strength(0.5F).sound(SoundType.ROOTED_DIRT))), true);

    // Logs
    public static final Supplier<RotatedPillarBlock> BLOODWOOD_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "bloodwood_log");
    public static final Supplier<RotatedPillarBlock> GHOSTLY_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "ghostly_log");
    public static final Supplier<RotatedPillarBlock> SEEPING_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "seeping_log");
    public static final Supplier<RotatedPillarBlock> SORBUS_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "sorbus_log");
    public static final Supplier<RotatedPillarBlock> WALNUT_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "walnut_log");

    // Stripped logs
    public static final Supplier<RotatedPillarBlock> BLOODWOOD_STRIPPED_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "bloodwood_stripped_log");
    public static final Supplier<RotatedPillarBlock> GHOSTLY_STRIPPED_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "ghostly_stripped_log");
    public static final Supplier<RotatedPillarBlock> SEEPING_STRIPPED_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "seeping_stripped_log");
    public static final Supplier<RotatedPillarBlock> SORBUS_STRIPPED_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "sorbus_stripped_log");
    public static final Supplier<RotatedPillarBlock> WALNUT_STRIPPED_LOG =
        MysteriousUtils.makePillarBlock(MysteriousCommon.MOD_ID, "walnut_stripped_log");

    // Woods
    public static final Supplier<Block> BLOODWOOD_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "bloodwood_wood");
    public static final Supplier<Block> GHOSTLY_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "ghostly_wood");
    public static final Supplier<Block> SEEPING_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "seeping_wood");
    public static final Supplier<Block> SORBUS_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "sorbus_wood");
    public static final Supplier<Block> WALNUT_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "walnut_wood");

    // Stripped woods
    public static final Supplier<Block> BLOODWOOD_STRIPPED_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "bloodwood_stripped_wood");
    public static final Supplier<Block> GHOSTLY_STRIPPED_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "ghostly_stripped_wood");
    public static final Supplier<Block> SEEPING_STRIPPED_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "seeping_stripped_wood");
    public static final Supplier<Block> SORBUS_STRIPPED_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "sorbus_stripped_wood");
    public static final Supplier<Block> WALNUT_STRIPPED_WOOD =
        MysteriousUtils.makeWoodBlock(MysteriousCommon.MOD_ID, "walnut_stripped_wood");

    // Planks
    public static final Supplier<Block> BLOODWOOD_PLANKS =
        MysteriousUtils.makePlanksBlock(MysteriousCommon.MOD_ID, "bloodwood_planks");
    public static final Supplier<Block> GHOSTLY_PLANKS =
        MysteriousUtils.makePlanksBlock(MysteriousCommon.MOD_ID, "ghostly_planks");
    public static final Supplier<Block> SEEPING_PLANKS =
        MysteriousUtils.makePlanksBlock(MysteriousCommon.MOD_ID, "seeping_planks");
    public static final Supplier<Block> SORBUS_PLANKS =
        MysteriousUtils.makePlanksBlock(MysteriousCommon.MOD_ID, "sorbus_planks");
    public static final Supplier<Block> WALNUT_PLANKS =
        MysteriousUtils.makePlanksBlock(MysteriousCommon.MOD_ID, "walnut_planks");

    // Stairs
    public static final Supplier<StairBlock> BLOODWOOD_STAIRS = MysteriousUtils.makeStairsBlock(
        MysteriousCommon.MOD_ID, "bloodwood_stairs", () -> BLOODWOOD_PLANKS.get().defaultBlockState());
    public static final Supplier<StairBlock> GHOSTLY_STAIRS = MysteriousUtils.makeStairsBlock(
        MysteriousCommon.MOD_ID, "ghostly_stairs", () -> GHOSTLY_PLANKS.get().defaultBlockState());
    public static final Supplier<StairBlock> SEEPING_STAIRS = MysteriousUtils.makeStairsBlock(
        MysteriousCommon.MOD_ID, "seeping_stairs", () -> SEEPING_PLANKS.get().defaultBlockState());
    public static final Supplier<StairBlock> SORBUS_STAIRS = MysteriousUtils.makeStairsBlock(
        MysteriousCommon.MOD_ID, "sorbus_stairs", () -> SORBUS_PLANKS.get().defaultBlockState());
    public static final Supplier<StairBlock> WALNUT_STAIRS = MysteriousUtils.makeStairsBlock(
        MysteriousCommon.MOD_ID, "walnut_stairs", () -> WALNUT_PLANKS.get().defaultBlockState());

    // Leaves
    public static final Supplier<Block> BLOODWOOD_LEAVES =
        MysteriousUtils.makeLeavesBlock(MysteriousCommon.MOD_ID, "bloodwood_leaves");
    public static final Supplier<Block> GHOSTLY_LEAVES =
        MysteriousUtils.makeLeavesBlock(MysteriousCommon.MOD_ID, "ghostly_leaves");
    public static final Supplier<Block> SEEPING_LEAVES =
        MysteriousUtils.makeLeavesBlock(MysteriousCommon.MOD_ID, "seeping_leaves");
    public static final Supplier<Block> SORBUS_LEAVES =
        MysteriousUtils.makeLeavesBlock(MysteriousCommon.MOD_ID, "sorbus_leaves");
    public static final Supplier<Block> WALNUT_LEAVES =
        MysteriousUtils.makeLeavesBlock(MysteriousCommon.MOD_ID, "walnut_leaves");

    // Slabs
    public static final Supplier<SlabBlock> BLOODWOOD_SLAB =
        MysteriousUtils.makeSlabBlock(MysteriousCommon.MOD_ID, "bloodwood_slab");
    public static final Supplier<SlabBlock> GHOSTLY_SLAB =
        MysteriousUtils.makeSlabBlock(MysteriousCommon.MOD_ID, "ghostly_slab");
    public static final Supplier<SlabBlock> SEEPING_SLAB =
        MysteriousUtils.makeSlabBlock(MysteriousCommon.MOD_ID, "seeping_slab");
    public static final Supplier<SlabBlock> SORBUS_SLAB =
        MysteriousUtils.makeSlabBlock(MysteriousCommon.MOD_ID, "sorbus_slab");
    public static final Supplier<SlabBlock> WALNUT_SLAB =
        MysteriousUtils.makeSlabBlock(MysteriousCommon.MOD_ID, "walnut_slab");

    // Fences
    public static final Supplier<FenceBlock> BLOODWOOD_FENCE =
        MysteriousUtils.makeFenceBlock(MysteriousCommon.MOD_ID, "bloodwood_fence");
    public static final Supplier<FenceBlock> GHOSTLY_FENCE =
        MysteriousUtils.makeFenceBlock(MysteriousCommon.MOD_ID, "ghostly_fence");
    public static final Supplier<FenceBlock> SEEPING_FENCE =
        MysteriousUtils.makeFenceBlock(MysteriousCommon.MOD_ID, "seeping_fence");
    public static final Supplier<FenceBlock> SORBUS_FENCE =
        MysteriousUtils.makeFenceBlock(MysteriousCommon.MOD_ID, "sorbus_fence");
    public static final Supplier<FenceBlock> WALNUT_FENCE =
        MysteriousUtils.makeFenceBlock(MysteriousCommon.MOD_ID, "walnut_fence");

    // Gates
    public static final Supplier<FenceGateBlock> BLOODWOOD_GATE =
        MysteriousUtils.makeGateBlock(MysteriousCommon.MOD_ID, "bloodwood_gate");
    public static final Supplier<FenceGateBlock> GHOSTLY_GATE =
        MysteriousUtils.makeGateBlock(MysteriousCommon.MOD_ID, "ghostly_gate");
    public static final Supplier<FenceGateBlock> SEEPING_GATE =
        MysteriousUtils.makeGateBlock(MysteriousCommon.MOD_ID, "seeping_gate");
    public static final Supplier<FenceGateBlock> SORBUS_GATE =
        MysteriousUtils.makeGateBlock(MysteriousCommon.MOD_ID, "sorbus_gate");
    public static final Supplier<FenceGateBlock> WALNUT_GATE =
        MysteriousUtils.makeGateBlock(MysteriousCommon.MOD_ID, "walnut_gate");

    // Buttons
    public static final Supplier<ButtonBlock> BLOODWOOD_BUTTON =
        MysteriousUtils.makeButtonBlock(MysteriousCommon.MOD_ID, "bloodwood_button");
    public static final Supplier<ButtonBlock> GHOSTLY_BUTTON =
        MysteriousUtils.makeButtonBlock(MysteriousCommon.MOD_ID, "ghostly_button");
    public static final Supplier<ButtonBlock> SEEPING_BUTTON =
        MysteriousUtils.makeButtonBlock(MysteriousCommon.MOD_ID, "seeping_button");
    public static final Supplier<ButtonBlock> SORBUS_BUTTON =
        MysteriousUtils.makeButtonBlock(MysteriousCommon.MOD_ID, "sorbus_button");
    public static final Supplier<ButtonBlock> WALNUT_BUTTON =
        MysteriousUtils.makeButtonBlock(MysteriousCommon.MOD_ID, "walnut_button");

    // Pressure plates
    public static final Supplier<PressurePlateBlock> BLOODWOOD_PRESSURE_PLATE =
        MysteriousUtils.makePressurePlateBlock(MysteriousCommon.MOD_ID, "bloodwood_pressure_plate");
    public static final Supplier<PressurePlateBlock> GHOSTLY_PRESSURE_PLATE =
        MysteriousUtils.makePressurePlateBlock(MysteriousCommon.MOD_ID, "ghostly_pressure_plate");
    public static final Supplier<PressurePlateBlock> SEEPING_PRESSURE_PLATE =
        MysteriousUtils.makePressurePlateBlock(MysteriousCommon.MOD_ID, "seeping_pressure_plate");
    public static final Supplier<PressurePlateBlock> SORBUS_PRESSURE_PLATE =
        MysteriousUtils.makePressurePlateBlock(MysteriousCommon.MOD_ID, "sorbus_pressure_plate");
    public static final Supplier<PressurePlateBlock> WALNUT_PRESSURE_PLATE =
        MysteriousUtils.makePressurePlateBlock(MysteriousCommon.MOD_ID, "walnut_pressure_plate");

    // Trapdoors
    public static final Supplier<TrapDoorBlock> BLOODWOOD_TRAPDOOR =
        MysteriousUtils.makeTrapdoorBlock(MysteriousCommon.MOD_ID, "bloodwood_trapdoor");
    public static final Supplier<TrapDoorBlock> GHOSTLY_TRAPDOOR =
        MysteriousUtils.makeTrapdoorBlock(MysteriousCommon.MOD_ID, "ghostly_trapdoor");
    public static final Supplier<TrapDoorBlock> SEEPING_TRAPDOOR =
        MysteriousUtils.makeTrapdoorBlock(MysteriousCommon.MOD_ID, "seeping_trapdoor");
    public static final Supplier<TrapDoorBlock> SORBUS_TRAPDOOR =
        MysteriousUtils.makeTrapdoorBlock(MysteriousCommon.MOD_ID, "sorbus_trapdoor");
    public static final Supplier<TrapDoorBlock> WALNUT_TRAPDOOR =
        MysteriousUtils.makeTrapdoorBlock(MysteriousCommon.MOD_ID, "walnut_trapdoor");

    // Doors
    public static final Supplier<DoorBlock> BLOODWOOD_DOOR =
        MysteriousUtils.makeDoorBlock(MysteriousCommon.MOD_ID, "bloodwood_door");
    public static final Supplier<DoorBlock> GHOSTLY_DOOR =
        MysteriousUtils.makeDoorBlock(MysteriousCommon.MOD_ID, "ghostly_door");
    public static final Supplier<DoorBlock> SEEPING_DOOR =
        MysteriousUtils.makeDoorBlock(MysteriousCommon.MOD_ID, "seeping_door");
    public static final Supplier<DoorBlock> SORBUS_DOOR =
        MysteriousUtils.makeDoorBlock(MysteriousCommon.MOD_ID, "sorbus_door");
    public static final Supplier<DoorBlock> WALNUT_DOOR =
        MysteriousUtils.makeDoorBlock(MysteriousCommon.MOD_ID, "walnut_door");

    // Saplings
    public static final Supplier<SaplingBlock> BLOODWOOD_SAPLING = MysteriousUtils.makeSaplingBlock(
        MysteriousCommon.MOD_ID, "bloodwood_sapling", new OakTreeGrower());
    public static final Supplier<SaplingBlock> GHOSTLY_SAPLING = MysteriousUtils.makeSaplingBlock(
        MysteriousCommon.MOD_ID, "ghostly_sapling", new OakTreeGrower());
    public static final Supplier<SaplingBlock> SEEPING_SAPLING = MysteriousUtils.makeSaplingBlock(
            MysteriousCommon.MOD_ID, "seeping_sapling", new OakTreeGrower());
    public static final Supplier<SaplingBlock> SORBUS_SAPLING = MysteriousUtils.makeSaplingBlock(
            MysteriousCommon.MOD_ID, "sorbus_sapling", new OakTreeGrower());
    public static final Supplier<SaplingBlock> WALNUT_SAPLING = MysteriousUtils.makeSaplingBlock(
            MysteriousCommon.MOD_ID, "walnut_sapling", new OakTreeGrower());

    // Floor signs
    public static final Supplier<StandingSignBlock> BLOODWOOD_FLOOR_SIGN = MysteriousUtils.makeFloorSignBlock(
        MysteriousCommon.MOD_ID, "bloodwood_sign", MysteriousWoodType.BLOODWOOD_TYPE);
    public static final Supplier<StandingSignBlock> GHOSTLY_FLOOR_SIGN = MysteriousUtils.makeFloorSignBlock(
        MysteriousCommon.MOD_ID, "ghostly_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<StandingSignBlock> SEEPING_FLOOR_SIGN = MysteriousUtils.makeFloorSignBlock(
        MysteriousCommon.MOD_ID, "seeping_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<StandingSignBlock> SORBUS_FLOOR_SIGN = MysteriousUtils.makeFloorSignBlock(
        MysteriousCommon.MOD_ID, "sorbus_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<StandingSignBlock> WALNUT_FLOOR_SIGN = MysteriousUtils.makeFloorSignBlock(
        MysteriousCommon.MOD_ID, "walnut_sign", MysteriousWoodType.WALNUT_TYPE);

    // Wall signs
    public static final Supplier<WallSignBlock> BLOODWOOD_WALL_SIGN = MysteriousUtils.makeWallSignBlock(
        MysteriousCommon.MOD_ID, "bloodwood_wall_sign", MysteriousWoodType.BLOODWOOD_TYPE);
    public static final Supplier<WallSignBlock> GHOSTLY_WALL_SIGN = MysteriousUtils.makeWallSignBlock(
        MysteriousCommon.MOD_ID, "ghostly_wall_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<WallSignBlock> SEEPING_WALL_SIGN = MysteriousUtils.makeWallSignBlock(
        MysteriousCommon.MOD_ID, "seeping_wall_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<WallSignBlock> SORBUS_WALL_SIGN = MysteriousUtils.makeWallSignBlock(
        MysteriousCommon.MOD_ID, "sorbus_wall_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<WallSignBlock> WALNUT_WALL_SIGN = MysteriousUtils.makeWallSignBlock(
        MysteriousCommon.MOD_ID, "walnut_wall_sign", MysteriousWoodType.WALNUT_TYPE);

    // Sign items
    public static final Supplier<SignItem> BLOODWOOD_SIGN = MysteriousUtils.makeSignItem(
        MysteriousCommon.MOD_ID, "bloodwood_sign", BLOODWOOD_FLOOR_SIGN, BLOODWOOD_WALL_SIGN);
    public static final Supplier<SignItem> GHOSTLY_SIGN = MysteriousUtils.makeSignItem(
        MysteriousCommon.MOD_ID, "ghostly_sign", GHOSTLY_FLOOR_SIGN, GHOSTLY_WALL_SIGN);
    public static final Supplier<SignItem> SEEPING_SIGN = MysteriousUtils.makeSignItem(
        MysteriousCommon.MOD_ID, "seeping_sign", SEEPING_FLOOR_SIGN, SEEPING_WALL_SIGN);
    public static final Supplier<SignItem> SORBUS_SIGN = MysteriousUtils.makeSignItem(
        MysteriousCommon.MOD_ID, "sorbus_sign", SORBUS_FLOOR_SIGN, SORBUS_WALL_SIGN);
    public static final Supplier<SignItem> WALNUT_SIGN = MysteriousUtils.makeSignItem(
        MysteriousCommon.MOD_ID, "walnut_sign", WALNUT_FLOOR_SIGN, WALNUT_WALL_SIGN);

    // Hanging signs
    public static final Supplier<CeilingHangingSignBlock> BLOODWOOD_HANGING_SIGN = MysteriousUtils.makeHangingSignBlock(
        MysteriousCommon.MOD_ID, "bloodwood_hanging_sign", MysteriousWoodType.BLOODWOOD_TYPE);
    public static final Supplier<CeilingHangingSignBlock> GHOSTLY_HANGING_SIGN = MysteriousUtils.makeHangingSignBlock(
        MysteriousCommon.MOD_ID, "ghostly_hanging_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<CeilingHangingSignBlock> SEEPING_HANGING_SIGN = MysteriousUtils.makeHangingSignBlock(
        MysteriousCommon.MOD_ID, "seeping_hanging_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<CeilingHangingSignBlock> SORBUS_HANGING_SIGN = MysteriousUtils.makeHangingSignBlock(
        MysteriousCommon.MOD_ID, "sorbus_hanging_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<CeilingHangingSignBlock> WALNUT_HANGING_SIGN = MysteriousUtils.makeHangingSignBlock(
        MysteriousCommon.MOD_ID, "walnut_hanging_sign", MysteriousWoodType.WALNUT_TYPE);

    // Wall hanging signs
    public static final Supplier<WallHangingSignBlock> BLOODWOOD_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock(MysteriousCommon.MOD_ID,
        "bloodwood_wall_hanging_sign", MysteriousWoodType.BLOODWOOD_TYPE);
    public static final Supplier<WallHangingSignBlock> GHOSTLY_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock(MysteriousCommon.MOD_ID,
        "ghostly_wall_hanging_sign", MysteriousWoodType.GHOSTLY_TYPE);
    public static final Supplier<WallHangingSignBlock> SEEPING_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock(MysteriousCommon.MOD_ID,
        "seeping_wall_hanging_sign", MysteriousWoodType.SEEPING_TYPE);
    public static final Supplier<WallHangingSignBlock> SORBUS_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock(MysteriousCommon.MOD_ID,
        "sorbus_wall_hanging_sign", MysteriousWoodType.SORBUS_TYPE);
    public static final Supplier<WallHangingSignBlock> WALNUT_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock(MysteriousCommon.MOD_ID,
        "walnut_wall_hanging_sign", MysteriousWoodType.WALNUT_TYPE);

    // Hanging sign items
    public static final Supplier<HangingSignItem> BLOODWOOD_HANGING_SIGN_ITEM = MysteriousUtils.makeHangingSignItem(
        MysteriousCommon.MOD_ID, "bloodwood_hanging_sign_item",
        BLOODWOOD_HANGING_SIGN, BLOODWOOD_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> GHOSTLY_HANGING_SIGN_ITEM = MysteriousUtils.makeHangingSignItem(
        MysteriousCommon.MOD_ID, "ghostly_hanging_sign_item",
        GHOSTLY_HANGING_SIGN, GHOSTLY_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> SEEPING_HANGING_SIGN_ITEM = MysteriousUtils.makeHangingSignItem(
        MysteriousCommon.MOD_ID, "seeping_hanging_sign_item",
        SEEPING_HANGING_SIGN, SEEPING_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> SORBUS_HANGING_SIGN_ITEM = MysteriousUtils.makeHangingSignItem(
        MysteriousCommon.MOD_ID, "sorbus_hanging_sign_item",
        SORBUS_HANGING_SIGN, SORBUS_WALL_HANGING_SIGN);
    public static final Supplier<HangingSignItem> WALNUT_HANGING_SIGN_ITEM = MysteriousUtils.makeHangingSignItem(
        MysteriousCommon.MOD_ID, "walnut_hanging_sign_item",
        WALNUT_HANGING_SIGN, WALNUT_WALL_HANGING_SIGN);

    public static void init() {
        MysteriousCommon.LOG.debug("Registering blocks, items and entities...");
    }
}
