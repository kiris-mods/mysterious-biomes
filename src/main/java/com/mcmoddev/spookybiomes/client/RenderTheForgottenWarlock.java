package com.mcmoddev.spookybiomes.client;

import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTheForgottenWarlock extends RenderLiving<EntityTheForgottenWarlock> {

    private static final ResourceLocation resourceLocation = new ResourceLocation(SpookyBiomes.MODID, "textures/entity/the_forgotten_warlock.png");

    public RenderTheForgottenWarlock(RenderManager renderManager) {
        super(renderManager, new TheForgottenWarlockModel(), 0.5F);
    }

    @Override
    protected boolean canRenderName(EntityTheForgottenWarlock entity) {
        return entity.hasCustomName();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTheForgottenWarlock entity) {
        return resourceLocation;
    }
}