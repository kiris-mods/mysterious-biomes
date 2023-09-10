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
package dev.tophatcat.mysteriousbiomes.datagen.client;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;

import java.util.List;

public class MysteriousBlockStateModelGenerator extends FabricModelProvider {

    private static final BlockFamily BLOODWOOD = fromWoodType(MysteriousBlockTypes.BLOODWOOD);
    private static final BlockFamily GHOSTLY = fromWoodType(MysteriousBlockTypes.GHOSTLY);
    private static final BlockFamily SORBUS = fromWoodType(MysteriousBlockTypes.SORBUS);
    private static final BlockFamily SEEPING = fromWoodType(MysteriousBlockTypes.SEEPING);
    private static final BlockFamily WALNUT = fromWoodType(MysteriousBlockTypes.WALNUT);

    public MysteriousBlockStateModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGen) {
        modelGen.registerCubeAllModelTexturePool(MysteriousBlockTypes.BLOODWOOD.getPlanks().get()).family(BLOODWOOD);
        modelGen.registerCubeAllModelTexturePool(MysteriousBlockTypes.GHOSTLY.getPlanks().get()).family(GHOSTLY);
        modelGen.registerCubeAllModelTexturePool(MysteriousBlockTypes.SORBUS.getPlanks().get()).family(SORBUS);
        modelGen.registerCubeAllModelTexturePool(MysteriousBlockTypes.SEEPING.getPlanks().get()).family(SEEPING);
        modelGen.registerCubeAllModelTexturePool(MysteriousBlockTypes.WALNUT.getPlanks().get()).family(WALNUT);
        var mysteriousWoodTypes = List.of(
            MysteriousBlockTypes.BLOODWOOD,
            MysteriousBlockTypes.GHOSTLY,
            MysteriousBlockTypes.SORBUS,
            MysteriousBlockTypes.SEEPING,
            MysteriousBlockTypes.WALNUT);

        mysteriousWoodTypes.forEach(woodType -> {
            modelGen.registerLog(woodType.getLog().get())
                .log(woodType.getLog().get())
                .wood(woodType.getWood().get());
            modelGen.registerSimpleCubeAll(woodType.getLeaves().get());
            modelGen.registerTintableCross(woodType.getSapling().get(),
                BlockStateModelGenerator.TintType.NOT_TINTED);
            modelGen.registerHangingSign(woodType.getLog().get(),
                woodType.getHangingSign().get(),
                woodType.getWallHangingSign().get());
        });

        //This does NOT generate the bloodied_grass.json block model file like it in theory should.
        //It does however generate the snowy model and the blockstate file.
        //Until a fix can be found, a manually written model file has been left in the mods resources to patch this.
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
        modelGen.registerSimpleCubeAll(MysteriousContentSetup.BLOODIED_DIRT.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
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
