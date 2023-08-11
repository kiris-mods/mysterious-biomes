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
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class MysteriousSetupHelpers {

    public static Supplier<Block> setupCraftingTableBlock(WoodType woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType.name()),
                () -> new CraftingTableBlock(Block.Settings.copy(Blocks.CRAFTING_TABLE)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSaplingBlock(String name, SaplingGenerator generator) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, name),
                () -> new SaplingBlock(generator, Block.Settings.copy(Blocks.OAK_SAPLING)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPillarBlock(String woodType, String blockType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + blockType), () -> new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPlanksBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_planks"), () -> new Block(Block.Settings.copy(Blocks.OAK_PLANKS)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupStairsBlock(String woodType, BlockState blockState) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_stairs"), () -> new StairsBlock(blockState, Block.Settings.copy(Blocks.OAK_STAIRS)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupLeavesBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_leaves"), () -> new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupSlabBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_slab"), () -> new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupFenceBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_fence"), () -> new FenceBlock(Block.Settings.copy(Blocks.OAK_FENCE)),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupGateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_gate"), () -> new FenceGateBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupButtonBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_button"), () -> new ButtonBlock(Block.Settings.copy(Blocks.OAK_BUTTON), BlockSetType.OAK,
                        30, true),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupPressurePlateBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_pressure_plate"), () -> new PressurePlateBlock(PressurePlateBlock
                        .ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupTrapdoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                        + "_trapdoor"), () -> new TrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK),
                MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Block> setupDoorBlock(String woodType) {
        return RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID, woodType
                + "_door"), () -> new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR).strength(3.0F)
                .nonOpaque(), BlockSetType.OAK), MysteriousContentSetup.BLOCKS, MysteriousContentSetup.ITEMS);
    }

    public static Supplier<Item> setupSignItem(String name, Block signBlock, Block wallSignBlock) {
        return RegHelpers.createBasicItem(new Identifier(MysteriousBiomes.MOD_ID, name),
                () -> new SignItem(new Item.Settings().maxCount(16),
                        signBlock, wallSignBlock), MysteriousContentSetup.ITEMS);
    }

    //TODO Correct sign strength.
    public static Supplier<Block> setupFloorSignBlock(String name, WoodType signType) {
        return RegHelpers.createBlock(new Identifier(MysteriousBiomes.MOD_ID, name),
                () -> new SignBlock(Block.Settings.copy(Blocks.OAK_SIGN), signType),
                MysteriousContentSetup.BLOCKS);
    }

    public static Supplier<Block> setupWallSignBlock(String woodType, WoodType signType) {
        return RegHelpers.createBlock(new Identifier(MysteriousBiomes.MOD_ID, woodType),
                () -> new WallSignBlock(Block.Settings.copy(Blocks.OAK_WALL_SIGN), signType),
                MysteriousContentSetup.BLOCKS);
    }
}
