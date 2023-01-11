/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2013-2022 <KiriCattus>
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
package dev.tophatcat.spookybiomes.client;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.entity.TheForgottenWarlock;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class RenderTheForgottenWarlock extends MobEntityRenderer<TheForgottenWarlock, EntityModel<TheForgottenWarlock>> {

    private static final Identifier RESOURCE_LOCATION = new Identifier(SpookyBiomes.MOD_ID,
        "textures/entity/the_forgotten_warlock.png");

    public RenderTheForgottenWarlock(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TheForgottenWarlockModel<>(
            renderManager.getPart(TheForgottenWarlockModel.THE_FORGOTTEN_WARLOCK_LOCATION)), 0.5F);
    }

    @NotNull
    @Override
    public Identifier getTexture(@NotNull TheForgottenWarlock theForgottenWarlock) {
        return RESOURCE_LOCATION;
    }

    @Override
    protected boolean hasLabel(@NotNull TheForgottenWarlock entity) {
        return super.hasLabel(entity);
    }
}
