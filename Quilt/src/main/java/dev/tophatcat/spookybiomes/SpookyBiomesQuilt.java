package dev.tophatcat.spookybiomes;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;

public class SpookyBiomesQuilt implements ModInitializer {

    @Override
    public void onInitialize(final ModContainer mod) {
        init();
        SpookyBiomesCommon.ITEM_TAB = QuiltItemGroup.createWithIcon(new ResourceLocation(
            SpookyBiomesCommon.MOD_ID, "group"), () -> new ItemStack(Items.BLAZE_ROD));
    }

    private static void init() {
        SpookyObjects.BLOCKS.keySet().forEach(block
            -> Registry.register(Registry.BLOCK, SpookyObjects.BLOCKS.get(block), block));
        SpookyObjects.ITEMS.keySet().forEach(item
            -> Registry.register(Registry.ITEM, SpookyObjects.ITEMS.get(item), item));
    }
}
