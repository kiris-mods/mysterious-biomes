package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.client.RenderTheForgottenWarlock;
import dev.tophatcat.spookybiomes.client.TheForgottenWarlockModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = SpookyBiomes.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class SpookyRendering {

    @SubscribeEvent
    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SpookyRegistry.THE_FORGOTTEN_WARLOCK.get(),
                RenderTheForgottenWarlock::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TheForgottenWarlockModel.THE_FORGOTTEN_WARLOCK_LOCATION,
                TheForgottenWarlockModel::createBodyLayer);

    }
}
