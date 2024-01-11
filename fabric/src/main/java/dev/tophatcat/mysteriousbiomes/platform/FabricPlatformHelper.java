package dev.tophatcat.mysteriousbiomes.platform;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

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

    @Override
    public <S, T extends S> Supplier<T> register(Supplier<T> supplier, ResourceLocation location, Registry<S> registry) {
        var entry = Registry.register(registry, location, supplier.get());
        return () -> entry;
    }
}
