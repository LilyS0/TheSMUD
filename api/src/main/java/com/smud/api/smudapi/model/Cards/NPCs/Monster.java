package com.smud.api.smudapi.model.Cards.NPCs;

import com.smud.api.smudapi.model.Items.Item;
import com.smud.api.smudapi.model.Items.Armor.Armor;
import com.smud.api.smudapi.model.Items.Weapons.Weapon;

public class Monster extends NPC{
    private int health;
    private int defense;
    private int attack;
    private Armor armor;
    private Weapon weapon;

    public Monster(String name, int health, int defense, int attack, Armor armor, Weapon weapon){
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.attack = attack;
        this.armor = armor;
        this.weapon = weapon;
        this.isDay = true;
        this.items = new Item[0];
    }

    public void takeDamage(int damage){
        if(isAlive() && health - damage > 0){
            health =- damage;
        }
        else{
            health = 0;
        }
    }

    //getters

    public boolean isAlive() {
        return health > 0;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    //setters

    public void setDay(boolean isDay){
        this.isDay = isDay;
    }

    public void setItems(Item[] items){
        this.items = items;
    }

}
