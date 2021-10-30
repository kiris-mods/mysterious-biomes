package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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

    public ResourceLocation modBlockTexture(String path) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + path);
    }
}
