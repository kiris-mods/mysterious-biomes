package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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

        // The casts are needed because the blocks are stored in RegistryObject<Block> fields

        // Sorbus blocks
        logBlock((RotatedPillarBlock) SpookyBlocks.SORBUS_LOG_STRIPPED.get());
        itemFromBlock(SpookyBlocks.SORBUS_LOG_STRIPPED.get());
        logBlock((RotatedPillarBlock) SpookyBlocks.SORBUS_LOG.get());
        itemFromBlock(SpookyBlocks.SORBUS_LOG.get());
        simpleBlock(SpookyBlocks.SORBUS_LEAVES.get());
        itemFromBlock(SpookyBlocks.SORBUS_LEAVES.get());
        simpleBlock(SpookyBlocks.SORBUS_PLANKS.get());
        itemFromBlock(SpookyBlocks.SORBUS_PLANKS.get());
        simpleBlock(SpookyBlocks.SORBUS_SAPLING.get(), cross(SpookyBlocks.SORBUS_SAPLING.get()));
        singleTextureBlockItem(SpookyBlocks.SORBUS_SAPLING.get());
        fenceGateBlock((FenceGateBlock) SpookyBlocks.SORBUS_GATE.get(), blockTexture(SpookyBlocks.SORBUS_PLANKS.get()));
        itemFromBlock(SpookyBlocks.SORBUS_GATE.get());
        doorBlock((DoorBlock) SpookyBlocks.SORBUS_DOOR.get(),
            suffix(blockTexture(SpookyBlocks.SORBUS_DOOR.get()), "_lower"),
            suffix(blockTexture(SpookyBlocks.SORBUS_DOOR.get()), "_upper"));
        itemModels().singleTexture(SpookyBlocks.SORBUS_DOOR.get().getRegistryName().getPath(),
            mcLoc("item/generated"), "layer0",
            modLoc(ModelProvider.ITEM_FOLDER + "/" + SpookyBlocks.SORBUS_DOOR.get().getRegistryName().getPath()));
        trapdoorBlock((TrapDoorBlock) SpookyBlocks.SORBUS_TRAPDOOR.get(), blockTexture(SpookyBlocks.SORBUS_PLANKS.get()), true);
        itemModels().withExistingParent(SpookyBlocks.SORBUS_TRAPDOOR.get().getRegistryName().getPath(),
            suffix(blockTexture(SpookyBlocks.SORBUS_TRAPDOOR.get()), "_bottom"));
        stairsBlock((StairBlock) SpookyBlocks.SORBUS_STAIRS.get(), blockTexture(SpookyBlocks.SORBUS_PLANKS.get()));
        itemFromBlock(SpookyBlocks.SORBUS_STAIRS.get());
        fenceBlock((FenceBlock) SpookyBlocks.SORBUS_FENCE.get(), blockTexture(SpookyBlocks.SORBUS_PLANKS.get()));
        simpleBlockItem(SpookyBlocks.SORBUS_FENCE.get(),
            models().fenceInventory(SpookyBlocks.SORBUS_FENCE.get().getRegistryName().getPath() + "_inventory",
                blockTexture(SpookyBlocks.SORBUS_PLANKS.get())));
        slabBlock((SlabBlock) SpookyBlocks.SORBUS_SLAB.get(), blockTexture(SpookyBlocks.SORBUS_PLANKS.get()), blockTexture(SpookyBlocks.SORBUS_PLANKS.get()));
        itemFromBlock(SpookyBlocks.SORBUS_SLAB.get());
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

    public ResourceLocation suffix(ResourceLocation name, String suffix) {
        return new ResourceLocation(name.getNamespace(), name.getPath() + suffix);
    }

    public ItemModelBuilder itemFromBlock(Block b) {
        return itemModels().withExistingParent(b.getRegistryName().getPath(), blockTexture(b));
    }

    public ItemModelBuilder singleTextureBlockItem(Block b) {
        return singleTextureBlockItem(b, blockTexture(b));
    }

    public ItemModelBuilder singleTextureBlockItem(Block b, ResourceLocation texture) {
        return itemModels().singleTexture(b.getRegistryName().getPath(), mcLoc("item/generated"), "layer0", texture);
    }

    public BlockModelBuilder cross(Block b) {
        return models().cross(b.getRegistryName().getPath(), blockTexture(b));
    }

    public ResourceLocation modBlockTexture(String path) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + path);
    }
}
