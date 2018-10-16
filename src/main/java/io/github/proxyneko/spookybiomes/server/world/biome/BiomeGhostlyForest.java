package io.github.proxyneko.spookybiomes.server.world.biome;

import io.github.proxyneko.spookybiomes.api.world.biome.SpookyBiome;
import io.github.proxyneko.spookybiomes.server.entity.EntityTheForgottenWarlock;
import io.github.proxyneko.spookybiomes.server.world.gen.features.WorldGenGhostlyTree;
import io.github.proxyneko.spookybiomes.server.world.trees.WorldGenGhostlyTrees;
import net.minecraft.block.BlockTallGrass.EnumType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeGhostlyForest extends SpookyBiome {

    public static final WorldGenGhostlyTree TREE_GEN = new WorldGenGhostlyTree(true);
    public static final WorldGenGhostlyTree NATURAL_GEN = new WorldGenGhostlyTree(false);

    public BiomeGhostlyForest() {
        super(new BiomeProperties("Ghostly Forest").setTemperature(0.25F).setRainfall(0.9F).setBaseHeight(0.05F).setHeightVariation(0.45F));
        setRegistryName("ghostly_forest");
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 2, 2, 2));
        spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 4, 1, 3));
        spawnableMonsterList.add(new SpawnListEntry(EntityTheForgottenWarlock.class, 5, 1, 2));
        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = 5;
        decorator.generateFalls = true;
        fogColor = 0xedfffd;
        fogDensity = 0.150F;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return (rand.nextInt(10) == 0 ? NATURAL_GEN : TREE_GEN);
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        return rand.nextInt(4) == 0 ? new WorldGenTallGrass(EnumType.GRASS) : new WorldGenTallGrass(EnumType.FERN);
    }

    public int getGrassColorAtPos(BlockPos pos) {
        return 0xdbe6e5;
    }

    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xdbe6e5;
    }

    public int getWaterColorMultiplier() {
        return 0x0a2a72;
    }

    @Override
    public float getSpawningChance() {
        return 0.1F;
    }
}