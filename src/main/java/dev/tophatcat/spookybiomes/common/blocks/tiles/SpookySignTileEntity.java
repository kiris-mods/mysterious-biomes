package dev.tophatcat.spookybiomes.common.blocks.tiles;

import dev.tophatcat.spookybiomes.init.SpookyEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class SpookySignTileEntity extends SignBlockEntity {

    public SpookySignTileEntity(final BlockPos blockPos, final BlockState blockState) {
        super(blockPos, blockState);
    }

    @Nonnull
    @Override
    public BlockEntityType<?> getType() {
        return SpookyEntities.SIGNS.get();
    }
}
