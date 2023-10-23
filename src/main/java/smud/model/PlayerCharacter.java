package smud.model;

import smud.model.Environment.Tiles.Tile;
import smud.model.Item.Armor.Armor;
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
    // INCORPORATE DEFAULT VALUES
// A player character (PC) is one that is controlled by a human user.
// Health: 100
// Attack: 10 
// Defense: 0
// The name and description are supplied by the user when the PC is created.
// A weapon slot into which one weapon can be equipped. If a weapon is already equipped, it is dropped.
// An armor slot into which one piece of armor can be equipped. If a piece of armor is already equipped, it is dropped.

// method graveyard: setHealth, setAttack/setDefense (KEEP METHOD, delete instances => might need for use in conjunction with )
// eventually gonna have to part w inventory functions bc the prompt says so
    public PlayerCharacter(String name, String description, Inventory inventory, Tile[][] location) {
        this.setName(name);
        this.setDescription(description);
        this.health = 100;
        this.setInventory(inventory);
//        this.setLocation(location);
    }

    @Override
    public int getAttack() {
        return this.attack + this.weapon.getStat();
    }

    @Override
    public int getDefense() {
        return this.defense + this.armor.getStat();
    }
    
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        PlayerCharacter notAlex = new PlayerCharacter("Not Alex", "This is not NPC Alex", inv, null);
        System.out.println(notAlex.getName());
        System.out.println(notAlex.getHealth());
    }
}
