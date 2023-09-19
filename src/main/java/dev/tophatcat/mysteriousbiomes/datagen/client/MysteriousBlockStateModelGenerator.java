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

import dev.tophatcat.mysteriousbiomes.setup.MysteriousRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
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

public class MysteriousBlockStateModelGenerator extends FabricModelProvider {

    public MysteriousBlockStateModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGen) {
        modelGen.family(MysteriousRegistry.BLOODWOOD_PLANKS.get()).generateFor(bloodwoodFamily());
        modelGen.family(MysteriousRegistry.GHOSTLY_PLANKS.get()).generateFor(ghostlyFamily());
        modelGen.family(MysteriousRegistry.SORBUS_PLANKS.get()).generateFor(sorbusFamily());
        modelGen.family(MysteriousRegistry.SEEPING_PLANKS.get()).generateFor(seepingFamily());
        modelGen.family(MysteriousRegistry.WALNUT_PLANKS.get()).generateFor(walnutFamily());

        modelGen.woodProvider(MysteriousRegistry.BLOODWOOD_LOG.get())
            .logWithHorizontal(MysteriousRegistry.BLOODWOOD_LOG.get())
            .wood(MysteriousRegistry.BLOODWOOD_WOOD.get());
        modelGen.woodProvider(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get())
            .logWithHorizontal(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get())
            .wood(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get());
        modelGen.createTrivialCube(MysteriousRegistry.BLOODWOOD_LEAVES.get());
        modelGen.createCrossBlockWithDefaultItem(MysteriousRegistry.BLOODWOOD_SAPLING.get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createHangingSign(MysteriousRegistry.BLOODWOOD_LOG.get(),
            MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get(),
            MysteriousRegistry.BLOODWOOD_WALL_HANGING_SIGN.get());

        modelGen.woodProvider(MysteriousRegistry.GHOSTLY_LOG.get())
            .logWithHorizontal(MysteriousRegistry.GHOSTLY_LOG.get())
            .wood(MysteriousRegistry.GHOSTLY_WOOD.get());
        modelGen.woodProvider(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get())
            .logWithHorizontal(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get())
            .wood(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get());
        modelGen.createTrivialCube(MysteriousRegistry.GHOSTLY_LEAVES.get());
        modelGen.createCrossBlockWithDefaultItem(MysteriousRegistry.GHOSTLY_SAPLING.get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createHangingSign(MysteriousRegistry.GHOSTLY_LOG.get(),
            MysteriousRegistry.GHOSTLY_HANGING_SIGN.get(),
            MysteriousRegistry.GHOSTLY_WALL_HANGING_SIGN.get());

        modelGen.woodProvider(MysteriousRegistry.SORBUS_LOG.get())
            .logWithHorizontal(MysteriousRegistry.SORBUS_LOG.get())
            .wood(MysteriousRegistry.SORBUS_WOOD.get());
        modelGen.woodProvider(MysteriousRegistry.SORBUS_STRIPPED_LOG.get())
            .logWithHorizontal(MysteriousRegistry.SORBUS_STRIPPED_LOG.get())
            .wood(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get());
        modelGen.createTrivialCube(MysteriousRegistry.SORBUS_LEAVES.get());
        modelGen.createCrossBlockWithDefaultItem(MysteriousRegistry.SORBUS_SAPLING.get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createHangingSign(MysteriousRegistry.SORBUS_LOG.get(),
            MysteriousRegistry.SORBUS_HANGING_SIGN.get(),
            MysteriousRegistry.SORBUS_WALL_HANGING_SIGN.get());

        modelGen.woodProvider(MysteriousRegistry.SEEPING_LOG.get())
            .logWithHorizontal(MysteriousRegistry.SEEPING_LOG.get())
            .wood(MysteriousRegistry.SEEPING_WOOD.get());
        modelGen.woodProvider(MysteriousRegistry.SEEPING_STRIPPED_LOG.get())
            .logWithHorizontal(MysteriousRegistry.SEEPING_STRIPPED_LOG.get())
            .wood(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get());
        modelGen.createTrivialCube(MysteriousRegistry.SEEPING_LEAVES.get());
        modelGen.createCrossBlockWithDefaultItem(MysteriousRegistry.SEEPING_SAPLING.get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createHangingSign(MysteriousRegistry.SEEPING_LOG.get(),
            MysteriousRegistry.SEEPING_HANGING_SIGN.get(),
            MysteriousRegistry.SEEPING_WALL_HANGING_SIGN.get());

        modelGen.woodProvider(MysteriousRegistry.WALNUT_LOG.get())
            .logWithHorizontal(MysteriousRegistry.WALNUT_LOG.get())
            .wood(MysteriousRegistry.WALNUT_WOOD.get());
        modelGen.woodProvider(MysteriousRegistry.WALNUT_STRIPPED_LOG.get())
            .logWithHorizontal(MysteriousRegistry.WALNUT_STRIPPED_LOG.get())
            .wood(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get());
        modelGen.createTrivialCube(MysteriousRegistry.WALNUT_LEAVES.get());
        modelGen.createCrossBlockWithDefaultItem(MysteriousRegistry.WALNUT_SAPLING.get(),
            BlockModelGenerators.TintState.NOT_TINTED);
        modelGen.createHangingSign(MysteriousRegistry.WALNUT_LOG.get(),
            MysteriousRegistry.WALNUT_HANGING_SIGN.get(),
            MysteriousRegistry.WALNUT_WALL_HANGING_SIGN.get());

        //This does NOT generate the bloodied_grass.json block model file like it in theory should.
        //It does however generate the snowy model and the blockstate file.
        //Until a fix can be found, a manually written model file has been left in the mods resources to patch this.
        modelGen.createGrassLikeBlock(MysteriousRegistry.BLOODIED_GRASS.get(),
            ModelLocationUtils.getModelLocation(MysteriousRegistry.BLOODIED_GRASS.get()),
            Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(
                MysteriousRegistry.BLOODIED_GRASS.get(), "_snow",
                new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(
                    MysteriousRegistry.BLOODIED_DIRT.get())).copyForced(TextureSlot.BOTTOM,
                    TextureSlot.PARTICLE).put(TextureSlot.TOP, TextureMapping.getBlockTexture(
                    MysteriousRegistry.BLOODIED_GRASS.get(), "_top")).put(TextureSlot.SIDE,
                    TextureMapping.getBlockTexture(MysteriousRegistry.BLOODIED_GRASS.get(),
                        "_snow")), modelGen.modelOutput)));
        modelGen.createTrivialCube(MysteriousRegistry.BLOODIED_DIRT.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    private static BlockFamily bloodwoodFamily() {
        return new BlockFamily.Builder(MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .button(MysteriousRegistry.BLOODWOOD_BUTTON.get())
            .door(MysteriousRegistry.BLOODWOOD_DOOR.get())
            .fence(MysteriousRegistry.BLOODWOOD_FENCE.get())
            .fenceGate(MysteriousRegistry.BLOODWOOD_GATE.get())
            .pressurePlate(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get())
            .slab(MysteriousRegistry.BLOODWOOD_SLAB.get())
            .stairs(MysteriousRegistry.BLOODWOOD_STAIRS.get())
            .sign(MysteriousRegistry.BLOODWOOD_FLOOR_SIGN.get(), MysteriousRegistry.BLOODWOOD_WALL_SIGN.get())
            .trapdoor(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get()).recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks").getFamily();
    }

    private static BlockFamily ghostlyFamily() {
        return new BlockFamily.Builder(MysteriousRegistry.GHOSTLY_PLANKS.get())
            .button(MysteriousRegistry.GHOSTLY_BUTTON.get())
            .door(MysteriousRegistry.GHOSTLY_DOOR.get())
            .fence(MysteriousRegistry.GHOSTLY_FENCE.get())
            .fenceGate(MysteriousRegistry.GHOSTLY_GATE.get())
            .pressurePlate(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get())
            .slab(MysteriousRegistry.GHOSTLY_SLAB.get())
            .stairs(MysteriousRegistry.GHOSTLY_STAIRS.get())
            .sign(MysteriousRegistry.GHOSTLY_FLOOR_SIGN.get(), MysteriousRegistry.GHOSTLY_WALL_SIGN.get())
            .trapdoor(MysteriousRegistry.GHOSTLY_TRAPDOOR.get()).recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks").getFamily();
    }

    private static BlockFamily sorbusFamily() {
        return new BlockFamily.Builder(MysteriousRegistry.SORBUS_PLANKS.get())
            .button(MysteriousRegistry.SORBUS_BUTTON.get())
            .door(MysteriousRegistry.SORBUS_DOOR.get())
            .fence(MysteriousRegistry.SORBUS_FENCE.get())
            .fenceGate(MysteriousRegistry.SORBUS_GATE.get())
            .pressurePlate(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get())
            .slab(MysteriousRegistry.SORBUS_SLAB.get())
            .stairs(MysteriousRegistry.SORBUS_STAIRS.get())
            .sign(MysteriousRegistry.SORBUS_FLOOR_SIGN.get(), MysteriousRegistry.SORBUS_WALL_SIGN.get())
            .trapdoor(MysteriousRegistry.SORBUS_TRAPDOOR.get()).recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks").getFamily();
    }

    private static BlockFamily seepingFamily() {
        return new BlockFamily.Builder(MysteriousRegistry.SEEPING_PLANKS.get())
            .button(MysteriousRegistry.SEEPING_BUTTON.get())
            .door(MysteriousRegistry.SEEPING_DOOR.get())
            .fence(MysteriousRegistry.SEEPING_FENCE.get())
            .fenceGate(MysteriousRegistry.SEEPING_GATE.get())
            .pressurePlate(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get())
            .slab(MysteriousRegistry.SEEPING_SLAB.get())
            .stairs(MysteriousRegistry.SEEPING_STAIRS.get())
            .sign(MysteriousRegistry.SEEPING_FLOOR_SIGN.get(), MysteriousRegistry.SEEPING_WALL_SIGN.get())
            .trapdoor(MysteriousRegistry.SEEPING_TRAPDOOR.get()).recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks").getFamily();
    }

    private static BlockFamily walnutFamily() {
        return new BlockFamily.Builder(MysteriousRegistry.WALNUT_PLANKS.get())
            .button(MysteriousRegistry.WALNUT_BUTTON.get())
            .door(MysteriousRegistry.WALNUT_DOOR.get())
            .fence(MysteriousRegistry.WALNUT_FENCE.get())
            .fenceGate(MysteriousRegistry.WALNUT_GATE.get())
            .pressurePlate(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get())
            .slab(MysteriousRegistry.WALNUT_SLAB.get())
            .stairs(MysteriousRegistry.WALNUT_STAIRS.get())
            .sign(MysteriousRegistry.WALNUT_FLOOR_SIGN.get(), MysteriousRegistry.WALNUT_WALL_SIGN.get())
            .trapdoor(MysteriousRegistry.WALNUT_TRAPDOOR.get()).recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks").getFamily();
    }
}
