package com.smud.api.smudapi.model.Items;

import com.smud.api.smudapi.model.SMUDCharacter;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents a potion that a player can use to give some buff
 */

public class Potion implements Item{

    private String name;
    private String effect;
    private int strength;
    private int turns;
    private int gold;

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

    @Override
    public int getGoldValue(){
        return gold;
    }

    @Override
    public void applyItem(SMUDCharacter character) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyItem'");
    }
}
