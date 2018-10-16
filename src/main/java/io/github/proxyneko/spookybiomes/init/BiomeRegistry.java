package io.github.proxyneko.spookybiomes.init;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.api.world.biome.SpookyBiome;
import io.github.proxyneko.spookybiomes.common.world.biome.BiomeBloodiedForest;
import io.github.proxyneko.spookybiomes.common.world.biome.BiomeGhostlyForest;
import io.github.proxyneko.spookybiomes.common.world.biome.BiomeOozingHills;
import io.github.proxyneko.spookybiomes.common.world.biome.BiomeWitchwoodForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class BiomeRegistry {

    public static final SpookyBiome WITCHWOOD_FOREST = null;
    public static final SpookyBiome GHOSTLY_FOREST = null;
    public static final SpookyBiome OOZING_HILLS = null;
    public static final SpookyBiome BLOODIED_FOREST = null;

    //TODO Enable this when tree generation is fixed. - Proxy
    //@SubscribeEvent
    public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().registerAll
                (
                        new BiomeWitchwoodForest(),
                        new BiomeGhostlyForest(),
                        new BiomeOozingHills(),
                        new BiomeBloodiedForest()
                );
    }

    public static void registerBiomeTypes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(WITCHWOOD_FOREST, ConfigHandler.biomeGeneration.witchwoodBiomeWeight));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(GHOSTLY_FOREST, ConfigHandler.biomeGeneration.ghostlyBiomeWeight));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BLOODIED_FOREST, 25));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(OOZING_HILLS, 25));

        BiomeManager.addSpawnBiome(WITCHWOOD_FOREST);
        BiomeManager.addSpawnBiome(GHOSTLY_FOREST);
        BiomeManager.addSpawnBiome(BLOODIED_FOREST);
        BiomeManager.addSpawnBiome(OOZING_HILLS);

        BiomeManager.addStrongholdBiome(WITCHWOOD_FOREST);
        BiomeManager.addStrongholdBiome(GHOSTLY_FOREST);
        BiomeManager.addStrongholdBiome(BLOODIED_FOREST);
        BiomeManager.addStrongholdBiome(OOZING_HILLS);

        BiomeDictionary.addTypes(WITCHWOOD_FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.WET);
        BiomeDictionary.addTypes(GHOSTLY_FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DEAD);
        BiomeDictionary.addTypes(BLOODIED_FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
        BiomeDictionary.addTypes(OOZING_HILLS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.WET);
    }
}
