package dev.tophatcat.spookybiomes.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class SpookyLogBlock extends RotatedPillarBlock {
    private final Supplier<? extends Block> strippedLogBlock;

    public SpookyLogBlock(final Properties properties, final Supplier<? extends Block> strippedLogBlock) {
        super(properties);
        this.strippedLogBlock = strippedLogBlock;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(final BlockState state, final Level world, final BlockPos pos, final Player player, final ItemStack stack, final ToolAction toolAction) {
        if (stack.canPerformAction(toolAction) && ToolActions.AXE_STRIP.equals(toolAction)) {
            return strippedLogBlock.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        return null;
    }
}
