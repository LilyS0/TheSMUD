package model.Item.Buffs;

import model.Item.Consumable;

public abstract class Buff implements Consumable{
    /*
     * Represents a Buff Item that a player can consume to apply a stat buff
     */

    protected int buffAmount;
    protected String buffType;

    public int getStat(){
        return buffAmount;
    }
    
}
