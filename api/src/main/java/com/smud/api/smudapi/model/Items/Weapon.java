package com.smud.api.smudapi.model.Items;

import com.smud.api.smudapi.model.SMUDCharacter;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents a weapon that a player can equip to add to their attack stat
 */

public class Weapon implements Item{

    private String name;
    private int attack;
    private int gold;

    public Weapon(String name, int attack, int gold) {
        this.name = name;
        this.attack = attack;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public int getGoldValue(){
        return gold;
    }

    @Override
    public void applyItem(SMUDCharacter character) {
        character.setWeapon(this);
    }
}
