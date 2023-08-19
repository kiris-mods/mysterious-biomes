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
import dev.tophatcat.mysteriousbiomes.entity.EntityTheForgottenWarlock;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ModelTheForgottenWarlock<T extends EntityTheForgottenWarlock> extends EntityModel<T> {

    public static final EntityModelLayer THE_FORGOTTEN_WARLOCK_LOCATION = new EntityModelLayer(
        new Identifier(MysteriousBiomes.MOD_ID, "the_forgotten_warlock"), "main");
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

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData headBone = modelPartData.addChild("headBone", ModelPartBuilder.create()
            .uv(0, 0)
            .cuboid(-6.0F, -42.0F, -6.0F,
                12.0F, 12.0F, 12.0F, new Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData hoodMinor = headBone.addChild("hoodMinor", ModelPartBuilder.create()
            .uv(0, 67)
            .cuboid(-2.5F, -5.5F, -2.0F,
                5.0F, 5.0F, 4.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, -31.7212F, 11.3161F, -0.3491F, 0.0F, 0.0F));

        ModelPartData hoodMajor = headBone.addChild("hoodMajor", ModelPartBuilder.create()
            .uv(56, 40).cuboid(-4.0F, -7.0F, -3.0F,
                8.0F, 8.0F, 6.0F, new Dilation(0.0F)),
            ModelTransform.of(0.0F, -33.0964F, 7.1201F, -0.2182F, 0.0F, 0.0F));

        ModelPartData rightArmBone = modelPartData.addChild("rightArmBone", ModelPartBuilder.create()
            .uv(32, 46).cuboid(-12.0F, -30.0F, -3.0F,
                6.0F, 16.0F, 6.0F, new Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leftArmBone = modelPartData.addChild("leftArmBone", ModelPartBuilder.create()
            .uv(38, 24).cuboid(6.0F, -30.0F, -3.0F,
                6.0F, 16.0F, 6.0F, new Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData leftLegBone = modelPartData.addChild("leftLegBone", ModelPartBuilder.create()
            .uv(0, 47).cuboid(-5.0F, -14.0F, -3.0F,
                6.0F, 14.0F, 6.0F, new Dilation(0.0F)),
            ModelTransform.pivot(5.0F, 24.0F, 0.0F));

        ModelPartData leftLegFlare = leftLegBone.addChild("leftLegFlare", ModelPartBuilder.create()
            .uv(62, 20).cuboid(-2.0F, -6.0F, -2.5F,
                4.0F, 12.0F, 5.0F, new Dilation(0.0F)),
            ModelTransform.of(0.5F, -6.5F, 0.0F, 0.0F, 0.0F, -0.2618F));

        ModelPartData rightLegBone = modelPartData.addChild("rightLegBone", ModelPartBuilder.create()
            .uv(48, 0).cuboid(-1.0F, -14.0F, -3.0F,
                6.0F, 14.0F, 6.0F, new Dilation(0.0F)),
            ModelTransform.pivot(-5.0F, 24.0F, 0.0F));

        ModelPartData rightLegFlare = rightLegBone.addChild("rightLegFlare", ModelPartBuilder.create()
            .uv(56, 54).cuboid(-2.0F, -6.0F, -2.5F,
                4.0F, 12.0F, 5.0F, new Dilation(0.0F)),
            ModelTransform.of(-0.5F, -6.5F, 0.0F, 0.0F, 0.0F, 0.2618F));

        ModelPartData torso = modelPartData.addChild("torso", ModelPartBuilder.create()
            .uv(0, 24).cuboid(-6.0F, -30.0F, -3.5F,
                12.0F, 16.0F, 7.0F, new Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);

    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //TODO Work on animations for arms, legs and attacking movements.
        //FIXME New texture required!
    }

    @Override
    public void render(MatrixStack matrix, VertexConsumer vertexConsumer, int light, int overlay,
                       float red, float green, float blue, float alpha) {
        headBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        rightArmBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        leftArmBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        leftLegBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        rightLegBone.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
        torso.render(matrix, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
