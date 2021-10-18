package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.VanillaBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpookyBiomesInjection {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, SpookyBiomes.MOD_ID);

    // Dummy biomes to make BiomeManager not blow up and for the json biomes to overwrite biome in world.
    static {
        BIOMES.register("bloodied_hills", VanillaBiomes::theVoidBiome);
        BIOMES.register("ghostly_forest", VanillaBiomes::theVoidBiome);
        BIOMES.register("seeping_forest", VanillaBiomes::theVoidBiome);
        BIOMES.register("sorbus_forest", VanillaBiomes::theVoidBiome);

        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "bloodied_hills")),
                5));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "ghostly_forest")),
                5));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "seeping_forest")),
                5));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
            new BiomeManager.BiomeEntry(ResourceKey.create(Registry.BIOME_REGISTRY,
                new ResourceLocation(SpookyBiomes.MOD_ID, "sorbus_forest")),
                5));
    }
}
