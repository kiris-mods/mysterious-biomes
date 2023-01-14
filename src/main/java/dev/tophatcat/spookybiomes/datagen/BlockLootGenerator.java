package dev.tophatcat.spookybiomes.datagen;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.setup.SpookyContentSetup;
import dev.tophatcat.spookybiomes.setup.SpookyWoodTypes;
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
            SpookyWoodTypes.BLOODWOOD.getName(),
            SpookyWoodTypes.GHOSTLY.getName(),
            SpookyWoodTypes.SORBUS.getName(),
            SpookyWoodTypes.SEEPING.getName());
        var spookyBlockTypes = List.of(
            "trapdoor", "slab", "stairs", "planks",
            "log", "stripped_log", "wood", "stripped_wood",
            "gate", "fence", "button", "pressure_plate", "sapling");

        spookyWoodTypes.forEach(woodType -> {

            spookyBlockTypes.forEach(blockType -> {
                var spookyIdentifier = new Identifier(SpookyBiomes.MOD_ID, woodType + "_" + blockType);
                biConsumer.accept(new Identifier(spookyIdentifier.getNamespace(), "blocks/"
                    + spookyIdentifier.getPath()), BlockLootTableGenerator.drops(
                    SpookyContentSetup.BLOCKS.get(spookyIdentifier).get().asItem()));
            });

            var doorIdentifier = new Identifier(SpookyBiomes.MOD_ID, woodType + "_door");
            biConsumer.accept(new Identifier(doorIdentifier.getNamespace(), "blocks/"
                + doorIdentifier.getPath()), BlockLootTableGenerator.addDoorDrop(
                SpookyContentSetup.BLOCKS.get(doorIdentifier).get()));

            var leafIdentifier = new Identifier(SpookyBiomes.MOD_ID, woodType + "_leaves");
            var saplingIdentifier = new Identifier(SpookyBiomes.MOD_ID, woodType + "_sapling");
            biConsumer.accept(new Identifier(leafIdentifier.getNamespace(), "blocks/"
                + leafIdentifier.getPath()), BlockLootTableGenerator.leavesDrop(
                SpookyContentSetup.BLOCKS.get(leafIdentifier).get(),
                SpookyContentSetup.BLOCKS.get(saplingIdentifier).get(),
                0.05F, 0.0625F, 0.083333336F, 0.1F));
        });
    }
}
