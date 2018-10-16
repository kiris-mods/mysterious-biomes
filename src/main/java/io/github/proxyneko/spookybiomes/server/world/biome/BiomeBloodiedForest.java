package io.github.proxyneko.spookybiomes.server.world.biome;

import io.github.proxyneko.spookybiomes.api.world.biome.SpookyBiome;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class BiomeBloodiedForest extends SpookyBiome {

    public BiomeBloodiedForest() {
        super(new Biome.BiomeProperties("Bloodied Forest").setTemperature(0.50F).setRainfall(0.5F).setBaseHeight(0.01F).setHeightVariation(0.05F));
        setRegistryName("bloodied_forest");
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityVex.class, 1, 1, 1));
        decorator.treesPerChunk = 5;
        decorator.grassPerChunk = 2;
        decorator.generateFalls = true;
        fogColor = 0xFF5605;
        fogDensity = 0.500F;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x8F0000;
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x8F0000;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x4F0000;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 0x8F0000;
    }

    @Override
    public float getSpawningChance() {
        return 0.2F;
    }
}
