package com.mcmoddev.spookybiomes.common.world.biome;

import com.mcmoddev.proxyslib.world.biome.MistyBiome;
import com.mcmoddev.spookybiomes.common.world.gen.features.WorldGenSeepingTree;
import com.mcmoddev.spookybiomes.init.ConfigHandler;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import javax.annotation.Nonnull;
import java.util.Random;

public class BiomeSeepingForest extends MistyBiome {

    public static final WorldGenSeepingTree NATURAL_GEN = new WorldGenSeepingTree(false);

    public BiomeSeepingForest() {
        super(new Biome.BiomeProperties("Seeping Forest")
                .setTemperature(0.25F).setRainfall(0.9F)
                .setBaseHeight(0.05F).setHeightVariation(0.65F));
        setRegistryName("seeping_forest");
        spawnableCreatureList.add(new Biome.SpawnListEntry(
                EntitySlime.class, 5, 1, 4));
        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = 4;
        decorator.generateFalls = true;
        mistColor = 0x98ad92;
        if (ConfigHandler.misc.disableBiomeMist) {
            mistDensity = 1.0F;
        } else {
            mistDensity = 0.50F;
        }
    }

    @Nonnull
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return (NATURAL_GEN);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x729e65;
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x85E21F;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x85E21F;
    }

    @Override
    public int getWaterColorMultiplier() {
        return 0x85E21F;
    }

    @Override
    public float getSpawningChance() {
        return 0.2F;
    }
}
