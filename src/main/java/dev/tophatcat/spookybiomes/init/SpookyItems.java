package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Register our Items to the game here.
 *
 * @author ProxyNeko
 */
public class SpookyItems {

    public static final DeferredRegister<Item> ITEMS
        = DeferredRegister.create(ForgeRegistries.ITEMS, SpookyBiomes.MOD_ID);

    public static final RegistryObject<SignItem> SORBUS_SIGN = ITEMS.register("sorbus_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.SORBUS_SIGN.get(), SpookyBlocks.SORBUS_WALL_SIGN.get()));

    public static final RegistryObject<SignItem> GHOSTLY_SIGN = ITEMS.register("ghostly_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.GHOSTLY_SIGN.get(), SpookyBlocks.GHOSTLY_WALL_SIGN.get()));

    public static final RegistryObject<SignItem> SEEPING_SIGN = ITEMS.register("seeping_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.SEEPING_SIGN.get(), SpookyBlocks.SEEPING_WALL_SIGN.get()));

    public static final RegistryObject<SignItem> BLOODWOOD_SIGN = ITEMS.register("bloodwood_sign",
        () -> new SignItem(new Item.Properties().stacksTo(16).tab(SpookyBiomes.CREATIVE_TAB),
            SpookyBlocks.BLOODWOOD_SIGN.get(), SpookyBlocks.BLOODWOOD_WALL_SIGN.get()));
}
