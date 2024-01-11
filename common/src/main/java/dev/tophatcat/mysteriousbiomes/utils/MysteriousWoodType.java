package dev.tophatcat.mysteriousbiomes.utils;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class MysteriousWoodType {

    public static void init() {
        BlockSetType.register(BLOODWOOD_SET);
        BlockSetType.register(GHOSTLY_SET);
        BlockSetType.register(SORBUS_SET);
        BlockSetType.register(SEEPING_SET);
        BlockSetType.register(WALNUT_SET);
        WoodType.register(BLOODWOOD_TYPE);
        WoodType.register(GHOSTLY_TYPE);
        WoodType.register(SORBUS_TYPE);
        WoodType.register(SEEPING_TYPE);
        WoodType.register(WALNUT_TYPE);
    }

    private static final BlockSetType BLOODWOOD_SET = new BlockSetType("bloodwood");
    private static final BlockSetType GHOSTLY_SET = new BlockSetType("ghostly");
    private static final BlockSetType SORBUS_SET = new BlockSetType("sorbus");
    private static final BlockSetType SEEPING_SET = new BlockSetType("seeping");
    private static final BlockSetType WALNUT_SET = new BlockSetType("walnut");

    public static final WoodType BLOODWOOD_TYPE = new WoodType(new ResourceLocation(
        MysteriousCommon.MOD_ID, "bloodwood").toString(), new BlockSetType(BLOODWOOD_SET.name()));
    public static final WoodType GHOSTLY_TYPE = new WoodType(new ResourceLocation(
        MysteriousCommon.MOD_ID, "ghostly").toString(), new BlockSetType(GHOSTLY_SET.name()));
    public static final WoodType SORBUS_TYPE = new WoodType(new ResourceLocation(
        MysteriousCommon.MOD_ID, "sorbus").toString(), new BlockSetType(SORBUS_SET.name()));
    public static final WoodType SEEPING_TYPE = new WoodType(new ResourceLocation(
        MysteriousCommon.MOD_ID, "seeping").toString(), new BlockSetType(SEEPING_SET.name()));
    public static final WoodType WALNUT_TYPE = new WoodType(new ResourceLocation(
        MysteriousCommon.MOD_ID, "walnut").toString(), new BlockSetType(WALNUT_SET.name()));
}
