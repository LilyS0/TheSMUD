package smud.model;

import java.util.Random;

import smud.model.Item.*;

/**
 * NPC implements the Character class amnd inherits the functionality associated with it, and adds
 * additional information associated with the NPC such as nocturnal/diurnal.
 * 
 * @author Sydney Wilson
 */
public class NPC extends MUDCharacter{
    // INCORPORATE DEFAULT VALUES

// An NPC is one that is controlled by the game. In this version of the game, all NPCs are enemies, but in future versions, some NPCs may not be hostile.
// An NPC is either nocturnal or diurnal
// Health: 50-150
// Attack: 5-15
// Defense: 0-10
// A description including the stats of the NPC (health, attack, armor).
// NPCs do not move, but will attack a player that is adjacent to them in any direction (including diagonal).
// If an NPC is defeated it may drop an item and/or gold.

// method graveyard: setHealth

    private boolean isNocturnal;
     
    public boolean getNocturnal() {
        return this.isNocturnal;
    }

    public void setNocturnal(boolean isNocturnal) {
        this.isNocturnal = isNocturnal;
    }

    public NPC(String name, String description, Inventory inventory, boolean isNocturnal) {
        this.setName(name);
        this.setDescription(description);
        Random rand = new Random();
        int minHealth = 50;
        int maxHealth = 150;
        this.health = rand.nextInt(maxHealth - minHealth + 1) + minHealth;
        this.setNocturnal(isNocturnal);
        this.setInventory(inventory);
    }

    public MUDItem dropItem() {
        // enter inventory, pick item, add item to Tile, delete item from NPC inventory
        // CALLED WHEN NPC IS DEFEATED => ADD TO isAlive():false
        return null;
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        NPC alex = new NPC("Alex", "This is NPC Alex", inv, false);
        System.out.println(alex.getName());
        System.out.println(alex.getNocturnal());
        System.out.println(alex.getHealth());
    }
}
