package model;

public abstract class Buff implements Consumable{
    /*
     * Represents a Buff Item that a player can consume to apply a stat buff
     */

    private int buffAmount;
    private String buffType;

    public int getStat(){
        return buffAmount;
    }
    
}
