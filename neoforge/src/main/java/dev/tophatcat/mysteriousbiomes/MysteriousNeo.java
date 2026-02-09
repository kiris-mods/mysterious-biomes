/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2025
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
import dev.tophatcat.mysteriousbiomes.data.MysteriousBiomeGen;
import dev.tophatcat.mysteriousbiomes.data.MysteriousFeaturesGen;
import dev.tophatcat.mysteriousbiomes.data.MysteriousPlacementsGen;
import dev.tophatcat.mysteriousbiomes.data.client.MysteriousBlockStateProvider;
import dev.tophatcat.mysteriousbiomes.data.client.MysteriousItemModelProvider;
import dev.tophatcat.mysteriousbiomes.data.client.MysteriousLanguageProvider;
import dev.tophatcat.mysteriousbiomes.data.server.MysteriousLootTableProvider;
import dev.tophatcat.mysteriousbiomes.data.server.MysteriousRecipeProvider;
import dev.tophatcat.mysteriousbiomes.data.server.MysteriousTagProvider;
import dev.tophatcat.mysteriousbiomes.entity.TheForgottenWarlockEntity;
import dev.tophatcat.mysteriouslands.MysteriousLandsCommon;
import dev.tophatcat.mysteriouslands.registry.EntityRegistry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(MysteriousLandsCommon.MOD_ID)
public class MysteriousNeo {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
        Registries.BLOCK_ENTITY_TYPE, MysteriousLandsCommon.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        Registries.BLOCK, MysteriousLandsCommon.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
        Registries.ENTITY_TYPE, MysteriousLandsCommon.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        Registries.ITEM, MysteriousLandsCommon.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
        Registries.SOUND_EVENT, MysteriousLandsCommon.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB, MysteriousLandsCommon.MOD_ID);

    public MysteriousNeo(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
        BLOCKS.register(bus);
        ENTITIES.register(bus);
        ITEMS.register(bus);
        SOUND_EVENTS.register(bus);
        CREATIVE_TABS.register(bus);
        bus.<FMLCommonSetupEvent>addListener(event -> MysteriousCommon.setupBlockEntities());
        MysteriousLandsCommon.init();

        bus.addListener(this::gatherData);
        if (FMLEnvironment.getDist() == Dist.CLIENT) {
            bus.addListener(MysteriousRenderingNeo::registerEntityModels);
            bus.addListener(MysteriousRenderingNeo::registerModelLayers);
        }
    }

    public void gatherData(GatherDataEvent.Client event) {
        RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, MysteriousFeaturesGen::run)
            .add(Registries.PLACED_FEATURE, MysteriousPlacementsGen::run)
            .add(Registries.BIOME, MysteriousBiomeGen::run);

        var generator = event.getGenerator();
        var packOutput = event.getGenerator().getPackOutput();
        var lookupProvider = event.getLookupProvider();

        var blockTags = generator.addProvider(new MysteriousTagProvider.MysteriousBlockTags(packOutput, lookupProvider));

        event.createProvider(MysteriousLanguageProvider::new);
        event.createProvider(MysteriousBlockStateProvider::new);

        generator.addProvider(new GatherDataEvent.Client(), new MysteriousTagProvider.MysteriousItemTags(packOutput, lookupProvider, blockTags.contentsGetter()));
        generator.addProvider(new MysteriousItemModelProvider(packOutput));
        generator.addProvider(new MysteriousRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(MysteriousLootTableProvider.create(packOutput, lookupProvider));
        generator.addProvider(new MysteriousBiomeGen(packOutput, lookupProvider, BUILDER));
    }
}
