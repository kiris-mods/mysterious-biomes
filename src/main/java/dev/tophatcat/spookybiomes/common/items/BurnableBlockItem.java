package dev.tophatcat.spookybiomes.common.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class BurnableBlockItem extends BlockItem {

    private final int burnTime;

    public BurnableBlockItem(final Block block, final int burnTime, final Properties properties) {
        super(block, properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
