package dev.tophatcat.mysteriousbiomes.core;

import org.quiltmc.qsl.item.content.registry.api.ItemContentRegistries;

public class MysteriousFlammableBlocks {

    public static void init() {
        //Bloodwood tree family.
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_PLANKS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_STAIRS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_SLAB.get().asItem(), 150);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_FENCE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_GATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_SIGN.get(), 200);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get().asItem(), 800);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_BUTTON.get().asItem(), 100);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.BLOODWOOD_SAPLING.get().asItem(), 100);

        //Ghostly tree family.
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_PLANKS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_STAIRS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_SLAB.get().asItem(), 150);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_TRAPDOOR.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_FENCE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_GATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_SIGN.get(), 200);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get().asItem(), 800);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_BUTTON.get().asItem(), 100);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.GHOSTLY_SAPLING.get().asItem(), 100);

        //Seeping tree family.
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_STRIPPED_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_PLANKS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_STAIRS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_SLAB.get().asItem(), 150);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_TRAPDOOR.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_FENCE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_GATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_SIGN.get(), 200);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_HANGING_SIGN.get().asItem(), 800);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_BUTTON.get().asItem(), 100);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SEEPING_SAPLING.get().asItem(), 100);

        //Sorbus tree family.
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_STRIPPED_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_PLANKS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_STAIRS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_SLAB.get().asItem(), 150);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_TRAPDOOR.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_FENCE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_GATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_SIGN.get(), 200);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_HANGING_SIGN.get().asItem(), 800);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_BUTTON.get().asItem(), 100);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.SORBUS_SAPLING.get().asItem(), 100);

        //Walnut tree family.
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_STRIPPED_LOG.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_PLANKS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_STAIRS.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_SLAB.get().asItem(), 150);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_TRAPDOOR.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_FENCE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_GATE.get().asItem(), 300);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_SIGN.get(), 200);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_HANGING_SIGN.get().asItem(), 800);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_BUTTON.get().asItem(), 100);
        ItemContentRegistries.FUEL_TIMES.put(MysteriousRegistry.WALNUT_SAPLING.get().asItem(), 100);
    }
}
