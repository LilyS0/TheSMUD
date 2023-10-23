package smud.model.Item.Armor;

import smud.model.Item.Equipable;

public abstract class Armor implements Equipable{

    /*
     * Represents an Armor Item that a player can equip to their armor slot
     */

    protected int defense;
    private static Armor[] children = {new ChainMailArmor(), new IronArmor(), new LeatherArmor()};

    public int getStat(){
        return defense;
    }

    public static Armor[] getChildren(){
        return children;
    }
    
}
