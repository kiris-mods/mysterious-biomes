package io.github.proxyneko.spookybiomes.client.rendering;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.client.model.ModelTheForgottenWarlock;
import io.github.proxyneko.spookybiomes.server.entity.EntityTheForgottenWarlock;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTheForgottenWarlock extends RenderLiving<EntityTheForgottenWarlock> {

    private static final ResourceLocation THE_FORGOTTEN_WARLOCK_TEXTURES = new ResourceLocation(SpookyBiomes.MODID, "textures/entity/the_forgotten_warlock.png");

    public RenderTheForgottenWarlock(RenderManager renderManager) {
        super(renderManager, new ModelTheForgottenWarlock(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTheForgottenWarlock entity) {
        return THE_FORGOTTEN_WARLOCK_TEXTURES;
    }
}