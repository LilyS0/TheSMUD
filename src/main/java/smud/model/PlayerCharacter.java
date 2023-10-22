package smud.model;

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
    private Inventory inventory;

    @Override
    public int getAttack() {
        return this.attack + this.weapon.getStat();
    }

    @Override
    public int getDefense() {
        return this.defense + this.armor.getStat();
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    // move() 
}
