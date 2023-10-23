package smud.model;

import java.util.Random;

import smud.model.Item.*;

/**
 * NPC implements the Character class and inherits the functionality associated with it, and adds
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
    private String[][] randomNPCs = {{"The Merchant", "Everyone's favorite street pharmacist."},
    {"Sans", "A metaphysics expert, knowledgeable in the ways of space-time manipulation and the multiverse."},
    {"Tom Nook", "Love him or hate him, either way you probably owe him."},
    {"Navi", "Sometimes the best advice, is no advice."},
    {"Igor", "Your friendly neighborhood blacksmith. Or is he?"},
    {"Count Chocula", "Not to be confused with the Count von Count."},
    {"Justin Case", "Well-known lawyer specializes in defending Goats and Trolls."},
    {"Guy DeFault", "Guy Fieri's half cousin twice removed."},
    {"Cosmic Menace", ""},
    {"Alex", "His dad works for Matlab. You've been warned."},
    {"Bobert St. Jaqass", "He looked at me funny, and even though I have no idea why, it offended me anyway."},
    {"Bubert", "When I actually went to class, halfway through I began to hate God for giving me the legs that brought me there."},
    {"Rotisserie St. Jacks", "Enrolling in GCIS-LRATIO has been the biggest mistake of my entire life. I don't even know what a capital letter looks like anymore."},
    {"Hank Schmogus", ""},
    {"Paul Creenis", ""}};
    Random rand = new Random();
    public boolean getNocturnal() {
        return this.isNocturnal;
    }

    public void setNocturnal(boolean isNocturnal) {
        this.isNocturnal = isNocturnal;
    }

    public NPC(String name, String description, Inventory inventory, boolean isNocturnal) {
        this.setName(name);
        this.setDescription(description);
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

    public NPC() {
        int minHealth = 50;
        int maxHealth = 150;
        this.health = rand.nextInt(maxHealth - minHealth + 1) + minHealth;
        int NPCnumber = rand.nextInt(15); //15 total options (located 0-14 in array)
        this.name = randomNPCs[NPCnumber][0];
        this.description = randomNPCs[NPCnumber][1];
        if (NPCnumber % 2 == 0) { this.setNocturnal(true); }
        // all this is missing is an inventory, but like obvi i gotta finish coding that first so i shall return to this capiche
    }

//     public static void main(String[] args) {
//         Inventory inv = new Inventory();
//         NPC alex = new NPC("Alex", "This is NPC Alex", inv, false);
//         System.out.println(alex.getName());
//         System.out.println(alex.getNocturnal());
//         System.out.println(alex.getHealth());
//     }
    public static void main(String[] args) {
        System.out.println(new NPC());
    }
}
