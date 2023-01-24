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
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;

public class BlockModelGenerator extends FabricModelProvider {

    private static final BlockFamily BLOODWOOD = fromWoodType(MysteriousWoodTypes.BLOODWOOD);
    private static final BlockFamily GHOSTLY = fromWoodType(MysteriousWoodTypes.GHOSTLY);
    private static final BlockFamily SORBUS = fromWoodType(MysteriousWoodTypes.SORBUS);
    private static final BlockFamily SEEPING = fromWoodType(MysteriousWoodTypes.SEEPING);
    private static final BlockFamily SAKURA = fromWoodType(MysteriousWoodTypes.SAKURA);

    public BlockModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGen) {
        makeWoodTypes(modelGen, MysteriousWoodTypes.BLOODWOOD, BLOODWOOD);
        makeWoodTypes(modelGen, MysteriousWoodTypes.GHOSTLY, GHOSTLY);
        makeWoodTypes(modelGen, MysteriousWoodTypes.SORBUS, SORBUS);
        makeWoodTypes(modelGen, MysteriousWoodTypes.SEEPING, SEEPING);
        makeWoodTypes(modelGen, MysteriousWoodTypes.SAKURA, SAKURA);
        modelGen.createTrivialCube(MysteriousWoodTypes.BLOODWOOD.getLeaves().get());
        modelGen.createTrivialCube(MysteriousWoodTypes.GHOSTLY.getLeaves().get());
        modelGen.createTrivialCube(MysteriousWoodTypes.SORBUS.getLeaves().get());
        modelGen.createTrivialCube(MysteriousWoodTypes.SEEPING.getLeaves().get());
        modelGen.createTrivialCube(MysteriousWoodTypes.SAKURA.getLeaves().get());
        modelGen.createCrossBlockWithDefaultItem(MysteriousWoodTypes.BLOODWOOD.getSapling().get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createCrossBlockWithDefaultItem(MysteriousWoodTypes.GHOSTLY.getSapling().get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createCrossBlockWithDefaultItem(MysteriousWoodTypes.SORBUS.getSapling().get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createCrossBlockWithDefaultItem(MysteriousWoodTypes.SEEPING.getSapling().get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createCrossBlockWithDefaultItem(MysteriousWoodTypes.SAKURA.getSapling().get(),
            BlockModelGenerators.TintState.NOT_TINTED);

        modelGen.createTrivialCube(MysteriousContentSetup.BLOODIED_DIRT.get());
        //FIXME This does NOT generate the bloodied_grass.json block model file like it in theory should.
        modelGen.createGrassLikeBlock(MysteriousContentSetup.BLOODIED_GRASS.get(),
            ModelLocationUtils.getModelLocation(MysteriousContentSetup.BLOODIED_GRASS.get()),
            Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP
                .createWithSuffix(MysteriousContentSetup.BLOODIED_GRASS.get(), "_snow",
                    new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(
                        MysteriousContentSetup.BLOODIED_DIRT.get())).copyForced(TextureSlot.BOTTOM,
                        TextureSlot.PARTICLE).put(TextureSlot.TOP, TextureMapping.getBlockTexture(
                        MysteriousContentSetup.BLOODIED_GRASS.get(), "_top")).put(TextureSlot.SIDE,
                        TextureMapping.getBlockTexture(MysteriousContentSetup.BLOODIED_GRASS.get(),
                            "_snow")), modelGen.modelOutput)));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    private void makeWoodTypes(BlockModelGenerators generator, MysteriousWoodTypes woodType, BlockFamily family) {
        generator.woodProvider(woodType.getLog().get()).logWithHorizontal(woodType.getLog().get())
            .wood(woodType.getWood().get());
        generator.woodProvider(woodType.getStrippedLog().get()).logWithHorizontal(woodType.getStrippedLog().get())
            .wood(woodType.getStrippedWood().get());
        generator.family(woodType.getPlanks().get()).generateFor(family);
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
            .trapdoor(woodTypes.getTrapdoor().get()).recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks").getFamily();

    }
}
