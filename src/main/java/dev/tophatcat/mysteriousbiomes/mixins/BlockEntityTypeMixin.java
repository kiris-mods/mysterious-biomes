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
package dev.tophatcat.mysteriousbiomes.mixins;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {

    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void isValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (BlockEntityType.SIGN.equals(this)
            && (state.is(MysteriousWoodTypes.BLOODWOOD.getFloorSign().get())
            || state.is(MysteriousWoodTypes.BLOODWOOD.getWallSign().get())
            || (state.is(MysteriousWoodTypes.GHOSTLY.getFloorSign().get())
            || state.is(MysteriousWoodTypes.GHOSTLY.getWallSign().get())
            || (state.is(MysteriousWoodTypes.SORBUS.getFloorSign().get())
            || state.is(MysteriousWoodTypes.SORBUS.getWallSign().get())
            || (state.is(MysteriousWoodTypes.SEEPING.getFloorSign().get())
            || state.is(MysteriousWoodTypes.SEEPING.getWallSign().get())
            || (state.is(MysteriousWoodTypes.SAKURA.getFloorSign().get())
            || state.is(MysteriousWoodTypes.SAKURA.getWallSign().get()))))))) {
            cir.setReturnValue(true);
        }
    }
}
