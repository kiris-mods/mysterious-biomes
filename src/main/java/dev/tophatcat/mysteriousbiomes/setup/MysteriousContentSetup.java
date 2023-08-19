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
import dev.tophatcat.mysteriousbiomes.blocks.BloodiedGrass;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public final class MysteriousContentSetup {

    public static final Map<Identifier, Supplier<Block>> BLOCKS = new LinkedHashMap<>();
    public static final Map<Identifier, Supplier<Item>> ITEMS = new LinkedHashMap<>();

    public static Supplier<Block> BLOODIED_GRASS = null;
    public static Supplier<Block> BLOODIED_DIRT = null;

    private MysteriousContentSetup() {
        throw new UnsupportedOperationException();
    }

    public static void init() {
        var spookyWoodTypes = List.of(
                MysteriousBlockTypes.BLOODWOOD,
                MysteriousBlockTypes.GHOSTLY,
                MysteriousBlockTypes.SORBUS,
                MysteriousBlockTypes.SEEPING,
                MysteriousBlockTypes.SAKURA);

        spookyWoodTypes.forEach(woodType -> {
            woodType.log = MysteriousHelpers.setupPillarBlock(woodType, "_log");
            woodType.stripped_log = MysteriousHelpers.setupPillarBlock(woodType,
                    "_stripped_log");
            woodType.wood = MysteriousHelpers.setupPillarBlock(woodType, "_wood");
            woodType.stripped_wood = MysteriousHelpers.setupPillarBlock(woodType,
                    "_stripped_wood");
            woodType.planks = MysteriousHelpers.setupPlanksBlock(woodType);
            woodType.stairs = MysteriousHelpers.setupStairsBlock(woodType,
                    woodType.getPlanks().get().getDefaultState());
            woodType.leaves = MysteriousHelpers.setupLeavesBlock(woodType);
            woodType.slab = MysteriousHelpers.setupSlabBlock(woodType);
            woodType.fence = MysteriousHelpers.setupFenceBlock(woodType);
            woodType.gate = MysteriousHelpers.setupGateBlock(woodType);
            woodType.button = MysteriousHelpers.setupButtonBlock(woodType);
            woodType.pressure_plate = MysteriousHelpers.setupPressurePlateBlock(woodType);
            woodType.trapdoor = MysteriousHelpers.setupTrapdoorBlock(woodType);
            woodType.door = MysteriousHelpers.setupDoorBlock(woodType);
        });

        //TODO Change the sapling generators.
        MysteriousBlockTypes.BLOODWOOD.sapling = MysteriousHelpers.setupSaplingBlock("bloodwood_sapling",
                new OakSaplingGenerator());
        MysteriousBlockTypes.GHOSTLY.sapling = MysteriousHelpers.setupSaplingBlock("ghostly_sapling",
                new OakSaplingGenerator());
        MysteriousBlockTypes.SORBUS.sapling = MysteriousHelpers.setupSaplingBlock("sorbus_sapling",
                new OakSaplingGenerator());
        MysteriousBlockTypes.SEEPING.sapling = MysteriousHelpers.setupSaplingBlock("seeping_sapling",
                new OakSaplingGenerator());
        MysteriousBlockTypes.SAKURA.sapling = MysteriousHelpers.setupSaplingBlock("sakura_sapling",
                new OakSaplingGenerator());


        MysteriousBlockTypes.BLOODWOOD.floor_sign = MysteriousHelpers.setupFloorSignBlock("bloodwood_sign",
                MysteriousWoodType.BLOODWOOD_WOOD_TYPE);
        MysteriousBlockTypes.GHOSTLY.floor_sign = MysteriousHelpers.setupFloorSignBlock("ghostly_sign",
                MysteriousWoodType.GHOSTLY_WOOD_TYPE);
        MysteriousBlockTypes.SORBUS.floor_sign = MysteriousHelpers.setupFloorSignBlock("sorbus_sign",
                MysteriousWoodType.SORBUS_WOOD_TYPE);
        MysteriousBlockTypes.SEEPING.floor_sign = MysteriousHelpers.setupFloorSignBlock("seeping_sign",
                MysteriousWoodType.SEEPING_WOOD_TYPE);
        MysteriousBlockTypes.SAKURA.floor_sign = MysteriousHelpers.setupFloorSignBlock("sakura_sign",
                MysteriousWoodType.SAKURA_WOOD_TYPE);


        MysteriousBlockTypes.BLOODWOOD.wall_sign = MysteriousHelpers.setupWallSignBlock("bloodwood_wall_sign",
                MysteriousWoodType.BLOODWOOD_WOOD_TYPE);
        MysteriousBlockTypes.GHOSTLY.wall_sign = MysteriousHelpers.setupWallSignBlock("ghostly_wall_sign",
                MysteriousWoodType.GHOSTLY_WOOD_TYPE);
        MysteriousBlockTypes.SORBUS.wall_sign = MysteriousHelpers.setupWallSignBlock("sorbus_wall_sign",
                MysteriousWoodType.SORBUS_WOOD_TYPE);
        MysteriousBlockTypes.SEEPING.wall_sign = MysteriousHelpers.setupWallSignBlock("seeping_wall_sign",
                MysteriousWoodType.SEEPING_WOOD_TYPE);
        MysteriousBlockTypes.SAKURA.wall_sign = MysteriousHelpers.setupWallSignBlock("sakura_wall_sign",
                MysteriousWoodType.SAKURA_WOOD_TYPE);

        MysteriousBlockTypes.BLOODWOOD.sign = MysteriousHelpers.setupSignItem("bloodwood_sign",
                MysteriousBlockTypes.BLOODWOOD.getFloorSign().get(),
                MysteriousBlockTypes.BLOODWOOD.getWallSign().get());
        MysteriousBlockTypes.GHOSTLY.sign = MysteriousHelpers.setupSignItem("ghostly_sign",
                MysteriousBlockTypes.GHOSTLY.getFloorSign().get(),
                MysteriousBlockTypes.GHOSTLY.getWallSign().get());
        MysteriousBlockTypes.SORBUS.sign = MysteriousHelpers.setupSignItem("sorbus_sign",
                MysteriousBlockTypes.SORBUS.getFloorSign().get(),
                MysteriousBlockTypes.SORBUS.getWallSign().get());
        MysteriousBlockTypes.SEEPING.sign = MysteriousHelpers.setupSignItem("seeping_sign",
                MysteriousBlockTypes.SEEPING.getFloorSign().get(),
                MysteriousBlockTypes.SEEPING.getWallSign().get());
        MysteriousBlockTypes.SAKURA.sign = MysteriousHelpers.setupSignItem("sakura_sign",
                MysteriousBlockTypes.SAKURA.getFloorSign().get(),
                MysteriousBlockTypes.SAKURA.getWallSign().get());

        MysteriousBlockTypes.BLOODWOOD.hanging_sign = MysteriousHelpers.setupHangingSignBlock(
                "bloodwood_hanging_sign", MysteriousWoodType.BLOODWOOD_WOOD_TYPE);
        MysteriousBlockTypes.GHOSTLY.hanging_sign = MysteriousHelpers.setupHangingSignBlock(
                "ghostly_hanging_sign", MysteriousWoodType.GHOSTLY_WOOD_TYPE);
        MysteriousBlockTypes.SORBUS.hanging_sign = MysteriousHelpers.setupHangingSignBlock(
                "sorbus_hanging_sign", MysteriousWoodType.SORBUS_WOOD_TYPE);
        MysteriousBlockTypes.SEEPING.hanging_sign = MysteriousHelpers.setupHangingSignBlock(
                "seeping_hanging_sign", MysteriousWoodType.SEEPING_WOOD_TYPE);
        MysteriousBlockTypes.SAKURA.hanging_sign = MysteriousHelpers.setupHangingSignBlock(
                "sakura_hanging_sign", MysteriousWoodType.SAKURA_WOOD_TYPE);

        MysteriousBlockTypes.BLOODWOOD.wall_hanging_sign = MysteriousHelpers.setupWallHangingSignBlock(
                "bloodwood_wall_hanging_sign", MysteriousWoodType.BLOODWOOD_WOOD_TYPE);
        MysteriousBlockTypes.GHOSTLY.wall_hanging_sign = MysteriousHelpers.setupWallHangingSignBlock(
                "ghostly_wall_hanging_sign", MysteriousWoodType.GHOSTLY_WOOD_TYPE);
        MysteriousBlockTypes.SORBUS.wall_hanging_sign = MysteriousHelpers.setupWallHangingSignBlock(
                "sorbus_wall_hanging_sign", MysteriousWoodType.SORBUS_WOOD_TYPE);
        MysteriousBlockTypes.SEEPING.wall_hanging_sign = MysteriousHelpers.setupWallHangingSignBlock(
                "seeping_wall_hanging_sign", MysteriousWoodType.SEEPING_WOOD_TYPE);
        MysteriousBlockTypes.SAKURA.wall_hanging_sign = MysteriousHelpers.setupWallHangingSignBlock(
                "sakura_wall_hanging_sign", MysteriousWoodType.SAKURA_WOOD_TYPE);

        MysteriousBlockTypes.BLOODWOOD.hanging_sign_item = MysteriousHelpers.setupHangingSignItem(
                "bloodwood_hanging_sign_item", MysteriousBlockTypes.BLOODWOOD.getHangingSign().get(),
                MysteriousBlockTypes.BLOODWOOD.getWallHangingSign().get());
        MysteriousBlockTypes.GHOSTLY.hanging_sign_item = MysteriousHelpers.setupHangingSignItem(
                "ghostly_hanging_sign_item", MysteriousBlockTypes.GHOSTLY.getHangingSign().get(),
                MysteriousBlockTypes.GHOSTLY.getWallHangingSign().get());
        MysteriousBlockTypes.SORBUS.hanging_sign_item = MysteriousHelpers.setupHangingSignItem(
                "sorbus_hanging_sign_item", MysteriousBlockTypes.SORBUS.getHangingSign().get(),
                MysteriousBlockTypes.SORBUS.getWallHangingSign().get());
        MysteriousBlockTypes.SEEPING.hanging_sign_item = MysteriousHelpers.setupHangingSignItem(
                "seeping_hanging_sign_item", MysteriousBlockTypes.SEEPING.getHangingSign().get(),
                MysteriousBlockTypes.SEEPING.getWallHangingSign().get());
        MysteriousBlockTypes.SAKURA.hanging_sign_item = MysteriousHelpers.setupHangingSignItem(
                "sakura_hanging_sign_item", MysteriousBlockTypes.SAKURA.getHangingSign().get(),
                MysteriousBlockTypes.SEEPING.getWallHangingSign().get());

        BLOODIED_GRASS = RegHelpers.createBlockWithItem(new Identifier(MysteriousBiomes.MOD_ID,
                "bloodied_grass"), () -> new BloodiedGrass(Block.Settings
                .copy(Blocks.DIRT).strength(0.5F).sounds(BlockSoundGroup.WET_GRASS).ticksRandomly()), BLOCKS, ITEMS);
        BLOODIED_DIRT = RegHelpers.createBlockWithItem(
                new Identifier(MysteriousBiomes.MOD_ID, "bloodied_dirt"),
                () -> new Block(Block.Settings.copy(Blocks.DIRT).strength(0.5F).sounds(BlockSoundGroup.ROOTED_DIRT)),
                BLOCKS, ITEMS);

        MysteriousHelpers.setupMobEgg("the_forgotten_warlock_spawn_egg",
                new SpawnEggItem(MysteriousBiomes.THE_FORGOTTEN_WARLOCK, 0x0519f7,
                0x161a4a, new Item.Settings()));

        StrippableBlockRegistry.register(MysteriousBlockTypes.BLOODWOOD.log.get(),
                MysteriousBlockTypes.BLOODWOOD.stripped_log.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.BLOODWOOD.wood.get(),
                MysteriousBlockTypes.BLOODWOOD.stripped_wood.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.GHOSTLY.log.get(),
                MysteriousBlockTypes.GHOSTLY.stripped_log.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.GHOSTLY.wood.get(),
                MysteriousBlockTypes.GHOSTLY.stripped_wood.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.SORBUS.log.get(),
                MysteriousBlockTypes.SORBUS.stripped_log.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.SORBUS.wood.get(),
                MysteriousBlockTypes.SORBUS.stripped_wood.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.SEEPING.log.get(),
                MysteriousBlockTypes.SEEPING.stripped_log.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.SEEPING.wood.get(),
                MysteriousBlockTypes.SEEPING.stripped_wood.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.SAKURA.log.get(),
                MysteriousBlockTypes.SAKURA.stripped_log.get());
        StrippableBlockRegistry.register(MysteriousBlockTypes.SAKURA.wood.get(),
                MysteriousBlockTypes.SAKURA.stripped_wood.get());
    }
}
