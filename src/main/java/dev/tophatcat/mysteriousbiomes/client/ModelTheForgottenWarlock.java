/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.mysteriousbiomes.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.entity.EntityTheForgottenWarlock;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ModelTheForgottenWarlock<T extends EntityTheForgottenWarlock> extends EntityModel<T> {

    public static final ModelLayerLocation THE_FORGOTTEN_WARLOCK_LOCATION = new ModelLayerLocation(
            new ResourceLocation(MysteriousBiomes.MOD_ID, "the_forgotten_warlock"), "main");
    private final ModelPart headBone;
    private final ModelPart rightArmBone;
    private final ModelPart leftArmBone;
    private final ModelPart leftLegBone;
    private final ModelPart rightLegBone;
    private final ModelPart torso;

    public ModelTheForgottenWarlock(ModelPart root) {
        this.headBone = root.getChild("headBone");
        this.rightArmBone = root.getChild("rightArmBone");
        this.leftArmBone = root.getChild("leftArmBone");
        this.leftLegBone = root.getChild("leftLegBone");
        this.rightLegBone = root.getChild("rightLegBone");
        this.torso = root.getChild("torso");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition headBone = modelPartData.addOrReplaceChild("headBone", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -42.0F, -6.0F,
                                12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition hoodMinor = headBone.addOrReplaceChild("hoodMinor", CubeListBuilder.create()
                        .texOffs(0, 67)
                        .addBox(-2.5F, -5.5F, -2.0F,
                                5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -31.7212F, 11.3161F, -0.3491F, 0.0F, 0.0F));

        PartDefinition hoodMajor = headBone.addOrReplaceChild("hoodMajor", CubeListBuilder.create()
                        .texOffs(56, 40).addBox(-4.0F, -7.0F, -3.0F,
                                8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -33.0964F, 7.1201F, -0.2182F, 0.0F, 0.0F));

        PartDefinition rightArmBone = modelPartData.addOrReplaceChild("rightArmBone", CubeListBuilder.create()
                        .texOffs(32, 46).addBox(-12.0F, -30.0F, -3.0F,
                                6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition leftArmBone = modelPartData.addOrReplaceChild("leftArmBone", CubeListBuilder.create()
                        .texOffs(38, 24).addBox(6.0F, -30.0F, -3.0F,
                                6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition leftLegBone = modelPartData.addOrReplaceChild("leftLegBone", CubeListBuilder.create()
                        .texOffs(0, 47).addBox(-5.0F, -14.0F, -3.0F,
                                6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 24.0F, 0.0F));

        PartDefinition leftLegFlare = leftLegBone.addOrReplaceChild("leftLegFlare", CubeListBuilder.create()
                        .texOffs(62, 20).addBox(-2.0F, -6.0F, -2.5F,
                                4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.5F, -6.5F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition rightLegBone = modelPartData.addOrReplaceChild("rightLegBone", CubeListBuilder.create()
                        .texOffs(48, 0).addBox(-1.0F, -14.0F, -3.0F,
                                6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 24.0F, 0.0F));

        PartDefinition rightLegFlare = rightLegBone.addOrReplaceChild("rightLegFlare", CubeListBuilder.create()
                        .texOffs(56, 54).addBox(-2.0F, -6.0F, -2.5F,
                                4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-0.5F, -6.5F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition torso = modelPartData.addOrReplaceChild("torso", CubeListBuilder.create()
                        .texOffs(0, 24).addBox(-6.0F, -30.0F, -3.5F,
                                12.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(modelData, 128, 128);

    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //TODO Work on animations for arms, legs and attacking movements, then get a new texture from Lux
    }

    @Override
    public void renderToBuffer(PoseStack matrix, VertexConsumer vertexConsumer, int light, int overlay,
                       float red, float green, float blue, float alpha) {
        headBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        rightArmBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        leftArmBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        leftLegBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        rightLegBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        torso.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
