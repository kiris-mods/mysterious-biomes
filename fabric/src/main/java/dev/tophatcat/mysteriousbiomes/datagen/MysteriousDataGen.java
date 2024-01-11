package dev.tophatcat.mysteriousbiomes.datagen;

import dev.tophatcat.mysteriousbiomes.datagen.client.MysteriousBlockStateModelGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.client.MysteriousLanguageGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.MysteriousBlockLootTableGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.MysteriousRecipeGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.tags.MysteriousBlockTagGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.tags.MysteriousItemTagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MysteriousDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(MysteriousLanguageGenerator::new);
        pack.addProvider(MysteriousBlockTagGenerator::new);
        pack.addProvider(MysteriousItemTagGenerator::new);
        pack.addProvider(MysteriousBlockLootTableGenerator::new);
        pack.addProvider(MysteriousRecipeGenerator::new);
        pack.addProvider(MysteriousBlockStateModelGenerator::new);
    }
}
