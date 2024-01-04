package com.smud.api.smudapi.model.Items;

import com.smud.api.smudapi.model.SMUDCharacter;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents food that the player can consume to give back health
 */

public class Food implements Item{

    private String name;
    private int health;
    private int gold;

    public Food(String name, int health, int gold) {
        this.name = name;
        this.health = health;
        this.gold = gold;
    }
    
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }

    @Override
    public int getGoldValue(){
        return gold;
    }
    @Override
    public void applyItem(SMUDCharacter character) {
        character.addHealth(health);
    }
}
