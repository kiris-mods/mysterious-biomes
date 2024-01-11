package dev.tophatcat.mysteriousbiomes.mixins;

import dev.tophatcat.mysteriousbiomes.utils.tags.MysteriousBlockTags;
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
            && (state.is(MysteriousBlockTags.WALL_SIGNS))
            || (state.is(MysteriousBlockTags.STANDING_SIGNS))) {
            cir.setReturnValue(true);
        }
        if (BlockEntityType.HANGING_SIGN.equals(this)
            && (state.is(MysteriousBlockTags.ALL_HANGING_SIGNS))) {
            cir.setReturnValue(true);
        }
    }
}
