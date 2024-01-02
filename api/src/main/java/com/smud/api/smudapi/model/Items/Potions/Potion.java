package com.smud.api.smudapi.model.Items.Potions;

import com.smud.api.smudapi.model.Items.Item;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents a potion that a player can use to give some buff
 */

public abstract class Potion implements Item{
    private String name;
    private String effect;
    private int strength;
    private int turns;

    public int getTurns() {
        return turns;
    }

    public int getStrength() {
        return strength;
    }

    public String getEffect() {
        return effect;
    }

    

    public String getName() {
        return name;
    }
}
