package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;

import javax.annotation.Nonnull;

public class SpookyBlockLoot extends BlockLoot {
    protected static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        dropSelf(SpookyBlocks.BLOODIED_DIRT.get());
        add(SpookyBlocks.BLOODIED_GRASS.get(), b -> createSingleItemTableWithSilkTouch(b, SpookyBlocks.BLOODIED_DIRT.get()));

        for (SpookyBlockFamily family : SpookyBlockFamily.FAMILIES) {
            dropSelf(family.planks().get());
            add(family.slab().get(), BlockLoot::createSlabItemTable);
            dropSelf(family.stairs().get());
            dropSelf(family.fence().get());
            dropSelf(family.fenceGate().get());
            add(family.door().get(), BlockLoot::createDoorTable);
            dropSelf(family.trapdoor().get());
            dropSelf(family.log().get());
            dropSelf(family.strippedLog().get());
            dropSelf(family.sapling().get());
            add(family.leaves().get(), b -> createLeavesDrops(b, family.sapling().get(), NORMAL_LEAVES_SAPLING_CHANCES));
        }
    }

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SpookyBlocks.BLOCKS.getEntries().stream()
            .map(RegistryObject::get)
            .toList();
    }
}
