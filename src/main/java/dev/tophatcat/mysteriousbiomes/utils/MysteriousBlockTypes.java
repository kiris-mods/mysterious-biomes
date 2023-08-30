/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.mysteriousbiomes.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public enum MysteriousBlockTypes {

    BLOODWOOD("bloodwood"),
    GHOSTLY("ghostly"),
    SORBUS("sorbus"),
    SEEPING("seeping"),
    SAKURA("sakura");

    MysteriousBlockTypes(String name) {
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
    public Supplier<Item> sign;
    public Supplier<Block> wall_sign;
    public Supplier<Item> hanging_sign_item;
    public Supplier<Block> hanging_sign;
    public Supplier<Block> wall_hanging_sign;
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

    public Supplier<Item> getSign() {
        return sign;
    }

    public Supplier<Block> getWallSign() {
        return wall_sign;
    }

    public Supplier<Item> getHangingSignItem() {
        return hanging_sign_item;
    }

    public Supplier<Block> getHangingSign() {
        return hanging_sign;
    }

    public Supplier<Block> getWallHangingSign() {
        return wall_hanging_sign;
    }

    public Supplier<Block> getFloorSign() {
        return floor_sign;
    }
}
