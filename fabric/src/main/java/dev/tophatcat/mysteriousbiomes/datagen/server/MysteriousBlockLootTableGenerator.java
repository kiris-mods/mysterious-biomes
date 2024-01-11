package dev.tophatcat.mysteriousbiomes.datagen.server;

import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.block.Block;

public class MysteriousBlockLootTableGenerator extends FabricBlockLootTableProvider {

    public MysteriousBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Misc blocks.
        dropSelf(MysteriousRegistry.BLOODIED_DIRT.get());
        add(MysteriousRegistry.BLOODIED_GRASS.get(), block
            -> createSingleItemTableWithSilkTouch(block, MysteriousRegistry.BLOODIED_DIRT.get()));

        //Bloodwood tree family.
        dropSelf(MysteriousRegistry.BLOODWOOD_LOG.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_WOOD.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_PLANKS.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_STAIRS.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_SLAB.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_FENCE.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_GATE.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_BUTTON.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_SAPLING.get());
        dropSelf(Block.byItem(MysteriousRegistry.BLOODWOOD_SIGN.get()));
        dropSelf(MysteriousRegistry.BLOODWOOD_WALL_SIGN.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get());
        dropSelf(MysteriousRegistry.BLOODWOOD_WALL_HANGING_SIGN.get());
        add(MysteriousRegistry.BLOODWOOD_DOOR.get(), this::createDoorTable);
        add(MysteriousRegistry.BLOODWOOD_LEAVES.get(), block -> createLeavesDrops(MysteriousRegistry.BLOODWOOD_LEAVES.get(),
            MysteriousRegistry.BLOODWOOD_SAPLING.get(),
            BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

        //Ghostly tree family.
        dropSelf(MysteriousRegistry.GHOSTLY_LOG.get());
        dropSelf(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get());
        dropSelf(MysteriousRegistry.GHOSTLY_WOOD.get());
        dropSelf(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get());
        dropSelf(MysteriousRegistry.GHOSTLY_PLANKS.get());
        dropSelf(MysteriousRegistry.GHOSTLY_STAIRS.get());
        dropSelf(MysteriousRegistry.GHOSTLY_SLAB.get());
        dropSelf(MysteriousRegistry.GHOSTLY_FENCE.get());
        dropSelf(MysteriousRegistry.GHOSTLY_GATE.get());
        dropSelf(MysteriousRegistry.GHOSTLY_BUTTON.get());
        dropSelf(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get());
        dropSelf(MysteriousRegistry.GHOSTLY_TRAPDOOR.get());
        dropSelf(MysteriousRegistry.GHOSTLY_SAPLING.get());
        dropSelf(Block.byItem(MysteriousRegistry.GHOSTLY_SIGN.get()));
        dropSelf(MysteriousRegistry.GHOSTLY_WALL_SIGN.get());
        dropSelf(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get());
        dropSelf(MysteriousRegistry.GHOSTLY_WALL_HANGING_SIGN.get());
        add(MysteriousRegistry.GHOSTLY_DOOR.get(), this::createDoorTable);
        add(MysteriousRegistry.GHOSTLY_LEAVES.get(), block -> createLeavesDrops(MysteriousRegistry.GHOSTLY_LEAVES.get(),
            MysteriousRegistry.GHOSTLY_SAPLING.get(),
            BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

        //Seeping tree family.
        dropSelf(MysteriousRegistry.SEEPING_LOG.get());
        dropSelf(MysteriousRegistry.SEEPING_STRIPPED_LOG.get());
        dropSelf(MysteriousRegistry.SEEPING_WOOD.get());
        dropSelf(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get());
        dropSelf(MysteriousRegistry.SEEPING_PLANKS.get());
        dropSelf(MysteriousRegistry.SEEPING_STAIRS.get());
        dropSelf(MysteriousRegistry.SEEPING_SLAB.get());
        dropSelf(MysteriousRegistry.SEEPING_FENCE.get());
        dropSelf(MysteriousRegistry.SEEPING_GATE.get());
        dropSelf(MysteriousRegistry.SEEPING_BUTTON.get());
        dropSelf(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get());
        dropSelf(MysteriousRegistry.SEEPING_TRAPDOOR.get());
        dropSelf(MysteriousRegistry.SEEPING_SAPLING.get());
        dropSelf(Block.byItem(MysteriousRegistry.SEEPING_SIGN.get()));
        dropSelf(MysteriousRegistry.SEEPING_WALL_SIGN.get());
        dropSelf(MysteriousRegistry.SEEPING_HANGING_SIGN.get());
        dropSelf(MysteriousRegistry.SEEPING_WALL_HANGING_SIGN.get());
        add(MysteriousRegistry.SEEPING_DOOR.get(), this::createDoorTable);
        add(MysteriousRegistry.SEEPING_LEAVES.get(), block -> createLeavesDrops(MysteriousRegistry.SEEPING_LEAVES.get(),
            MysteriousRegistry.SEEPING_SAPLING.get(),
            BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

        //Sorbus tree family.
        dropSelf(MysteriousRegistry.SORBUS_LOG.get());
        dropSelf(MysteriousRegistry.SORBUS_STRIPPED_LOG.get());
        dropSelf(MysteriousRegistry.SORBUS_WOOD.get());
        dropSelf(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get());
        dropSelf(MysteriousRegistry.SORBUS_PLANKS.get());
        dropSelf(MysteriousRegistry.SORBUS_STAIRS.get());
        dropSelf(MysteriousRegistry.SORBUS_SLAB.get());
        dropSelf(MysteriousRegistry.SORBUS_FENCE.get());
        dropSelf(MysteriousRegistry.SORBUS_GATE.get());
        dropSelf(MysteriousRegistry.SORBUS_BUTTON.get());
        dropSelf(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get());
        dropSelf(MysteriousRegistry.SORBUS_TRAPDOOR.get());
        dropSelf(MysteriousRegistry.SORBUS_SAPLING.get());
        dropSelf(Block.byItem(MysteriousRegistry.SORBUS_SIGN.get()));
        dropSelf(MysteriousRegistry.SORBUS_WALL_SIGN.get());
        dropSelf(MysteriousRegistry.SORBUS_HANGING_SIGN.get());
        dropSelf(MysteriousRegistry.SORBUS_WALL_HANGING_SIGN.get());
        add(MysteriousRegistry.SORBUS_DOOR.get(), this::createDoorTable);
        add(MysteriousRegistry.SORBUS_LEAVES.get(), block -> createLeavesDrops(MysteriousRegistry.SORBUS_LEAVES.get(),
            MysteriousRegistry.SORBUS_SAPLING.get(),
            BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));

        //Walnut tree family.
        dropSelf(MysteriousRegistry.WALNUT_LOG.get());
        dropSelf(MysteriousRegistry.WALNUT_STRIPPED_LOG.get());
        dropSelf(MysteriousRegistry.WALNUT_WOOD.get());
        dropSelf(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get());
        dropSelf(MysteriousRegistry.WALNUT_PLANKS.get());
        dropSelf(MysteriousRegistry.WALNUT_STAIRS.get());
        dropSelf(MysteriousRegistry.WALNUT_SLAB.get());
        dropSelf(MysteriousRegistry.WALNUT_FENCE.get());
        dropSelf(MysteriousRegistry.WALNUT_GATE.get());
        dropSelf(MysteriousRegistry.WALNUT_BUTTON.get());
        dropSelf(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get());
        dropSelf(MysteriousRegistry.WALNUT_TRAPDOOR.get());
        dropSelf(MysteriousRegistry.WALNUT_SAPLING.get());
        dropSelf(Block.byItem(MysteriousRegistry.WALNUT_SIGN.get()));
        dropSelf(MysteriousRegistry.WALNUT_WALL_SIGN.get());
        dropSelf(MysteriousRegistry.WALNUT_HANGING_SIGN.get());
        dropSelf(MysteriousRegistry.WALNUT_WALL_HANGING_SIGN.get());
        add(MysteriousRegistry.WALNUT_DOOR.get(), this::createDoorTable);
        add(MysteriousRegistry.WALNUT_LEAVES.get(), block -> createLeavesDrops(MysteriousRegistry.WALNUT_LEAVES.get(),
            MysteriousRegistry.WALNUT_SAPLING.get(),
            BlockLootSubProvider.NORMAL_LEAVES_SAPLING_CHANCES));
    }
}
