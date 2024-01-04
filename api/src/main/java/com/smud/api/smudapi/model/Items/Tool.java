package com.smud.api.smudapi.model.Items;

import com.smud.api.smudapi.model.SMUDCharacter;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents a tool that a player can use to break obsticles and traps
 */

public class Tool implements Item{
    
    private String name;
    private int strength;
    private int gold;

    public Tool(String name, int strength, int gold) {
        this.name = name;
        this.strength = strength;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public int getGoldValue(){
        return gold;
    }

    @Override
    public void applyItem(SMUDCharacter character) {
        character.setTool(this);
    }
}
