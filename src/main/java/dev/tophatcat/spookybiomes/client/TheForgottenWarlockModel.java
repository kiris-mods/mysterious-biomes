/*
 * Spooky Biomes - https://tophatcat.dev/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.entity.TheForgottenWarlock;
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

import javax.annotation.Nonnull;

public class TheForgottenWarlockModel<T extends TheForgottenWarlock> extends EntityModel<T> {

    //This layer location should be baked with EntityRendererProvider.
    //Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation THE_FORGOTTEN_WARLOCK_LOCATION = new ModelLayerLocation(
        new ResourceLocation(SpookyBiomes.MOD_ID, "the_forgotten_warlock"), "main");
    private final ModelPart root;

    public TheForgottenWarlockModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(),
            PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.5F, -7.0F, -3.5F,
                    7.0F, 7.0F, 7.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition headChild = head.addOrReplaceChild("headChild", CubeListBuilder.create()
                .texOffs(29, 0)
                .addBox(-2.5F, -13.0F, -3.5F,
                    5.0F, 5.0F, 5.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 6.5F, 2.0F,
                -0.2276F, 0.0F, 0.0F));

        PartDefinition headChildChild = headChild.addOrReplaceChild("headChildChild", CubeListBuilder.create()
                .texOffs(50, 0)
                .addBox(-1.5F, -1.0F, -4.5F,
                    3.0F, 3.0F, 3.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -10.5F, 5.0F,
                -0.1367F, 0.0F, 0.0F));

        PartDefinition rightLeg = root.addOrReplaceChild("rightLeg", CubeListBuilder.create()
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
            PartPose.offsetAndRotation(-3.75F, 1.0F, 0.1F,
                0.0F, 0.0F, 0.5236F));

        PartDefinition rightArm = root.addOrReplaceChild("rightArm", CubeListBuilder.create()
                .texOffs(33, 15)
                .addBox(-1.5F, -1.5F, -3.0F,
                    3.0F, 11.0F, 6.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-6.5F, 8.5F, 0.0F,
                0.0F, 0.0F, 0.1F));

        PartDefinition leftArm = root.addOrReplaceChild("leftArm", CubeListBuilder.create()
                .texOffs(33, 15).mirror()
                .addBox(-1.5F, -0.5F, -3.0F,
                    3.0F, 11.0F, 6.0F,
                    new CubeDeformation(0.0F)).mirror(false),
            PartPose.offsetAndRotation(6.5F, 7.5F, 0.0F,
                0.0F, 0.0F, -0.1F));

        PartDefinition leftLeg = root.addOrReplaceChild("leftLeg", CubeListBuilder.create()
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
            PartPose.offsetAndRotation(7.5F, 0.0F, 0.1F,
                0.0F, 0.0F, -0.5236F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(0, 15)
                .addBox(-5.0F, -5.5F, -3.0F,
                    10.0F, 11.0F, 6.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 12.5F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(@Nonnull TheForgottenWarlock entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(@Nonnull PoseStack poseStack, @Nonnull VertexConsumer buffer, int packedLight,
                               int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
