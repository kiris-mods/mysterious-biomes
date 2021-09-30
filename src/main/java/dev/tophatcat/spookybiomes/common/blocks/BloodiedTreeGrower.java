package dev.tophatcat.spookybiomes.common.blocks;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nullable;
import java.util.Random;

public class BloodiedTreeGrower extends SpookyBiomeTreeGrower {
    @Override
    protected ConfiguredFeature<?, ?> getDynamicConfiguredFeature(Registry<ConfiguredFeature<?, ?>> configuredFeatureRegistry, Random random, boolean alternative) {
        if (random.nextInt(10) == 0) {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID, "bloodied_tree_big"));
        } else {
            return configuredFeatureRegistry.get(new ResourceLocation(SpookyBiomes.MOD_ID, "bloodied_tree"));
        }
    }
}
