/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2024
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
package dev.tophatcat.mysteriousbiomes.client.renderers;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.client.models.TheForgottenWarlockModel;
import dev.tophatcat.mysteriousbiomes.common.entity.TheForgottenWarlockEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TheForgottenWarlockRenderer
    extends MobRenderer<TheForgottenWarlockEntity, EntityModel<TheForgottenWarlockEntity>> {

    private static final ResourceLocation RESOURCE_LOCATION =
        new ResourceLocation(MysteriousCommon.MOD_ID, "textures/entity/the_forgotten_warlock.png");

    public TheForgottenWarlockRenderer(EntityRendererProvider.Context renderManager) {
        super(
            renderManager,
            new TheForgottenWarlockModel<>(
                renderManager.bakeLayer(TheForgottenWarlockModel.LAYER_LOCATION)),
            0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(TheForgottenWarlockEntity theForgottenWarlock) {
        return RESOURCE_LOCATION;
    }
}
