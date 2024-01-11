package dev.tophatcat.mysteriousbiomes.platform;

import com.mojang.datafixers.util.Pair;
import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.platform.services.IPlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NeoForgePlatformHelper implements IPlatformHelper {

    public static final Map<Pair<String, ResourceKey<? extends Registry<?>>>,
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

    @Override
    public <S, T extends S> Supplier<T> register(Supplier<T> supplier, ResourceLocation location, Registry<S> registry) {
        DeferredRegister<S> register = (DeferredRegister<S>) REGISTRIES.computeIfAbsent(Pair.of(location.getNamespace(),
            registry.key()), k -> DeferredRegister.create(registry.key(), location.getNamespace()));
        return register.register(location.getPath(), supplier);
    }
}
