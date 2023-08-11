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

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.entity.TheForgottenWarlock;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class TheForgottenWarlockModel<T extends TheForgottenWarlock> extends EntityModel<T> {

    //This layer location should be baked with EntityRendererProvider.
    //Context in the entity renderer and passed into this model's constructor
    public static final EntityModelLayer THE_FORGOTTEN_WARLOCK_LOCATION = new EntityModelLayer(
            new Identifier(MysteriousBiomes.MOD_ID, "the_forgotten_warlock"), "main");
    private final ModelPart root;

    public TheForgottenWarlockModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData meshDefinition = new ModelData();
        ModelPartData ModelPartData = meshDefinition.getRoot();

        ModelPartData root = ModelPartData.addChild("root", ModelPartBuilder.create(),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = root.addChild("head", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-3.5F, -7.0F, -3.5F,
                                7.0F, 7.0F, 7.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData headChild = head.addChild("headChild", ModelPartBuilder.create()
                        .uv(29, 0)
                        .cuboid(-2.5F, -13.0F, -3.5F,
                                5.0F, 5.0F, 5.0F,
                                new Dilation(0.0F)),
                ModelTransform.of(0.0F, 6.5F, 2.0F,
                        -0.2276F, 0.0F, 0.0F));

        ModelPartData headChildChild = headChild.addChild("headChildChild", ModelPartBuilder.create()
                        .uv(50, 0)
                        .cuboid(-1.5F, -1.0F, -4.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.of(0.0F, -10.5F, 5.0F,
                        -0.1367F, 0.0F, 0.0F));

        ModelPartData rightLeg = root.addChild("rightLeg", ModelPartBuilder.create()
                        .uv(0, 33)
                        .cuboid(-3.75F, -1.5F, -3.0F,
                                5.0F, 6.0F, 6.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(-1.25F, 19.5F, 0.0F));

        ModelPartData rightLegChild = rightLeg.addChild("rightLegChild", ModelPartBuilder.create()
                        .uv(23, 33).mirrored()
                        .cuboid(-1.5F, -2.5F, -3.0F,
                                3.0F, 5.0F, 6.0F,
                                new Dilation(0.0F)).mirrored(false),
                ModelTransform.of(-3.75F, 1.0F, 0.1F,
                        0.0F, 0.0F, 0.5236F));

        ModelPartData rightArm = root.addChild("rightArm", ModelPartBuilder.create()
                        .uv(33, 15)
                        .cuboid(-1.5F, -1.5F, -3.0F,
                                3.0F, 11.0F, 6.0F,
                                new Dilation(0.0F)),
                ModelTransform.of(-6.5F, 8.5F, 0.0F,
                        0.0F, 0.0F, 0.1F));

        ModelPartData leftArm = root.addChild("leftArm", ModelPartBuilder.create()
                        .uv(33, 15).mirrored()
                        .cuboid(-1.5F, -0.5F, -3.0F,
                                3.0F, 11.0F, 6.0F,
                                new Dilation(0.0F)).mirrored(false),
                ModelTransform.of(6.5F, 7.5F, 0.0F,
                        0.0F, 0.0F, -0.1F));

        ModelPartData leftLeg = root.addChild("leftLeg", ModelPartBuilder.create()
                        .uv(0, 33).mirrored()
                        .cuboid(2.5F, 0.0F, -3.0F,
                                5.0F, 6.0F, 6.0F,
                                new Dilation(0.0F)).mirrored(false),
                ModelTransform.pivot(-2.5F, 18.0F, 0.0F));

        ModelPartData leftLegChild = leftLeg.addChild("leftLegChild", ModelPartBuilder.create()
                        .uv(23, 33).mirrored()
                        .cuboid(-2.5F, 0.0F, -3.0F,
                                3.0F, 5.0F, 6.0F,
                                new Dilation(0.0F)).mirrored(false),
                ModelTransform.of(7.5F, 0.0F, 0.1F,
                        0.0F, 0.0F, -0.5236F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create()
                        .uv(0, 15)
                        .cuboid(-5.0F, -5.5F, -3.0F,
                                10.0F, 11.0F, 6.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 12.5F, 0.0F));
        return TexturedModelData.of(meshDefinition, 64, 64);
    }

    @Override
    public void setAngles(@NotNull T entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(@NotNull MatrixStack poseStack, @NotNull VertexConsumer buffer, int packedLight,
                       int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
