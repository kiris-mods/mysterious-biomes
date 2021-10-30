package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
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
    }
}
