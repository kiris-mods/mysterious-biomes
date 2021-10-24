package dev.tophatcat.spookybiomes.data;

import com.google.common.collect.ImmutableSet;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.SpookyTags;
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

        // Leaves
        this.addToTags(ImmutableSet.of(BlockTags.LEAVES, BlockTags.MINEABLE_WITH_HOE),
            SpookyBlocks.SORBUS_LEAVES,
            SpookyBlocks.GHOSTLY_LEAVES,
            SpookyBlocks.SEEPING_LEAVES,
            SpookyBlocks.BLOODWOOD_LEAVES);

        // Logs
        this.addToTag(SpookyTags.Blocks.SORBUS_LOGS,
            SpookyBlocks.SORBUS_LOG,
            SpookyBlocks.SORBUS_LOG_STRIPPED);
        this.addToTag(SpookyTags.Blocks.GHOSTLY_LOGS,
            SpookyBlocks.GHOSTLY_LOG,
            SpookyBlocks.GHOSTLY_LOG_STRIPPED);
        this.addToTag(SpookyTags.Blocks.SEEPING_LOGS,
            SpookyBlocks.SEEPING_LOG,
            SpookyBlocks.SEEPING_LOG_STRIPPED);
        this.addToTag(SpookyTags.Blocks.BLOODWOOD_LOGS,
            SpookyBlocks.BLOODWOOD_LOG,
            SpookyBlocks.BLOODWOOD_LOG_STRIPPED);
        this.addToTag(BlockTags.LOGS_THAT_BURN,
            SpookyTags.Blocks.SORBUS_LOGS,
            SpookyTags.Blocks.GHOSTLY_LOGS,
            SpookyTags.Blocks.SEEPING_LOGS,
            SpookyTags.Blocks.BLOODWOOD_LOGS);

        // Planks
        this.addToTag(BlockTags.PLANKS,
            SpookyBlocks.SORBUS_PLANKS,
            SpookyBlocks.GHOSTLY_PLANKS,
            SpookyBlocks.SEEPING_PLANKS,
            SpookyBlocks.BLOODWOOD_PLANKS);

        // Saplings
        this.addToTag(BlockTags.SAPLINGS,
            SpookyBlocks.SORBUS_SAPLING,
            SpookyBlocks.GHOSTLY_SAPLING,
            SpookyBlocks.SEEPING_SAPLING,
            SpookyBlocks.BLOODWOOD_SAPLING);

        // Fence Gates
        this.addToTag(BlockTags.FENCE_GATES,
            SpookyBlocks.SORBUS_GATE,
            SpookyBlocks.GHOSTLY_GATE,
            SpookyBlocks.SEEPING_GATE,
            SpookyBlocks.BLOODWOOD_GATE);

        // Doors
        this.addToTag(BlockTags.WOODEN_DOORS,
            SpookyBlocks.SORBUS_DOOR,
            SpookyBlocks.GHOSTLY_DOOR,
            SpookyBlocks.SEEPING_DOOR,
            SpookyBlocks.BLOODWOOD_DOOR);

        // Trapdoors
        this.addToTag(BlockTags.WOODEN_TRAPDOORS,
            SpookyBlocks.SORBUS_TRAPDOOR,
            SpookyBlocks.GHOSTLY_TRAPDOOR,
            SpookyBlocks.SEEPING_TRAPDOOR,
            SpookyBlocks.BLOODWOOD_TRAPDOOR);

        // Stairs
        this.addToTag(BlockTags.WOODEN_STAIRS,
            SpookyBlocks.SORBUS_STAIRS,
            SpookyBlocks.GHOSTLY_STAIRS,
            SpookyBlocks.SEEPING_STAIRS,
            SpookyBlocks.BLOODWOOD_STAIRS);

        // Fences
        this.addToTag(BlockTags.WOODEN_FENCES,
            SpookyBlocks.SORBUS_FENCE,
            SpookyBlocks.GHOSTLY_FENCE,
            SpookyBlocks.SEEPING_FENCE,
            SpookyBlocks.BLOODWOOD_FENCE);

        // Slabs
        this.addToTag(BlockTags.WOODEN_SLABS,
            SpookyBlocks.SORBUS_SLAB,
            SpookyBlocks.GHOSTLY_SLAB,
            SpookyBlocks.SEEPING_SLAB,
            SpookyBlocks.BLOODWOOD_SLAB);
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
