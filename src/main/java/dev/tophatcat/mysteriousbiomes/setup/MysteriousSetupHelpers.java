package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.kirislib.RegHelpers;
import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class MysteriousSetupHelpers {

    public static Supplier<Block> setupCraftingTableBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType),
            MysteriousBiomes.ITEM_TAB, () -> new CraftingTableBlock(Block.Properties.of(Material.WOOD)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSaplingBlock(String name, AbstractTreeGrower generator) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, name),
            MysteriousBiomes.ITEM_TAB, () -> new SaplingBlock(generator, Block.Properties.of(Material.WOOD)
                .randomTicks().noCollission()), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPillarBlock(String woodType, String blockType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + blockType),
            MysteriousBiomes.ITEM_TAB, () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).strength(2.0F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPlanksBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_planks"),
            MysteriousBiomes.ITEM_TAB, () -> new Block(Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupStairsBlock(String woodType, BlockState blockState) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_stairs"),
            MysteriousBiomes.ITEM_TAB, () -> new StairBlock(blockState, Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupLeavesBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_leaves"),
            MysteriousBiomes.ITEM_TAB, () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F)
                .noOcclusion()), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSlabBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_slab"),
            MysteriousBiomes.ITEM_TAB, () -> new SlabBlock(Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupFenceBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_fence"),
            MysteriousBiomes.ITEM_TAB, () -> new FenceBlock(Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupGateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_gate"),
            MysteriousBiomes.ITEM_TAB,
            () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupButtonBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_button"),
            MysteriousBiomes.ITEM_TAB, () -> new WoodButtonBlock(Block.Properties.of(Material.WOOD).strength(0.5F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPressurePlateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType
                + "_pressure_plate"), MysteriousBiomes.ITEM_TAB, () -> new PressurePlateBlock(PressurePlateBlock
                .Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).strength(0.5F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupTrapdoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType
            + "_trapdoor"), MysteriousBiomes.ITEM_TAB, () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD)
            .strength(3.0F).noOcclusion()), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupDoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_door"),
            MysteriousBiomes.ITEM_TAB, () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F)
                .noOcclusion()), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Item> setupSignItem(String name, Block signBlock, Block wallSignBlock) {
        return RegHelpers.createBasicItem(new ResourceLocation(MysteriousBiomes.MOD_ID, name),
            () -> new SignItem(new Item.Properties().tab(MysteriousBiomes.ITEM_TAB).stacksTo(16),
                signBlock, wallSignBlock), MysteriousContentSetup.ITEMS);
    }

    //TODO Correct sign strength.
    public static Supplier<Block> setupFloorSignBlock(String name, WoodType signType) {
        return RegHelpers.createBlock(new ResourceLocation(MysteriousBiomes.MOD_ID, name),
            () -> new StandingSignBlock(Block.Properties.copy(Blocks.OAK_SIGN), signType),
            MysteriousContentSetup.BLOCKS);
    }

    public static Supplier<Block> setupWallSignBlock(String woodType, WoodType signType) {
        return RegHelpers.createBlock(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType),
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), signType),
            MysteriousContentSetup.BLOCKS);
    }
}
