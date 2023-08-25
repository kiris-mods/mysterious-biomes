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
import dev.tophatcat.mysteriousbiomes.setup.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;

public class MysteriousBlockStateModelGenerator extends FabricModelProvider {

    private static final BlockFamily BLOODWOOD = fromWoodType(MysteriousBlockTypes.BLOODWOOD);
    private static final BlockFamily GHOSTLY = fromWoodType(MysteriousBlockTypes.GHOSTLY);
    private static final BlockFamily SORBUS = fromWoodType(MysteriousBlockTypes.SORBUS);
    private static final BlockFamily SEEPING = fromWoodType(MysteriousBlockTypes.SEEPING);
    private static final BlockFamily SAKURA = fromWoodType(MysteriousBlockTypes.SAKURA);

    public MysteriousBlockStateModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGen) {
        makeWoodTypes(modelGen, MysteriousBlockTypes.BLOODWOOD, BLOODWOOD);
        makeWoodTypes(modelGen, MysteriousBlockTypes.GHOSTLY, GHOSTLY);
        makeWoodTypes(modelGen, MysteriousBlockTypes.SORBUS, SORBUS);
        makeWoodTypes(modelGen, MysteriousBlockTypes.SEEPING, SEEPING);
        makeWoodTypes(modelGen, MysteriousBlockTypes.SAKURA, SAKURA);

        modelGen.registerSimpleCubeAll(MysteriousBlockTypes.BLOODWOOD.getLeaves().get());
        modelGen.registerSimpleCubeAll(MysteriousBlockTypes.GHOSTLY.getLeaves().get());
        modelGen.registerSimpleCubeAll(MysteriousBlockTypes.SORBUS.getLeaves().get());
        modelGen.registerSimpleCubeAll(MysteriousBlockTypes.SEEPING.getLeaves().get());
        modelGen.registerSimpleCubeAll(MysteriousBlockTypes.SAKURA.getLeaves().get());

        modelGen.registerTintableCross(MysteriousBlockTypes.BLOODWOOD.getSapling().get(),
                BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(MysteriousBlockTypes.GHOSTLY.getSapling().get(),
                BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(MysteriousBlockTypes.SORBUS.getSapling().get(),
                BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(MysteriousBlockTypes.SEEPING.getSapling().get(),
                BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(MysteriousBlockTypes.SAKURA.getSapling().get(),
            BlockStateModelGenerator.TintType.NOT_TINTED);

        modelGen.registerHangingSign(MysteriousBlockTypes.BLOODWOOD.getLog().get(),
                MysteriousBlockTypes.BLOODWOOD.getHangingSign().get(),
                MysteriousBlockTypes.BLOODWOOD.getWallHangingSign().get());
        modelGen.registerHangingSign(MysteriousBlockTypes.GHOSTLY.getLog().get(),
                MysteriousBlockTypes.GHOSTLY.getHangingSign().get(),
                MysteriousBlockTypes.GHOSTLY.getWallHangingSign().get());
        modelGen.registerHangingSign(MysteriousBlockTypes.SORBUS.getLog().get(),
                MysteriousBlockTypes.SORBUS.getHangingSign().get(),
                MysteriousBlockTypes.SORBUS.getWallHangingSign().get());
        modelGen.registerHangingSign(MysteriousBlockTypes.SEEPING.getLog().get(),
                MysteriousBlockTypes.SEEPING.getHangingSign().get(),
                MysteriousBlockTypes.SEEPING.getWallHangingSign().get());
        modelGen.registerHangingSign(MysteriousBlockTypes.SAKURA.getLog().get(),
                MysteriousBlockTypes.SAKURA.getHangingSign().get(),
                MysteriousBlockTypes.SAKURA.getWallHangingSign().get());

        modelGen.registerSimpleCubeAll(MysteriousContentSetup.BLOODIED_DIRT.get());

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

    private void makeWoodTypes(BlockStateModelGenerator generator, MysteriousBlockTypes woodType, BlockFamily family) {
        generator.registerLog(woodType.getLog().get()).log(woodType.getLog().get())
                .wood(woodType.getWood().get());
        generator.registerLog(woodType.getStrippedLog().get()).log(woodType.getStrippedLog().get())
                .wood(woodType.getStrippedWood().get());
        generator.registerCubeAllModelTexturePool(woodType.getPlanks().get()).family(family);
    }

    private static BlockFamily fromWoodType(MysteriousBlockTypes woodTypes) {
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
