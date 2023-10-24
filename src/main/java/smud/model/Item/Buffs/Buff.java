package smud.model.Item.Buffs;

import java.util.Random;

import smud.model.MUDException;
import smud.model.Item.Consumable;

public abstract class Buff implements Consumable{
    /*
     * Represents a Buff Item that a player can consume to apply a stat buff
     */

    protected int buffAmount;
    protected String buffType;
    protected int turns;
    protected static final Random random = new Random();
    private static Buff[] children = {new Regen(),  new Resistance(), new Strength()};

    public int getStat(){
        return buffAmount;
    }

    public int getTurns(){
        return turns;
    }

    public void useTurn() throws MUDException{
        if(turns > 0){
            turns --;
        } else {
            throw new MUDException("Out of turns");
        }
    }

    public static Buff[] getChildren(){
        return children;
    }
    
}
