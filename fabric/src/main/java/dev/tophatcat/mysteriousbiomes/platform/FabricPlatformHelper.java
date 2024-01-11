package dev.tophatcat.mysteriousbiomes.platform;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper  implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(MysteriousCommon.MOD_ID);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
