package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriousbiomes.common.entity.EntityTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Comparator;

public class MysteriousFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MysteriousCommon.init();

        FabricDefaultAttributeRegistry.register(MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(),
            EntityTheForgottenWarlock.createAttributes());

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MysteriousCommon.ITEM_GROUP, FabricItemGroup.builder()
            .title(Component.translatable(Util.makeDescriptionId("itemGroup",
                new ResourceLocation(MysteriousCommon.MOD_ID, "group"))))
            .icon(() -> new ItemStack(MysteriousRegistry.GHOSTLY_SAPLING.get()))
            .displayItems((displayContext, entries) -> BuiltInRegistries.ITEM.holders()
                .filter(itemReference -> itemReference.key().location().getNamespace().equals(MysteriousCommon.MOD_ID))
                .sorted(Comparator.comparing(itemReference -> itemReference.key().location().getPath()))
                .map(Holder.Reference::value)
                .forEachOrdered(entries::accept))
            .build());
    }
}
