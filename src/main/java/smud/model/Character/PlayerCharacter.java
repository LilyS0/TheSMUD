package smud.model.Character;

import java.util.ArrayList;

import smud.model.Environment.Room;
import smud.model.Item.MUDItem;
import smud.model.Item.Armor.Armor;
import smud.model.Item.Buffs.Buff;
import smud.model.Item.Food.Food;
import smud.model.Item.Weapons.Weapon;

/**
 * PlayerCharacter implements the Character interface, and adds additionaly functionality
 * such as Weapon and Armor associated with character.
 * 
 * @author Sydney Wilson
 */
public class PlayerCharacter extends MUDCharacter {
    private Weapon weapon;
    private Armor armor;
    private ArrayList<Buff> activeBuffs;
    private int healthBuff;
    private int attackBuff;
    private int defenseBuff;
// The name and description are supplied by the user when the PC is created.
// A weapon slot into which one weapon can be equipped. If a weapon is already equipped, it is dropped.
// An armor slot into which one piece of armor can be equipped. If a piece of armor is already equipped, it is dropped.

// method graveyard: setHealth, setAttack/setDefense (KEEP METHOD, delete instances => might need for use in conjunction with )
// eventually gonna have to part w inventory functions bc the prompt says so
    public PlayerCharacter(String name, String description) {

        this.health = 1000;
        this.attack = 50;
        this.defense = 0;
        this.name = name;
        this.description = description;
        this.inventory = new Inventory();
        this.activeBuffs = new ArrayList<>();
        this.items = new MUDItem[0];
        this.gold = 0;
        this.attackBuff = 0;
        this.healthBuff = 0;
        this.defenseBuff = 0;
    }

    public PlayerCharacter(String name, String description, int health, Weapon weapon, Armor armor, ArrayList<Buff> activeBuffs, Room currRoom, int xCor, int yCor, Inventory inventory){
        this.defense = 0;
        this.attack = 10;
        this.health = health;
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.activeBuffs = activeBuffs;
        this.weapon = weapon;
        this.armor = armor;
        this.items = new MUDItem[0];
        this.attackBuff = 0;
        this.healthBuff = 0;
        this.defenseBuff = 0;
    }

    @Override
    public int getAttack() {
        if(this.weapon != null){
            return this.attack + this.weapon.getStat() + this.attackBuff;
        }else{
            return this.attack;
        }
    }

    @Override
    public int getDefense() {
        if(this.armor != null){
            return this.defense + this.armor.getStat() + this.defenseBuff;
        }else{
            return this.defense + this.defenseBuff;
        }
    }

    public int getHealth(){
        return health + healthBuff;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Armor getArmor(){
        return armor;
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }

    public ArrayList<Buff> getActiveBuffs(){
        return activeBuffs;
    }

    private ArrayList<Buff> copyBuffs(){
        ArrayList<Buff> copy = new ArrayList<>();

        for(Buff buff: activeBuffs){
            copy.add(buff);
        }

        return copy;
    }

    public void useBuffs(){

        ArrayList<Buff> copy = copyBuffs();
        
        for(Buff buff: copy){
            if(!buff.isActive()){
                buff.removeBuff(this);
            }
        } 
    }

    public void addBuff(Buff buff){
        activeBuffs.add(buff);
        buff.useBuff(this);
        System.out.println("Added: " + buff);
    }

    public void removeBuff(Buff buff){
        activeBuffs.remove(buff);
    }

    public void addHealthBuff(int amount){
        healthBuff += amount;
    }

    public void subHealthBuff(int amount){
        healthBuff -= amount;
    }

    public void addAttackBuff(int amount){
        attackBuff += amount;
    }

    public void subAttackBuff(int amount){
        attackBuff -= amount;
    }

    public void addDefenseBuff(int amount){
        defenseBuff += amount;
    }

    public void subDefenseBuff(int amount){
        defenseBuff -= amount;
    }

    public void eatFood(Food food){
        health += food.getStat();
    }

    @Override
    public String toString(){
        return "Health: " + health + ", Attack: " + attack + ", Defense: " + defense + ", Inventory capacity: " + inventory.getRatio() + 
        "\nWeapon: " + weapon + ", Armor: " + armor + 
        "\nBuffs: " + activeBuffs.toString();
    }

    public static void main(String[] args) {
        PlayerCharacter notAlex = new PlayerCharacter("Not Alex", "This is not NPC Alex");
        System.out.println(notAlex.getName());
        System.out.println(notAlex.getHealth());
    }
}
