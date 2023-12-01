package smud.model.Character;

import java.util.Random;

import smud.controller.DayNightObserver;
import smud.model.Environment.Tiles.Tile;
import smud.model.Item.*;


/**
 * NPC implements the Character class and inherits the functionality associated with it, and adds
 * additional information associated with the NPC such as nocturnal/diurnal.
 * 
 * @author Sydney Wilson
 */
public class NPC extends MUDCharacter implements DayNightObserver{
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

    
    private final String[][] randomNPCs = {{"The Merchant", "Everyone's favorite street pharmacist."},
    {"Sans", "A metaphysics expert, knowledgeable in the ways of space-time manipulation and the multiverse."},
    {"Tom Nook", "Love him or hate him, either way you probably owe him."},
    {"Navi", "Sometimes the best advice, is no advice."},
    {"Igor", "Your friendly neighborhood blacksmith. Or is he?"},
    {"Count Chocula", "Not to be confused with the Count von Count."},
    {"Justin Case", "Well-known lawyer specializes in defending Goats and Trolls."},
    {"Guy DeFault", "Guy Fieri's half cousin twice removed."},
    {"Cosmic Menace", "The enigmatic extraterrestrial force that looms on the edge of the universe, harboring unknown intentions for all of humanity."},
    {"Alex", "His dad works for Matlab. You've been warned."},
    {"Bobert St. Jaqass", "He looked at me funny, and even though I have no idea why, it offended me anyway."},
    {"Bubert", "When I actually went to class, halfway through I began to hate God for giving me the legs that brought me there."},
    {"Rotisserie St. Jacks", "Enrolling in GCIS-LRATIO has been the biggest mistake of my entire life. I don't even know what a capital letter looks like anymore."},
    {"Hank Schmogus", "The eccentric inventor with a penchant for creating quirky contraptions that defy convention"},
    {"Paul Creenis", "The unassuming librarian who secretly moonlights as a stand-up comedian, spreading laughter one book at a time."}};

    private final Random rand = new Random();
    private boolean isNocturnal;
    private boolean isDay;
    private final int MIN_HEALTH = 50;
    private final int MAX_HEALTH = 150;
    private final int MIN_ATTACK = 5;
    private final int MAX_ATTACK = 15;
    private final int MIN_DEFENSE = 0;
    private final int MAX_DEFENSE = 10;
    private final double NOCT_BUFF = 1.2;
    private final double DIN_BUFF = 1.1;

    // first off don't jump me for making it public imma change it but also idk if [][] is the best data structure but we can talk ab that in the 10/23 meeting
    public Tile[][] location;
    public NPC(String name, String description, Inventory inventory, boolean isNocturnal,Tile[][] location) {
        this.name = name;
        this.description = description;
        this.health = rand.nextInt(MAX_HEALTH - MIN_HEALTH + 1) + MIN_HEALTH;
        this.attack = rand.nextInt(MAX_ATTACK - MIN_ATTACK) + 1 + MIN_ATTACK;
        this.defense = rand.nextInt(MAX_DEFENSE - MIN_DEFENSE + 1) + MIN_DEFENSE;
        this.isNocturnal = isNocturnal;
        this.inventory = inventory;
        this.items = MUDItem.getRandomItems();
    }

    public NPC() {
        this.health = rand.nextInt(MAX_HEALTH - MIN_HEALTH + 1) + MIN_HEALTH;
        this.attack = rand.nextInt(MAX_ATTACK - MIN_ATTACK) + 1 + MIN_ATTACK;
        this.defense = rand.nextInt(MAX_DEFENSE - MIN_DEFENSE + 1) + MIN_DEFENSE;
        int NPCnumber = rand.nextInt(15); //15 total options (located 0-14 in array)
        this.name = randomNPCs[NPCnumber][0];
        this.description = randomNPCs[NPCnumber][1];
        if (NPCnumber % 2 == 0) { this.setNocturnal(true); }
        this.items = MUDItem.getRandomItems();
    }

    public boolean getNocturnal() {
        return this.isNocturnal;
    }

    public void setNocturnal(boolean isNocturnal) {
        this.isNocturnal = isNocturnal;
    }

    private void increaseNoctStats(){
        if(isNocturnal){
            health *= NOCT_BUFF;
            attack *= NOCT_BUFF;
            defense *= NOCT_BUFF;
        }
    }

    private void decreaseNoctStats(){
        if(isNocturnal){
            health /= NOCT_BUFF;
            attack /= NOCT_BUFF;
            defense /= NOCT_BUFF;
        }
        
    }

    private void increaseDinStats(){
        if(!isNocturnal){
            health *= DIN_BUFF;
            attack *= DIN_BUFF;
            defense *= DIN_BUFF;
        }  
    }

    private void decreaseDinStats(){
        if(!isNocturnal){
            health /= DIN_BUFF;
            attack /= DIN_BUFF;
            defense /= DIN_BUFF;
        }
    }

    @Override
    public MUDItem[] getItems() {
        return items;
    }

    @Override
    public String toString(){
        return "Attack: " + attack + ", Defense: " + defense + ", Health: " + health;
    }

    public static void main(String[] args) {
        System.out.println(new NPC());
    }

    @Override
    public void updateTime(boolean isDay) {
        this.isDay = isDay;

        //System.out.println("Before: " + this + " Nocturnal: " + isNocturnal);

        if(this.isDay){
            increaseDinStats();
            decreaseNoctStats();
        }
        else{
            increaseNoctStats();
            decreaseDinStats();
        }

        //System.out.println("After: " + this);
    }
}
