package dev.tophatcat.mysteriousbiomes.core;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MysteriousFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODWOOD_TREE
        = FeatureUtils.createKey("bloodwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GHOSTLY_TREE
        = FeatureUtils.createKey("ghostly_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SORBUS_TREE
        = FeatureUtils.createKey("sorbus_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEEPING_TREE
        = FeatureUtils.createKey("seeping_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_TREE
        = FeatureUtils.createKey("walnut_tree");
}
