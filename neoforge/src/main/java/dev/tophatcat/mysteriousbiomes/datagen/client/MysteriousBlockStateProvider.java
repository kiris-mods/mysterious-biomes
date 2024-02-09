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
package dev.tophatcat.mysteriousbiomes.datagen.client;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MysteriousBlockStateProvider extends BlockStateProvider {

    public MysteriousBlockStateProvider(PackOutput output, ExistingFileHelper existingHelper) {
        super(output, MysteriousCommon.MOD_ID, existingHelper);
    }

    protected String getName(Block item) {
        return BuiltInRegistries.BLOCK.getKey(item).getPath();
    }

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(MysteriousRegistry.BLOODIED_GRASS.get())
            .partialState()
            .with(BlockStateProperties.SNOWY, true)
            .modelForState()
            .modelFile(
                models()
                    .withExistingParent(
                        getName(MysteriousRegistry.BLOODIED_GRASS.get()) + "_snow",
                        "minecraft:block/cube_bottom_top")
                    .texture("bottom", modLoc("block/bloodied_dirt"))
                    .texture("side", modLoc("block/bloodied_grass_snow"))
                    .texture("top", modLoc("block/bloodied_grass_top"))
                    .texture("particle", modLoc("block/bloodied_dirt")))
            .addModel()
            .partialState()
            .with(BlockStateProperties.SNOWY, false)
            .modelForState()
            .modelFile(
                models()
                    .withExistingParent(
                        getName(MysteriousRegistry.BLOODIED_GRASS.get()),
                        "minecraft:block/cube_bottom_top")
                    .texture("bottom", modLoc("block/bloodied_dirt"))
                    .texture("side", modLoc("block/bloodied_grass_side"))
                    .texture("top", modLoc("block/bloodied_grass_top"))
                    .texture("particle", modLoc("block/bloodied_dirt")))
            .addModel();
        simpleBlock(MysteriousRegistry.BLOODIED_DIRT.get());

        // Logs
        logBlock(MysteriousRegistry.BLOODWOOD_LOG.get());
        logBlock(MysteriousRegistry.GHOSTLY_LOG.get());
        logBlock(MysteriousRegistry.SEEPING_LOG.get());
        logBlock(MysteriousRegistry.SORBUS_LOG.get());
        // TODO Enable these once we have textures, data generation fails without them.
        // logBlock(MysteriousRegistry.WALNUT_LOG.get());

        // Stripped logs
        logBlock(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get());
        logBlock(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get());
        logBlock(MysteriousRegistry.SEEPING_STRIPPED_LOG.get());
        logBlock(MysteriousRegistry.SORBUS_STRIPPED_LOG.get());
        // TODO Enable these once we have textures, data generation fails without them.
        // logBlock(MysteriousRegistry.WALNUT_STRIPPED_LOG.get());

        // Woods
        simpleBlock(MysteriousRegistry.BLOODWOOD_WOOD.get());
        simpleBlock(MysteriousRegistry.GHOSTLY_WOOD.get());
        simpleBlock(MysteriousRegistry.SEEPING_WOOD.get());
        simpleBlock(MysteriousRegistry.SORBUS_WOOD.get());
        // TODO Enable these once we have textures, data generation fails without them.
        // simpleBlock(MysteriousRegistry.WALNUT_WOOD.get());

        // Stripped woods
        simpleBlock(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get());
        simpleBlock(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get());
        simpleBlock(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get());
        simpleBlock(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get());
        // TODO Enable these once we have textures, data generation fails without them.
        // simpleBlock(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get());

        // Planks
        simpleBlock(MysteriousRegistry.BLOODWOOD_PLANKS.get());
        simpleBlock(MysteriousRegistry.GHOSTLY_PLANKS.get());
        simpleBlock(MysteriousRegistry.SEEPING_PLANKS.get());
        simpleBlock(MysteriousRegistry.SORBUS_PLANKS.get());
        // TODO Enable these once we have textures, data generation fails without them.
        // simpleBlock(MysteriousRegistry.WALNUT_PLANKS.get());

        // Stairs
        stairsBlock(
            MysteriousRegistry.BLOODWOOD_STAIRS.get(),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()));
        stairsBlock(
            MysteriousRegistry.GHOSTLY_STAIRS.get(),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()));
        stairsBlock(
            MysteriousRegistry.SEEPING_STAIRS.get(),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()));
        stairsBlock(
            MysteriousRegistry.SORBUS_STAIRS.get(),
            blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()));
        // TODO Enable these once we have textures, data generation fails without them.
        // stairsBlock(MysteriousRegistry.WALNUT_STAIRS.get(),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()));

        // Leaves
        simpleBlock(MysteriousRegistry.BLOODWOOD_LEAVES.get());
        simpleBlock(MysteriousRegistry.GHOSTLY_LEAVES.get());
        simpleBlock(MysteriousRegistry.SEEPING_LEAVES.get());
        simpleBlock(MysteriousRegistry.SORBUS_LEAVES.get());
        // TODO Enable these once we have textures, data generation fails without them.
        // simpleBlock(MysteriousRegistry.WALNUT_LEAVES.get());

        // Slabs
        slabBlock(
            MysteriousRegistry.BLOODWOOD_SLAB.get(),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()));
        slabBlock(
            MysteriousRegistry.GHOSTLY_SLAB.get(),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()));
        slabBlock(
            MysteriousRegistry.SEEPING_SLAB.get(),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()));
        slabBlock(
            MysteriousRegistry.SORBUS_SLAB.get(),
            blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()),
            blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()));
        // TODO Enable these once we have textures, data generation fails without them.
        // slabBlock(MysteriousRegistry.WALNUT_SLAB.get(),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()));

        // Fences
        fenceBlock(
            MysteriousRegistry.BLOODWOOD_FENCE.get(),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()));
        fenceBlock(
            MysteriousRegistry.GHOSTLY_FENCE.get(),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()));
        fenceBlock(
            MysteriousRegistry.SEEPING_FENCE.get(),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()));
        fenceBlock(
            MysteriousRegistry.SORBUS_FENCE.get(),
            blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()));
        // TODO Enable these once we have textures, data generation fails without them.
        // fenceBlock(MysteriousRegistry.WALNUT_FENCE.get(),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()));

        // Gates
        fenceGateBlock(
            MysteriousRegistry.BLOODWOOD_GATE.get(),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()));
        fenceGateBlock(
            MysteriousRegistry.GHOSTLY_GATE.get(),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()));
        fenceGateBlock(
            MysteriousRegistry.SEEPING_GATE.get(),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()));
        fenceGateBlock(
            MysteriousRegistry.SORBUS_GATE.get(), blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()));
        // TODO Enable these once we have textures, data generation fails without them.
        // fenceGateBlock(MysteriousRegistry.WALNUT_GATE.get(),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()));

        // Buttons
        buttonBlock(
            MysteriousRegistry.BLOODWOOD_BUTTON.get(),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()));
        buttonBlock(
            MysteriousRegistry.GHOSTLY_BUTTON.get(),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()));
        buttonBlock(
            MysteriousRegistry.SEEPING_BUTTON.get(),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()));
        buttonBlock(
            MysteriousRegistry.SORBUS_BUTTON.get(),
            blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()));
        // TODO Enable these once we have textures, data generation fails without them.
        // buttonBlock(MysteriousRegistry.WALNUT_BUTTON.get(),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()));

        // Pressure plates
        pressurePlateBlock(
            MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get(),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()));
        pressurePlateBlock(
            MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get(),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()));
        pressurePlateBlock(
            MysteriousRegistry.SEEPING_PRESSURE_PLATE.get(),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()));
        pressurePlateBlock(
            MysteriousRegistry.SORBUS_PRESSURE_PLATE.get(),
            blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()));
        // TODO Enable these once we have textures, data generation fails without them.
        // pressurePlateBlock(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get(),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()));

        // Trapdoors
        trapdoorBlock(
            MysteriousRegistry.BLOODWOOD_TRAPDOOR.get(), modLoc("block/bloodwood_trapdoor"), true);
        trapdoorBlock(
            MysteriousRegistry.GHOSTLY_TRAPDOOR.get(), modLoc("block/ghostly_trapdoor"), true);
        trapdoorBlock(
            MysteriousRegistry.SEEPING_TRAPDOOR.get(), modLoc("block/seeping_trapdoor"), true);
        trapdoorBlock(MysteriousRegistry.SORBUS_TRAPDOOR.get(), modLoc("block/sorbus_trapdoor"), true);
        // TODO Enable these once we have textures, data generation fails without them.
        // trapdoorBlock(MysteriousRegistry.WALNUT_TRAPDOOR.get(),
        //    modLoc("block/walnut_trapdoor"), true);

        // Doors
        doorBlock(
            MysteriousRegistry.BLOODWOOD_DOOR.get(),
            modLoc("block/bloodwood_door_bottom"),
            modLoc("block/bloodwood_door_top"));
        doorBlock(
            MysteriousRegistry.GHOSTLY_DOOR.get(),
            modLoc("block/ghostly_door_bottom"),
            modLoc("block/ghostly_door_top"));
        doorBlock(
            MysteriousRegistry.SEEPING_DOOR.get(),
            modLoc("block/seeping_door_bottom"),
            modLoc("block/seeping_door_top"));
        doorBlock(
            MysteriousRegistry.SORBUS_DOOR.get(),
            modLoc("block/sorbus_door_bottom"),
            modLoc("block/sorbus_door_top"));
        // TODO Enable these once we have textures, data generation fails without them.
        // doorBlock(MysteriousRegistry.WALNUT_DOOR.get(), modLoc("block/walnut_door_bottom"),
        //    modLoc("block/walnut_door_top"));

        // Saplings
        simpleBlock(
            MysteriousRegistry.BLOODWOOD_SAPLING.get(),
            models()
                .cross("bloodwood_sapling", modLoc("block/bloodwood_sapling"))
                .renderType("cutout"));
        simpleBlock(
            MysteriousRegistry.GHOSTLY_SAPLING.get(),
            models().cross("ghostly_sapling", modLoc("block/ghostly_sapling")).renderType("cutout"));
        simpleBlock(
            MysteriousRegistry.SEEPING_SAPLING.get(),
            models().cross("seeping_sapling", modLoc("block/seeping_sapling")).renderType("cutout"));
        simpleBlock(
            MysteriousRegistry.SORBUS_SAPLING.get(),
            models().cross("sorbus_sapling", modLoc("block/sorbus_sapling")).renderType("cutout"));
        // TODO Enable these once we have textures, data generation fails without them.
        // simpleBlock(MysteriousRegistry.WALNUT_SAPLING.get(), models().cross("walnut_sapling",
        //    modLoc("block/walnut_sapling")).renderType("cutout"));

        // Floor/wall signs
        signBlock(
            MysteriousRegistry.BLOODWOOD_FLOOR_SIGN.get(),
            MysteriousRegistry.BLOODWOOD_WALL_SIGN.get(),
            blockTexture(MysteriousRegistry.BLOODWOOD_PLANKS.get()));
        signBlock(
            MysteriousRegistry.GHOSTLY_FLOOR_SIGN.get(),
            MysteriousRegistry.GHOSTLY_WALL_SIGN.get(),
            blockTexture(MysteriousRegistry.GHOSTLY_PLANKS.get()));
        signBlock(
            MysteriousRegistry.SEEPING_FLOOR_SIGN.get(),
            MysteriousRegistry.SEEPING_WALL_SIGN.get(),
            blockTexture(MysteriousRegistry.SEEPING_PLANKS.get()));
        signBlock(
            MysteriousRegistry.SORBUS_FLOOR_SIGN.get(),
            MysteriousRegistry.SORBUS_WALL_SIGN.get(),
            blockTexture(MysteriousRegistry.SORBUS_PLANKS.get()));
        // TODO Enable these once we have textures, data generation fails without them.
        // signBlock(MysteriousRegistry.WALNUT_FLOOR_SIGN.get(),
        // MysteriousRegistry.WALNUT_WALL_SIGN.get(),
        //    blockTexture(MysteriousRegistry.WALNUT_PLANKS.get()));

        // TODO Enable these once we have textures, data generation fails without them.
        // Hanging signs
        // simpleBlock(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.SEEPING_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.SORBUS_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.WALNUT_HANGING_SIGN.get());

        // TODO Enable these once we have textures, data generation fails without them.
        // Wall hanging signs
        // simpleBlock(MysteriousRegistry.BLOODWOOD_WALL_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.GHOSTLY_WALL_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.SEEPING_WALL_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.SORBUS_WALL_HANGING_SIGN.get());
        // simpleBlock(MysteriousRegistry.WALNUT_WALL_HANGING_SIGN.get());

        // Sign items
        itemModels().basicItem(MysteriousRegistry.BLOODWOOD_SIGN.get());
        itemModels().basicItem(MysteriousRegistry.GHOSTLY_SIGN.get());
        itemModels().basicItem(MysteriousRegistry.SEEPING_SIGN.get());
        itemModels().basicItem(MysteriousRegistry.SORBUS_SIGN.get());
        // TODO Enable these once we have textures, data generation fails without them.
        // itemModels().basicItem(MysteriousRegistry.WALNUT_SIGN.get());
    }
}
