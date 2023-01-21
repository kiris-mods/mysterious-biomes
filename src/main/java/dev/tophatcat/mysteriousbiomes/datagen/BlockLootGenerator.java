package dev.tophatcat.mysteriousbiomes.datagen;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.function.BiConsumer;

public class BlockLootGenerator extends SimpleFabricLootTableProvider {

    public BlockLootGenerator(FabricDataGenerator dataGen) {
        super(dataGen, LootContextParamSets.BLOCK);
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        var spookyWoodTypes = List.of(
            MysteriousWoodTypes.BLOODWOOD.getName(),
            MysteriousWoodTypes.GHOSTLY.getName(),
            MysteriousWoodTypes.SORBUS.getName(),
            MysteriousWoodTypes.SEEPING.getName(),
            MysteriousWoodTypes.SAKURA.getName());
        var spookyBlockTypes = List.of(
            "trapdoor", "slab", "stairs", "planks",
            "log", "stripped_log", "wood", "stripped_wood",
            "gate", "fence", "button", "pressure_plate", "sapling");

        spookyWoodTypes.forEach(woodType -> {
            spookyBlockTypes.forEach(blockType -> {
                var spookyIdentifier = new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_" + blockType);
                biConsumer.accept(new ResourceLocation(spookyIdentifier.getNamespace(), "blocks/"
                    + spookyIdentifier.getPath()), BlockLoot.createSingleItemTable(
                    MysteriousContentSetup.BLOCKS.get(spookyIdentifier).get().asItem()));
            });

            var doorIdentifier = new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_door");
            biConsumer.accept(new ResourceLocation(doorIdentifier.getNamespace(), "blocks/"
                + doorIdentifier.getPath()), BlockLoot.createDoorTable(
                MysteriousContentSetup.BLOCKS.get(doorIdentifier).get()));

            var leafIdentifier = new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_leaves");
            var saplingIdentifier = new ResourceLocation(MysteriousBiomes.MOD_ID, woodType + "_sapling");
            biConsumer.accept(new ResourceLocation(leafIdentifier.getNamespace(), "blocks/"
                + leafIdentifier.getPath()), BlockLoot.createLeavesDrops(
                MysteriousContentSetup.BLOCKS.get(leafIdentifier).get(),
                MysteriousContentSetup.BLOCKS.get(saplingIdentifier).get(),
                0.05F, 0.0625F, 0.083333336F, 0.1F));
        });

        var dirtIdentifier = new ResourceLocation(MysteriousBiomes.MOD_ID, "bloodied_dirt");
        biConsumer.accept(new ResourceLocation(dirtIdentifier.getNamespace(), "blocks/"
                + dirtIdentifier.getPath()),
            BlockLoot.createSingleItemTable(MysteriousContentSetup.BLOCKS.get(dirtIdentifier).get().asItem()));

        var grassIdentifier = new ResourceLocation(MysteriousBiomes.MOD_ID, "bloodied_grass");
        biConsumer.accept(new ResourceLocation(grassIdentifier.getNamespace(), "blocks/"
                + grassIdentifier.getPath()),
            BlockLoot.createSilkTouchOnlyTable(MysteriousContentSetup.BLOCKS.get(grassIdentifier).get().asItem()));
    }
}