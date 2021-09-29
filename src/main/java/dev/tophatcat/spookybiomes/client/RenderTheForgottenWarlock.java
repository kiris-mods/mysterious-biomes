package dev.tophatcat.spookybiomes.client;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.entity.TheForgottenWarlock;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class RenderTheForgottenWarlock extends MobRenderer<TheForgottenWarlock, EntityModel<TheForgottenWarlock>> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(SpookyBiomes.MOD_ID,
            "textures/entity/the_forgotten_warlock.png");

    public RenderTheForgottenWarlock(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TheForgottenWarlockModel<>(
                renderManager.bakeLayer(TheForgottenWarlockModel.THE_FORGOTTEN_WARLOCK_LOCATION)), 0.5F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull TheForgottenWarlock theForgottenWarlock) {
        return RESOURCE_LOCATION;
    }

    @Override
    protected boolean shouldShowName(@Nonnull TheForgottenWarlock entity) {
        return super.shouldShowName(entity);
    }
}