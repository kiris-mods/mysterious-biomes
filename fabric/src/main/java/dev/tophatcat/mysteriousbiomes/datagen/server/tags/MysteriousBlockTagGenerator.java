package dev.tophatcat.mysteriousbiomes.datagen.server.tags;

import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.utils.tags.MysteriousBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class MysteriousBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public MysteriousBlockTagGenerator(FabricDataOutput output,
                                       CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(MysteriousBlockTags.PLANKS)
            .add(MysteriousRegistry.BLOODWOOD_PLANKS.get())
            .add(MysteriousRegistry.GHOSTLY_PLANKS.get())
            .add(MysteriousRegistry.SEEPING_PLANKS.get())
            .add(MysteriousRegistry.SORBUS_PLANKS.get())
            .add(MysteriousRegistry.WALNUT_PLANKS.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_BUTTONS)
            .add(MysteriousRegistry.BLOODWOOD_BUTTON.get())
            .add(MysteriousRegistry.GHOSTLY_BUTTON.get())
            .add(MysteriousRegistry.SEEPING_BUTTON.get())
            .add(MysteriousRegistry.SORBUS_BUTTON.get())
            .add(MysteriousRegistry.WALNUT_BUTTON.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_DOORS)
            .add(MysteriousRegistry.BLOODWOOD_DOOR.get())
            .add(MysteriousRegistry.GHOSTLY_DOOR.get())
            .add(MysteriousRegistry.SEEPING_DOOR.get())
            .add(MysteriousRegistry.SORBUS_DOOR.get())
            .add(MysteriousRegistry.WALNUT_DOOR.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_STAIRS)
            .add(MysteriousRegistry.BLOODWOOD_STAIRS.get())
            .add(MysteriousRegistry.GHOSTLY_STAIRS.get())
            .add(MysteriousRegistry.SEEPING_STAIRS.get())
            .add(MysteriousRegistry.SORBUS_STAIRS.get())
            .add(MysteriousRegistry.WALNUT_STAIRS.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_SLABS)
            .add(MysteriousRegistry.BLOODWOOD_SLAB.get())
            .add(MysteriousRegistry.GHOSTLY_SLAB.get())
            .add(MysteriousRegistry.SEEPING_SLAB.get())
            .add(MysteriousRegistry.SORBUS_SLAB.get())
            .add(MysteriousRegistry.WALNUT_SLAB.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_FENCES)
            .add(MysteriousRegistry.BLOODWOOD_FENCE.get())
            .add(MysteriousRegistry.GHOSTLY_FENCE.get())
            .add(MysteriousRegistry.SEEPING_FENCE.get())
            .add(MysteriousRegistry.SORBUS_FENCE.get())
            .add(MysteriousRegistry.WALNUT_FENCE.get());

        getOrCreateTagBuilder(MysteriousBlockTags.SAPLINGS)
            .add(MysteriousRegistry.BLOODWOOD_SAPLING.get())
            .add(MysteriousRegistry.GHOSTLY_SAPLING.get())
            .add(MysteriousRegistry.SEEPING_SAPLING.get())
            .add(MysteriousRegistry.SORBUS_SAPLING.get())
            .add(MysteriousRegistry.WALNUT_SAPLING.get());

        getOrCreateTagBuilder(MysteriousBlockTags.LOGS)
            .addTag(MysteriousBlockTags.LOGS_THAT_BURN);

        getOrCreateTagBuilder(MysteriousBlockTags.OVERWORLD_NATURAL_LOGS)
            .add(MysteriousRegistry.BLOODWOOD_LOG.get())
            .add(MysteriousRegistry.GHOSTLY_LOG.get())
            .add(MysteriousRegistry.SEEPING_LOG.get())
            .add(MysteriousRegistry.SORBUS_LOG.get())
            .add(MysteriousRegistry.WALNUT_LOG.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_PRESSURE_PLATES)
            .add(MysteriousRegistry.BLOODWOOD_PRESSURE_PLATE.get())
            .add(MysteriousRegistry.GHOSTLY_PRESSURE_PLATE.get())
            .add(MysteriousRegistry.SEEPING_PRESSURE_PLATE.get())
            .add(MysteriousRegistry.SORBUS_PRESSURE_PLATE.get())
            .add(MysteriousRegistry.WALNUT_PRESSURE_PLATE.get());

        getOrCreateTagBuilder(MysteriousBlockTags.LEAVES)
            .add(MysteriousRegistry.BLOODWOOD_LEAVES.get())
            .add(MysteriousRegistry.GHOSTLY_LEAVES.get())
            .add(MysteriousRegistry.SEEPING_LEAVES.get())
            .add(MysteriousRegistry.SORBUS_LEAVES.get())
            .add(MysteriousRegistry.WALNUT_LEAVES.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_TRAPDOORS)
            .add(MysteriousRegistry.BLOODWOOD_TRAPDOOR.get())
            .add(MysteriousRegistry.GHOSTLY_TRAPDOOR.get())
            .add(MysteriousRegistry.SEEPING_TRAPDOOR.get())
            .add(MysteriousRegistry.SORBUS_TRAPDOOR.get())
            .add(MysteriousRegistry.WALNUT_TRAPDOOR.get());

        getOrCreateTagBuilder(MysteriousBlockTags.STANDING_SIGNS)
            .add(Block.byItem(MysteriousRegistry.BLOODWOOD_SIGN.get()))
            .add(Block.byItem(MysteriousRegistry.GHOSTLY_SIGN.get()))
            .add(Block.byItem(MysteriousRegistry.SEEPING_SIGN.get()))
            .add(Block.byItem(MysteriousRegistry.SORBUS_SIGN.get()))
            .add(Block.byItem(MysteriousRegistry.WALNUT_SIGN.get()));

        getOrCreateTagBuilder(MysteriousBlockTags.WALL_SIGNS)
            .add(MysteriousRegistry.BLOODWOOD_WALL_SIGN.get())
            .add(MysteriousRegistry.GHOSTLY_WALL_SIGN.get())
            .add(MysteriousRegistry.SEEPING_WALL_SIGN.get())
            .add(MysteriousRegistry.SORBUS_WALL_SIGN.get())
            .add(MysteriousRegistry.WALNUT_WALL_SIGN.get());

        getOrCreateTagBuilder(MysteriousBlockTags.CEILING_HANGING_SIGNS)
            .add(MysteriousRegistry.BLOODWOOD_HANGING_SIGN.get())
            .add(MysteriousRegistry.GHOSTLY_HANGING_SIGN.get())
            .add(MysteriousRegistry.SEEPING_HANGING_SIGN.get())
            .add(MysteriousRegistry.SORBUS_HANGING_SIGN.get())
            .add(MysteriousRegistry.WALNUT_HANGING_SIGN.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WALL_HANGING_SIGNS)
            .add(MysteriousRegistry.BLOODWOOD_WALL_HANGING_SIGN.get())
            .add(MysteriousRegistry.GHOSTLY_WALL_HANGING_SIGN.get())
            .add(MysteriousRegistry.SEEPING_WALL_HANGING_SIGN.get())
            .add(MysteriousRegistry.SORBUS_WALL_HANGING_SIGN.get())
            .add(MysteriousRegistry.WALNUT_WALL_HANGING_SIGN.get());

        getOrCreateTagBuilder(MysteriousBlockTags.FENCE_GATES)
            .add(MysteriousRegistry.BLOODWOOD_GATE.get())
            .add(MysteriousRegistry.GHOSTLY_GATE.get())
            .add(MysteriousRegistry.SEEPING_GATE.get())
            .add(MysteriousRegistry.SORBUS_GATE.get())
            .add(MysteriousRegistry.WALNUT_GATE.get());

        getOrCreateTagBuilder(MysteriousBlockTags.DIRT)
            .add(MysteriousRegistry.BLOODIED_DIRT.get())
            .add(MysteriousRegistry.BLOODIED_GRASS.get());

        getOrCreateTagBuilder(MysteriousBlockTags.BUTTONS).addTag(MysteriousBlockTags.WOODEN_BUTTONS);
        getOrCreateTagBuilder(MysteriousBlockTags.DOORS).addTag(MysteriousBlockTags.WOODEN_DOORS);

        getOrCreateTagBuilder(MysteriousBlockTags.BLOODWOOD_LOGS)
            .add(MysteriousRegistry.BLOODWOOD_LOG.get())
            .add(MysteriousRegistry.BLOODWOOD_STRIPPED_LOG.get())
            .add(MysteriousRegistry.BLOODWOOD_WOOD.get())
            .add(MysteriousRegistry.BLOODWOOD_STRIPPED_WOOD.get());

        getOrCreateTagBuilder(MysteriousBlockTags.GHOSTLY_LOGS)
            .add(MysteriousRegistry.GHOSTLY_LOG.get())
            .add(MysteriousRegistry.GHOSTLY_STRIPPED_LOG.get())
            .add(MysteriousRegistry.GHOSTLY_WOOD.get())
            .add(MysteriousRegistry.GHOSTLY_STRIPPED_WOOD.get());

        getOrCreateTagBuilder(MysteriousBlockTags.SORBUS_LOGS)
            .add(MysteriousRegistry.SORBUS_LOG.get())
            .add(MysteriousRegistry.SORBUS_STRIPPED_LOG.get())
            .add(MysteriousRegistry.SORBUS_WOOD.get())
            .add(MysteriousRegistry.SORBUS_STRIPPED_WOOD.get());

        getOrCreateTagBuilder(MysteriousBlockTags.SEEPING_LOGS)
            .add(MysteriousRegistry.SEEPING_LOG.get())
            .add(MysteriousRegistry.SEEPING_STRIPPED_LOG.get())
            .add(MysteriousRegistry.SEEPING_WOOD.get())
            .add(MysteriousRegistry.SEEPING_STRIPPED_WOOD.get());

        getOrCreateTagBuilder(MysteriousBlockTags.WALNUT_LOGS)
            .add(MysteriousRegistry.WALNUT_LOG.get())
            .add(MysteriousRegistry.WALNUT_STRIPPED_LOG.get())
            .add(MysteriousRegistry.WALNUT_WOOD.get())
            .add(MysteriousRegistry.WALNUT_STRIPPED_WOOD.get());

        getOrCreateTagBuilder(MysteriousBlockTags.LOGS_THAT_BURN)
            .addTag(MysteriousBlockTags.BLOODWOOD_LOGS)
            .addTag(MysteriousBlockTags.GHOSTLY_LOGS)
            .addTag(MysteriousBlockTags.SORBUS_LOGS)
            .addTag(MysteriousBlockTags.SEEPING_LOGS)
            .addTag(MysteriousBlockTags.WALNUT_LOGS);

        getOrCreateTagBuilder(MysteriousBlockTags.PRESSURE_PLATES)
            .addTag(MysteriousBlockTags.WOODEN_PRESSURE_PLATES);

        getOrCreateTagBuilder(MysteriousBlockTags.STAIRS)
            .addTag(MysteriousBlockTags.WOODEN_STAIRS);

        getOrCreateTagBuilder(MysteriousBlockTags.SLABS)
            .addTag(MysteriousBlockTags.WOODEN_SLABS);

        getOrCreateTagBuilder(MysteriousBlockTags.TRAPDOORS)
            .addTag(MysteriousBlockTags.WOODEN_TRAPDOORS);

        getOrCreateTagBuilder(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.STANDING_SIGNS)
            .addTag(MysteriousBlockTags.WALL_SIGNS);

        getOrCreateTagBuilder(MysteriousBlockTags.ALL_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.CEILING_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.WALL_HANGING_SIGNS);

        getOrCreateTagBuilder(MysteriousBlockTags.ALL_SIGNS)
            .addTag(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.ALL_HANGING_SIGNS);

        getOrCreateTagBuilder(MysteriousBlockTags.FENCES)
            .addTag(MysteriousBlockTags.WOODEN_FENCES);

        getOrCreateTagBuilder(MysteriousBlockTags.AXE_MINEABLE)
            .addTag(MysteriousBlockTags.ALL_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.WOODEN_TRAPDOORS)
            .addTag(MysteriousBlockTags.WOODEN_STAIRS)
            .addTag(MysteriousBlockTags.WOODEN_SLABS)
            .addTag(MysteriousBlockTags.WOODEN_PRESSURE_PLATES)
            .addTag(MysteriousBlockTags.WOODEN_FENCES)
            .addTag(MysteriousBlockTags.WOODEN_DOORS)
            .addTag(MysteriousBlockTags.WOODEN_BUTTONS)
            .addTag(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.SAPLINGS)
            .addTag(MysteriousBlockTags.PLANKS)
            .addTag(MysteriousBlockTags.LOGS)
            .addTag(MysteriousBlockTags.FENCE_GATES);

        getOrCreateTagBuilder(MysteriousBlockTags.HOE_MINEABLE)
            .addTag(MysteriousBlockTags.LEAVES);

        getOrCreateTagBuilder(MysteriousBlockTags.SHOVEL_MINEABLE)
            .add(MysteriousRegistry.BLOODIED_GRASS.get())
            .add(MysteriousRegistry.BLOODIED_DIRT.get());
    }
}
