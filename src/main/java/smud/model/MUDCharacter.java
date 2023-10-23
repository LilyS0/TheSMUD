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
        // will call inventory.useAttack(Weapon?) to do so
        return 0;
    }

    public int getDefense() {
        // will call inventory.useDefense(Armor?) to do so
        return 0;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isAlive() {
        // if health > 0 && (game is over u die??)
        return true;
    }

    public void attack(MUDCharacter character) {
        // 1) get attack from inventory 2) subtract from character.health() 3) delete item from this.inventory
    }

    public void defend() {
        // 1) get defend from inventory 2) this.health REMAINS SAME, & no damage done to other character either 3) delete from this.inventory
    }

    // will be discussed in 10/23 meting
//    public void move(Tile[][] location) {
//
//    }
}
