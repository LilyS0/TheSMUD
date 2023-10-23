package smud.model.Item.Buffs;

import smud.model.Item.Consumable;

public abstract class Buff implements Consumable{
    /*
     * Represents a Buff Item that a player can consume to apply a stat buff
     */

    protected int buffAmount;
    protected String buffType;
    private static Buff[] children = {new Regen(),  new Resistance(), new Strength()};

    public int getStat(){
        return buffAmount;
    }

    public static Buff[] getChildren(){
        return children;
    }
    
}
