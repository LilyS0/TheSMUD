package smud.model;

import smud.model.Item.*;

/**
 * NPC implements the Character class amnd inherits the functionality associated with it, and adds
 * additional information associated with the NPC such as nocturnal/diurnal.
 * 
 * @author Sydney Wilson
 */
public class NPC extends MUDCharacter{
    // INCORPORATE DEFAULT VALUES
    private boolean isNocturnal;
     
    public boolean getNocturnal() {
        return this.isNocturnal;
    }

    public void setNocturnal(boolean isNocturnal) {
        this.isNocturnal = isNocturnal;
    }

    public NPC(String name, String description, int health, Inventory inventory, boolean isNocturnal) {
        this.setName(name);
        this.setDescription(description);
        this.setHealth(health);
        this.setNocturnal(isNocturnal);
        this.setInventory(inventory);
    }

    public MUDItem dropItem() {
        // enter inventory, pick item, add item to Tile, delete item from NPC inventory
        // CALLED WHEN NPC IS DEFEATED => ADD TO isAlive():false
        return null;
    }

    // public static void main(String[] args) {
    //     Inventory inv = new Inventory();
    //     NPC alex = new NPC("Alex", "This is NPC Alex", 20, inv, false);
    //     System.out.println(alex.getName());
    //     System.out.println(alex.getNocturnal());
    // }
}
