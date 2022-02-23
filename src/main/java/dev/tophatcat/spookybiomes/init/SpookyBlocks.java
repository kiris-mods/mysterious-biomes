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
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.spookybiomes.common.blocks.SpookyLogBlock;
import dev.tophatcat.spookybiomes.common.blocks.signs.SpookyStandingSignBlock;
import dev.tophatcat.spookybiomes.common.blocks.signs.SpookyWallSignBlock;
import dev.tophatcat.spookybiomes.common.blocks.tiles.SpookySignBlockEntity;
import dev.tophatcat.spookybiomes.common.generation.BloodiedTreeGrower;
import dev.tophatcat.spookybiomes.common.generation.GhostlyTreeGrower;
import dev.tophatcat.spookybiomes.common.generation.SeepingTreeGrower;
import dev.tophatcat.spookybiomes.common.generation.SorbusTreeGrower;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static dev.tophatcat.spookybiomes.RegistrationHelpers.registerBlockAndBurnableItem;
import static dev.tophatcat.spookybiomes.RegistrationHelpers.registerBlockAndStandardItem;
import static dev.tophatcat.spookybiomes.init.SpookyItems.ITEMS;

public class SpookyBlocks {

    public static final DeferredRegister<Block> BLOCKS
        = DeferredRegister.create(ForgeRegistries.BLOCKS, SpookyBiomes.MOD_ID);

    //Misc blocks
    public static final RegistryObject<BloodiedGrass> BLOODIED_GRASS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodied_grass", () -> new BloodiedGrass(Properties.of(Material.DIRT)
            .strength(0.6F).sound(SoundType.GRAVEL).randomTicks()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<Block> BLOODIED_DIRT = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodied_dirt", () -> new Block(Properties.of(Material.DIRT)
            .strength(0.6F).sound(SoundType.GRAVEL)), SpookyBiomes.CREATIVE_TAB);

    //Sorbus blocks
    public static final RegistryObject<RotatedPillarBlock> SORBUS_LOG_STRIPPED = registerBlockAndStandardItem(BLOCKS,
        ITEMS, "sorbus_log_stripped", () -> new RotatedPillarBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyLogBlock> SORBUS_LOG = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_log", () -> new SpookyLogBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD), SORBUS_LOG_STRIPPED),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<LeavesBlock> SORBUS_LEAVES = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_leaves", () -> new LeavesBlock(Properties.of(Material.LEAVES)
            .strength(0.2F).sound(SoundType.GRASS).randomTicks().noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<Block> SORBUS_PLANKS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_planks", () -> new Block(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SaplingBlock> SORBUS_SAPLING = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_sapling", () -> new SaplingBlock(new SorbusTreeGrower(), Properties.of(Material.GRASS)
            .sound(SoundType.GRASS).noCollission().noOcclusion().randomTicks()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceGateBlock> SORBUS_GATE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "sorbus_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), 300,
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<DoorBlock> SORBUS_DOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_door", () -> new DoorBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<TrapDoorBlock> SORBUS_TRAPDOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD)
            .strength(3.0F, 6.0F).sound(SoundType.WOOD).noOcclusion()),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<StairBlock> SORBUS_STAIRS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_stairs", () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
            Properties.of(Material.WOOD).strength(2.0F, 5.0F).sound(SoundType.WOOD)),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceBlock> SORBUS_FENCE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "sorbus_fence", () -> new FenceBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), 300,
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SlabBlock> SORBUS_SLAB = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_slab", () -> new SlabBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<PressurePlateBlock> SORBUS_PRESSURE_PLATE = registerBlockAndStandardItem(BLOCKS,
        ITEMS, "sorbus_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
            Properties.of(Material.WOOD, SORBUS_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F)
                .sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<ButtonBlock> SORBUS_BUTTON = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "sorbus_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION)
            .noCollission().strength(0.5F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyStandingSignBlock> SORBUS_SIGN = BLOCKS.register(
        "sorbus_sign", () -> new SpookyStandingSignBlock(Properties.of(Material.WOOD,
            SORBUS_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD),
            SpookyBiomes.SORBUS_WOOD_TYPE, SpookySignBlockEntity::new));

    public static final RegistryObject<SpookyWallSignBlock> SORBUS_WALL_SIGN = BLOCKS.register(
        "sorbus_wall_sign", () -> new SpookyWallSignBlock(Properties.of(Material.WOOD,
                SORBUS_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD)
            .lootFrom(SORBUS_SIGN), SpookyBiomes.SORBUS_WOOD_TYPE, SpookySignBlockEntity::new));

    //Ghostly blocks
    public static final RegistryObject<RotatedPillarBlock> GHOSTLY_LOG_STRIPPED = registerBlockAndStandardItem(BLOCKS,
        ITEMS, "ghostly_log_stripped", () -> new RotatedPillarBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyLogBlock> GHOSTLY_LOG = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_log", () -> new SpookyLogBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD), GHOSTLY_LOG_STRIPPED),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<LeavesBlock> GHOSTLY_LEAVES = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_leaves", () -> new LeavesBlock(Properties.of(Material.LEAVES)
            .strength(0.2F).sound(SoundType.GRASS).randomTicks().noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<Block> GHOSTLY_PLANKS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_planks", () -> new Block(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SaplingBlock> GHOSTLY_SAPLING = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_sapling", () -> new SaplingBlock(new GhostlyTreeGrower(), Properties.of(Material.GRASS)
            .sound(SoundType.GRASS).noCollission().noOcclusion().randomTicks()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceGateBlock> GHOSTLY_GATE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "ghostly_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)),
        300, SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<DoorBlock> GHOSTLY_DOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_door", () -> new DoorBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD).noOcclusion()),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<TrapDoorBlock> GHOSTLY_TRAPDOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD)
            .strength(3.0F, 6.0F).sound(SoundType.WOOD).noOcclusion()),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<StairBlock> GHOSTLY_STAIRS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_stairs", () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
            Properties.of(Material.WOOD).strength(2.0F, 5.0F).sound(SoundType.WOOD)),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceBlock> GHOSTLY_FENCE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "ghostly_fence", () -> new FenceBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)),
        300, SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SlabBlock> GHOSTLY_SLAB = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_slab", () -> new SlabBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<PressurePlateBlock> GHOSTLY_PRESSURE_PLATE = registerBlockAndStandardItem(BLOCKS,
        ITEMS, "ghostly_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
            Properties.of(Material.WOOD, GHOSTLY_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F)
                .sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<ButtonBlock> GHOSTLY_BUTTON = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "ghostly_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION)
            .noCollission().strength(0.5F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyStandingSignBlock> GHOSTLY_SIGN = BLOCKS.register(
        "ghostly_sign", () -> new SpookyStandingSignBlock(Properties.of(Material.WOOD,
            GHOSTLY_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD),
            SpookyBiomes.GHOSTLY_WOOD_TYPE, SpookySignBlockEntity::new));

    public static final RegistryObject<SpookyWallSignBlock> GHOSTLY_WALL_SIGN = BLOCKS.register(
        "ghostly_wall_sign", () -> new SpookyWallSignBlock(Properties.of(Material.WOOD,
                GHOSTLY_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD)
            .lootFrom(GHOSTLY_SIGN), SpookyBiomes.GHOSTLY_WOOD_TYPE, SpookySignBlockEntity::new));

    //Seeping blocks
    public static final RegistryObject<RotatedPillarBlock> SEEPING_LOG_STRIPPED = registerBlockAndStandardItem(BLOCKS,
        ITEMS, "seeping_log_stripped", () -> new RotatedPillarBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyLogBlock> SEEPING_LOG = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_log", () -> new SpookyLogBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD), SEEPING_LOG_STRIPPED), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<LeavesBlock> SEEPING_LEAVES = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_leaves", () -> new LeavesBlock(Properties.of(Material.LEAVES)
            .strength(0.2F).sound(SoundType.GRASS).randomTicks().noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<Block> SEEPING_PLANKS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_planks", () -> new Block(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SaplingBlock> SEEPING_SAPLING = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_sapling", () -> new SaplingBlock(new SeepingTreeGrower(), Properties.of(Material.GRASS)
            .sound(SoundType.GRASS).noCollission().noOcclusion().randomTicks()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceGateBlock> SEEPING_GATE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "seeping_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD)), 300, SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<DoorBlock> SEEPING_DOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_door", () -> new DoorBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<TrapDoorBlock> SEEPING_TRAPDOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F,
            6.0F).sound(SoundType.WOOD).noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<StairBlock> SEEPING_STAIRS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_stairs", () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
            Properties.of(Material.WOOD).strength(2.0F, 5.0F).sound(SoundType.WOOD)),
        SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceBlock> SEEPING_FENCE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "seeping_fence", () -> new FenceBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD)), 300, SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SlabBlock> SEEPING_SLAB = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_slab", () -> new SlabBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<PressurePlateBlock> SEEPING_PRESSURE_PLATE = registerBlockAndStandardItem(BLOCKS,
        ITEMS, "seeping_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
            Properties.of(Material.WOOD, SORBUS_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F)
                .sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<ButtonBlock> SEEPING_BUTTON = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "seeping_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION)
            .noCollission().strength(0.5F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyStandingSignBlock> SEEPING_SIGN = BLOCKS.register(
        "seeping_sign", () -> new SpookyStandingSignBlock(Properties.of(Material.WOOD,
            SEEPING_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD),
            SpookyBiomes.SEEPING_WOOD_TYPE, SpookySignBlockEntity::new));

    public static final RegistryObject<SpookyWallSignBlock> SEEPING_WALL_SIGN = BLOCKS.register(
        "seeping_wall_sign", () -> new SpookyWallSignBlock(Properties.of(Material.WOOD,
                SEEPING_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD)
            .lootFrom(SEEPING_SIGN), SpookyBiomes.SEEPING_WOOD_TYPE, SpookySignBlockEntity::new));

    //Bloodwood blocks
    public static final RegistryObject<RotatedPillarBlock> BLOODWOOD_LOG_STRIPPED = registerBlockAndStandardItem(BLOCKS,
        ITEMS, "bloodwood_log_stripped", () -> new RotatedPillarBlock(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyLogBlock> BLOODWOOD_LOG = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_log", () -> new SpookyLogBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD), BLOODWOOD_LOG_STRIPPED), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<LeavesBlock> BLOODWOOD_LEAVES = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_leaves", () -> new LeavesBlock(Properties.of(Material.LEAVES)
            .strength(0.2F).sound(SoundType.GRASS).randomTicks().noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<Block> BLOODWOOD_PLANKS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_planks", () -> new Block(Properties.of(Material.WOOD)
            .strength(2.0F, 5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SaplingBlock> BLOODWOOD_SAPLING = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_sapling", () -> new SaplingBlock(new BloodiedTreeGrower(), Properties.of(Material.GRASS)
            .sound(SoundType.GRASS).randomTicks().noCollission().noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceGateBlock> BLOODWOOD_GATE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "bloodwood_gate", () -> new FenceGateBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD)), 300, SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<DoorBlock> BLOODWOOD_DOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_door", () -> new DoorBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD).noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<TrapDoorBlock> BLOODWOOD_TRAPDOOR = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_trapdoor", () -> new TrapDoorBlock(Properties.of(Material.WOOD).strength(3.0F,
            6.0F).sound(SoundType.WOOD).noOcclusion()), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<StairBlock> BLOODWOOD_STAIRS = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_stairs", () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
            Properties.of(Material.WOOD).strength(2.0F, 5.0F)
                .sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<FenceBlock> BLOODWOOD_FENCE = registerBlockAndBurnableItem(BLOCKS, ITEMS,
        "bloodwood_fence", () -> new FenceBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD)), 300, SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SlabBlock> BLOODWOOD_SLAB = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_slab", () -> new SlabBlock(Properties.of(Material.WOOD).strength(2.0F,
            5.0F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<PressurePlateBlock> BLOODWOOD_PRESSURE_PLATE = registerBlockAndStandardItem(
        BLOCKS, ITEMS, "bloodwood_pressure_plate", () -> new PressurePlateBlock(
            PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.WOOD,
                SORBUS_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F)
            .sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<ButtonBlock> BLOODWOOD_BUTTON = registerBlockAndStandardItem(BLOCKS, ITEMS,
        "bloodwood_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION)
            .noCollission().strength(0.5F).sound(SoundType.WOOD)), SpookyBiomes.CREATIVE_TAB);

    public static final RegistryObject<SpookyStandingSignBlock> BLOODWOOD_SIGN = BLOCKS.register(
        "bloodwood_sign", () -> new SpookyStandingSignBlock(Properties.of(Material.WOOD,
            BLOODWOOD_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD),
            SpookyBiomes.BLOODWOOD_WOOD_TYPE, SpookySignBlockEntity::new));

    public static final RegistryObject<SpookyWallSignBlock> BLOODWOOD_WALL_SIGN = BLOCKS.register(
        "bloodwood_wall_sign", () -> new SpookyWallSignBlock(Properties.of(Material.WOOD,
                BLOODWOOD_PLANKS.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD)
            .lootFrom(BLOODWOOD_SIGN), SpookyBiomes.BLOODWOOD_WOOD_TYPE, SpookySignBlockEntity::new));
}
