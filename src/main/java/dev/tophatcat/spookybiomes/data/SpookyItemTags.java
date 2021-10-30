package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

/**
 * A provider to generate the item tags.
 */
public class SpookyItemTags extends ItemTagsProvider {

    /**
     * A simple constructor.
     *
     * @param generator          the generator to generate the data
     * @param blockTags          the provider to copy the block tag data from
     * @param existingFileHelper a helper to validate any existing tags
     */
    public SpookyItemTags(final DataGenerator generator, final BlockTagsProvider blockTags,
                          @Nullable final ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, SpookyBiomes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // Copy existing tag data
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        for (SpookyBlockFamily family : SpookyBlockFamily.FAMILIES) {
            this.copy(family.logsBlockTag(), family.logsItemTag());
        }
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
    }
}
