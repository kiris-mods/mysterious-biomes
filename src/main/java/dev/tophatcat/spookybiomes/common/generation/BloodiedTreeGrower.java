package dev.tophatcat.spookybiomes.common.generation;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class BloodiedTreeGrower extends SpookyBiomesTreeGrower {

    @Override
    protected ConfiguredFeature<?, ?> getDynamicConfiguredFeature(final Registry<ConfiguredFeature<?, ?>>
        configuredFeatureRegistry, Random random, boolean alternative) {
        if (random.nextInt(10) == 0) {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID,
                "bloodied_tree_big"));
        } else {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID,
                "bloodied_tree"));
        }
    }
}
