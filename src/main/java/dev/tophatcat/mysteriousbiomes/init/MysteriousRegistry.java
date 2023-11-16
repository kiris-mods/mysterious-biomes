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
package dev.tophatcat.mysteriousbiomes.init;

import dev.tophatcat.kirislib.RegHelpers;
import dev.tophatcat.mysteriousbiomes.blocks.BloodiedGrass;
import dev.tophatcat.mysteriousbiomes.items.CharmOfBloodlust;
import dev.tophatcat.mysteriousbiomes.items.CharmOfMistProtection;
import dev.tophatcat.mysteriousbiomes.items.CharmOfTheElder;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousSignType;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.OakTreeGrower;

import java.util.function.Supplier;

public class MysteriousRegistry {

    private MysteriousRegistry() {
        throw new UnsupportedOperationException("MysteriousRegistry only contains static definitions...");
    }

    public static void init() {
        MysteriousUtils.BLOCKS.forEach((id, block) -> Registry.register(BuiltInRegistries.BLOCK, id, block.get()));
        MysteriousUtils.ITEMS.forEach((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item.get()));
    }

    //Charm items.
    public static final Supplier<Item> CHARM_OF_MIST_PROTECTION = RegHelpers.createBasicItem(
        MysteriousUtils.identifier("charm_of_mist_protection"),
        () -> new CharmOfMistProtection(new Item.Properties()), MysteriousUtils.ITEMS);
    public static final Supplier<Item> CHARM_OF_BLOODLUST = RegHelpers.createBasicItem(
        MysteriousUtils.identifier("charm_of_bloodlust"),
        ()  -> new CharmOfBloodlust(new Item.Properties()), MysteriousUtils.ITEMS);
    public static final Supplier<Item> CHARM_OF_THE_ELDER = RegHelpers.createBasicItem(
        MysteriousUtils.identifier("charm_of_the_elder"),
        () -> new CharmOfTheElder(new Item.Properties()), MysteriousUtils.ITEMS);

    //Misc blocks.
    public static final Supplier<Block> BLOODIED_GRASS = RegHelpers.createBlockWithItem(MysteriousUtils.identifier(
        "bloodied_grass"), () -> new BloodiedGrass(Block.Properties.copy(Blocks.DIRT).strength(0.5F)
        .sound(SoundType.WET_GRASS).randomTicks()), MysteriousUtils.BLOCKS, MysteriousUtils.ITEMS);
    public static final Supplier<Block> BLOODIED_DIRT = RegHelpers.createBlockWithItem(MysteriousUtils.identifier(
        "bloodied_dirt"), () -> new Block(Block.Properties.copy(Blocks.DIRT).strength(0.5F)
        .sound(SoundType.ROOTED_DIRT)), MysteriousUtils.BLOCKS, MysteriousUtils.ITEMS);

    //Bloodwood tree family.
    public static final Supplier<Block> BLOODWOOD_LOG
        = MysteriousUtils.makePillarBlock("bloodwood_log");
    public static final Supplier<Block> BLOODWOOD_STRIPPED_LOG
        = MysteriousUtils.makePillarBlock("bloodwood_stripped_log");
    public static final Supplier<Block> BLOODWOOD_WOOD
        = MysteriousUtils.makePillarBlock("bloodwood_wood");
    public static final Supplier<Block> BLOODWOOD_STRIPPED_WOOD
        = MysteriousUtils.makePillarBlock("bloodwood_stripped_wood");
    public static final Supplier<Block> BLOODWOOD_PLANKS
        = MysteriousUtils.makePlanksBlock("bloodwood_planks");
    public static final Supplier<Block> BLOODWOOD_STAIRS
        = MysteriousUtils.makeStairsBlock("bloodwood_stairs", BLOODWOOD_PLANKS.get().defaultBlockState());
    public static final Supplier<Block> BLOODWOOD_LEAVES
        = MysteriousUtils.makeLeavesBlock("bloodwood_leaves");
    public static final Supplier<Block> BLOODWOOD_SLAB
        = MysteriousUtils.makeSlabBlock("bloodwood_slab");
    public static final Supplier<Block> BLOODWOOD_FENCE
        = MysteriousUtils.makeFenceBlock("bloodwood_fence");
    public static final Supplier<Block> BLOODWOOD_GATE
        = MysteriousUtils.makeGateBlock("bloodwood_gate");
    public static final Supplier<Block> BLOODWOOD_BUTTON
        = MysteriousUtils.makeButtonBlock("bloodwood_button");
    public static final Supplier<Block> BLOODWOOD_PRESSURE_PLATE
        = MysteriousUtils.makePressurePlateBlock("bloodwood_pressure_plate");
    public static final Supplier<Block> BLOODWOOD_TRAPDOOR
        = MysteriousUtils.makeTrapdoorBlock("bloodwood_trapdoor");
    public static final Supplier<Block> BLOODWOOD_DOOR
        = MysteriousUtils.makeDoorBlock("bloodwood_door");
    public static final Supplier<Block> BLOODWOOD_SAPLING
        = MysteriousUtils.makeSaplingBlock("bloodwood_sapling", new OakTreeGrower());
    public static final Supplier<Block> BLOODWOOD_FLOOR_SIGN
        = MysteriousUtils.makeFloorSignBlock("bloodwood_sign", MysteriousSignType.BLOODWOOD_SIGN_TYPE);
    public static final Supplier<Block> BLOODWOOD_WALL_SIGN
        = MysteriousUtils.makeWallSignBlock("bloodwood_wall_sign", MysteriousSignType.BLOODWOOD_SIGN_TYPE);
    public static final Supplier<Item> BLOODWOOD_SIGN
        = MysteriousUtils.makeSignItem("bloodwood_sign", BLOODWOOD_FLOOR_SIGN.get(), BLOODWOOD_WALL_SIGN.get());
    public static final Supplier<Block> BLOODWOOD_HANGING_SIGN
        = MysteriousUtils.makeHangingSignBlock("bloodwood_hanging_sign", MysteriousSignType.BLOODWOOD_SIGN_TYPE);
    public static final Supplier<Block> BLOODWOOD_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock("bloodwood_wall_hanging_sign",
        MysteriousSignType.BLOODWOOD_SIGN_TYPE);
    public static final Supplier<Item> BLOODWOOD_HANGING_SIGN_ITEM
        = MysteriousUtils.makeHangingSignItem("bloodwood_hanging_sign_item", BLOODWOOD_HANGING_SIGN.get(),
        BLOODWOOD_WALL_HANGING_SIGN.get());

    //Ghostly tree family.
    public static final Supplier<Block> GHOSTLY_LOG
        = MysteriousUtils.makePillarBlock("ghostly_log");
    public static final Supplier<Block> GHOSTLY_STRIPPED_LOG
        = MysteriousUtils.makePillarBlock("ghostly_stripped_log");
    public static final Supplier<Block> GHOSTLY_WOOD
        = MysteriousUtils.makePillarBlock("ghostly_wood");
    public static final Supplier<Block> GHOSTLY_STRIPPED_WOOD
        = MysteriousUtils.makePillarBlock("ghostly_stripped_wood");
    public static final Supplier<Block> GHOSTLY_PLANKS
        = MysteriousUtils.makePlanksBlock("ghostly_planks");
    public static final Supplier<Block> GHOSTLY_STAIRS
        = MysteriousUtils.makeStairsBlock("ghostly_stairs", GHOSTLY_PLANKS.get().defaultBlockState());
    public static final Supplier<Block> GHOSTLY_LEAVES
        = MysteriousUtils.makeLeavesBlock("ghostly_leaves");
    public static final Supplier<Block> GHOSTLY_SLAB
        = MysteriousUtils.makeSlabBlock("ghostly_slab");
    public static final Supplier<Block> GHOSTLY_FENCE
        = MysteriousUtils.makeFenceBlock("ghostly_fence");
    public static final Supplier<Block> GHOSTLY_GATE
        = MysteriousUtils.makeGateBlock("ghostly_gate");
    public static final Supplier<Block> GHOSTLY_BUTTON
        = MysteriousUtils.makeButtonBlock("ghostly_button");
    public static final Supplier<Block> GHOSTLY_PRESSURE_PLATE
        = MysteriousUtils.makePressurePlateBlock("ghostly_pressure_plate");
    public static final Supplier<Block> GHOSTLY_TRAPDOOR
        = MysteriousUtils.makeTrapdoorBlock("ghostly_trapdoor");
    public static final Supplier<Block> GHOSTLY_DOOR
        = MysteriousUtils.makeDoorBlock("ghostly_door");
    public static final Supplier<Block> GHOSTLY_SAPLING
        = MysteriousUtils.makeSaplingBlock("ghostly_sapling", new OakTreeGrower());
    public static final Supplier<Block> GHOSTLY_FLOOR_SIGN
        = MysteriousUtils.makeFloorSignBlock("ghostly_sign", MysteriousSignType.GHOSTLY_SIGN_TYPE);
    public static final Supplier<Block> GHOSTLY_WALL_SIGN
        = MysteriousUtils.makeWallSignBlock("ghostly_wall_sign", MysteriousSignType.GHOSTLY_SIGN_TYPE);
    public static final Supplier<Item> GHOSTLY_SIGN
        = MysteriousUtils.makeSignItem("ghostly_sign", GHOSTLY_FLOOR_SIGN.get(), GHOSTLY_WALL_SIGN.get());
    public static final Supplier<Block> GHOSTLY_HANGING_SIGN
        = MysteriousUtils.makeHangingSignBlock("ghostly_hanging_sign", MysteriousSignType.GHOSTLY_SIGN_TYPE);
    public static final Supplier<Block> GHOSTLY_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock("ghostly_wall_hanging_sign",
        MysteriousSignType.GHOSTLY_SIGN_TYPE);
    public static final Supplier<Item> GHOSTLY_HANGING_SIGN_ITEM
        = MysteriousUtils.makeHangingSignItem("ghostly_hanging_sign_item", GHOSTLY_HANGING_SIGN.get(),
        GHOSTLY_WALL_HANGING_SIGN.get());

    //Seeping tree family.
    public static final Supplier<Block> SEEPING_LOG
        = MysteriousUtils.makePillarBlock("seeping_log");
    public static final Supplier<Block> SEEPING_STRIPPED_LOG
        = MysteriousUtils.makePillarBlock("seeping_stripped_log");
    public static final Supplier<Block> SEEPING_WOOD
        = MysteriousUtils.makePillarBlock("seeping_wood");
    public static final Supplier<Block> SEEPING_STRIPPED_WOOD
        = MysteriousUtils.makePillarBlock("seeping_stripped_wood");
    public static final Supplier<Block> SEEPING_PLANKS
        = MysteriousUtils.makePlanksBlock("seeping_planks");
    public static final Supplier<Block> SEEPING_STAIRS
        = MysteriousUtils.makeStairsBlock("seeping_stairs", SEEPING_PLANKS.get().defaultBlockState());
    public static final Supplier<Block> SEEPING_LEAVES
        = MysteriousUtils.makeLeavesBlock("seeping_leaves");
    public static final Supplier<Block> SEEPING_SLAB
        = MysteriousUtils.makeSlabBlock("seeping_slab");
    public static final Supplier<Block> SEEPING_FENCE
        = MysteriousUtils.makeFenceBlock("seeping_fence");
    public static final Supplier<Block> SEEPING_GATE
        = MysteriousUtils.makeGateBlock("seeping_gate");
    public static final Supplier<Block> SEEPING_BUTTON
        = MysteriousUtils.makeButtonBlock("seeping_button");
    public static final Supplier<Block> SEEPING_PRESSURE_PLATE
        = MysteriousUtils.makePressurePlateBlock("seeping_pressure_plate");
    public static final Supplier<Block> SEEPING_TRAPDOOR
        = MysteriousUtils.makeTrapdoorBlock("seeping_trapdoor");
    public static final Supplier<Block> SEEPING_DOOR
        = MysteriousUtils.makeDoorBlock("seeping_door");
    public static final Supplier<Block> SEEPING_SAPLING
        = MysteriousUtils.makeSaplingBlock("seeping_sapling", new OakTreeGrower());
    public static final Supplier<Block> SEEPING_FLOOR_SIGN
        = MysteriousUtils.makeFloorSignBlock("seeping_sign", MysteriousSignType.SEEPING_SIGN_TYPE);
    public static final Supplier<Block> SEEPING_WALL_SIGN
        = MysteriousUtils.makeWallSignBlock("seeping_wall_sign", MysteriousSignType.SEEPING_SIGN_TYPE);
    public static final Supplier<Item> SEEPING_SIGN
        = MysteriousUtils.makeSignItem("seeping_sign", SEEPING_FLOOR_SIGN.get(), SEEPING_WALL_SIGN.get());
    public static final Supplier<Block> SEEPING_HANGING_SIGN
        = MysteriousUtils.makeHangingSignBlock("seeping_hanging_sign", MysteriousSignType.SEEPING_SIGN_TYPE);
    public static final Supplier<Block> SEEPING_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock("seeping_wall_hanging_sign",
        MysteriousSignType.SEEPING_SIGN_TYPE);
    public static final Supplier<Item> SEEPING_HANGING_SIGN_ITEM
        = MysteriousUtils.makeHangingSignItem("seeping_hanging_sign_item", SEEPING_HANGING_SIGN.get(),
        SEEPING_WALL_HANGING_SIGN.get());

    //Sorbus tree family.
    public static final Supplier<Block> SORBUS_LOG
        = MysteriousUtils.makePillarBlock("sorbus_log");
    public static final Supplier<Block> SORBUS_STRIPPED_LOG
        = MysteriousUtils.makePillarBlock("sorbus_stripped_log");
    public static final Supplier<Block> SORBUS_WOOD
        = MysteriousUtils.makePillarBlock("sorbus_wood");
    public static final Supplier<Block> SORBUS_STRIPPED_WOOD
        = MysteriousUtils.makePillarBlock("sorbus_stripped_wood");
    public static final Supplier<Block> SORBUS_PLANKS
        = MysteriousUtils.makePlanksBlock("sorbus_planks");
    public static final Supplier<Block> SORBUS_STAIRS
        = MysteriousUtils.makeStairsBlock("sorbus_stairs", SORBUS_PLANKS.get().defaultBlockState());
    public static final Supplier<Block> SORBUS_LEAVES
        = MysteriousUtils.makeLeavesBlock("sorbus_leaves");
    public static final Supplier<Block> SORBUS_SLAB
        = MysteriousUtils.makeSlabBlock("sorbus_slab");
    public static final Supplier<Block> SORBUS_FENCE
        = MysteriousUtils.makeFenceBlock("sorbus_fence");
    public static final Supplier<Block> SORBUS_GATE
        = MysteriousUtils.makeGateBlock("sorbus_gate");
    public static final Supplier<Block> SORBUS_BUTTON
        = MysteriousUtils.makeButtonBlock("sorbus_button");
    public static final Supplier<Block> SORBUS_PRESSURE_PLATE
        = MysteriousUtils.makePressurePlateBlock("sorbus_pressure_plate");
    public static final Supplier<Block> SORBUS_TRAPDOOR
        = MysteriousUtils.makeTrapdoorBlock("sorbus_trapdoor");
    public static final Supplier<Block> SORBUS_DOOR
        = MysteriousUtils.makeDoorBlock("sorbus_door");
    public static final Supplier<Block> SORBUS_SAPLING
        = MysteriousUtils.makeSaplingBlock("sorbus_sapling", new OakTreeGrower());
    public static final Supplier<Block> SORBUS_FLOOR_SIGN
        = MysteriousUtils.makeFloorSignBlock("sorbus_sign", MysteriousSignType.SORBUS_SIGN_TYPE);
    public static final Supplier<Block> SORBUS_WALL_SIGN
        = MysteriousUtils.makeWallSignBlock("sorbus_wall_sign", MysteriousSignType.SORBUS_SIGN_TYPE);
    public static final Supplier<Item> SORBUS_SIGN
        = MysteriousUtils.makeSignItem("sorbus_sign", SORBUS_FLOOR_SIGN.get(), SORBUS_WALL_SIGN.get());
    public static final Supplier<Block> SORBUS_HANGING_SIGN
        = MysteriousUtils.makeHangingSignBlock("sorbus_hanging_sign", MysteriousSignType.SORBUS_SIGN_TYPE);
    public static final Supplier<Block> SORBUS_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock("sorbus_wall_hanging_sign",
        MysteriousSignType.SORBUS_SIGN_TYPE);
    public static final Supplier<Item> SORBUS_HANGING_SIGN_ITEM
        = MysteriousUtils.makeHangingSignItem("sorbus_hanging_sign_item", SORBUS_HANGING_SIGN.get(),
        SORBUS_WALL_HANGING_SIGN.get());

    //Walnut tree family.
    public static final Supplier<Block> WALNUT_LOG
        = MysteriousUtils.makePillarBlock("walnut_log");
    public static final Supplier<Block> WALNUT_STRIPPED_LOG
        = MysteriousUtils.makePillarBlock("walnut_stripped_log");
    public static final Supplier<Block> WALNUT_WOOD
        = MysteriousUtils.makePillarBlock("walnut_wood");
    public static final Supplier<Block> WALNUT_STRIPPED_WOOD
        = MysteriousUtils.makePillarBlock("walnut_stripped_wood");
    public static final Supplier<Block> WALNUT_PLANKS
        = MysteriousUtils.makePlanksBlock("walnut_planks");
    public static final Supplier<Block> WALNUT_STAIRS
        = MysteriousUtils.makeStairsBlock("walnut_stairs", WALNUT_PLANKS.get().defaultBlockState());
    public static final Supplier<Block> WALNUT_LEAVES
        = MysteriousUtils.makeLeavesBlock("walnut_leaves");
    public static final Supplier<Block> WALNUT_SLAB
        = MysteriousUtils.makeSlabBlock("walnut_slab");
    public static final Supplier<Block> WALNUT_FENCE
        = MysteriousUtils.makeFenceBlock("walnut_fence");
    public static final Supplier<Block> WALNUT_GATE
        = MysteriousUtils.makeGateBlock("walnut_gate");
    public static final Supplier<Block> WALNUT_BUTTON
        = MysteriousUtils.makeButtonBlock("walnut_button");
    public static final Supplier<Block> WALNUT_PRESSURE_PLATE
        = MysteriousUtils.makePressurePlateBlock("walnut_pressure_plate");
    public static final Supplier<Block> WALNUT_TRAPDOOR
        = MysteriousUtils.makeTrapdoorBlock("walnut_trapdoor");
    public static final Supplier<Block> WALNUT_DOOR
        = MysteriousUtils.makeDoorBlock("walnut_door");
    public static final Supplier<Block> WALNUT_SAPLING
        = MysteriousUtils.makeSaplingBlock("walnut_sapling", new OakTreeGrower());
    public static final Supplier<Block> WALNUT_FLOOR_SIGN
        = MysteriousUtils.makeFloorSignBlock("walnut_sign", MysteriousSignType.WALNUT_SIGN_TYPE);
    public static final Supplier<Block> WALNUT_WALL_SIGN
        = MysteriousUtils.makeWallSignBlock("walnut_wall_sign", MysteriousSignType.WALNUT_SIGN_TYPE);
    public static final Supplier<Item> WALNUT_SIGN
        = MysteriousUtils.makeSignItem("walnut_sign", WALNUT_FLOOR_SIGN.get(), WALNUT_WALL_SIGN.get());
    public static final Supplier<Block> WALNUT_HANGING_SIGN
        = MysteriousUtils.makeHangingSignBlock("walnut_hanging_sign", MysteriousSignType.WALNUT_SIGN_TYPE);
    public static final Supplier<Block> WALNUT_WALL_HANGING_SIGN
        = MysteriousUtils.makeWallHangingSignBlock("walnut_wall_hanging_sign",
        MysteriousSignType.WALNUT_SIGN_TYPE);
    public static final Supplier<Item> WALNUT_HANGING_SIGN_ITEM
        = MysteriousUtils.makeHangingSignItem("walnut_hanging_sign_item", WALNUT_HANGING_SIGN.get(),
        WALNUT_WALL_HANGING_SIGN.get());
}
