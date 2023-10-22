package smud.model;

import java.util.Random;

/**
 * PlayerCharacter implements the Character interface, and adds additionaly functionality
 * such as Weapon and Armor associated with character.
 * 
 * @author Sydney Wilson
 */
public class PlayerCharacter extends MUDCharacter {
    // INCORPORATE DEFAULT VALUES
// A player character (PC) is one that is controlled by a human user.
// Health: 100
// Attack: 10 
// Defense: 0
// The name and description are supplied by the user when the PC is created.
// A weapon slot into which one weapon can be equipped. If a weapon is already equipped, it is dropped.
// An armor slot into which one piece of armor can be equipped. If a piece of armor is already equipped, it is dropped.

// method graveyard: setHealth

    public PlayerCharacter(String name, String description, Inventory inventory) {
        this.setName(name);
        this.setDescription(description);
        Random rand = new Random();
        int minHealth = 50;
        int maxHealth = 150;
        this.health = rand.nextInt(maxHealth - minHealth + 1) + minHealth;
        this.setInventory(inventory);
    }
    // public static void main(String[] args) {
    //     Inventory inv = new Inventory();
    //     PlayerCharacter notAlex = new PlayerCharacter("Not Alex", "This is not NPC Alex", inv);
    //     System.out.println(notAlex.getName());
    //     System.out.println(notAlex.getHealth());
    // }
}
