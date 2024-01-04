package com.smud.api.smudapi.model.Items;

import com.smud.api.smudapi.model.SMUDCharacter;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents armor that the player an equip to add on to their defense stat
 */

public class Armor implements Item{

    private String name;
    private int defense;
    private int gold;

    public Armor(String name, int defense, int gold){
        this.name = name;
        this.defense = defense;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public int getGoldValue(){
        return gold;
    }

    @Override
    public void applyItem(SMUDCharacter character) {
        character.setArmor(this);
    }
}
