package dev.tophatcat.mysteriousbiomes.client;

import dev.tophatcat.mysteriousbiomes.client.models.ModelTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.client.renderers.RenderTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class MysteriousRenderingNeo {

    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(), RenderTheForgottenWarlock::new);
    }

    public static void registerModelLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelTheForgottenWarlock.LAYER_LOCATION, ModelTheForgottenWarlock::createBodyLayer);
    }
}
