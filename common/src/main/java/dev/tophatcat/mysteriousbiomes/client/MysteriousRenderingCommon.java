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
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MysteriousRenderingCommon {

    public static <T extends Entity> List<Renderers<?>> getRenderers() {
        return List.of(
            new Renderers<>(MysteriousRegistry.THE_FORGOTTEN_WARLOCK, TheForgottenWarlockRenderer::new)
        );
    }

    public static List<LayerDefinitions> getLayerDefinitions() {
        return new ArrayList<>(List.of(
            new LayerDefinitions(TheForgottenWarlockModel.LAYER_LOCATION, TheForgottenWarlockModel.createBodyLayer())
        ));
    }

    public record Renderers<T extends Entity>(Supplier<EntityType<T>> type, EntityRendererProvider<T> renderer) {
    }

    public record LayerDefinitions(ModelLayerLocation layerLocation, LayerDefinition supplier) {
    }
}
