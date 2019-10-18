package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import com.mcmoddev.spookybiomes.api.items.ItemsSB;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictRegistry {

    public static void init() {
        //Witchwood stuff
        OreDictionary.registerOre("logWood", BlocksSB.SORBUS_LOG);
        OreDictionary.registerOre("treeLeaves", BlocksSB.SORBUS_LEAVES);
        OreDictionary.registerOre("plankWood", BlocksSB.SORBUS_PLANKS);
        OreDictionary.registerOre("treeSapling", BlocksSB.SORBUS_SAPLING);
        OreDictionary.registerOre("fenceGateWood", BlocksSB.SORBUS_GATE);
        OreDictionary.registerOre("doorWood", ItemsSB.SORBUS_DOOR);
        OreDictionary.registerOre("stairWood", BlocksSB.SORBUS_STAIRS);
        OreDictionary.registerOre("fenceWood", BlocksSB.SORBUS_FENCE);

        //Ghostly stuff
        OreDictionary.registerOre("logWood", BlocksSB.GHOSTLY_LOG);
        OreDictionary.registerOre("treeLeaves", BlocksSB.GHOSTLY_LEAVES);
        OreDictionary.registerOre("plankWood", BlocksSB.GHOSTLY_PLANKS);
        OreDictionary.registerOre("treeSapling", BlocksSB.GHOSTLY_SAPLING);
        OreDictionary.registerOre("fenceGateWood", BlocksSB.GHOSTLY_GATE);
        OreDictionary.registerOre("doorWood", ItemsSB.GHOSTLY_DOOR);
        OreDictionary.registerOre("stairWood", BlocksSB.GHOSTLY_STAIRS);
        OreDictionary.registerOre("fenceWood", BlocksSB.GHOSTLY_FENCE);

        //Seeping stuff
        OreDictionary.registerOre("logWood", BlocksSB.SEEPING_LOG);
        OreDictionary.registerOre("treeLeaves", BlocksSB.SEEPING_LEAVES);
        OreDictionary.registerOre("plankWood", BlocksSB.SEEPING_PLANKS);
        OreDictionary.registerOre("treeSapling", BlocksSB.SEEPING_SAPLING);
        OreDictionary.registerOre("fenceGateWood", BlocksSB.SEEPING_GATE);
        OreDictionary.registerOre("doorWood", ItemsSB.SEEPING_DOOR);
        OreDictionary.registerOre("stairWood", BlocksSB.SEEPING_STAIRS);
        OreDictionary.registerOre("fenceWood", BlocksSB.SEEPING_FENCE);

        //Bloodwood stuff
        OreDictionary.registerOre("logWood", BlocksSB.BLOODWOOD_LOG);
        OreDictionary.registerOre("treeLeaves", BlocksSB.BLOODWOOD_LEAVES);
        OreDictionary.registerOre("plankWood", BlocksSB.BLOODWOOD_PLANKS);
        OreDictionary.registerOre("treeSapling", BlocksSB.BLOODWOOD_SAPLING);
        OreDictionary.registerOre("fenceGateWood", BlocksSB.BLOODWOOD_GATE);
        OreDictionary.registerOre("doorWood", ItemsSB.BLOODWOOD_DOOR);
        OreDictionary.registerOre("stairWood", BlocksSB.BLOODWOOD_STAIRS);
        OreDictionary.registerOre("fenceWood", BlocksSB.BLOODWOOD_FENCE);
    }
}
