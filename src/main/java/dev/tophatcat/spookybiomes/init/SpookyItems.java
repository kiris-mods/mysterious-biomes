package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.world.item.Item;
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
}
