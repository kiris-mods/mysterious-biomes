/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
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
package dev.tophatcat.mysteriousbiomes.utils;

import dev.tophatcat.kirislib.RegHelpers;
import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class MysteriousUtils {

    public static final LinkedHashMap<EntityType<?>, ResourceLocation> ENTITIES = new LinkedHashMap<>();
    public static final Map<ResourceLocation, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<ResourceLocation, Supplier<Item>> ITEMS = new LinkedHashMap<>();

    private void MysteriousBiomes() {
        throw new UnsupportedOperationException();
    }

    public static ResourceLocation identifier(String name) {
        return new ResourceLocation(MysteriousBiomes.MOD_ID, name);
    }

    public static <T extends Entity> EntityType<T> makeEntity(String name, EntityType<T> type) {
        ENTITIES.put(type, identifier(name));
        return type;
    }

    public static Supplier<Block> makeSaplingBlock(String name, AbstractTreeGrower generator) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new SaplingBlock(generator, Block.Properties.copy(Blocks.OAK_SAPLING)), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makePillarBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_LOG)), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makePlanksBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeStairsBlock(String name, BlockState blockState) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new StairBlock(blockState, Block.Properties.copy(Blocks.OAK_STAIRS)), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeLeavesBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new LeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES)), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeSlabBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new SlabBlock(Block.Properties.copy(Blocks.OAK_SLAB)), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeFenceBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeGateBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeButtonBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30,
                true), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makePressurePlateBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeTrapdoorBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK), BLOCKS, ITEMS);
    }

    public static Supplier<Block> makeDoorBlock(String name) {
        return RegHelpers.createBlockWithItem(identifier(name),
            () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR).strength(3.0F).noOcclusion().ignitedByLava(),
                BlockSetType.OAK), BLOCKS, ITEMS);
    }

    public static Supplier<Item> makeSignItem(String name, Block signBlock, Block wallSignBlock) {
        return RegHelpers.createBasicItem(identifier(name),
            () -> new SignItem(new Item.Properties().stacksTo(16), signBlock, wallSignBlock), ITEMS);
    }

    public static Supplier<Block> makeFloorSignBlock(String name, WoodType signType) {
        return RegHelpers.createBlock(identifier(name),
            () -> new StandingSignBlock(Block.Properties.copy(Blocks.OAK_SIGN), signType), BLOCKS);
    }

    public static Supplier<Block> makeWallSignBlock(String name, WoodType woodType) {
        return RegHelpers.createBlock(identifier(name),
            () -> new WallSignBlock(Block.Properties.copy(Blocks.OAK_WALL_SIGN), woodType), BLOCKS);
    }

    public static Supplier<Item> makeHangingSignItem(String name, Block hangingSignBlock, Block wallHangingSignBlock) {
        return RegHelpers.createBasicItem(identifier(name),
            () -> new HangingSignItem(hangingSignBlock, wallHangingSignBlock, new Item.Properties()
                .stacksTo(16)), ITEMS);
    }

    public static Supplier<Block> makeHangingSignBlock(String name, WoodType signType) {
        return RegHelpers.createBlock(identifier(name),
            () -> new CeilingHangingSignBlock(Block.Properties.copy(Blocks.OAK_HANGING_SIGN), signType), BLOCKS);
    }

    public static Supplier<Block> makeWallHangingSignBlock(String name, WoodType signType) {
        return RegHelpers.createBlock(identifier(name),
            () -> new WallHangingSignBlock(Block.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), signType), BLOCKS);
    }
}
