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
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class MysteriousSetupHelpers {

    public static Supplier<Block> setupCraftingTableBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()),
            () -> new CraftingTableBlock(Block.Properties.of(Material.WOOD)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSaplingBlock(String name, AbstractTreeGrower generator) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, name),
            () -> new SaplingBlock(generator, Block.Properties.of(Material.WOOD)
                .randomTicks().noCollission()), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPillarBlock(WoodType woodType, String blockType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + blockType), () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).strength(2.0F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPlanksBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_planks"), () -> new Block(Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupStairsBlock(WoodType woodType, BlockState blockState) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_stairs"), () -> new StairBlock(blockState, Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupLeavesBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_leaves"), () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F)
                .noOcclusion()), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSlabBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_slab"), () -> new SlabBlock(Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupFenceBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_fence"), () -> new FenceBlock(Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F)), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupGateBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_gate"), () -> new FenceGateBlock(Block.Properties.of(Material.WOOD)
                .strength(2.0F, 3.0F), woodType),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupButtonBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_button"), () -> new ButtonBlock(Block.Properties.of(Material.WOOD).strength(0.5F)),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPressurePlateBlock(WoodType woodType, BlockSetType setType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_pressure_plate"), () -> new PressurePlateBlock(PressurePlateBlock
                .Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).strength(0.5F), setType),
            MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupTrapdoorBlock(WoodType woodType, BlockSetType setType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
            + "_trapdoor"), () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD)
            .strength(3.0F).noOcclusion(), setType), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupDoorBlock(WoodType woodType, BlockSetType setType) {
        return RegHelpers.createBlockWithItem(new ResourceLocation(MysteriousBiomes.MOD_ID, woodType.name()
                + "_door"), () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F)
                .noOcclusion(), setType), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Item> setupSignItem(String name, Block signBlock, Block wallSignBlock) {
        return RegHelpers.createBasicItem(new ResourceLocation(MysteriousBiomes.MOD_ID, name),
            () -> new SignItem(new Item.Properties().stacksTo(16),
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
