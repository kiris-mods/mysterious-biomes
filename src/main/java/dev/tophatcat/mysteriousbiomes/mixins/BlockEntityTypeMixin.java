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
