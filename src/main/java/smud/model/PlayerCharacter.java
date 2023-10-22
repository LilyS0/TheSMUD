package smud.model;

/**
 * PlayerCharacter implements the Character interface, and adds additionaly functionality
 * such as Weapon and Armor associated with character.
 * 
 * @author Sydney Wilson
 */
public class PlayerCharacter extends MUDCharacter {
    // INCORPORATE DEFAULT VALUES
    public PlayerCharacter(String name, String description, int health, Inventory inventory) {
        this.setName(name);
        this.setDescription(description);
        this.setHealth(health);
        this.setInventory(inventory);
    }
}
