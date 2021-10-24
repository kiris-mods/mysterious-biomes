package dev.tophatcat.spookybiomes.common.generation;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class SorbusTreeGrower extends SpookyBiomesTreeGrower {

    @Override
    protected ConfiguredFeature<?, ?> getDynamicConfiguredFeature(Registry<ConfiguredFeature<?, ?>>
                                                                      configuredFeatureRegistry, final Random random, final boolean alternative) {
        if (random.nextInt(10) == 0) {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID,
                "sorbus_tree_big"));
        } else {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID,
                "sorbus_tree"));
        }
    }
}
