package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriousbiomes.client.MysteriousRenderingNeo;
import dev.tophatcat.mysteriousbiomes.common.entity.EntityTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.platform.NeoForgePlatformHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod(MysteriousCommon.MOD_ID)
public class MysteriousNeo {

    public MysteriousNeo(IEventBus bus) {
        MysteriousCommon.init();

        for (var registry : NeoForgePlatformHelper.REGISTRIES.values()) {
            registry.register(bus);
        }
        bus.addListener(this::registerEntityAttributes);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(MysteriousRenderingNeo::registerEntityModels);
            bus.addListener(MysteriousRenderingNeo::registerModelLayers);
        }
    }

    public void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(), EntityTheForgottenWarlock.createAttributes().build());
    }
}
