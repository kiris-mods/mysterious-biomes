package dev.tophatcat.mysteriousbiomes.platform;

import com.mojang.datafixers.util.Pair;
import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.platform.services.IPlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class NeoForgePlatformHelper implements IPlatformHelper {

    private static final Map<Pair<String, ResourceKey<? extends Registry<?>>>,
            DeferredRegister<?>> REGISTRIES = new HashMap<>();

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(MysteriousCommon.MOD_ID);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLEnvironment.production;
    }
}
