package com.mcmoddev.spookybiomes.common.world.biome;

import com.mcmoddev.proxyslib.world.biome.MistyBiome;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class BiomeBloodiedHills extends MistyBiome {

    protected static final WorldGenTrees NORMAL_TREE = new WorldGenTrees(false);
    protected static final WorldGenBigTree BIG_TREE = new WorldGenBigTree(false);

    public BiomeBloodiedHills() {
        super(new Biome.BiomeProperties("Bloodied Hills").setTemperature(0.50F).setRainfall(0.5F).setBaseHeight(0.01F).setHeightVariation(0.50F));
        setRegistryName("bloodied_hills");
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityVex.class, 1, 1, 1));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityTheForgottenWarlock.class, 1, 1, 1));
        decorator.treesPerChunk = 5;
        decorator.grassPerChunk = 2;
        decorator.generateFalls = true;
        fogColor = 0x8F0000;
        fogDensity = 0.3F;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return (rand.nextInt(10) == 0 ? BIG_TREE : NORMAL_TREE);
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
