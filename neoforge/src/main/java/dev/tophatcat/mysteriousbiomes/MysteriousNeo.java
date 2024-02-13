/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2024
 * https://github.com/kiris-mods/mysterious-biomes/blob/dev/LICENSE.md
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriousbiomes.client.MysteriousRenderingNeo;
import dev.tophatcat.mysteriousbiomes.common.entity.TheForgottenWarlockEntity;
import dev.tophatcat.mysteriousbiomes.common.worldgen.MysteriousRegion;
import dev.tophatcat.mysteriousbiomes.common.worldgen.MysteriousSurfaceRules;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.datagen.client.MysteriousBlockStateProvider;
import dev.tophatcat.mysteriousbiomes.datagen.client.MysteriousItemModelProvider;
import dev.tophatcat.mysteriousbiomes.datagen.client.MysteriousLanguageProvider;
import dev.tophatcat.mysteriousbiomes.datagen.server.MysteriousLootTableProvider;
import dev.tophatcat.mysteriousbiomes.datagen.server.MysteriousRecipeProvider;
import dev.tophatcat.mysteriousbiomes.datagen.server.MysteriousTagProvider;
import dev.tophatcat.mysteriousbiomes.platform.NeoForgePlatformHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.Comparator;

@Mod(MysteriousCommon.MOD_ID)
public class MysteriousNeo {

    public static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MysteriousCommon.MOD_ID);

    private static final DeferredHolder<CreativeModeTab, CreativeModeTab> MYSTERIOUS_TAB =
        TABS.register("mysterious_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(MysteriousRegistry.GHOSTLY_SAPLING.get()))
            .title(Component.translatable("item_group." + MysteriousCommon.MOD_ID + ".mysterious_tab"))
            .displayItems((displayContext, entries) -> BuiltInRegistries.ITEM.holders().filter(itemReference
                    -> itemReference.key().location().getNamespace().equals(MysteriousCommon.MOD_ID)).sorted(
                        Comparator.comparing(itemReference -> itemReference.key().location().getPath()))
                .map(Holder.Reference::value).forEachOrdered(entries::accept)).build());

    public MysteriousNeo(IEventBus bus) {
        MysteriousCommon.init();
        for (var registry : NeoForgePlatformHelper.REGISTRIES.values()) {
            registry.register(bus);
        }

        bus.addListener(this::gatherData);
        bus.addListener(this::registerEntityAttributes);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(MysteriousRenderingNeo::registerEntityModels);
            bus.addListener(MysteriousRenderingNeo::registerModelLayers);
        }

        TABS.register(bus);

        bus.addListener(this::worldGenSetup);
    }

    private void worldGenSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(MysteriousCommon::initTerraBlender);
    }

    public void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(
            MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(),
            TheForgottenWarlockEntity.createAttributes().build());
        SpawnPlacements.register(
            MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(),
            SpawnPlacements.Type.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            TheForgottenWarlockEntity::checkSpawnRules);
    }

    public void gatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var existingHelper = event.getExistingFileHelper();

        // Datagen block and item tags.
        var blockTags = gen.addProvider(true, new MysteriousTagProvider.MysteriousBlockTags(gen.getPackOutput(),
            event.getLookupProvider(), existingHelper));

        gen.addProvider(true, new MysteriousTagProvider.MysteriousItemTags(gen.getPackOutput(),
            event.getLookupProvider(), blockTags.contentsGetter(), existingHelper));

        // Datagen language files.
        gen.addProvider(event.includeClient(), new MysteriousLanguageProvider(gen.getPackOutput(),
            MysteriousCommon.MOD_ID, "en_us"));

        // Datagen the block states and model files.
        gen.addProvider(event.includeClient(), new MysteriousBlockStateProvider(gen.getPackOutput(), existingHelper));

        // Datagen item model files.
        gen.addProvider(event.includeClient(), new MysteriousItemModelProvider(gen.getPackOutput(), existingHelper));

        // Datagen recipes.
        gen.addProvider(event.includeServer(), new MysteriousRecipeProvider(
            gen.getPackOutput(), event.getLookupProvider()));

        // Datagen loot tables.
        gen.addProvider(event.includeServer(), MysteriousLootTableProvider.create(gen.getPackOutput()));
    }
}
