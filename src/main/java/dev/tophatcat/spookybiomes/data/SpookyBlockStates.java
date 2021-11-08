/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2016-2021 <ProxyNeko>
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SpookyBlockStates extends BlockStateProvider {
    public SpookyBlockStates(final DataGenerator gen, final ExistingFileHelper exFileHelper) {
        super(gen, SpookyBiomes.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Bloodied Dirt
        final BlockModelBuilder bloodiedDirtModel = models()
            .cubeAll("bloodied_dirt", blockTexture(SpookyBlocks.BLOODIED_DIRT.get()));
        getVariantBuilder(SpookyBlocks.BLOODIED_DIRT.get())
            .forAllStates(state -> ConfiguredModel.allYRotations(bloodiedDirtModel, 0, false));
        itemModels().getBuilder("bloodied_dirt").parent(bloodiedDirtModel);

        bloodiedGrass();

        for (SpookyBlockFamily family : SpookyBlockFamily.FAMILIES) {
            final Block planks = family.planks().get();
            final ResourceLocation planksTexture = blockTexture(planks);

            both(family.planks(), this::simpleBlock, this::inheritingBlockItem);
            both(family.slab(), b -> slabBlock(b, planksTexture, planksTexture), this::inheritingBlockItem);
            both(family.stairs(), b -> stairsBlock(b, planksTexture), this::inheritingBlockItem);
            both(family.pressurePlate(), b -> pressurePlateBlock(b, planksTexture), this::inheritingBlockItem);
            both(family.button(), b -> buttonBlock(b, planksTexture),
                b -> simpleBlockItem(b, models().buttonInventory(path(b) + "_inventory", planksTexture)));
            both(family.fence(), b -> fenceBlock(b, planksTexture),
                b -> simpleBlockItem(b, models().fenceInventory(path(b) + "_inventory", planksTexture)));
            both(family.fenceGate(), b -> fenceGateBlock(b, planksTexture), this::inheritingBlockItem);
            both(family.door(), b -> {
                    final ResourceLocation doorTexture = blockTexture(b);
                    doorBlock(b, suffix(doorTexture, "_lower"), suffix(doorTexture, "_upper"));
                },
                b -> itemModels().singleTexture(path(b), mcLoc("item/generated"), "layer0",
                    modLoc(ModelProvider.ITEM_FOLDER + "/" + path(b))));
            both(family.trapdoor(), b -> trapdoorBlock(b, planksTexture, true),
                b -> itemModels().withExistingParent(path(b), suffix(blockTexture(b), "_bottom")));
            both(family.log(), this::logBlock, this::inheritingBlockItem);
            both(family.strippedLog(), this::logBlock, this::inheritingBlockItem);
            both(family.leaves(), this::simpleBlock, this::inheritingBlockItem);
            both(family.sapling(), b -> simpleBlock(b, cross(b)), b -> singleTextureBlockItem(b, blockTexture(b)));

            final StandingSignBlock standingSign = family.standingSign().get();
            final WallSignBlock wallSign = family.wallSign().get();
            signBlock(standingSign, wallSign, planksTexture);
            singleTextureBlockItem(standingSign, modLoc(ModelProvider.ITEM_FOLDER + "/" + path(standingSign)));
        }
    }

    private void bloodiedGrass() {
        final BlockModelBuilder regularModel = models().withExistingParent("bloodied_grass", mcLoc("block/block"))
            .texture("particle", modBlockTexture("bloodied_dirt"))
            .texture("bottom", modBlockTexture("bloodied_dirt"))
            .texture("top", modBlockTexture("bloodied_grass_top"))
            .texture("side", modBlockTexture("bloodied_grass_sides"))
            // Only one element: from 0,0,0 to 16,16,16
            .element().from(0F, 0F, 0F).to(16F, 16F, 16F)
            .face(Direction.DOWN).texture("#bottom").end()
            .face(Direction.UP).texture("#top").tintindex(0).end()
            .face(Direction.NORTH).texture("#side").end()
            .face(Direction.SOUTH).texture("#side").end()
            .face(Direction.WEST).texture("#side").end()
            .face(Direction.EAST).texture("#side").end()
            // All face have the same UVs (0,0 to 16,16), and the cullface is in the same direction
            .allFaces((dir, face) -> face.uvs(0F, 0F, 16F, 16F).cullface(dir))
            .end();

        final BlockModelBuilder snowyModel = models().cubeBottomTop("bloodied_grass_snow",
                modBlockTexture("bloodied_grass_snowy"), // side texture
                modBlockTexture("bloodied_dirt"), // bottom texture
                modBlockTexture("bloodied_grass_top")) // top texture
            .texture("particle", modBlockTexture("bloodied_dirt"));

        getVariantBuilder(SpookyBlocks.BLOODIED_GRASS.get())
            .partialState().with(BloodiedGrass.SNOWY, false) // For the non-snowy variant
            .setModels(ConfiguredModel.allYRotations(regularModel, 0, false))
            .partialState().with(BloodiedGrass.SNOWY, true) // For the snowy variant
            .setModels(ConfiguredModel.builder().modelFile(snowyModel).build());

        itemModels().getBuilder("bloodied_grass").parent(regularModel);
    }

    protected ItemModelBuilder inheritingBlockItem(Block b) {
        return itemModels().withExistingParent(path(b), blockTexture(b));
    }

    protected ItemModelBuilder singleTextureBlockItem(Block b, ResourceLocation texture) {
        return itemModels().singleTexture(path(b), mcLoc("item/generated"), "layer0", texture);
    }

    protected BlockModelBuilder cross(Block b) {
        return models().cross(path(b), blockTexture(b));
    }

    /**
     * Returns the {@linkplain ResourceLocation#getPath() path} of the registry name for the given registry entry. This
     * is a convenience method which checks if the registry name of the entry exists, to avoid linting warnings about
     * the nullability of the {@linkplain IForgeRegistryEntry#getRegistryName() entry's registry name}.
     *
     * @param entry the registry entry
     * @return the path of the registry name of the given entry
     * @throws NullPointerException if the entry does not have a registry name
     */
    protected static String path(IForgeRegistryEntry<?> entry) {
        return Objects.requireNonNull(entry.getRegistryName(), "Registry name").getPath();
    }

    /**
     * Returns a location of the given texture under the {@linkplain ModelProvider#BLOCK_FOLDER {@code blocks} folder}
     * with the same namespace of this block state provider.
     *
     * @param path the path to the texture
     * @return a resource location to the specified texture, relative to the {@code blocks} folder
     */
    protected ResourceLocation modBlockTexture(String path) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    /**
     * Appends the given suffix to the path of the given resource location.
     *
     * @param name   the resource location to modify
     * @param suffix the suffix
     * @return the modified resource location with the suffix
     */
    protected static ResourceLocation suffix(ResourceLocation name, String suffix) {
        return new ResourceLocation(name.getNamespace(), name.getPath() + suffix);
    }

    /**
     * Gets a value from the given supplier and passes it to both consumers in order.
     *
     * @param supplier a supplier of values
     * @param one      the first value consumer
     * @param two      the second value consumer
     * @param <T>      the type of the value
     */
    protected static <T> void both(Supplier<T> supplier, Consumer<T> one, Consumer<T> two) {
        T thing = supplier.get();
        one.accept(thing);
        two.accept(thing);
    }
}
