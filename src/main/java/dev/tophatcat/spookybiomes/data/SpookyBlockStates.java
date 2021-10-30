package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
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

        // The casts are needed because the blocks are stored in RegistryObject<Block> fields

        SpookyBlockFamily[] families = new SpookyBlockFamily[]{SORBUS};
        for (SpookyBlockFamily family : families) {
            final Block planks = family.planks().get();
            final ResourceLocation planksTexture = blockTexture(planks);

            both(family.planks(), this::simpleBlock, this::itemFromBlock);
            both(family.slab(), b -> slabBlock(b, planksTexture, planksTexture), this::itemFromBlock);
            both(family.stairs(), b -> stairsBlock(b, planksTexture), this::itemFromBlock);
            both(family.fence(), b -> fenceBlock(b, planksTexture),
                b -> simpleBlockItem(b, models().fenceInventory(path(b) + "_inventory", planksTexture)));
            both(family.fenceGate(), b -> fenceGateBlock(b, planksTexture), this::itemFromBlock);
            both(family.door(), b -> {
                    final ResourceLocation doorTexture = blockTexture(b);
                    doorBlock(b, suffix(doorTexture, "_lower"), suffix(doorTexture, "_upper"));
                },
                b -> itemModels().singleTexture(path(b), mcLoc("item/generated"), "layer0",
                    modLoc(ModelProvider.ITEM_FOLDER + "/" + path(b))));
            both(family.trapdoor(), b -> trapdoorBlock(b, planksTexture, true),
                b -> itemModels().withExistingParent(path(b), suffix(blockTexture(b), "_bottom")));
            both(family.log(), this::logBlock, this::itemFromBlock);
            both(family.strippedLog(), this::logBlock, this::itemFromBlock);
            both(family.leaves(), this::simpleBlock, this::itemFromBlock);
            both(family.sapling(), b -> simpleBlock(b, cross(b)), this::singleTextureBlockItem);
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

    public ResourceLocation suffix(ResourceLocation name, String suffix) {
        return new ResourceLocation(name.getNamespace(), name.getPath() + suffix);
    }

    public ItemModelBuilder itemFromBlock(Block b) {
        return itemModels().withExistingParent(path(b), blockTexture(b));
    }

    public ItemModelBuilder singleTextureBlockItem(Block b) {
        return singleTextureBlockItem(b, blockTexture(b));
    }

    public ItemModelBuilder singleTextureBlockItem(Block b, ResourceLocation texture) {
        return itemModels().singleTexture(path(b), mcLoc("item/generated"), "layer0", texture);
    }

    public BlockModelBuilder cross(Block b) {
        return models().cross(path(b), blockTexture(b));
    }

    public <T> void both(Supplier<T> thingSupplier, Consumer<T> one, Consumer<T> two) {
        T thing = thingSupplier.get();
        one.accept(thing);
        two.accept(thing);
    }

    public String path(IForgeRegistryEntry<?> entry) {
        return Objects.requireNonNull(entry.getRegistryName(), "Registry name").getPath();
    }

    public ResourceLocation modBlockTexture(String path) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    static record SpookyBlockFamily(Supplier<Block> planks,
                                    Supplier<? extends SlabBlock> slab,
                                    Supplier<? extends StairBlock> stairs,
                                    Supplier<? extends FenceBlock> fence,
                                    Supplier<? extends FenceGateBlock> fenceGate,
                                    Supplier<? extends DoorBlock> door,
                                    Supplier<? extends TrapDoorBlock> trapdoor,
                                    Supplier<? extends RotatedPillarBlock> log,
                                    Supplier<? extends RotatedPillarBlock> strippedLog,
                                    Supplier<? extends LeavesBlock> leaves,
                                    Supplier<? extends SaplingBlock> sapling) {
    }

    static SpookyBlockFamily SORBUS = new SpookyBlockFamily(
        SpookyBlocks.SORBUS_PLANKS,
        SpookyBlocks.SORBUS_SLAB,
        SpookyBlocks.SORBUS_STAIRS,
        SpookyBlocks.SORBUS_FENCE,
        SpookyBlocks.SORBUS_GATE,
        SpookyBlocks.SORBUS_DOOR,
        SpookyBlocks.SORBUS_TRAPDOOR,
        SpookyBlocks.SORBUS_LOG,
        SpookyBlocks.SORBUS_LOG_STRIPPED,
        SpookyBlocks.SORBUS_LEAVES,
        SpookyBlocks.SORBUS_SAPLING
    );
}
