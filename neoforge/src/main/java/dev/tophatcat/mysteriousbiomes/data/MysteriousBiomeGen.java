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
package dev.tophatcat.mysteriousbiomes.data;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriouslands.registry.EntityRegistry;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

public class MysteriousBiomeGen extends DatapackBuiltinEntriesProvider {

    public MysteriousBiomeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
                              RegistrySetBuilder builder) {
        super(output, registries, builder, Set.of(MysteriousCommon.MOD_ID));
    }

    public static void run(BootstrapContext<Biome> context) {
        context.register(MysteriousCommon.BLOOD_SOAKED_PLAINS, bloodSoakedPlains(context));
        context.register(MysteriousCommon.GHOSTLY_WOODLANDS, ghostlyWoodlands(context));
        context.register(MysteriousCommon.SEEPING_FOREST, seepingForest(context));
        context.register(MysteriousCommon.SORBUS_HIGHLANDS, sorbusHighlands(context));
        context.register(MysteriousCommon.WALNUT_WOODLANDS, walnutWoodlands(context));
    }

    private static Biome bloodSoakedPlains(BootstrapContext<Biome> context) {
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
            .skyColor(6226463)
            .fogColor(6226463)
            .waterColor(9371648)
            .waterFogColor(9371648);

        return new Biome.BiomeBuilder()
            .downfall(0.5F)
            .hasPrecipitation(true)
            .temperature(0.5F)
            .generationSettings(commonGenerationSettings(context).build())
            .specialEffects(effects.build())
            .mobSpawnSettings(commonMobSpawnSettings().build())
            .build();
    }

    private static Biome ghostlyWoodlands(BootstrapContext<Biome> context) {
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
            .skyColor(7972607)
            .fogColor(12638463)
            .waterColor(666226)
            .waterFogColor(666226)
            .grassColorOverride(14411493)
            .foliageColorOverride(14411493);

        return new Biome.BiomeBuilder()
            .downfall(0.9F)
            .hasPrecipitation(true)
            .temperature(0.25F)
            .generationSettings(commonGenerationSettings(context).build())
            .specialEffects(effects.build())
            .mobSpawnSettings(commonMobSpawnSettings().build())
            .build();
    }

    private static Biome seepingForest(BootstrapContext<Biome> context) {
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
            .skyColor(7511653)
            .fogColor(7511653)
            .waterColor(8774175)
            .waterFogColor(8774175)
            .grassColorOverride(8774175)
            .foliageColorOverride(8774175);

        return new Biome.BiomeBuilder()
            .downfall(0.9F)
            .hasPrecipitation(true)
            .temperature(0.25F)
            .generationSettings(commonGenerationSettings(context).build())
            .specialEffects(effects.build())
            .mobSpawnSettings(commonMobSpawnSettings().build())
            .build();
    }

    private static Biome sorbusHighlands(BootstrapContext<Biome> context) {
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
            .skyColor(15859663)
            .fogColor(15859663)
            .waterColor(13369231)
            .waterFogColor(13369231)
            .grassColorOverride(10665728)
            .foliageColorOverride(8690688);

        return new Biome.BiomeBuilder()
            .downfall(0.9F)
            .hasPrecipitation(true)
            .temperature(0.25F)
            .generationSettings(commonGenerationSettings(context).build())
            .specialEffects(effects.build())
            .mobSpawnSettings(commonMobSpawnSettings().build())
            .build();
    }

    private static Biome walnutWoodlands(BootstrapContext<Biome> context) {
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder();
        //TODO Set up effects.
            //.skyColor()
            //.fogColor()
            //.waterColor()
            //.waterFogColor()
            //.grassColorOverride()
            //.foliageColorOverride();
        return new Biome.BiomeBuilder()
            .downfall(0.7F)
            .hasPrecipitation(true)
            .temperature(0.50F)
            .generationSettings(commonGenerationSettings(context).build())
            //.specialEffects(effects.build())
            .mobSpawnSettings(commonMobSpawnSettings().build())
            .build();
    }

    private static MobSpawnSettings.Builder commonMobSpawnSettings() {
        return new MobSpawnSettings.Builder()
            .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                EntityRegistry.THE_FORGOTTEN_WARLOCK.get(), 1, 1, 2))
            .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                EntityType.ZOMBIE, 1, 2, 2))
            .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                EntityType.SKELETON, 1, 2, 2))
            .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                EntityType.CREEPER, 1, 1, 2));
    }

    private static BiomeGenerationSettings.PlainBuilder commonGenerationSettings(BootstrapContext<Biome> context) {
        return new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
            context.lookup(Registries.CONFIGURED_CARVER))
            .addFeature(GenerationStep.Decoration.LAKES, context.lookup(Registries.PLACED_FEATURE)
                .get(MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND).get())
            .addFeature(GenerationStep.Decoration.LAKES, context.lookup(Registries.PLACED_FEATURE)
                .get(MiscOverworldPlacements.LAKE_LAVA_SURFACE).get())
            .addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, context.lookup(Registries.PLACED_FEATURE)
                .get(CavePlacements.AMETHYST_GEODE).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_DIRT).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_GRAVEL).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_COAL_UPPER).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_COAL_LOWER).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_IRON_UPPER).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_IRON_MIDDLE).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_IRON_SMALL).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_GOLD).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_GOLD_LOWER).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_REDSTONE).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_REDSTONE_LOWER).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_DIAMOND).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_DIAMOND_LARGE).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_DIAMOND_BURIED).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_LAPIS).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_LAPIS_BURIED).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(OrePlacements.ORE_COPPER).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(CavePlacements.UNDERWATER_MAGMA).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(MiscOverworldPlacements.DISK_SAND).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(MiscOverworldPlacements.DISK_CLAY).get())
            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, context.lookup(Registries.PLACED_FEATURE)
                .get(MiscOverworldPlacements.DISK_GRAVEL).get())
            .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, context.lookup(Registries.PLACED_FEATURE)
                .get(MiscOverworldPlacements.SPRING_WATER).get())
            .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, context.lookup(Registries.PLACED_FEATURE)
                .get(MiscOverworldPlacements.SPRING_LAVA).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(CavePlacements.GLOW_LICHEN).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(VegetationPlacements.FOREST_FLOWERS).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(VegetationPlacements.FLOWER_DEFAULT).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(VegetationPlacements.PATCH_GRASS_FOREST).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(VegetationPlacements.BROWN_MUSHROOM_NORMAL).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(VegetationPlacements.RED_MUSHROOM_NORMAL).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(VegetationPlacements.PATCH_SUGAR_CANE).get())
            .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, context.lookup(Registries.PLACED_FEATURE)
                .get(VegetationPlacements.PATCH_PUMPKIN).get());
    }
}
