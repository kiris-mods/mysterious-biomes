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
package dev.tophatcat.mysteriousbiomes.client;

import dev.tophatcat.mysteriousbiomes.client.models.TheForgottenWarlockModel;
import dev.tophatcat.mysteriousbiomes.client.renderers.TheForgottenWarlockRenderer;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MysteriousRenderingFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(
            MysteriousRegistry.THE_FORGOTTEN_WARLOCK.get(), TheForgottenWarlockRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(
            TheForgottenWarlockModel.LAYER_LOCATION, TheForgottenWarlockModel::createBodyLayer);
    }
}
