package smud.model.Item.Weapons;

import smud.model.Item.Equipable;

public abstract class Weapon implements Equipable {

    /*
     * Represents a Weapon Item that a player can equip to their weapon slot
     */

    protected int damage;
    protected int value;
    private static Weapon[] children = {new Axe(), new Bow(), new Sword()};

    public int getStat(){
        return damage;
    }

    public int getValue(){
        return value;
    }
    
    public static Weapon[] getChildren(){
        return children;
    }
}
