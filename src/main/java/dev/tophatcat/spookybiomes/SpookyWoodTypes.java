package dev.tophatcat.spookybiomes;

import net.minecraft.block.Block;

import java.util.function.Supplier;

public enum SpookyWoodTypes {

    BLOODWOOD("bloodwood"),
    GHOSTLY("ghostly"),
    SORBUS("sorbus"),
    SEEPING("seeping");

    SpookyWoodTypes(String name)  {
        this.name = name;
    }

    private String name;
    private Supplier<Block> door;
    private Supplier<Block> trapdoor;
    private Supplier<Block> slab;
    private Supplier<Block> stairs;
    private Supplier<Block> planks;
    private Supplier<Block> log;
    private Supplier<Block> stripped_log;
    private Supplier<Block> wood;
    private Supplier<Block> stripped_wood;
    private Supplier<Block> gate;
    private Supplier<Block> fence;
    private Supplier<Block> button;
    private Supplier<Block> pressure_plate;
    private Supplier<Block> sapling;
    private Supplier<Block> leaves;

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

    public Supplier<Block> getSapling() {
        return sapling;
    }

    public Supplier<Block> getLeaves() {
        return leaves;
    }

    public String getName() {
        return name;
    }
}
