package io.github.proxyneko.spookybiomes;

import com.mcmoddev.lib.data.SharedStrings;
import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
                modid = SpookyBiomes.MODID,
                name = SpookyBiomes.NAME,
                version = SpookyBiomes.VERSION,
                acceptedMinecraftVersions = SpookyBiomes.MCVERSION,
                certificateFingerprint = SpookyBiomes.FINGERPRINT,
                updateJSON = SpookyBiomes.UPDATEJSON,
                dependencies = "required-after:mmdlib"
        )
public class SpookyBiomes {

    //TODO Ore dict stuff

    @Mod.Instance(value = SpookyBiomes.MODID)
    public static SpookyBiomes instance;

    public static final String NAME = "Spooky Biomes";
    public static final String MODID = "spookybiomes";
    public static final String VERSION = "2.0.0";
    public static final String UPDATEJSON = "https://raw.githubusercontent.com/ProxyNeko/Spooky-Biomes/master/update.json";
    public static final String FINGERPRINT = "@fingerprint@";
    public static final String MCVERSION = "1.12.2";
    public static final Logger NEKO_LOGGER = LogManager.getLogger(NAME);
    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlocksSB.GHOSTLY_SAPLING);
        }
    };

    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        NEKO_LOGGER.warn(SharedStrings.INVALID_FINGERPRINT + "This build will not be supported by ProxyNeko! Please download from CurseForge for a signed version.");
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

        //TODO Create this and move it somewhere else as this is for the client not the common. - Proxy
        //MinecraftForge.EVENT_BUS.register(new FogHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        NEKO_LOGGER.info("AHHHH!! The SPOOKYS ARE COMING FOR ME!!");
    }
}
