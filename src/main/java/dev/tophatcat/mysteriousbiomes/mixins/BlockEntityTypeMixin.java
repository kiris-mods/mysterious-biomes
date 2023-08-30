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

import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {

    //TODO Change this to a better system.
    @Inject(method = "supports", at = @At("HEAD"), cancellable = true)
    private void isValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (BlockEntityType.SIGN.equals(this)
                && (state.isOf(MysteriousBlockTypes.BLOODWOOD.getFloorSign().get())
                || state.isOf(MysteriousBlockTypes.BLOODWOOD.getWallSign().get())
                || (state.isOf(MysteriousBlockTypes.GHOSTLY.getFloorSign().get())
                || state.isOf(MysteriousBlockTypes.GHOSTLY.getWallSign().get())
                || (state.isOf(MysteriousBlockTypes.SORBUS.getFloorSign().get())
                || state.isOf(MysteriousBlockTypes.SORBUS.getWallSign().get())
                || (state.isOf(MysteriousBlockTypes.SEEPING.getFloorSign().get())
                || state.isOf(MysteriousBlockTypes.SEEPING.getWallSign().get())
                || (state.isOf(MysteriousBlockTypes.SAKURA.getFloorSign().get())
                || state.isOf(MysteriousBlockTypes.SAKURA.getWallSign().get()))))))) {
            cir.setReturnValue(true);
        }
        if (BlockEntityType.HANGING_SIGN.equals(this)
                && (state.isOf(MysteriousBlockTypes.BLOODWOOD.getHangingSign().get())
                || state.isOf(MysteriousBlockTypes.BLOODWOOD.getWallHangingSign().get())
                || (state.isOf(MysteriousBlockTypes.GHOSTLY.getHangingSign().get())
                || state.isOf(MysteriousBlockTypes.GHOSTLY.getWallHangingSign().get())
                || (state.isOf(MysteriousBlockTypes.SORBUS.getHangingSign().get())
                || state.isOf(MysteriousBlockTypes.SORBUS.getWallHangingSign().get())
                || (state.isOf(MysteriousBlockTypes.SEEPING.getHangingSign().get())
                || state.isOf(MysteriousBlockTypes.SEEPING.getWallHangingSign().get())
                || (state.isOf(MysteriousBlockTypes.SAKURA.getHangingSign().get())
                || state.isOf(MysteriousBlockTypes.SAKURA.getWallHangingSign().get()))))))) {
            cir.setReturnValue(true);
        }
    }
}
