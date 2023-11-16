package dev.tophatcat.mysteriousbiomes.world;

import com.mojang.datafixers.util.Pair;
import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class MysteriousRegion extends Region {

    public MysteriousRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(Biomes.SAVANNA, MysteriousBiomes.BLOODIED_PLAINS);
            builder.replaceBiome(Biomes.SAVANNA_PLATEAU, MysteriousBiomes.GHOSTLY_WOODLANDS);
            builder.replaceBiome(Biomes.WINDSWEPT_SAVANNA, MysteriousBiomes.SORBUS_HIGHLANDS);
            builder.replaceBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS, MysteriousBiomes.SEEPING_FOREST);
        });
    }
}
