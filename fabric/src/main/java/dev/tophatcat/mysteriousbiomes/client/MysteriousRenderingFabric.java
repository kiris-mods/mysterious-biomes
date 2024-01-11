package dev.tophatcat.mysteriousbiomes.client;

import dev.tophatcat.mysteriousbiomes.client.models.ModelTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.client.renderers.RenderTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MysteriousRenderingFabric  implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(), RenderTheForgottenWarlock::new);
        EntityModelLayerRegistry.registerModelLayer(ModelTheForgottenWarlock.LAYER_LOCATION,
            ModelTheForgottenWarlock::createBodyLayer);
    }
}
