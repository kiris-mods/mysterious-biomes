package com.mcmoddev.spookybiomes.common.world.gen;

import com.mcmoddev.spookybiomes.common.world.biome.BiomeGhostlyForest;
import com.mcmoddev.spookybiomes.common.world.biome.BiomeSorbusForest;
import com.mcmoddev.spookybiomes.init.ConfigHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class SpookyWorldGenerator implements IWorldGenerator {

    @Override
    @SuppressWarnings("deprecation")
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                generateOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }

        if (ConfigHandler.treeGeneration.sorbusOnHills > 0 &&
                BiomeDictionary.hasType(world.getBiome(new BlockPos(chunkX, 0, chunkZ)), Type.HILLS)) {
            for (int i = 0; i < ConfigHandler.treeGeneration.sorbusOnHills; ++i) {
                if (random.nextInt(10) == 0) {
                    BlockPos blockpos = world.getHeight(new BlockPos(chunkX, 0, chunkZ)
                            .add(random.nextInt(15) + 8, 0, random.nextInt(15) + 8));

                    if (TerrainGen.decorate(world, random, blockpos, EventType.TREE)) {
                        BiomeSorbusForest.NATURAL_GEN.generate(world, random, blockpos);
                    }
                }
            }
        }

        if (ConfigHandler.treeGeneration.ghostlyOnHills > 0 &&
                BiomeDictionary.hasType(world.getBiome(new BlockPos(chunkX, 0, chunkZ)), Type.HILLS)) {
            for (int i = 0; i < ConfigHandler.treeGeneration.ghostlyOnHills; ++i) {
                if (random.nextInt(10) == 0) {
                    BlockPos blockpos = world.getHeight(new BlockPos(chunkX, 0, chunkZ)
                            .add(random.nextInt(15) + 8, 0, random.nextInt(15) + 8));

                    if (TerrainGen.decorate(world, random, blockpos, EventType.TREE)) {
                        BiomeGhostlyForest.NATURAL_GEN.generate(world, random, blockpos);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unused")
    private void generateNether(World world, Random random, int chunkX, int chunkZ) {
    }

    @SuppressWarnings("unused")
    private void generateOverworld(World world, Random random, int chunkX, int chunkZ) {
    }

    @SuppressWarnings("unused")
    private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
    }
}