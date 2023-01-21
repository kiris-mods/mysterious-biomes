package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {

    //TODO Add the rest of the signs to this and check it works.
    //FIXME Can't see sign blocks when placed and can't edit signs when placing them...
    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void isValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        MysteriousBiomes.LOGGER.error("Mixin running 1");
        if (BlockEntityType.SIGN.equals(this)
            && (state.is(MysteriousWoodTypes.BLOODWOOD.getFloorSign().get())
            || state.is(MysteriousWoodTypes.BLOODWOOD.getWallSign().get()))) {
            MysteriousBiomes.LOGGER.error("Mixin running 2");
            cir.setReturnValue(true);
        }
    }
}
