package dev.tophatcat.spookybiomes.common;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

/**
 * A class holding the bound tags used in this mod.
 */
public class SpookyTags {

    /**
     * A class holding the bound block tags used in this mod.
     */
    public static class Blocks {

        public static final Tag.Named<Block> SORBUS_LOGS = tag("sorbus_logs");
        public static final Tag.Named<Block> GHOSTLY_LOGS = tag("ghostly_logs");
        public static final Tag.Named<Block> SEEPING_LOGS = tag("seeping_logs");
        public static final Tag.Named<Block> BLOODWOOD_LOGS = tag("bloodwood_logs");

        /**
         * Binds a block tag via its name. The name is appended with the modid.
         *
         * @param name the name of the tag
         * @return a new named, block tag
         */
        private static Tag.Named<Block> tag(final String name) {
            return genericTag(name, BlockTags::bind);
        }
    }

    /**
     * A class holding the bound item tags used in this mod.
     */
    public static class Items {

        public static final Tag.Named<Item> SORBUS_LOGS = tag("sorbus_logs");
        public static final Tag.Named<Item> GHOSTLY_LOGS = tag("ghostly_logs");
        public static final Tag.Named<Item> SEEPING_LOGS = tag("seeping_logs");
        public static final Tag.Named<Item> BLOODWOOD_LOGS = tag("bloodwood_logs");

        /**
         * Binds an item tag via its name. The name is appended with the modid.
         *
         * @param name the name of the tag
         * @return a new named, item tag
         */
        private static Tag.Named<Item> tag(final String name) {
            return genericTag(name, ItemTags::bind);
        }
    }

    /**
     * Binds a tag via its name. The name is appended with the modid.
     *
     * @param name the name of the tag
     * @param tagBind the binding function to create the tag
     * @param <T> the type of the elements of the tag
     * @return a new named tag
     */
    private static <T> Tag.Named<T> genericTag(final String name, final Function<String, Tag.Named<T>> tagBind) {
        return tagBind.apply(SpookyBiomes.MOD_ID + ":" + name);
    }
}
