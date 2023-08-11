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
package dev.tophatcat.mysteriousbiomes.datagen;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;

public class BlockModelGenerator extends FabricModelProvider {

    private static final BlockFamily BLOODWOOD = fromWoodType(MysteriousWoodTypes.BLOODWOOD);
    private static final BlockFamily GHOSTLY = fromWoodType(MysteriousWoodTypes.GHOSTLY);
    private static final BlockFamily SORBUS = fromWoodType(MysteriousWoodTypes.SORBUS);
    private static final BlockFamily SEEPING = fromWoodType(MysteriousWoodTypes.SEEPING);

    public BlockModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGen) {
        makeWoodTypes(modelGen, MysteriousWoodTypes.BLOODWOOD, BLOODWOOD);
        makeWoodTypes(modelGen, MysteriousWoodTypes.GHOSTLY, GHOSTLY);
        makeWoodTypes(modelGen, MysteriousWoodTypes.SORBUS, SORBUS);
        makeWoodTypes(modelGen, MysteriousWoodTypes.SEEPING, SEEPING);
        modelGen.registerSimpleCubeAll(MysteriousWoodTypes.BLOODWOOD.getLeaves().get());
        modelGen.registerSimpleCubeAll(MysteriousWoodTypes.GHOSTLY.getLeaves().get());
        modelGen.registerSimpleCubeAll(MysteriousWoodTypes.SORBUS.getLeaves().get());
        modelGen.registerSimpleCubeAll(MysteriousWoodTypes.SEEPING.getLeaves().get());
        modelGen.registerTintableCross((MysteriousWoodTypes.BLOODWOOD.getSapling().get()),
                BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross((MysteriousWoodTypes.GHOSTLY.getSapling().get()),
                BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(MysteriousWoodTypes.SORBUS.getSapling().get(),
                BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross((MysteriousWoodTypes.SEEPING.getSapling().get()),
                BlockStateModelGenerator.TintType.NOT_TINTED);

        modelGen.registerSimpleCubeAll(MysteriousContentSetup.BLOODIED_DIRT.get());
        //TODO Check if this is still broken or not.
        //FIXME This does NOT generate the bloodied_grass.json block model file like it in theory should.
        modelGen.registerTopSoil(MysteriousContentSetup.BLOODIED_GRASS.get(),
                ModelIds.getBlockModelId(MysteriousContentSetup.BLOODIED_GRASS.get()),
                BlockStateVariant.create().put(VariantSettings.MODEL, Models.CUBE_BOTTOM_TOP.upload(
                        MysteriousContentSetup.BLOODIED_GRASS.get(), "_snow",
                        new TextureMap().put(TextureKey.BOTTOM, TextureMap.getId(
                                MysteriousContentSetup.BLOODIED_DIRT.get())).inherit(TextureKey.BOTTOM,
                                TextureKey.PARTICLE).put(TextureKey.TOP, TextureMap.getSubId(
                                MysteriousContentSetup.BLOODIED_GRASS.get(), "_top")).put(TextureKey.SIDE,
                                TextureMap.getSubId(MysteriousContentSetup.BLOODIED_GRASS.get(),
                                        "_snow")), modelGen.modelCollector)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }

    private void makeWoodTypes(BlockStateModelGenerator generator, MysteriousWoodTypes woodType, BlockFamily family) {
        generator.registerLog(woodType.getLog().get()).log(woodType.getLog().get())
                .wood(woodType.getWood().get());
        generator.registerLog(woodType.getStrippedLog().get()).log(woodType.getStrippedLog().get())
                .wood(woodType.getStrippedWood().get());
        generator.registerCubeAllModelTexturePool(woodType.getPlanks().get()).family(family);
    }

    private static BlockFamily fromWoodType(MysteriousWoodTypes woodTypes) {
        return new BlockFamily.Builder(woodTypes.getPlanks().get())
                .button(woodTypes.getButton().get())
                .door(woodTypes.getDoor().get())
                .fence(woodTypes.getFence().get())
                .fenceGate(woodTypes.getGate().get())
                .pressurePlate(woodTypes.getPressurePlate().get())
                .slab(woodTypes.getSlab().get())
                .stairs(woodTypes.getStairs().get())
                .sign(woodTypes.getFloorSign().get(), woodTypes.getWallSign().get())
                .trapdoor(woodTypes.getTrapdoor().get()).group("wooden")
                .unlockCriterionName("has_planks").build();

    }
}
