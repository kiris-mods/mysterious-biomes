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
import dev.tophatcat.mysteriousbiomes.setup.MysteriousBlockTypes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.Heightmap;
import terrablender.api.TerraBlenderApi;

import java.util.Comparator;

public class MysteriousBiomes implements ModInitializer, TerraBlenderApi {

    //TODO Make sure all of the following work properly
    //Recipes
    //Tags
    //Loot tables
    //Block states for things like fences
    //Fire burns wooden blocks
    //Furnaces can use our woods for fuel and turn logs into charcoal
    //Advancements?
    //Structures?
    //World generation
    //Saplings
    //Mist not working in biomes
    //Configurable poison damage in our biomes
    //Charms to protect against poisonings from the mist
    //Compat with Eight's mod
    //Baubles/Charms compat
    //Full set of textures for all blocks and for The Forgotten Warlock
    //Check all block and item properties are correct.
    public static final String MOD_ID = "mysteriousbiomes";

    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            new Identifier(MOD_ID, "group"));

    public static final EntityType<EntityTheForgottenWarlock> THE_FORGOTTEN_WARLOCK = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(MysteriousBiomes.MOD_ID, "the_forgotten_warlock"),
            FabricEntityTypeBuilder.<EntityTheForgottenWarlock>createMob()
                    .spawnGroup(SpawnGroup.MONSTER)
                    .entityFactory(EntityTheForgottenWarlock::new)
                    .defaultAttributes(EntityTheForgottenWarlock::theForgottenWarlockAttributes)
                    .dimensions(EntityDimensions.fixed(0.75F, 2.30F))
                    .trackRangeChunks(1)
                    .spawnRestriction(SpawnRestriction.Location.ON_GROUND,
                            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn)
                    .build());

    @Override
    public void onInitialize() {
        MysteriousWoodType.init();
        MysteriousContentSetup.init();

        MysteriousContentSetup.BLOCKS.forEach((id, block) -> Registry.register(Registries.BLOCK, id, block.get()));
        MysteriousContentSetup.ITEMS.forEach((id, item) -> Registry.register(Registries.ITEM, id, item.get()));

        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable(Util.createTranslationKey("itemGroup",
                        new Identifier(MOD_ID, "group"))))
                .icon(() -> new ItemStack(MysteriousBlockTypes.GHOSTLY.sapling.get()))
                .entries((displayContext, entries) -> Registries.ITEM.streamEntries()
                        .filter(itemReference -> itemReference.registryKey().getValue().getNamespace().equals(MOD_ID))
                        .sorted(Comparator.comparing(itemReference -> itemReference.registryKey().getValue().getPath()))
                        .map(RegistryEntry.Reference::value)
                        .forEachOrdered(entries::add))
                .build());

        BiomeModifications.addSpawn(biome -> biome.getBiomeRegistryEntry().isIn(BiomeTags.IS_FOREST),
                SpawnGroup.MONSTER, THE_FORGOTTEN_WARLOCK,
                10, 1, 2);
    }
}
