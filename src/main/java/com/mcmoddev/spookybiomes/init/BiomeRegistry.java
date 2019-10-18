package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.proxyslib.world.biome.MistyBiome;
import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.common.world.biome.BiomeBloodiedHills;
import com.mcmoddev.spookybiomes.common.world.biome.BiomeGhostlyForest;
import com.mcmoddev.spookybiomes.common.world.biome.BiomeSeepingForest;
import com.mcmoddev.spookybiomes.common.world.biome.BiomeSorbusForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class BiomeRegistry {

    public static final MistyBiome SORBUS_FOREST = new BiomeSorbusForest();
    public static final MistyBiome GHOSTLY_FOREST = new BiomeGhostlyForest();
    public static final MistyBiome SEEPING_FOREST = new BiomeSeepingForest();
    public static final MistyBiome BLOODIED_HILLS = new BiomeBloodiedHills();

    @SubscribeEvent
    public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().registerAll(
                SORBUS_FOREST,
                GHOSTLY_FOREST,
                SEEPING_FOREST,
                BLOODIED_HILLS
        );
    }

    public static void registerBiomeTypes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(SORBUS_FOREST, ConfigHandler.biomeGeneration.sorbusBiomeWeight));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(GHOSTLY_FOREST, ConfigHandler.biomeGeneration.ghostlyBiomeWeight));
        //TODO Add configs for biome weight
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BLOODIED_HILLS, 25));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(SEEPING_FOREST, 25));

        BiomeManager.addSpawnBiome(SORBUS_FOREST);
        BiomeManager.addSpawnBiome(GHOSTLY_FOREST);
        BiomeManager.addSpawnBiome(BLOODIED_HILLS);
        BiomeManager.addSpawnBiome(SEEPING_FOREST);

        BiomeManager.addStrongholdBiome(SORBUS_FOREST);
        BiomeManager.addStrongholdBiome(GHOSTLY_FOREST);
        BiomeManager.addStrongholdBiome(BLOODIED_HILLS);
        BiomeManager.addStrongholdBiome(SEEPING_FOREST);

        BiomeDictionary.addTypes(SORBUS_FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.WET);
        BiomeDictionary.addTypes(GHOSTLY_FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DEAD);
        BiomeDictionary.addTypes(BLOODIED_HILLS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
        BiomeDictionary.addTypes(SEEPING_FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.WET);
    }
}
