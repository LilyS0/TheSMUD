package model.Item.Weapons;

import model.Item.Equipable;

public abstract class Weapon implements Equipable {

    /*
     * Represents a Weapon Item that a player can equip to their weapon slot
     */

    protected int damage;

    public int getStat(){
        return damage;
    }
}
