package io.github.proxyneko.spookybiomes.common.world.biome;

import io.github.proxyneko.spookybiomes.api.world.biome.SpookyBiome;
import io.github.proxyneko.spookybiomes.common.entity.EntityTheForgottenWarlock;
import io.github.proxyneko.spookybiomes.common.world.gen.features.WorldGenWitchwoodTree;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeWitchwoodForest extends SpookyBiome {

    public static final WorldGenWitchwoodTree TREE_GEN = new WorldGenWitchwoodTree(true, true);
    public static final WorldGenWitchwoodTree NATURAL_GEN = new WorldGenWitchwoodTree(false, false);

    public BiomeWitchwoodForest() {
        super(new BiomeProperties("Witchwood Forest").setTemperature(0.25F).setRainfall(0.9F).setBaseHeight(0.05F).setHeightVariation(0.65F));
        setRegistryName("witchwood_forest");
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
        return (rand.nextInt(10) == 0 ? NATURAL_GEN : TREE_GEN);
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