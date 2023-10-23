package smud.model;

import smud.model.Environment.Tiles.Tile;

/**
 * Interface that contains information shared by both NPC and PlayerCharacter.
 * 
 * @author Sydney Wilson
 */
public abstract class MUDCharacter {
    protected String name;
    protected String description;
    protected int health;
    protected Inventory inventory;
    protected Tile[][] location;
    protected int attack;
    protected int defense;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    // requires further discussion at 10/23 meeting
//    public Tile[][] getLocation() {
//        return this.location;
//    }

    // requires further discussion at 10/23 meeting
//    public void setLocation(Tile[][] location) {
//        this.location = location;
//    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void takeDamage(int attackValue){
        int damage = attackValue-this.getDefense();
        if(damage <= 0){
            damage = 1;
        }
        this.health -= defense;
    }

    public void attack(MUDCharacter target){
        target.takeDamage(this.getAttack());
    }

    // will be discussed in 10/23 meting
//    public void move(Tile[][] location) {
//
//    }
}
