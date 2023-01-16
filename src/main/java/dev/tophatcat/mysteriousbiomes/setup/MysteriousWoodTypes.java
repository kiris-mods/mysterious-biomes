package dev.tophatcat.mysteriousbiomes.setup;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum MysteriousWoodTypes {

    BLOODWOOD("bloodwood"),
    GHOSTLY("ghostly"),
    SORBUS("sorbus"),
    SEEPING("seeping"),
    SAKURA("sakura");

    MysteriousWoodTypes(String name)  {
        this.name = name;
    }

    private final String name;
    public Supplier<Block> door;
    public Supplier<Block> trapdoor;
    public Supplier<Block> slab;
    public Supplier<Block> stairs;
    public Supplier<Block> planks;
    public Supplier<Block> log;
    public Supplier<Block> stripped_log;
    public Supplier<Block> wood;
    public Supplier<Block> stripped_wood;
    public Supplier<Block> gate;
    public Supplier<Block> fence;
    public Supplier<Block> button;
    public Supplier<Block> pressure_plate;
    public Supplier<Block> leaves;
    public Supplier<Block> sapling;
    public Supplier<Block> wall_sign;
    public Supplier<Block> floor_sign;

    public String getName() {
        return name;
    }

    public Supplier<Block> getDoor() {
        return door;
    }

    public Supplier<Block> getTrapdoor() {
        return trapdoor;
    }

    public Supplier<Block> getSlab() {
        return slab;
    }

    public Supplier<Block> getStairs() {
        return stairs;
    }

    public Supplier<Block> getPlanks() {
        return planks;
    }

    public Supplier<Block> getLog() {
        return log;
    }

    public Supplier<Block> getStrippedLog() {
        return stripped_log;
    }

    public Supplier<Block> getWood() {
        return wood;
    }

    public Supplier<Block> getStrippedWood() {
        return stripped_wood;
    }

    public Supplier<Block> getGate() {
        return gate;
    }

    public Supplier<Block> getFence() {
        return fence;
    }

    public Supplier<Block> getButton() {
        return button;
    }

    public Supplier<Block> getPressurePlate() {
        return pressure_plate;
    }

    public Supplier<Block> getLeaves() {
        return leaves;
    }

    public Supplier<Block> getSapling() {
        return sapling;
    }

    public Supplier<Block> getWallSign() {
        return wall_sign;
    }

    public Supplier<Block> getFloorSign() {
        return floor_sign;
    }
}
