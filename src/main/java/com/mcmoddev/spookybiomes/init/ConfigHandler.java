package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.spookybiomes.SpookyBiomes;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = SpookyBiomes.MODID, category = "")
@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class ConfigHandler {

    private static final String LANG = SpookyBiomes.MODID + ".config.";

    @Config.LangKey(LANG + "treeGeneration")
    @Config.Comment({"Tree gen settings."})
    public static final ConfigTreeGeneration treeGeneration = new ConfigTreeGeneration();

    @Config.LangKey(LANG + "biomeGeneration")
    @Config.Comment({"Biome gen settings."})
    public static final ConfigBiomeGeneration biomeGeneration = new ConfigBiomeGeneration();

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(SpookyBiomes.MODID)) {
            ConfigManager.sync(SpookyBiomes.MODID, Config.Type.INSTANCE);
        }
    }

    public static class ConfigTreeGeneration {
        @Config.LangKey(LANG + "sorbusOnHills")
        @Config.RangeInt(min = 0, max = 100)
        @Config.Comment({"Specify the gen rate of Sorbus Trees on hills. If 0, Sorbus Trees will be not generated there."})
        public int sorbusOnHills = 5;

        @Config.LangKey(LANG + "ghostlyOnHills")
        @Config.RangeInt(min = 0, max = 100)
        @Config.Comment({"Specify the gen rate of Ghostly Trees on hills. If 0, Ghostly Trees will be not generated there."})
        public int ghostlyOnHills = 5;
    }

    public static class ConfigBiomeGeneration {
        @Config.LangKey(LANG + "sorbusBiomeWeight")
        @Config.RangeInt(min = 0, max = 100)
        @Config.Comment({"Set the gen weight of Sorbus Forest biome."})
        public int sorbusBiomeWeight = 20;

        @Config.LangKey(LANG + "ghostlyForestBiomeWeight")
        @Config.RangeInt(min = 0, max = 100)
        @Config.Comment({"Set the gen weight of Ghostly Forest biome."})
        public int ghostlyBiomeWeight = 35;

        @Config.LangKey(LANG + "seepingForestBiomeWeight")
        @Config.RangeInt(min = 0, max = 100)
        @Config.Comment({"Set the gen weight of Seeping Forest biome."})
        public int seepingBiomeWeight = 35;

        @Config.LangKey(LANG + "bloodiedHillsBiomeWeight")
        @Config.RangeInt(min = 0, max = 100)
        @Config.Comment({"Set the gen weight of Bloodied Hills biome."})
        public int bloodiedBiomeWeight = 35;
    }
}
