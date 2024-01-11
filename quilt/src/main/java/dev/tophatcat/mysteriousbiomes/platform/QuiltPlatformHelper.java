package dev.tophatcat.mysteriousbiomes.platform;

import dev.tophatcat.mysteriousbiomes.ProjectICBPCommon;
import dev.tophatcat.mysteriousbiomes.platform.services.IPlatformHelper;
import org.quiltmc.loader.api.QuiltLoader;

public class QuiltPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Quilt";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return QuiltLoader.isModLoaded(MysteriousCommon.MOD_ID);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return QuiltLoader.isDevelopmentEnvironment();
    }
}
