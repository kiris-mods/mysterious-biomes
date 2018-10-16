package io.github.proxyneko.spookybiomes.api.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class SpookyBiome extends Biome {

    public int fogColor = -1;
    public float fogDensity = 1.0F;

    public SpookyBiome(BiomeProperties properties) {
        super(properties);
    }

    public int getFogColor(BlockPos pos) {
        return fogColor;
    }

    public float getFogDensity(BlockPos pos) {
        return fogDensity;
    }
}