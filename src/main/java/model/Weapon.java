package model;

public abstract class Weapon implements Equipable {

    /*
     * Represents a Weapon Item that a player can equip to their weapon slot
     */

    private int damage;

    public int getStat(){
        return damage;
    }
}
