package smud.model.Cards;

import smud.model.Items.Armor;
import smud.model.Items.Item;
import smud.model.Items.Weapon;

/*
 * <<concrete state>> in state pattern for card subsytem
 * represents an NPC that a player and fight or interact with
 */
 
public abstract class NPC implements Card{
    private String name;
    private int health;
    private int defense;
    private int attack;
    private Armor armor;
    private Weapon weapon;
    private Item[] items;
    private boolean isDay;

    public void takeDamage(int damage){
        if(isAlive() && health - damage > 0){
            health =- damage;
        }
        else{
            health = 0;
        }
    }

    @Override
    public void updateTime(boolean isDay){
        this.isDay = isDay;
    }

    @Override
    public NPC getMonster(){
        return this;
    }

    //getters

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isDay() {
        return isDay;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Item[] getItems() {
        return items;
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

    public String getName(){
        return name;
    }
}
