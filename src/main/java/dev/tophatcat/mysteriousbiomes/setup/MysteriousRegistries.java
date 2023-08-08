package dev.tophatcat.mysteriousbiomes.setup;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class MysteriousRegistries {

    public static final Block BLOODWOOD_LEAVES = registerBlock("bloodwood_leaves", leaves());
    public static final Block GHOSTLY_LEAVES = registerBlock("ghostly_leaves", leaves());
    public static final Block SORBUS_LEAVES = registerBlock("sorbus_leaves", leaves());
    public static final Block SEEPING_LEAVES = registerBlock("seeping_leaves", leaves());

    private static LeavesBlock leaves() {
        return new LeavesBlock(
            BlockBehaviour.Properties.of(Material.LEAVES)
                .strength(0.2F)
                .randomTicks()
                .sound(SoundType.GRASS)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(Blocks::never)
                .isViewBlocking(Blocks::never)
        );
    }

    private static Item registerItem(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    private static Block registerBlock(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
}
