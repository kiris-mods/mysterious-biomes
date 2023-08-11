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
package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class MysteriousWorldGen {

    public static final RegistryKey<Biome> BLOODIED_PLAINS = register("bloodied_plains");
    public static final RegistryKey<Biome> GHOSTLY_WOODLANDS = register("ghostly_woodlands");
    public static final RegistryKey<Biome> SEEPING_FOREST = register("seeping_forest");
    public static final RegistryKey<Biome> SORBUS_HIGHLANDS = register("sorbus_highlands");

    public MysteriousWorldGen() {
        //TODO Setup biomes and terrablender? Please?
        //Registry.register(RegistryKeys.BIOME, BLOODIED_PLAINS.getRegistry(), setupBloodiedPlains());
        //Registry.register(RegistryKeys.BIOME, GHOSTLY_WOODLANDS.getRegistry(), setupGhostlyWoodlands());
        //Registry.register(RegistryKeys.BIOME, SEEPING_FOREST.getRegistry(), setupSeepingForest());
        //Registry.register(RegistryKeys.BIOME, SORBUS_HIGHLANDS.getRegistry(), setupSorbusHighlands());
    }

    private static Biome setupBloodiedPlains(RegistryEntryLookup<PlacedFeature> placedFeatureGetter,
                                             RegistryEntryLookup<ConfiguredCarver<?>> carverGetter) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder
                = new GenerationSettings.LookupBackedBuilder(placedFeatureGetter, carverGetter);
        DefaultBiomeFeatures.addPlainsMobs(spawnSettings);
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
        addBasicFeatures(biomeBuilder);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 1, 1, 1));
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7F)
                .downfall(0.4F)
                .effects(
                        new BiomeEffects.Builder()
                                .waterColor(9371648)
                                .waterFogColor(6226463)
                                .fogColor(6226463)
                                .skyColor(6226463)
                                .foliageColor(12728064)
                                .grassColor(5505281)
                                .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static Biome setupGhostlyWoodlands(RegistryEntryLookup<PlacedFeature> placedFeatureGetter,
                                               RegistryEntryLookup<ConfiguredCarver<?>> carverGetter) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder
                = new GenerationSettings.LookupBackedBuilder(placedFeatureGetter, carverGetter);
        DefaultBiomeFeatures.addPlainsMobs(spawnSettings);
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
        addBasicFeatures(biomeBuilder);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 1, 1, 1));
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.25F)
                .downfall(0.9F)
                .effects(
                        new BiomeEffects.Builder()
                                .waterColor(666226)
                                .waterFogColor(666226)
                                .fogColor(12638463)
                                .skyColor(7972607)
                                .foliageColor(14411493)
                                .grassColor(14411493)
                                .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static Biome setupSeepingForest(RegistryEntryLookup<PlacedFeature> placedFeatureGetter,
                                            RegistryEntryLookup<ConfiguredCarver<?>> carverGetter) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder
                = new GenerationSettings.LookupBackedBuilder(placedFeatureGetter, carverGetter);
        DefaultBiomeFeatures.addPlainsMobs(spawnSettings);
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
        addBasicFeatures(biomeBuilder);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(
                MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 1, 1, 1));
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.25F)
                .downfall(0.9F)
                .effects(
                        new BiomeEffects.Builder()
                                .waterColor(8774175)
                                .waterFogColor(8774175)
                                .fogColor(7511653)
                                .skyColor(7511653)
                                .foliageColor(8774175)
                                .grassColor(8774175)
                                .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static Biome setupSorbusHighlands(RegistryEntryLookup<PlacedFeature> placedFeatureGetter,
                                              RegistryEntryLookup<ConfiguredCarver<?>> carverGetter) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.LookupBackedBuilder biomeBuilder
                = new GenerationSettings.LookupBackedBuilder(placedFeatureGetter, carverGetter);
        DefaultBiomeFeatures.addPlainsMobs(spawnSettings);
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
        addBasicFeatures(biomeBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.25F)
                .downfall(0.9F)
                .effects(
                        new BiomeEffects.Builder()
                                .waterColor(113369231)
                                .waterFogColor(13369231)
                                .fogColor(15859663)
                                .skyColor(15859663)
                                .foliageColor(8690688)
                                .grassColor(10665728)
                                .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(MysteriousBiomes.MOD_ID, name));
    }

    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addDefaultOres(builder, true);
        DefaultBiomeFeatures.addExtraGoldOre(builder);
        DefaultBiomeFeatures.addPlainsTallGrass(builder);
        DefaultBiomeFeatures.addDefaultDisks(builder);
    }
}
