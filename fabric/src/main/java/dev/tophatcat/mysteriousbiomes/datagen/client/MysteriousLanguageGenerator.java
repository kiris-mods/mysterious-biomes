package dev.tophatcat.mysteriousbiomes.datagen.client;

import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class MysteriousLanguageGenerator extends FabricLanguageProvider {

    public MysteriousLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        //Config.
        translationBuilder.add("mysteriousbiomes.midnightconfig.title", "Mysterious Biomes Config");
        translationBuilder.add("mysteriousbiomes.midnightconfig.shouldMistCausePoisonDamage",
            "Some Mysterious Biomes have a poisonous mist that cause harm without the "
                + "correct protection charms, these charms can be found in loot chests in the world.");
        translationBuilder.add("mysteriousbiomes.midnightconfig.doMistPoisonDamage",
            "Mist causes poison damage without charms?");

        //TODO Enable these once a new creative tab system has been added.
        //Creative tab/item group.
        //translationBuilder.add(MysteriousBiomes.ITEM_GROUP, "Mysterious Biomes");

        //Entities.
        translationBuilder.add(MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(), "The Forgotten Warlock");

        //Misc blocks.
        translationBuilder.add(MysteriousRegistry.BLOODIED_DIRT.get(), "Bloodied Dirt");
        translationBuilder.add(MysteriousRegistry.BLOODIED_GRASS.get(), "Bloodied Grass");

        //Bloodwood tree family.
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_LOG.get(), "Bloodwood Log");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_WOOD.get(), "Bloodwood Wood");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get(), "Bloodwood Stripped Log");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get(), "Bloodwood Stripped Wood");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_BUTTON.get(), "Bloodwood Button");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_DOOR.get(), "Bloodwood Door");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_FENCE.get(), "Bloodwood Fence");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_GATE.get(), "Bloodwood Gate");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_LEAVES.get(), "Bloodwood Leaves");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_PLANKS.get(), "Bloodwood Planks");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get(), "Bloodwood Pressure Plate");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_SAPLING.get(), "Bloodwood Sapling");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_SIGN.get(), "Bloodwood Sign");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get(), "Bloodwood Hanging Sign");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_SLAB.get(), "Bloodwood Slab");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_STAIRS.get(), "Bloodwood Stairs");
        translationBuilder.add(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get(), "Bloodwood Trapdoor");

        //Ghostly tree family.
        translationBuilder.add(MysteriousRegistry.GHOSTLY_LOG.get(), "Ghostly Log");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_WOOD.get(), "Ghostly Wood");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get(), "Ghostly Stripped Log");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get(), "Ghostly Stripped Wood");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_BUTTON.get(), "Ghostly Button");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_DOOR.get(), "Ghostly Door");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_FENCE.get(), "Ghostly Fence");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_GATE.get(), "Ghostly Gate");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_LEAVES.get(), "Ghostly Leaves");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_PLANKS.get(), "Ghostly Planks");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get(), "Ghostly Pressure Plate");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_SAPLING.get(), "Ghostly Sapling");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_SIGN.get(), "Ghostly Sign");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get(), "Ghostly Hanging Sign");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_SLAB.get(), "Ghostly Slab");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_STAIRS.get(), "Ghostly Stairs");
        translationBuilder.add(MysteriousRegistry.GHOSTLY_TRAPDOOR.get(), "Ghostly Trapdoor");

        //Seeping tree family.
        translationBuilder.add(MysteriousRegistry.SEEPING_LOG.get(), "Seeping Log");
        translationBuilder.add(MysteriousRegistry.SEEPING_WOOD.get(), "Seeping Wood");
        translationBuilder.add(MysteriousRegistry.SEEPING_STRIPPED_LOG.get(), "Seeping Stripped Log");
        translationBuilder.add(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get(), "Seeping Stripped Wood");
        translationBuilder.add(MysteriousRegistry.SEEPING_BUTTON.get(), "Seeping Button");
        translationBuilder.add(MysteriousRegistry.SEEPING_DOOR.get(), "Seeping Door");
        translationBuilder.add(MysteriousRegistry.SEEPING_FENCE.get(), "Seeping Fence");
        translationBuilder.add(MysteriousRegistry.SEEPING_GATE.get(), "Seeping Gate");
        translationBuilder.add(MysteriousRegistry.SEEPING_LEAVES.get(), "Seeping Leaves");
        translationBuilder.add(MysteriousRegistry.SEEPING_PLANKS.get(), "Seeping Planks");
        translationBuilder.add(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get(), "Seeping Pressure Plate");
        translationBuilder.add(MysteriousRegistry.SEEPING_SAPLING.get(), "Seeping Sapling");
        translationBuilder.add(MysteriousRegistry.SEEPING_SIGN.get(), "Seeping Sign");
        translationBuilder.add(MysteriousRegistry.SEEPING_HANGING_SIGN.get(), "Seeping Hanging Sign");
        translationBuilder.add(MysteriousRegistry.SEEPING_SLAB.get(), "Seeping Slab");
        translationBuilder.add(MysteriousRegistry.SEEPING_STAIRS.get(), "Seeping Stairs");
        translationBuilder.add(MysteriousRegistry.SEEPING_TRAPDOOR.get(), "Seeping Trapdoor");

        //Sorbus tree family.
        translationBuilder.add(MysteriousRegistry.SORBUS_LOG.get(), "Sorbus Log");
        translationBuilder.add(MysteriousRegistry.SORBUS_WOOD.get(), "Sorbus Wood");
        translationBuilder.add(MysteriousRegistry.SORBUS_STRIPPED_LOG.get(), "Sorbus Stripped Log");
        translationBuilder.add(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get(), "Sorbus Stripped Wood");
        translationBuilder.add(MysteriousRegistry.SORBUS_BUTTON.get(), "Sorbus Button");
        translationBuilder.add(MysteriousRegistry.SORBUS_DOOR.get(), "Sorbus Door");
        translationBuilder.add(MysteriousRegistry.SORBUS_FENCE.get(), "Sorbus Fence");
        translationBuilder.add(MysteriousRegistry.SORBUS_GATE.get(), "Sorbus Gate");
        translationBuilder.add(MysteriousRegistry.SORBUS_LEAVES.get(), "Sorbus Leaves");
        translationBuilder.add(MysteriousRegistry.SORBUS_PLANKS.get(), "Sorbus Planks");
        translationBuilder.add(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get(), "Sorbus Pressure Plate");
        translationBuilder.add(MysteriousRegistry.SORBUS_SAPLING.get(), "Sorbus Sapling");
        translationBuilder.add(MysteriousRegistry.SORBUS_SIGN.get(), "Sorbus Sign");
        translationBuilder.add(MysteriousRegistry.SORBUS_HANGING_SIGN.get(), "Sorbus Hanging Sign");
        translationBuilder.add(MysteriousRegistry.SORBUS_SLAB.get(), "Sorbus Slab");
        translationBuilder.add(MysteriousRegistry.SORBUS_STAIRS.get(), "Sorbus Stairs");
        translationBuilder.add(MysteriousRegistry.SORBUS_TRAPDOOR.get(), "Sorbus Trapdoor");

        //Walnut tree family.
        translationBuilder.add(MysteriousRegistry.WALNUT_LOG.get(), "Walnut Log");
        translationBuilder.add(MysteriousRegistry.WALNUT_WOOD.get(), "Walnut Wood");
        translationBuilder.add(MysteriousRegistry.WALNUT_STRIPPED_LOG.get(), "Walnut Stripped Log");
        translationBuilder.add(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get(), "Walnut Stripped Wood");
        translationBuilder.add(MysteriousRegistry.WALNUT_BUTTON.get(), "Walnut Button");
        translationBuilder.add(MysteriousRegistry.WALNUT_DOOR.get(), "Walnut Door");
        translationBuilder.add(MysteriousRegistry.WALNUT_FENCE.get(), "Walnut Fence");
        translationBuilder.add(MysteriousRegistry.WALNUT_GATE.get(), "Walnut Gate");
        translationBuilder.add(MysteriousRegistry.WALNUT_LEAVES.get(), "Walnut Leaves");
        translationBuilder.add(MysteriousRegistry.WALNUT_PLANKS.get(), "Walnut Planks");
        translationBuilder.add(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get(), "Walnut Pressure Plate");
        translationBuilder.add(MysteriousRegistry.WALNUT_SAPLING.get(), "Walnut Sapling");
        translationBuilder.add(MysteriousRegistry.WALNUT_SIGN.get(), "Walnut Sign");
        translationBuilder.add(MysteriousRegistry.WALNUT_HANGING_SIGN.get(), "Walnut Hanging Sign");
        translationBuilder.add(MysteriousRegistry.WALNUT_SLAB.get(), "Walnut Slab");
        translationBuilder.add(MysteriousRegistry.WALNUT_STAIRS.get(), "Walnut Stairs");
        translationBuilder.add(MysteriousRegistry.WALNUT_TRAPDOOR.get(), "Walnut Trapdoor");
    }
}
