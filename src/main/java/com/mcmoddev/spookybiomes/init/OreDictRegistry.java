package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import com.mcmoddev.spookybiomes.api.items.SpookyItemObjects;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictRegistry {

    public static void init() {
        OreDictionary.registerOre("logWood", SpookyBlockObjects.SORBUS_LOG);
        OreDictionary.registerOre("treeLeaves", SpookyBlockObjects.SORBUS_LEAVES);
        OreDictionary.registerOre("plankWood", SpookyBlockObjects.SORBUS_PLANKS);
        OreDictionary.registerOre("treeSapling", SpookyBlockObjects.SORBUS_SAPLING);
        OreDictionary.registerOre("fenceGateWood", SpookyBlockObjects.SORBUS_GATE);
        OreDictionary.registerOre("doorWood", SpookyItemObjects.SORBUS_DOOR);
        OreDictionary.registerOre("stairWood", SpookyBlockObjects.SORBUS_STAIRS);
        OreDictionary.registerOre("fenceWood", SpookyBlockObjects.SORBUS_FENCE);

        OreDictionary.registerOre("logWood", SpookyBlockObjects.GHOSTLY_LOG);
        OreDictionary.registerOre("treeLeaves", SpookyBlockObjects.GHOSTLY_LEAVES);
        OreDictionary.registerOre("plankWood", SpookyBlockObjects.GHOSTLY_PLANKS);
        OreDictionary.registerOre("treeSapling", SpookyBlockObjects.GHOSTLY_SAPLING);
        OreDictionary.registerOre("fenceGateWood", SpookyBlockObjects.GHOSTLY_GATE);
        OreDictionary.registerOre("doorWood", SpookyItemObjects.GHOSTLY_DOOR);
        OreDictionary.registerOre("stairWood", SpookyBlockObjects.GHOSTLY_STAIRS);
        OreDictionary.registerOre("fenceWood", SpookyBlockObjects.GHOSTLY_FENCE);

        OreDictionary.registerOre("logWood", SpookyBlockObjects.SEEPING_LOG);
        OreDictionary.registerOre("treeLeaves", SpookyBlockObjects.SEEPING_LEAVES);
        OreDictionary.registerOre("plankWood", SpookyBlockObjects.SEEPING_PLANKS);
        OreDictionary.registerOre("treeSapling", SpookyBlockObjects.SEEPING_SAPLING);
        OreDictionary.registerOre("fenceGateWood", SpookyBlockObjects.SEEPING_GATE);
        OreDictionary.registerOre("doorWood", SpookyItemObjects.SEEPING_DOOR);
        OreDictionary.registerOre("stairWood", SpookyBlockObjects.SEEPING_STAIRS);
        OreDictionary.registerOre("fenceWood", SpookyBlockObjects.SEEPING_FENCE);

        OreDictionary.registerOre("logWood", SpookyBlockObjects.BLOODWOOD_LOG);
        OreDictionary.registerOre("treeLeaves", SpookyBlockObjects.BLOODWOOD_LEAVES);
        OreDictionary.registerOre("plankWood", SpookyBlockObjects.BLOODWOOD_PLANKS);
        OreDictionary.registerOre("treeSapling", SpookyBlockObjects.BLOODWOOD_SAPLING);
        OreDictionary.registerOre("fenceGateWood", SpookyBlockObjects.BLOODWOOD_GATE);
        OreDictionary.registerOre("doorWood", SpookyItemObjects.BLOODWOOD_DOOR);
        OreDictionary.registerOre("stairWood", SpookyBlockObjects.BLOODWOOD_STAIRS);
        OreDictionary.registerOre("fenceWood", SpookyBlockObjects.BLOODWOOD_FENCE);
    }
}
