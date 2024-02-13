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

import dev.tophatcat.mysteriousbiomes.common.entity.TheForgottenWarlockEntity;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import java.util.Comparator;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import terrablender.api.TerraBlenderApi;

public class MysteriousQuilt implements ModInitializer, TerraBlenderApi {

    private static final ResourceKey<CreativeModeTab> MYSTERIOUS_TAB =
        ResourceKey.create(Registries.CREATIVE_MODE_TAB,
            new ResourceLocation(MysteriousCommon.MOD_ID, "mysterious_tab"));

    @Override
    public void onInitialize(ModContainer mod) {
        MysteriousCommon.init();

        FabricDefaultAttributeRegistry.register(
            MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(),
            TheForgottenWarlockEntity.createAttributes());
        SpawnPlacements.register(
            MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(),
            SpawnPlacements.Type.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            TheForgottenWarlockEntity::checkSpawnRules);

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MYSTERIOUS_TAB, FabricItemGroup.builder()
            .icon(() -> new ItemStack(MysteriousRegistry.GHOSTLY_SAPLING.get())).title(Component.translatable(
                "item_group." + MysteriousCommon.MOD_ID + ".mysterious_tab")).displayItems(
                (displayContext, entries) -> BuiltInRegistries.ITEM.holders().filter(itemReference -> itemReference
                        .key().location().getNamespace().equals(MysteriousCommon.MOD_ID)).sorted(
                        Comparator.comparing(itemReference -> itemReference.key().location().getPath()))
                    .map(Holder.Reference::value)
                    .forEachOrdered(entries::accept)).build());
    }

    @Override
    public void onTerraBlenderInitialized() {
        MysteriousCommon.initTerraBlender();
    }
}
