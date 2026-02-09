package dev.tophatcat.mysteriouslands;

import dev.tophatcat.mysteriouslands.platform.IPlatform;
import dev.tophatcat.mysteriouslands.registry.BlockRegistry;
import dev.tophatcat.mysteriouslands.registry.CreativeTabRegistry;
import dev.tophatcat.mysteriouslands.registry.EntityRegistry;
import dev.tophatcat.mysteriouslands.registry.ItemRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

public class MysteriousLandsCommon {

    public static final String MOD_ID = "mysteriouslands";
    public static final String MOD_NAME = "Mysterious Lands";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final IPlatform COMMON_PLATFORM = ServiceLoader.load(IPlatform.class).findFirst().orElseThrow();

    public static void init() {
        LOGGER.debug("We are currently loaded via the {} mod loader in a {} environment!",
            COMMON_PLATFORM.getPlatformName(),
            COMMON_PLATFORM.getEnvironmentName());

        //Mysterious Wood Types
        //Block Entities
        BlockRegistry.init();
        EntityRegistry.init();
        ItemRegistry.init();
        //Sounds
        CreativeTabRegistry.init();
    }
}
