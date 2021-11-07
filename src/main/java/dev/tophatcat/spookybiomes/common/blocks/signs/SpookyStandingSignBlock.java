package dev.tophatcat.spookybiomes.common.blocks.signs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.BiFunction;

public class SpookyStandingSignBlock extends StandingSignBlock {
    private final BiFunction<BlockPos, BlockState, ? extends BlockEntity> blockEntityCreator;

    public SpookyStandingSignBlock(BlockBehaviour.Properties properties, WoodType woodType,
                                   final BiFunction<BlockPos, BlockState, ? extends BlockEntity> blockEntityCreator) {
        super(properties, woodType);
        this.blockEntityCreator = blockEntityCreator;
    }

    @Override
    public BlockEntity newBlockEntity(final BlockPos pos, final BlockState state) {
        return blockEntityCreator.apply(pos, state);
    }
}
