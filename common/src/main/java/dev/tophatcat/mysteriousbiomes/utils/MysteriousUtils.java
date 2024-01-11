package dev.tophatcat.mysteriousbiomes.utils;

import com.google.common.base.Suppliers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Supplier;

public final class MysteriousUtils {

    //TODO Set up registration with services for multi-platform blocks, items and entities.
    public static <T extends EntityType<?>> Supplier<T> createEntity(String name, Supplier<T> entity) {
        return entity;
    }

    public static <T extends Block> Supplier<T> createBlock(String name, Supplier<T> block, boolean makeItem) {
        if (makeItem) {
            createItem(name, Suppliers.memoize(() -> new BlockItem(block.get(), new Item.Properties())));
        }
        return block;
    }

    public static <T extends Item> Supplier<T> createItem(String name, Supplier<T> item) {
        return item;
    }

    public static Supplier<Block> makePillarBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new RotatedPillarBlock(
            Block.Properties.ofFullCopy(Blocks.OAK_LOG))), true);
    }

    public static Supplier<Block> makePlanksBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new Block(
            Block.Properties.ofFullCopy(Blocks.OAK_PLANKS))), false);
    }

    public static Supplier<Block> makeLeavesBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new LeavesBlock(
            Block.Properties.ofFullCopy(Blocks.OAK_LEAVES))), true);
    }

    public static Supplier<Block> makeSlabBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new SlabBlock(
            Block.Properties.ofFullCopy(Blocks.OAK_SLAB))), true);
    }

    public static Supplier<Block> makeFenceBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new FenceBlock(
            Block.Properties.ofFullCopy(Blocks.OAK_FENCE))), true);
    }

    public static Supplier<Block> makeGateBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new FenceGateBlock(
            WoodType.OAK, Block.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE))), true);
    }

    public static Supplier<Block> makeButtonBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new ButtonBlock(
            BlockSetType.OAK, 30, Block.Properties.ofFullCopy(Blocks.OAK_BUTTON))), true);
    }

    public static Supplier<Block> makePressurePlateBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new PressurePlateBlock(
            BlockSetType.OAK, Block.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE))), true);
    }

    public static Supplier<Block> makeTrapdoorBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new TrapDoorBlock(
            BlockSetType.OAK, Block.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR))), true);
    }

    public static Supplier<Block> makeDoorBlock(String name) {
        return createBlock(name, Suppliers.memoize(() -> new DoorBlock(
            BlockSetType.OAK, Block.Properties.ofFullCopy(Blocks.OAK_DOOR)
            .strength(3.0F).noOcclusion().ignitedByLava())), true);
    }

    public static Supplier<Block> makeSaplingBlock(String name, TreeGrower generator) {
        return createBlock(name, Suppliers.memoize(() -> new SaplingBlock(
            generator, Block.Properties.ofFullCopy(Blocks.OAK_SAPLING))), true);
    }

    public static Supplier<Block> makeStairsBlock(String name, BlockState blockState) {
        return createBlock(name, Suppliers.memoize(() -> new StairBlock(blockState,
            Block.Properties.ofFullCopy(Blocks.OAK_STAIRS))), true);
    }

    public static Supplier<Item> makeSignItem(String name, Block signBlock, Block wallSignBlock) {
        return createItem(name, Suppliers.memoize(() -> new SignItem(
            new Item.Properties().stacksTo(16), signBlock, wallSignBlock)));
    }

    public static Supplier<Block> makeFloorSignBlock(String name, WoodType signType) {
        return createBlock(name, Suppliers.memoize(() -> new StandingSignBlock(
            signType, Block.Properties.ofFullCopy(Blocks.OAK_SIGN))), false);
    }

    public static Supplier<Block> makeWallSignBlock(String name, WoodType woodType) {
        return createBlock(name, Suppliers.memoize(() -> new WallSignBlock(woodType,
            Block.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN))), false);
    }

    public static Supplier<Item> makeHangingSignItem(String name, Block hangingSignBlock, Block wallHangingSignBlock) {
        return createItem(name, Suppliers.memoize(() -> new HangingSignItem(
            hangingSignBlock, wallHangingSignBlock, new Item.Properties().stacksTo(16))));
    }

    public static Supplier<Block> makeHangingSignBlock(String name, WoodType signType) {
        return createBlock(name, Suppliers.memoize(() -> new CeilingHangingSignBlock(
            signType, Block.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN))), false);
    }

    public static Supplier<Block> makeWallHangingSignBlock(String name, WoodType signType) {
        return createBlock(name, Suppliers.memoize(() -> new WallHangingSignBlock(
            signType, Block.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN))), false);
    }
}
