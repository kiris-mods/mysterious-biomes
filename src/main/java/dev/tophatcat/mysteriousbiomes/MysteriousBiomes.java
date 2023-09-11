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

import dev.tophatcat.mysteriousbiomes.entity.EntityTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousFlammableBlocks;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousWoodType;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import terrablender.api.TerraBlenderApi;

import java.util.Comparator;

public class MysteriousBiomes implements ModInitializer, TerraBlenderApi {

    //TODO Make sure all of the following work properly
    //Structures?
    //World generation.
    //Saplings.
    //Mist not working in biomes.
    //Poison the player if they enter the biome without a charm for protection.
    //Add a config to disable this in certain cases.
    //Charms to protect against poisonings from the mist.
    //Loot generation for said charms.
    //Compat with Eight's mod.
    //Baubles or Charms compat.
    //Full set of textures for all blocks and for The Forgotten Warlock.
    //Check The Forgotten Warlock is spawning in the world.
    //Check all block and item properties are correct.
    public static final String MOD_ID = "mysteriousbiomes";

    public static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
            new ResourceLocation(MOD_ID, "group"));

    public static final EntityType<EntityTheForgottenWarlock> THE_FORGOTTEN_WARLOCK = Registry.register(
            BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(MysteriousBiomes.MOD_ID, "the_forgotten_warlock"),
            QuiltEntityTypeBuilder.<EntityTheForgottenWarlock>createMob()
                    .spawnGroup(MobCategory.MONSTER)
                    .entityFactory(EntityTheForgottenWarlock::new)
                    .defaultAttributes(EntityTheForgottenWarlock.theForgottenWarlockAttributes())
                    .setDimensions(EntityDimensions.fixed(0.75F, 2.30F))
                    .maxChunkTrackingRange(1)
                    .spawnRestriction(SpawnPlacements.Type.ON_GROUND,
                            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules)
                    .build());

    @Override
    public void onInitialize(ModContainer container) {
        MysteriousWoodType.init();
        MysteriousContentSetup.init();
        MysteriousFlammableBlocks.init();

        MysteriousContentSetup.BLOCKS.forEach((id, block) -> Registry.register(BuiltInRegistries.BLOCK, id, block.get()));
        MysteriousContentSetup.ITEMS.forEach((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item.get()));

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP, FabricItemGroup.builder()
                .title(Component.translatable(Util.makeDescriptionId("itemGroup",
                        new ResourceLocation(MOD_ID, "group"))))
                .icon(() -> new ItemStack(MysteriousBlockTypes.GHOSTLY.sapling.get()))
                .displayItems((displayContext, entries) -> BuiltInRegistries.ITEM.holders()
                        .filter(itemReference -> itemReference.key().location().getNamespace().equals(MOD_ID))
                        .sorted(Comparator.comparing(itemReference -> itemReference.key().location().getPath()))
                        .map(Holder.Reference::value)
                        .forEachOrdered(entries::accept))
                .build());

        BiomeModifications.addSpawn(biome -> biome.getBiomeHolder().is(BiomeTags.IS_FOREST),
                MobCategory.MONSTER, THE_FORGOTTEN_WARLOCK,
                10, 1, 2);
    }
}
