package dev.tophatcat.spookybiomes.datagen;

import dev.tophatcat.spookybiomes.setup.SpookyContentSetup;
import dev.tophatcat.spookybiomes.setup.SpookyWoodTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.family.BlockFamily;

public class BlockModelGenerator extends FabricModelProvider {

    private static final BlockFamily BLOODWOOD = fromWoodType(SpookyWoodTypes.BLOODWOOD);
    private static final BlockFamily GHOSTLY = fromWoodType(SpookyWoodTypes.GHOSTLY);
    private static final BlockFamily SORBUS = fromWoodType(SpookyWoodTypes.SORBUS);
    private static final BlockFamily SEEPING = fromWoodType(SpookyWoodTypes.SEEPING);

    public BlockModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGen) {
        makeWoodTypes(modelGen, SpookyWoodTypes.BLOODWOOD, BLOODWOOD);
        makeWoodTypes(modelGen, SpookyWoodTypes.GHOSTLY, GHOSTLY);
        makeWoodTypes(modelGen, SpookyWoodTypes.SORBUS, SORBUS);
        makeWoodTypes(modelGen, SpookyWoodTypes.SEEPING, SEEPING);
        modelGen.registerSimpleCubeAll(SpookyWoodTypes.BLOODWOOD.getLeaves().get());
        modelGen.registerSimpleCubeAll(SpookyWoodTypes.GHOSTLY.getLeaves().get());
        modelGen.registerSimpleCubeAll(SpookyWoodTypes.SORBUS.getLeaves().get());
        modelGen.registerSimpleCubeAll(SpookyWoodTypes.SEEPING.getLeaves().get());
        modelGen.registerTintableCross(SpookyWoodTypes.BLOODWOOD.getSapling().get(),
            BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(SpookyWoodTypes.GHOSTLY.getSapling().get(),
            BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(SpookyWoodTypes.SORBUS.getSapling().get(),
            BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerTintableCross(SpookyWoodTypes.SEEPING.getSapling().get(),
            BlockStateModelGenerator.TintType.NOT_TINTED);
        modelGen.registerSimpleCubeAll(SpookyContentSetup.BLOODIED_DIRT.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }

    private void makeWoodTypes(BlockStateModelGenerator generator, SpookyWoodTypes woodType, BlockFamily family) {
        generator.registerLog(woodType.getLog().get()).log(woodType.getLog().get()).wood(woodType.getWood().get());
        generator.registerLog(woodType.getStrippedLog().get()).log(woodType.getStrippedLog().get())
            .wood(woodType.getStrippedWood().get());
        generator.registerCubeAllModelTexturePool(woodType.getPlanks().get()).family(family);
    }

    private static BlockFamily fromWoodType(SpookyWoodTypes woodTypes) {
        return new BlockFamily.Builder(woodTypes.getPlanks().get())
            .button(woodTypes.getButton().get())
            .door(woodTypes.getDoor().get())
            .fence(woodTypes.getFence().get())
            .fenceGate(woodTypes.getGate().get())
            .pressurePlate(woodTypes.getPressurePlate().get())
            .slab(woodTypes.getSlab().get())
            .stairs(woodTypes.getStairs().get())
            //TODO Sign stuff!
            //.sign(woodTypes.getFloorSign().get(), woodTypes.getWallSign().get())
            .trapdoor(woodTypes.getTrapdoor().get()).group("wooden").unlockCriterionName("has_planks").build();

    }
}
