package com.mcmoddev.spookybiomes.common.world.biome;

import com.mcmoddev.proxyslib.world.biome.MistyBiome;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import com.mcmoddev.spookybiomes.common.world.gen.features.WorldGenSorbusTree;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeSorbusForest extends MistyBiome {

    public static final WorldGenSorbusTree TREE_GEN = new WorldGenSorbusTree(true);
    public static final WorldGenSorbusTree NATURAL_GEN = new WorldGenSorbusTree(false);

    public BiomeSorbusForest() {
        super(new BiomeProperties("Sorbus Forest").setTemperature(0.25F).setRainfall(0.9F).setBaseHeight(0.05F).setHeightVariation(0.65F));
        setRegistryName("sorbus_forest");
        spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityWitch.class, 6, 3, 5));
        spawnableMonsterList.add(new SpawnListEntry(EntityTheForgottenWarlock.class, 8, 1, 3));
        decorator.treesPerChunk = 4;
        decorator.grassPerChunk = 4;
        decorator.generateFalls = true;
        fogColor = 0xff5605;
        fogDensity = 0.500F;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return (TREE_GEN);
    }

    public int getGrassColorAtPos(BlockPos pos) {
        return 0xbf9200;
    }

    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x706300;
    }

    public int getWaterColorMultiplier() {
        return 0xdccaff;
    }

    @Override
    public float getSpawningChance() {
        return 0.1F;
    }
}