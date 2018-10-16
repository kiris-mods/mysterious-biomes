package io.github.proxyneko.spookybiomes.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelTheForgottenWarlock extends ModelBase {

    private double[] modelScale = new double[]{1.0D, 1.0D, 1.0D};
    private ModelRenderer head;
    private ModelRenderer headHood;
    private ModelRenderer headHoodTip;
    private ModelRenderer body;
    private ModelRenderer rightArm;
    private ModelRenderer leftArm;
    private ModelRenderer rightLeg;
    private ModelRenderer leftLeg;
    private ModelRenderer rightLegPant;
    private ModelRenderer leftLegPant;

    public ModelTheForgottenWarlock() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.setRotationPoint(0.0F, 7.0F, 0.0F);
        head.addBox(-3.5F, -7.0F, -3.5F, 7, 7, 7, 0.0F);

        headHood = new ModelRenderer(this, 29, 0);
        headHood.setRotationPoint(0.0F, -4.0F, 1.5F);
        headHood.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 5, 0.0F);
        setRotateAngle(headHood, -0.22759093446006054F, 0.0F, 0.0F);

        headHoodTip = new ModelRenderer(this, 50, 0);
        headHoodTip.setRotationPoint(0.0F, 0.0F, 4.0F);
        headHoodTip.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
        setRotateAngle(headHoodTip, -0.136659280431156F, 0.0F, 0.0F);

        body = new ModelRenderer(this, 0, 15);
        body.setRotationPoint(0.0F, 7.0F, 0.0F);
        body.addBox(-5.0F, 0.0F, -3.0F, 10, 11, 6, 0.0F);

        rightArm = new ModelRenderer(this, 33, 15);
        rightArm.setRotationPoint(-6.0F, 8.5F, 0.0F);
        rightArm.addBox(-2.0F, -1.5F, -3.0F, 3, 11, 6, 0.0F);
        setRotateAngle(rightArm, 0.0F, 0.0F, 0.10000736613927509F);

        leftArm = new ModelRenderer(this, 33, 15);
        leftArm.mirror = true;
        leftArm.setRotationPoint(6.0F, 8.5F, 0.0F);
        leftArm.addBox(-1.0F, -1.5F, -3.0F, 3, 11, 6, 0.0F);
        setRotateAngle(leftArm, 0.0F, 0.0F, -0.10000736613927509F);

        rightLeg = new ModelRenderer(this, 0, 33);
        rightLeg.setRotationPoint(-2.5F, 18.0F, 0.0F);
        rightLeg.addBox(-2.5F, 0.0F, -3.0F, 5, 6, 6, 0.0F);

        leftLeg = new ModelRenderer(this, 0, 33);
        leftLeg.mirror = true;
        leftLeg.setRotationPoint(2.5F, 18.0F, 0.0F);
        leftLeg.addBox(-2.5F, 0.0F, -3.0F, 5, 6, 6, 0.0F);

        rightLegPant = new ModelRenderer(this, 23, 33);
        rightLegPant.mirror = true;
        rightLegPant.setRotationPoint(-0.5F, 1.0F, 0.1F);
        rightLegPant.addBox(-2.5F, 0.0F, -3.0F, 3, 5, 6, 0.0F);
        setRotateAngle(rightLegPant, 0.0F, 0.0F, 0.5235987755982988F);

        leftLegPant = new ModelRenderer(this, 23, 33);
        leftLegPant.mirror = true;
        leftLegPant.setRotationPoint(0.5F, 1.0F, 0.1F);
        leftLegPant.addBox(-0.5F, 0.0F, -3.0F, 3, 5, 6, 0.0F);
        setRotateAngle(leftLegPant, 0.0F, 0.0F, -0.5235987755982988F);

        head.addChild(headHood);
        headHood.addChild(headHoodTip);
        rightLeg.addChild(rightLegPant);
        leftLeg.addChild(leftLegPant);
    }

    @Override
    public void render(Entity entity, float f, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(1.0D / modelScale[0], 1.0D / modelScale[1], 1.0D / modelScale[2]);
        head.render(scale);
        body.render(scale);
        rightArm.render(scale);
        leftArm.render(scale);
        rightLeg.render(scale);
        leftLeg.render(scale);
        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        head.rotateAngleY = netHeadYaw * 0.017453292F;
        head.rotateAngleX = headPitch * 0.017453292F;
        body.rotateAngleY = 0.0F;
        float f = 1.0F;
        rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        rightArm.rotateAngleZ = 0.0F;
        leftArm.rotateAngleZ = 0.0F;
        rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
        rightLeg.rotateAngleY = 0.0F;
        leftLeg.rotateAngleY = 0.0F;
        rightLeg.rotateAngleZ = 0.0F;
        leftLeg.rotateAngleZ = 0.0F;

        if (isRiding) {
            rightArm.rotateAngleX += -((float) Math.PI / 5F);
            leftArm.rotateAngleX += -((float) Math.PI / 5F);
            rightLeg.rotateAngleX = -1.4137167F;
            rightLeg.rotateAngleY = ((float) Math.PI / 10F);
            rightLeg.rotateAngleZ = 0.07853982F;
            leftLeg.rotateAngleX = -1.4137167F;
            leftLeg.rotateAngleY = -((float) Math.PI / 10F);
            leftLeg.rotateAngleZ = -0.07853982F;
        }

        rightArm.rotateAngleY = 0.0F;
        rightArm.rotateAngleZ = 0.0F;
        leftArm.rotateAngleY = 0.0F;
        rightArm.rotateAngleY = 0.0F;

        if (swingProgress > 0.0F) {
            ModelRenderer modelrenderer = rightArm;
            float f1 = swingProgress;
            body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
            rightArm.rotateAngleY += body.rotateAngleY;
            leftArm.rotateAngleY += body.rotateAngleY;
            leftArm.rotateAngleX += body.rotateAngleY;
            f1 = 1.0F - swingProgress;
            f1 = f1 * f1;
            f1 = f1 * f1;
            f1 = 1.0F - f1;
            float f2 = MathHelper.sin(f1 * (float) Math.PI);
            float f3 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;
            modelrenderer.rotateAngleX = (float) ((double) modelrenderer.rotateAngleX - ((double) f2 * 1.2D + (double) f3));
            modelrenderer.rotateAngleY += body.rotateAngleY * 2.0F;
            modelrenderer.rotateAngleZ += MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F;
        }

        body.rotateAngleX = 0.0F;
        rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
    }

    private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}