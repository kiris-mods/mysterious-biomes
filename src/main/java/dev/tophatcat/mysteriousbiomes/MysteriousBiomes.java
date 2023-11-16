/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriousbiomes.init.MysteriousConfig;
import dev.tophatcat.mysteriousbiomes.init.MysteriousEntities;
import dev.tophatcat.mysteriousbiomes.init.MysteriousFlammableBlocks;
import dev.tophatcat.mysteriousbiomes.init.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousSignType;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousUtils;
import dev.tophatcat.mysteriousbiomes.world.MysteriousRegion;
import dev.tophatcat.mysteriousbiomes.world.MysteriousSurfaceRules;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

import java.util.Comparator;

public class MysteriousBiomes implements ModInitializer, TerraBlenderApi {

    //TODO Make sure all of the following work properly/are implemented.
    //Structures?
    //World generation.
    //Saplings.
    //Mist not working in biomes.
    //Poison effect on player entering the biome with a chat warning.
    //Charm items
    // - Charm of Blood Lust (Gives you a speed and damage buff at a cost of hunger)
    // - Charm of Poisonous Mist (Protects against poison mist damage)
    // - Charm of the Elder (normal mobs act passive towards you)
    //Poison the player if they enter the biome without a charm for protection.
    //Loot generation for said charms.
    //Compat with Eight's mod.
    //Baubles or Charms compat.
    //Full set of textures for all blocks and for The Forgotten Warlock.
    public static final String MOD_ID = "mysteriousbiomes";

    public static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
        new ResourceLocation(MOD_ID, "group"));

    public static final ResourceKey<Biome> BLOODIED_PLAINS = MysteriousUtils.registerBiome("bloodied_plains");
    public static final ResourceKey<Biome> GHOSTLY_WOODLANDS = MysteriousUtils.registerBiome("ghostly_woodlands");
    public static final ResourceKey<Biome> SEEPING_FOREST = MysteriousUtils.registerBiome("seeping_forest");
    public static final ResourceKey<Biome> SORBUS_HIGHLANDS = MysteriousUtils.registerBiome("sorbus_highlands");

    @Override
    public void onInitialize(ModContainer container) {
        MidnightConfig.init(MOD_ID, MysteriousConfig.class);
        MysteriousEntities.init();
        MysteriousSignType.init();
        MysteriousRegistry.init();
        MysteriousFlammableBlocks.init();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP, FabricItemGroup.builder()
            .title(Component.translatable(Util.makeDescriptionId("itemGroup",
                new ResourceLocation(MOD_ID, "group"))))
            .icon(() -> new ItemStack(MysteriousRegistry.GHOSTLY_SAPLING.get()))
            .displayItems((displayContext, entries) -> BuiltInRegistries.ITEM.holders()
                .filter(itemReference -> itemReference.key().location().getNamespace().equals(MOD_ID))
                .sorted(Comparator.comparing(itemReference -> itemReference.key().location().getPath()))
                .map(Holder.Reference::value)
                .forEachOrdered(entries::accept))
            .build());
    }

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new MysteriousRegion(new ResourceLocation(MOD_ID, "overworld_1"), 5));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,
            MOD_ID, MysteriousSurfaceRules.makeRules());
    }
}
