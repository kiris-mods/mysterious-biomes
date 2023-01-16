package dev.tophatcat.mysteriousbiomes.datagen;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodTypes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.BiConsumer;

public class BlockLootGenerator extends SimpleFabricLootTableProvider {

    public BlockLootGenerator(FabricDataGenerator dataGen) {
        super(dataGen, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> biConsumer) {
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
                var spookyIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_" + blockType);
                biConsumer.accept(new Identifier(spookyIdentifier.getNamespace(), "blocks/"
                    + spookyIdentifier.getPath()), BlockLootTableGenerator.drops(
                    MysteriousContentSetup.BLOCKS.get(spookyIdentifier).get().asItem()));
            });

            var doorIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_door");
            biConsumer.accept(new Identifier(doorIdentifier.getNamespace(), "blocks/"
                + doorIdentifier.getPath()), BlockLootTableGenerator.addDoorDrop(
                MysteriousContentSetup.BLOCKS.get(doorIdentifier).get()));

            var leafIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_leaves");
            var saplingIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_sapling");
            biConsumer.accept(new Identifier(leafIdentifier.getNamespace(), "blocks/"
                + leafIdentifier.getPath()), BlockLootTableGenerator.leavesDrop(
                MysteriousContentSetup.BLOCKS.get(leafIdentifier).get(),
                MysteriousContentSetup.BLOCKS.get(saplingIdentifier).get(),
                0.05F, 0.0625F, 0.083333336F, 0.1F));
        });

        var dirtIdentifier = new Identifier(MysteriousBiomes.MOD_ID, "bloodied_dirt");
        biConsumer.accept(new Identifier(dirtIdentifier.getNamespace(), "blocks/" + dirtIdentifier.getPath()),
            BlockLootTableGenerator.drops(MysteriousContentSetup.BLOCKS.get(dirtIdentifier).get().asItem()));

        var grassIdentifier = new Identifier(MysteriousBiomes.MOD_ID, "bloodied_grass");
        biConsumer.accept(new Identifier(grassIdentifier.getNamespace(), "blocks/" + grassIdentifier.getPath()),
            BlockLootTableGenerator.dropsWithSilkTouch(MysteriousContentSetup.BLOCKS.get(grassIdentifier).get().asItem()));
    }
}
