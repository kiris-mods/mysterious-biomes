/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2025
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
package dev.tophatcat.mysteriousbiomes.data.client;

import dev.tophatcat.mysteriouslands.MysteriousLandsCommon;
import dev.tophatcat.mysteriouslands.registry.BlockRegistry;
import dev.tophatcat.mysteriouslands.registry.ItemRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MysteriousBlockStateProvider extends BlockStateProvider {

    public MysteriousBlockStateProvider(PackOutput output) {
    }

    protected String getName(Block item) {
        return BuiltInRegistries.BLOCK.getKey(item).getPath();
    }

    public void hangingSignBlock(CeilingHangingSignBlock signBlock, WallHangingSignBlock wallSignBlock, ResourceLocation texture) {
        ModelFile sign = this.models().sign(getName(signBlock), texture);
        this.hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(CeilingHangingSignBlock signBlock, WallHangingSignBlock wallSignBlock, ModelFile sign) {
        this.simpleBlock(signBlock, sign);
        this.simpleBlock(wallSignBlock, sign);
    }

    @Override
    protected void registerStatesAndModels() {
        // Logs
        logBlock(BlockRegistry.BLOOD_SOAKED_LOG.get());
        logBlock(BlockRegistry.GHOSTLY_LOG.get());
        logBlock(BlockRegistry.SEEPING_LOG.get());
        logBlock(BlockRegistry.SORBUS_LOG.get());
        logBlock(BlockRegistry.WALNUT_LOG.get());

        // Stripped logs
        logBlock(BlockRegistry.BLOOD_SOAKED_STRIPPED_LOG.get());
        logBlock(BlockRegistry.GHOSTLY_STRIPPED_LOG.get());
        logBlock(BlockRegistry.SEEPING_STRIPPED_LOG.get());
        logBlock(BlockRegistry.SORBUS_STRIPPED_LOG.get());
        logBlock(BlockRegistry.WALNUT_STRIPPED_LOG.get());

        // Woods
        simpleBlock(BlockRegistry.BLOOD_SOAKED_WOOD.get());
        simpleBlock(BlockRegistry.GHOSTLY_WOOD.get());
        simpleBlock(BlockRegistry.SEEPING_WOOD.get());
        simpleBlock(BlockRegistry.SORBUS_WOOD.get());
        simpleBlock(BlockRegistry.WALNUT_WOOD.get());

        // Stripped woods
        simpleBlock(BlockRegistry.BLOOD_SOAKED_STRIPPED_WOOD.get());
        simpleBlock(BlockRegistry.GHOSTLY_STRIPPED_WOOD.get());
        simpleBlock(BlockRegistry.SEEPING_STRIPPED_WOOD.get());
        simpleBlock(BlockRegistry.SORBUS_STRIPPED_WOOD.get());
        simpleBlock(BlockRegistry.WALNUT_STRIPPED_WOOD.get());

        // Planks
        simpleBlock(BlockRegistry.BLOOD_SOAKED_PLANKS.get());
        simpleBlock(BlockRegistry.GHOSTLY_PLANKS.get());
        simpleBlock(BlockRegistry.SEEPING_PLANKS.get());
        simpleBlock(BlockRegistry.SORBUS_PLANKS.get());
        simpleBlock(BlockRegistry.WALNUT_PLANKS.get());

        // Stairs
        stairsBlock(BlockRegistry.BLOOD_SOAKED_STAIRS.get(), blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        stairsBlock(BlockRegistry.GHOSTLY_STAIRS.get(), blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        stairsBlock(BlockRegistry.SEEPING_STAIRS.get(), blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        stairsBlock(BlockRegistry.SORBUS_STAIRS.get(), blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        stairsBlock(BlockRegistry.WALNUT_STAIRS.get(), blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Leaves
        simpleBlock(BlockRegistry.BLOOD_SOAKED_LEAVES.get());
        simpleBlock(BlockRegistry.GHOSTLY_LEAVES.get());
        simpleBlock(BlockRegistry.SEEPING_LEAVES.get());
        simpleBlock(BlockRegistry.SORBUS_LEAVES.get());
        simpleBlock(BlockRegistry.WALNUT_LEAVES.get());

        // Slabs
        slabBlock(BlockRegistry.BLOOD_SOAKED_SLAB.get(), blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()),
            blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        slabBlock(BlockRegistry.GHOSTLY_SLAB.get(), blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()),
            blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        slabBlock(BlockRegistry.SEEPING_SLAB.get(), blockTexture(BlockRegistry.SEEPING_PLANKS.get()),
            blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        slabBlock(BlockRegistry.SORBUS_SLAB.get(), blockTexture(BlockRegistry.SORBUS_PLANKS.get()),
            blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        slabBlock(BlockRegistry.WALNUT_SLAB.get(), blockTexture(BlockRegistry.WALNUT_PLANKS.get()),
            blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Fences
        fenceBlock(BlockRegistry.BLOOD_SOAKED_FENCE.get(), blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        fenceBlock(BlockRegistry.GHOSTLY_FENCE.get(), blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        fenceBlock(BlockRegistry.SEEPING_FENCE.get(), blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        fenceBlock(BlockRegistry.SORBUS_FENCE.get(), blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        fenceBlock(BlockRegistry.WALNUT_FENCE.get(), blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Gates
        fenceGateBlock(BlockRegistry.BLOOD_SOAKED_GATE.get(), blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        fenceGateBlock(BlockRegistry.GHOSTLY_GATE.get(), blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        fenceGateBlock(BlockRegistry.SEEPING_GATE.get(), blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        fenceGateBlock(BlockRegistry.SORBUS_GATE.get(), blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        fenceGateBlock(BlockRegistry.WALNUT_GATE.get(), blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Buttons
        buttonBlock(BlockRegistry.BLOOD_SOAKED_BUTTON.get(), blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        buttonBlock(BlockRegistry.GHOSTLY_BUTTON.get(), blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        buttonBlock(BlockRegistry.SEEPING_BUTTON.get(), blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        buttonBlock(BlockRegistry.SORBUS_BUTTON.get(), blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        buttonBlock(BlockRegistry.WALNUT_BUTTON.get(), blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Pressure plates
        pressurePlateBlock(BlockRegistry.BLOOD_SOAKED_PRESSURE_PLATE.get(),
            blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        pressurePlateBlock(BlockRegistry.GHOSTLY_PRESSURE_PLATE.get(),
            blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        pressurePlateBlock(BlockRegistry.SEEPING_PRESSURE_PLATE.get(),
            blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        pressurePlateBlock(BlockRegistry.SORBUS_PRESSURE_PLATE.get(),
            blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        pressurePlateBlock(BlockRegistry.WALNUT_PRESSURE_PLATE.get(),
            blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Trapdoors
        trapdoorBlockWithRenderType(BlockRegistry.BLOOD_SOAKED_TRAPDOOR.get(),
            modLoc("block/blood_soaked_trapdoor"), true, RenderType.CUTOUT.name);
        trapdoorBlockWithRenderType(BlockRegistry.GHOSTLY_TRAPDOOR.get(),
            modLoc("block/ghostly_trapdoor"), true, RenderType.CUTOUT.name);
        trapdoorBlockWithRenderType(BlockRegistry.SEEPING_TRAPDOOR.get(),
            modLoc("block/seeping_trapdoor"), true, RenderType.CUTOUT.name);
        trapdoorBlockWithRenderType(BlockRegistry.SORBUS_TRAPDOOR.get(),
            modLoc("block/sorbus_trapdoor"), true, RenderType.CUTOUT.name);
        trapdoorBlockWithRenderType(BlockRegistry.WALNUT_TRAPDOOR.get(),
            modLoc("block/walnut_trapdoor"), true, RenderType.CUTOUT.name);

        // Doors
        doorBlockWithRenderType(BlockRegistry.BLOOD_SOAKED_DOOR.get(), modLoc("block/blood_soaked_door_bottom"),
            modLoc("block/blood_soaked_door_top"), RenderType.CUTOUT.name);
        doorBlockWithRenderType(BlockRegistry.GHOSTLY_DOOR.get(), modLoc("block/ghostly_door_bottom"),
            modLoc("block/ghostly_door_top"), RenderType.CUTOUT.name);
        doorBlockWithRenderType(BlockRegistry.SEEPING_DOOR.get(), modLoc("block/seeping_door_bottom"),
            modLoc("block/seeping_door_top"), RenderType.CUTOUT.name);
        doorBlockWithRenderType(BlockRegistry.SORBUS_DOOR.get(), modLoc("block/sorbus_door_bottom"),
            modLoc("block/sorbus_door_top"), RenderType.CUTOUT.name);
        doorBlockWithRenderType(BlockRegistry.WALNUT_DOOR.get(), modLoc("block/walnut_door_bottom"),
            modLoc("block/walnut_door_top"), RenderType.CUTOUT.name);

        // Saplings
        simpleBlock(BlockRegistry.BLOOD_SOAKED_SAPLING.get(), models().cross("blood_soaked_sapling",
            modLoc("block/blood_soaked_sapling")).renderType(RenderType.CUTOUT.name));
        simpleBlock(BlockRegistry.GHOSTLY_SAPLING.get(), models().cross("ghostly_sapling",
            modLoc("block/ghostly_sapling")).renderType(RenderType.CUTOUT.name));
        simpleBlock(BlockRegistry.SEEPING_SAPLING.get(), models().cross("seeping_sapling",
            modLoc("block/seeping_sapling")).renderType(RenderType.CUTOUT.name));
        simpleBlock(BlockRegistry.SORBUS_SAPLING.get(), models().cross("sorbus_sapling",
            modLoc("block/sorbus_sapling")).renderType(RenderType.CUTOUT.name));
        simpleBlock(BlockRegistry.WALNUT_SAPLING.get(), models().cross("walnut_sapling",
            modLoc("block/walnut_sapling")).renderType(RenderType.CUTOUT.name));

        // Floor/wall signs
        signBlock(BlockRegistry.BLOOD_SOAKED_FLOOR_SIGN.get(), BlockRegistry.BLOOD_SOAKED_WALL_SIGN.get(),
            blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        signBlock(BlockRegistry.GHOSTLY_FLOOR_SIGN.get(), BlockRegistry.GHOSTLY_WALL_SIGN.get(),
            blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        signBlock(BlockRegistry.SEEPING_FLOOR_SIGN.get(), BlockRegistry.SEEPING_WALL_SIGN.get(),
            blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        signBlock(BlockRegistry.SORBUS_FLOOR_SIGN.get(), BlockRegistry.SORBUS_WALL_SIGN.get(),
            blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        signBlock(BlockRegistry.WALNUT_FLOOR_SIGN.get(), BlockRegistry.WALNUT_WALL_SIGN.get(),
            blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Hanging signs
        hangingSignBlock(BlockRegistry.BLOOD_SOAKED_HANGING_SIGN.get(),
            BlockRegistry.BLOOD_SOAKED_WALL_HANGING_SIGN.get(),
            blockTexture(BlockRegistry.BLOOD_SOAKED_PLANKS.get()));
        hangingSignBlock(BlockRegistry.GHOSTLY_HANGING_SIGN.get(),
            BlockRegistry.GHOSTLY_WALL_HANGING_SIGN.get(),
            blockTexture(BlockRegistry.GHOSTLY_PLANKS.get()));
        hangingSignBlock(BlockRegistry.SEEPING_HANGING_SIGN.get(),
            BlockRegistry.SEEPING_WALL_HANGING_SIGN.get(),
            blockTexture(BlockRegistry.SEEPING_PLANKS.get()));
        hangingSignBlock(BlockRegistry.SORBUS_HANGING_SIGN.get(),
            BlockRegistry.SORBUS_WALL_HANGING_SIGN.get(),
            blockTexture(BlockRegistry.SORBUS_PLANKS.get()));
        hangingSignBlock(BlockRegistry.WALNUT_HANGING_SIGN.get(),
            BlockRegistry.WALNUT_WALL_HANGING_SIGN.get(),
            blockTexture(BlockRegistry.WALNUT_PLANKS.get()));

        // Sign items
        itemModels().basicItem(ItemRegistry.BLOOD_SOAKED_SIGN.get());
        itemModels().basicItem(ItemRegistry.GHOSTLY_SIGN.get());
        itemModels().basicItem(ItemRegistry.SEEPING_SIGN.get());
        itemModels().basicItem(ItemRegistry.SORBUS_SIGN.get());
        itemModels().basicItem(ItemRegistry.WALNUT_SIGN.get());
    }

    @Override
    protected BlockStateProviderType<?> type() {
        return null;
    }

    @Override
    public BlockState getState(RandomSource randomSource, BlockPos blockPos) {
        return null;
    }
}
