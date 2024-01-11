package dev.tophatcat.mysteriousbiomes.client.renderers;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.client.models.ModelTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.common.entity.EntityTheForgottenWarlock;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class RenderTheForgottenWarlock extends MobRenderer<EntityTheForgottenWarlock, EntityModel<EntityTheForgottenWarlock>> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(MysteriousCommon.MOD_ID,
        "textures/entity/the_forgotten_warlock.png");

    public RenderTheForgottenWarlock(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelTheForgottenWarlock<>(
            renderManager.bakeLayer(ModelTheForgottenWarlock.THE_FORGOTTEN_WARLOCK_LOCATION)), 0.5F);
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(@NotNull EntityTheForgottenWarlock theForgottenWarlock) {
        return RESOURCE_LOCATION;
    }
}
