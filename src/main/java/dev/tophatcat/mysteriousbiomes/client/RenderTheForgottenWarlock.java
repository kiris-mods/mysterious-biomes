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
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class RenderTheForgottenWarlock extends MobRenderer<EntityTheForgottenWarlock, EntityModel<EntityTheForgottenWarlock>> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(MysteriousBiomes.MOD_ID,
            "textures/entity/the_forgotten_warlock.png");

    public RenderTheForgottenWarlock(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelTheForgottenWarlock<>(
                renderManager.bakeLayer(ModelTheForgottenWarlock.THE_FORGOTTEN_WARLOCK_LOCATION)), 0.5F);
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(@NotNull EntityTheForgottenWarlock theForgottenWarlock) {
        return RESOURCE_LOCATION;
    }
}
