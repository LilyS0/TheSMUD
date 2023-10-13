package model;

public abstract class Armor implements Equipable{

    /*
     * Represents an Armor Item that a player can equip to their armor slot
     */

    private int defense;

    public int getStat(){
        return defense;
    }
    
}
