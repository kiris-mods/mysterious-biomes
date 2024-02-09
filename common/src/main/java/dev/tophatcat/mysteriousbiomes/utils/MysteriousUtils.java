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
package dev.tophatcat.mysteriousbiomes.utils;

import com.google.common.base.Suppliers;
import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.platform.Services;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class MysteriousUtils {

    public static <T extends EntityType<?>> Supplier<T> createEntity(
        String name, Supplier<T> entity) {
        return Services.PLATFORM.register(entity, new ResourceLocation(MysteriousCommon.MOD_ID, name),
            BuiltInRegistries.ENTITY_TYPE);
    }

    public static <T extends Block> Supplier<T> createBlock(String modId, String name,
                                                            Supplier<T> block, boolean makeItem) {
        if (makeItem) {
            createItem(
                modId, name, Suppliers.memoize(() -> new BlockItem(block.get(), new Item.Properties())));
        }
        return Services.PLATFORM.register(
            block, new ResourceLocation(modId, name), BuiltInRegistries.BLOCK);
    }

    public static <T extends Item> Supplier<T> createItem(String modId, String name, Supplier<T> item) {
        return Services.PLATFORM.register(item, new ResourceLocation(modId, name), BuiltInRegistries.ITEM);
    }

    public static Supplier<RotatedPillarBlock> makePillarBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new RotatedPillarBlock(
            Block.Properties.copy(Blocks.OAK_LOG))), true);
    }

    public static Supplier<Block> makeWoodBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new Block(
            BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))), true);
    }

    public static Supplier<Block> makePlanksBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new Block(
            Block.Properties.copy(Blocks.OAK_PLANKS))), true);
    }

    public static Supplier<Block> makeLeavesBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new LeavesBlock(
            Block.Properties.copy(Blocks.OAK_LEAVES))), true);
    }

    public static Supplier<SlabBlock> makeSlabBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new SlabBlock(
            Block.Properties.copy(Blocks.OAK_SLAB))), true);
    }

    public static Supplier<FenceBlock> makeFenceBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new FenceBlock(
            Block.Properties.copy(Blocks.OAK_FENCE))), true);
    }

    public static Supplier<FenceGateBlock> makeGateBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new FenceGateBlock(
            Block.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK)), true);
    }

    public static Supplier<ButtonBlock> makeButtonBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new ButtonBlock(
            Block.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true)), true);
    }

    public static Supplier<PressurePlateBlock> makePressurePlateBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new PressurePlateBlock(
            PressurePlateBlock.Sensitivity.EVERYTHING,
            Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK)), true);
    }

    public static Supplier<TrapDoorBlock> makeTrapdoorBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new TrapDoorBlock(
            Block.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK)), true);
    }

    public static Supplier<DoorBlock> makeDoorBlock(String modId, String name) {
        return createBlock(modId, name, Suppliers.memoize(() -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR)
                .strength(3.0F).noOcclusion().ignitedByLava(), BlockSetType.OAK)), true);
    }

    public static Supplier<SaplingBlock> makeSaplingBlock(String modId, String name, AbstractTreeGrower generator) {
        return createBlock(modId, name, Suppliers.memoize(() -> new SaplingBlock(generator,
            Block.Properties.copy(Blocks.OAK_SAPLING))), true);
    }

    public static Supplier<StairBlock> makeStairsBlock(String modId, String name, Supplier<BlockState> blockState) {
        return createBlock(modId, name, Suppliers.memoize(() -> new StairBlock(blockState.get(),
            Block.Properties.copy(Blocks.OAK_STAIRS))), true);
    }

    public static Supplier<SignItem> makeSignItem(String modId, String name, Supplier<StandingSignBlock> signBlock,
                                                  Supplier<WallSignBlock> wallSignBlock) {
        return createItem(modId, name, Suppliers.memoize(() -> new SignItem(new Item.Properties()
            .stacksTo(16), signBlock.get(), wallSignBlock.get())));
    }

    public static Supplier<StandingSignBlock> makeFloorSignBlock(String modId, String name, WoodType signType) {
        return createBlock(modId, name, Suppliers.memoize(() -> new StandingSignBlock(
            Block.Properties.copy(Blocks.OAK_SIGN), signType)), false);
    }

    public static Supplier<WallSignBlock> makeWallSignBlock(String modId, String name, WoodType woodType) {
        return createBlock(modId, name, Suppliers.memoize(() -> new WallSignBlock(
            Block.Properties.copy(Blocks.OAK_WALL_SIGN), woodType)), false);
    }

    public static Supplier<HangingSignItem> makeHangingSignItem(String modId, String name,
                                                                Supplier<CeilingHangingSignBlock> hangingSignBlock,
                                                                Supplier<WallHangingSignBlock> wallHangingSignBlock) {
        return createItem(modId, name, Suppliers.memoize(() -> new HangingSignItem(
            hangingSignBlock.get(), wallHangingSignBlock.get(), new Item.Properties().stacksTo(16))));
    }

    public static Supplier<CeilingHangingSignBlock> makeHangingSignBlock(String modId, String name, WoodType signType) {
        return createBlock(modId, name, Suppliers.memoize(() -> new CeilingHangingSignBlock(
            Block.Properties.copy(Blocks.OAK_HANGING_SIGN), signType)), false);
    }

    public static Supplier<WallHangingSignBlock> makeWallHangingSignBlock(String modId, String name,
                                                                          WoodType signType) {
        return createBlock(modId, name, Suppliers.memoize(() -> new WallHangingSignBlock(
            Block.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), signType)), false);
    }
}
