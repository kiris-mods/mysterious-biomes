package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.RegistrationHelpers;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedGrass;
import dev.tophatcat.spookybiomes.common.blocks.BloodiedTreeGrower;
import dev.tophatcat.spookybiomes.common.entity.TheForgottenWarlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Register our Entities, Blocks and Items to the game here.
 *
 * @author ProxyNeko
 */
public class SpookyRegistry {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, SpookyBiomes.MOD_ID);
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, SpookyBiomes.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, SpookyBiomes.MOD_ID);

    public static void registerSpookyContent(final FMLCommonSetupEvent event) {
        event.enqueueWork(SpookyRegistry::registerSpawnPlacements);
    }

    private static void registerSpawnPlacements() {
        SpawnPlacements.register(SpookyRegistry.THE_FORGOTTEN_WARLOCK.get(), Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }

    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(SpookyRegistry.THE_FORGOTTEN_WARLOCK.get(), TheForgottenWarlock.prepareAttributes().build());
    }

    public static final RegistryObject<EntityType<TheForgottenWarlock>> THE_FORGOTTEN_WARLOCK
            = ENTITIES.register("the_forgotten_warlock",
            () -> EntityType.Builder.of(TheForgottenWarlock::new, MobCategory.MONSTER)
                    .sized(0.65F, 1.45F)
                    .setTrackingRange(80)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .build(new ResourceLocation(SpookyBiomes.MOD_ID, "the_forgotten_warlock").toString()));

    public static final RegistryObject<BloodiedGrass> BLOODIED_GRASS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodied_grass",
            () -> new BloodiedGrass(Properties.of(Material.DIRT).sound(SoundType.GRAVEL)));

    public static final RegistryObject<Block> BLOODIED_DIRT
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodied_dirt",
            () -> new Block(Block.Properties.of(Material.DIRT).sound(SoundType.GRAVEL)));

    //Sorbus
    public static final RegistryObject<RotatedPillarBlock> SORBUS_LOG
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_log",
            () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<LeavesBlock> SORBUS_LEAVES
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_leaves",
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> SORBUS_PLANKS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_planks",
            () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SaplingBlock> SORBUS_SAPLING
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_sapling",
            () -> new SaplingBlock(new OakTreeGrower(),
                    Block.Properties.of(Material.GRASS).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> SORBUS_GATE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_gate",
            () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<DoorBlock> SORBUS_DOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<TrapDoorBlock> SORBUS_TRAPDOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<StairBlock> SORBUS_STAIRS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_stairs",
            () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
                    Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<FenceBlock> SORBUS_FENCE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_fence",
            () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SlabBlock> SORBUS_SLAB
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "sorbus_slab",
            () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    //Ghostly
    public static final RegistryObject<RotatedPillarBlock> GHOSTLY_LOG
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_log",
            () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<LeavesBlock> GHOSTLY_LEAVES
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_leaves",
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> GHOSTLY_PLANKS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_planks",
            () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SaplingBlock> GHOSTLY_SAPLING
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_sapling",
            () -> new SaplingBlock(new OakTreeGrower(),
                    Block.Properties.of(Material.GRASS).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> GHOSTLY_GATE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_gate",
            () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<DoorBlock> GHOSTLY_DOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<TrapDoorBlock> GHOSTLY_TRAPDOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<StairBlock> GHOSTLY_STAIRS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_stairs",
            () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
                    Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<FenceBlock> GHOSTLY_FENCE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_fence",
            () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SlabBlock> GHOSTLY_SLAB
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "ghostly_slab",
            () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    //Seeping
    public static final RegistryObject<RotatedPillarBlock> SEEPING_LOG
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_log",
            () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<LeavesBlock> SEEPING_LEAVES
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_leaves",
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> SEEPING_PLANKS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_planks",
            () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SaplingBlock> SEEPING_SAPLING
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_sapling",
            () -> new SaplingBlock(new OakTreeGrower(),
                    Block.Properties.of(Material.GRASS).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> SEEPING_GATE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_gate",
            () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<DoorBlock> SEEPING_DOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<TrapDoorBlock> SEEPING_TRAPDOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<StairBlock> SEEPING_STAIRS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_stairs",
            () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
                    Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<FenceBlock> SEEPING_FENCE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_fence",
            () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SlabBlock> SEEPING_SLAB
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "seeping_slab",
            () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    //Bloodwood
    public static final RegistryObject<RotatedPillarBlock> BLOODWOOD_LOG
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_log",
            () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<LeavesBlock> BLOODWOOD_LEAVES
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_leaves",
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> BLOODWOOD_PLANKS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_planks",
            () -> new Block(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SaplingBlock> BLOODWOOD_SAPLING
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_sapling",
            () -> new SaplingBlock(new BloodiedTreeGrower(),
                    Block.Properties.of(Material.GRASS).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> BLOODWOOD_GATE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_gate",
            () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<DoorBlock> BLOODWOOD_DOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_door",
            () -> new DoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<TrapDoorBlock> BLOODWOOD_TRAPDOOR
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_trapdoor",
            () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<StairBlock> BLOODWOOD_STAIRS
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_stairs",
            () -> new StairBlock(() -> SORBUS_PLANKS.get().defaultBlockState(),
                    Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<FenceBlock> BLOODWOOD_FENCE
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_fence",
            () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<SlabBlock> BLOODWOOD_SLAB
            = RegistrationHelpers.registerBlockAndStandardItem(BLOCKS, ITEMS, "bloodwood_slab",
            () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD)));
}
