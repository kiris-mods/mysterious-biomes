package com.mcmoddev.spookybiomes.common.world.biome;

import com.mcmoddev.proxyslib.world.biome.MistyBiome;
import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import com.mcmoddev.spookybiomes.common.world.gen.features.WorldGenBloodTree;
import com.mcmoddev.spookybiomes.init.ConfigHandler;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import javax.annotation.Nonnull;
import java.util.Random;

public class BiomeBloodiedHills extends MistyBiome {

    protected static final WorldGenBloodTree NORMAL_TREE = new WorldGenBloodTree(false);
    protected static final WorldGenBloodTree BIG_TREE = new WorldGenBloodTree(false);

    public BiomeBloodiedHills() {
        super(new Biome.BiomeProperties("Bloodied Hills")
                .setTemperature(0.50F).setRainfall(0.5F)
                .setBaseHeight(0.01F).setHeightVariation(0.50F));
        setRegistryName("bloodied_hills");
        topBlock = SpookyBlockObjects.BLOODIED_GRASS.getDefaultState();
        fillerBlock = SpookyBlockObjects.BLOODIED_DIRT.getDefaultState();
        spawnableCreatureList.clear();
        spawnableCreatureList.add(new Biome.SpawnListEntry(
                EntityVex.class, 1, 1, 1));
        spawnableCreatureList.add(new Biome.SpawnListEntry(
                EntityTheForgottenWarlock.class, 1, 1, 1));
        decorator.treesPerChunk = 6;
        decorator.grassPerChunk = 3;
        decorator.generateFalls = true;
        mistColor = 0x5F021F;
        if (ConfigHandler.misc.disableBiomeMist) {
            mistDensity = 1.0F;
        } else {
            mistDensity = 0.05F;
        }
    }

    @Nonnull
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return (rand.nextInt(10) == 0 ? BIG_TREE : NORMAL_TREE);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x5F021F;
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x540101;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xc23700;
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
