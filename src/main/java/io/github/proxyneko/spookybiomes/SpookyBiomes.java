package io.github.proxyneko.spookybiomes;

import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = SpookyBiomes.MODID, name = SpookyBiomes.NAME, version = SpookyBiomes.VERSION, acceptedMinecraftVersions = SpookyBiomes.MCVERSION, certificateFingerprint = SpookyBiomes.FINGERPRINT, updateJSON = SpookyBiomes.UPDATEJSON)
public class SpookyBiomes {

    public static final String MODID = "spookybiomes";
    public static final String NAME = "Spooky Biomes";
    public static final String VERSION = "@version@";
    public static final String MCVERSION = "@mc_version@";
    public static final String FINGERPRINT = "@fingerprint@";
    public static final String UPDATEJSON = "@update_json@";
    public static final Logger NEKO_LOGGER = LogManager.getLogger(NAME);

    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlocksSB.GHOSTLY_SAPLING);
        }
    };

    @Mod.Instance(MODID)
    public static SpookyBiomes instance;

    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        FMLLog.bigWarning("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported by Proxy!");
    }

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NEKO_LOGGER.info("Its time to get spooky!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NEKO_LOGGER.info("OOOOooooooo Look out for The Lost Warlock!");
        //BiomeRegistry.registerBiomeTypes();
        //TODO Enable once tree generation is fixed. Spawns random trees in certain areas. - Proxy
        //GameRegistry.registerWorldGenerator(new SpookyWorldGenerator(), 10);

        //TODO Create this and move it somewhere else as this is for the client not the server. - Proxy
        //MinecraftForge.EVENT_BUS.register(new FogHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        NEKO_LOGGER.info("AHHHH!! The SPOOKYS ARE COMING FOR ME!!");
    }
}
