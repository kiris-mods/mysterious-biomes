package dev.tophatcat.spookybiomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Methods to assist in the registering of blocks without having lines full of duplicated code.
 *
 * @author ProxyNeko
 */
public class RegistrationHelpers {

    public static <BLOCK extends Block, ITEM extends BlockItem>
    Pair<RegistryObject<BLOCK>, RegistryObject<ITEM>> registerBlockAndItem(
        DeferredRegister<Block> blocks,
        DeferredRegister<Item> items,
        String name,
        Supplier<BLOCK> blockFactory,
        Function<? super BLOCK, ITEM> itemFactory) {
        RegistryObject<BLOCK> block = blocks.register(name, blockFactory);
        RegistryObject<ITEM> item = items.register(name, () -> itemFactory.apply(block.get()));
        return Pair.of(block, item);
    }

    public static <BLOCK extends Block> RegistryObject<BLOCK> registerBlockAndStandardItem(
        DeferredRegister<Block> blocks,
        DeferredRegister<Item> items,
        String name,
        Supplier<BLOCK> blockFactory) {
        return registerBlockAndItem(blocks, items, name, blockFactory, block
            -> new BlockItem(block, new Item.Properties().tab(SpookyBiomes.CREATIVE_TAB))).getFirst();
    }
}
