/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/mysterious-biomes/blob/dev/LICENSE.md
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
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
 */
package dev.tophatcat.mysteriousbiomes.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.tophatcat.mysteriousbiomes.entity.TheForgottenWarlockEntity;
import dev.tophatcat.mysteriouslands.MysteriousLandsCommon;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class TheForgottenWarlockModel<T extends TheForgottenWarlockEntity> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        ResourceLocation.fromNamespaceAndPath(MysteriousLandsCommon.MOD_ID, "the_forgotten_warlock"), "main");
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private final ModelPart torso;

    public TheForgottenWarlockModel(ModelPart root) {
        this.head = root.getChild("head");
        this.rightArm = root.getChild("rightArm");
        this.leftArm = root.getChild("leftArm");
        this.leftLeg = root.getChild("leftLeg");
        this.rightLeg = root.getChild("rightLeg");
        this.torso = root.getChild("torso");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.5F, -7.0F, -3.5F,
                    7.0F, 7.0F, 7.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition hoodMinor = head.addOrReplaceChild("hoodMinor", CubeListBuilder.create()
                .texOffs(29, 0)
                .addBox(-2.5F, -13.0F, -3.5F,
                    5.0F, 5.0F, 5.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 6.5F, 2.0F, -0.2276F, 0.0F, 0.0F));

        PartDefinition hoodMajor = hoodMinor.addOrReplaceChild("hoodMajor", CubeListBuilder.create()
                .texOffs(50, 0)
                .addBox(-1.5F, -1.0F, -4.5F,
                    3.0F, 3.0F, 3.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -10.5F, 5.0F, -0.1367F, 0.0F, 0.0F));

        PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create()
                .texOffs(33, 15)
                .addBox(-1.5F, -1.5F, -3.0F,
                    3.0F, 11.0F, 6.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-6.5F, 8.5F, 0.0F, 0.0F, 0.0F, 0.1F));

        PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create()
                .texOffs(33, 15).mirror()
                .addBox(-1.5F, -0.5F, -3.0F,
                    3.0F, 11.0F, 6.0F,
                    new CubeDeformation(0.0F)).mirror(false),
            PartPose.offsetAndRotation(6.5F, 7.5F, 0.0F, 0.0F, 0.0F, -0.1F));

        PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create()
                .texOffs(0, 33)
                .addBox(-3.75F, -1.5F, -3.0F,
                    5.0F, 6.0F, 6.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(-1.25F, 19.5F, 0.0F));

        PartDefinition rightLegChild = rightLeg.addOrReplaceChild("rightLegChild", CubeListBuilder.create()
                .texOffs(23, 33).mirror()
                .addBox(-1.5F, -2.5F, -3.0F,
                    3.0F, 5.0F, 6.0F,
                    new CubeDeformation(0.0F)).mirror(false),
            PartPose.offsetAndRotation(-3.75F, 1.0F, 0.1F, 0.0F, 0.0F, 0.5236F));

        PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create()
                .texOffs(0, 33).mirror()
                .addBox(2.5F, 0.0F, -3.0F,
                    5.0F, 6.0F, 6.0F,
                    new CubeDeformation(0.0F)).mirror(false),
            PartPose.offset(-2.5F, 18.0F, 0.0F));

        PartDefinition leftLegChild = leftLeg.addOrReplaceChild("leftLegChild", CubeListBuilder.create()
                .texOffs(23, 33).mirror()
                .addBox(-2.5F, 0.0F, -3.0F,
                    3.0F, 5.0F, 6.0F,
                    new CubeDeformation(0.0F)).mirror(false),
            PartPose.offsetAndRotation(7.5F, 0.0F, 0.1F, 0.0F, 0.0F, -0.5236F));

        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create()
                .texOffs(0, 15)
                .addBox(-5.0F, -5.5F, -3.0F,
                    10.0F, 11.0F, 6.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 12.5F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        // TODO Work on animations for arms, legs and attacking movements, then get a new texture from Lux
    }

    @Override
    public void renderToBuffer(PoseStack matrix, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        head.render(matrix, vertexConsumer, light, overlay, color);
        rightArm.render(matrix, vertexConsumer, light, overlay, color);
        leftArm.render(matrix, vertexConsumer, light, overlay, color);
        leftLeg.render(matrix, vertexConsumer, light, overlay, color);
        rightLeg.render(matrix, vertexConsumer, light, overlay, color);
        torso.render(matrix, vertexConsumer, light, overlay, color);
    }
}
