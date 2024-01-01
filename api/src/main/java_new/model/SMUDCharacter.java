package smud.model;

import smud.model.Backpacks.Backpack;
import smud.model.Backpacks.SmallBackpack;
import smud.model.Items.Armor;
import smud.model.Items.Tool;
import smud.model.Items.Weapon;

/*
 * <<context>> in state pattern for item subsystem
 * a character that the player controls
 */

public class SMUDCharacter {

    private String name;
    private int health;
    private int defense;
    private int attack;
    private Armor armor;
    private Weapon weapon;
    private Tool tool;
    private Backpack backpack;

    public SMUDCharacter(String name){
        this.name = name;
        this.health = 250;
        this.defense = 0;
        this.attack = 10;
        this.armor = null;
        this.weapon = null;
        this.tool = null;
        this.backpack = new SmallBackpack();
    }

    public void takeDamage(int damage){
        if(isAlive() && health - damage > 0){
            health -= damage;
        }
        else{
            health = 0;
        }
    }

    public boolean isAlive(){
        return health > 0;
    }

    //setters

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    //getters

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        if(armor == null){
            return defense;
        }
        else{
            return defense + armor.getDefense();
        }
        
    }

    public int getAttack() {
        if(weapon == null){
            return attack;
        }
        else{
            return attack + weapon.getAttack();
        }
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Tool getTool() {
        return tool;
    }
    
    public Backpack getBackpack() {
        return backpack;
    }

}
