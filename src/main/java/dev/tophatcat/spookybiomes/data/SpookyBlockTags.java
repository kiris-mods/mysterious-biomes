package dev.tophatcat.spookybiomes.data;

import com.google.common.collect.ImmutableSet;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Supplier;

/**
 * A provider to generate the block tags.
 */
public class SpookyBlockTags extends BlockTagsProvider {

    /**
     * A simple constructor.
     *
     * @param generator          the generator to generate the data
     * @param existingFileHelper a helper to validate any existing tags
     */
    public SpookyBlockTags(final DataGenerator generator, @Nullable final ExistingFileHelper existingFileHelper) {
        super(generator, SpookyBiomes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // Shoveled Blocks
        this.addToTags(ImmutableSet.of(BlockTags.DIRT, BlockTags.MINEABLE_WITH_SHOVEL),
            SpookyBlocks.BLOODIED_DIRT,
            SpookyBlocks.BLOODIED_GRASS);

        for (SpookyBlockFamily family : SpookyBlockFamily.FAMILIES) {
            this.addToTags(Set.of(BlockTags.LEAVES, BlockTags.MINEABLE_WITH_HOE), family.leaves());
            this.addToTag(family.logsBlockTag(), family.log(), family.strippedLog());
            this.addToTag(BlockTags.LOGS_THAT_BURN, family.logsBlockTag());
            this.addToTag(BlockTags.PLANKS, family.planks());
            this.addToTag(BlockTags.SAPLINGS, family.sapling());
            this.addToTag(BlockTags.FENCE_GATES, family.fenceGate());
            this.addToTag(BlockTags.WOODEN_DOORS, family.door());
            this.addToTag(BlockTags.WOODEN_TRAPDOORS, family.trapdoor());
            this.addToTag(BlockTags.WOODEN_STAIRS, family.stairs());
            this.addToTag(BlockTags.WOODEN_FENCES, family.fence());
            this.addToTag(BlockTags.WOODEN_SLABS, family.slab());
            this.addToTag(BlockTags.WOODEN_PRESSURE_PLATES, family.pressurePlate());
            this.addToTag(BlockTags.WOODEN_BUTTONS, family.button());
            this.addToTag(BlockTags.STANDING_SIGNS, family.standingSign());
            this.addToTag(BlockTags.WALL_SIGNS, family.wallSign());
        }
    }

    @SafeVarargs
    private void addToTag(final Tag.Named<Block> tag, final Supplier<? extends Block>... additions) {
        this.addToTags(ImmutableSet.of(tag), additions);
    }

    @SafeVarargs
    private void addToTags(final Set<Tag.Named<Block>> tags, final Supplier<? extends Block>... additions) {
        tags.forEach(tag -> this.tag(tag).add(Arrays.stream(additions).map(Supplier::get).toArray(Block[]::new)));
    }

    @SafeVarargs
    private void addToTag(final Tag.Named<Block> tag, final Tag.Named<Block>... additions) {
        this.addToTags(ImmutableSet.of(tag), additions);
    }

    @SafeVarargs
    private void addToTags(final Set<Tag.Named<Block>> tags, final Tag.Named<Block>... additions) {
        tags.forEach(tag -> this.tag(tag).addTags(additions));
    }
}
