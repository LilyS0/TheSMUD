package com.smud.api.smudapi.model.Items.Armor;

import com.smud.api.smudapi.model.Items.Item;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents armor that the player an equip to add on to their defense stat
 */

public abstract class Armor implements Item{
    protected int defense;
    protected String name;

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }
}
