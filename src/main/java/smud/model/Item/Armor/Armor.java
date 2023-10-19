package smud.model.Item.Armor;

import smud.model.Item.Equipable;

public abstract class Armor implements Equipable{

    /*
     * Represents an Armor Item that a player can equip to their armor slot
     */

    protected int defense;

    public int getStat(){
        return defense;
    }
    
}
