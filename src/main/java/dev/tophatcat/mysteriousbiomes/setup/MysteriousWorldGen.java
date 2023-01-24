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
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

public class MysteriousWorldGen {

    public static final ResourceKey<Biome> BLOODIED_PLAINS = register("bloodied_plains");
    public static final ResourceKey<Biome> GHOSTLY_WOODLANDS = register("ghostly_woodlands");
    public static final ResourceKey<Biome> SEEPING_FOREST = register("seeping_forest");
    public static final ResourceKey<Biome> SORBUS_HIGHLANDS = register("sorbus_highlands");
    public static final ResourceKey<Biome> SAKURA_HILLS = register("sakura_hills");

    public MysteriousWorldGen() {
        BuiltinRegistries.register(BuiltinRegistries.BIOME, BLOODIED_PLAINS.location(), setupBloodiedPlains());
        BuiltinRegistries.register(BuiltinRegistries.BIOME, GHOSTLY_WOODLANDS.location(), setupGhostlyWoodlands());
        BuiltinRegistries.register(BuiltinRegistries.BIOME, SEEPING_FOREST.location(), setupSeepingForest());
        BuiltinRegistries.register(BuiltinRegistries.BIOME, SORBUS_HIGHLANDS.location(), setupSorbusHighlands());
        BuiltinRegistries.register(BuiltinRegistries.BIOME, SAKURA_HILLS.location(), setupSakuraHills());
    }

    private static Biome setupBloodiedPlains() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.plainsSpawns(spawnSettings);
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        addBasicFeatures(biomeBuilder);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
            MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 1, 1, 1));
        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.7F)
            .downfall(0.4F)
            .specialEffects(
                new BiomeSpecialEffects.Builder()
                    .waterColor(9371648)
                    .waterFogColor(6226463)
                    .fogColor(6226463)
                    .skyColor(6226463)
                    .foliageColorOverride(12728064)
                    .grassColorOverride(5505281)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
            .mobSpawnSettings(spawnSettings.build())
            .generationSettings(biomeBuilder.build())
            .build();
    }

    private static Biome setupGhostlyWoodlands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.plainsSpawns(spawnSettings);
        addBasicFeatures(biomeBuilder);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
            MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 1, 1, 1));
        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.25F)
            .downfall(0.9F)
            .specialEffects(
                new BiomeSpecialEffects.Builder()
                    .waterColor(666226)
                    .waterFogColor(666226)
                    .fogColor(12638463)
                    .skyColor(7972607)
                    .foliageColorOverride(14411493)
                    .grassColorOverride(14411493)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
            .mobSpawnSettings(spawnSettings.build())
            .generationSettings(biomeBuilder.build())
            .build();
    }

    private static Biome setupSeepingForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.plainsSpawns(spawnSettings);
        addBasicFeatures(biomeBuilder);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
            MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 1, 1, 1));
        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.25F)
            .downfall(0.9F)
            .specialEffects(
                new BiomeSpecialEffects.Builder()
                    .waterColor(8774175)
                    .waterFogColor(8774175)
                    .fogColor(7511653)
                    .skyColor(7511653)
                    .foliageColorOverride(8774175)
                    .grassColorOverride(8774175)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
            .mobSpawnSettings(spawnSettings.build())
            .generationSettings(biomeBuilder.build())
            .build();
    }

    private static Biome setupSorbusHighlands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.caveSpawns(spawnSettings);
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.plainsSpawns(spawnSettings);
        addBasicFeatures(biomeBuilder);
        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.25F)
            .downfall(0.9F)
            .specialEffects(
                new BiomeSpecialEffects.Builder()
                    .waterColor(113369231)
                    .waterFogColor(13369231)
                    .fogColor(15859663)
                    .skyColor(15859663)
                    .foliageColorOverride(8690688)
                    .grassColorOverride(10665728)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
            .mobSpawnSettings(spawnSettings.build())
            .generationSettings(biomeBuilder.build())
            .build();
    }

    private static Biome setupSakuraHills() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.plainsSpawns(spawnSettings);
        addBasicFeatures(biomeBuilder);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
            MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 1, 1, 1));
        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.RAIN)
            .temperature(0.6F)
            .downfall(0.5F)
            .specialEffects(
                new BiomeSpecialEffects.Builder()
                    .waterColor(79146188)
                    .waterFogColor(79146188)
                    .fogColor(252164255)
                    .skyColor(93185232)
                    .foliageColorOverride(7516570)
                    .grassColorOverride(7516570)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
            .mobSpawnSettings(spawnSettings.build())
            .generationSettings(biomeBuilder.build())
            .build();
    }

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(MysteriousBiomes.MOD_ID, name));
    }

    private static void addBasicFeatures(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultOres(builder, true);
        BiomeDefaultFeatures.addExtraGold(builder);
        BiomeDefaultFeatures.addPlainGrass(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
    }
}
