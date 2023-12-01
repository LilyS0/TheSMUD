package smud.model.Item.Buffs;

import java.util.Random;

import smud.model.Character.PlayerCharacter;
import smud.model.Item.Consumable;

public abstract class Buff implements Consumable{
    /*
     * Represents a Buff Item that a player can consume to apply a stat buff
     */

    protected int buffAmount;
    protected String buffType;
    protected int turns;
    protected boolean isActive;
    protected boolean activated;
    protected static final Random random = new Random();
    private static Buff[] children = {new Regen(),  new Resistance(), new Strength()};

    public abstract void useBuff(PlayerCharacter player);

    public abstract void removeBuff(PlayerCharacter player);

    public int getStat(){
        return buffAmount;
    }

    public int getTurns(){
        return turns;
    }

    public boolean isActive(){
        return isActive;
    }

    public void useTurn(){
        if(turns > 0){
            turns --;
        } 
        else{
            isActive = false;
        }
    }

    public static Buff[] getChildren(){
        return children;
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.addBuff(this);
        // System.out.println("Added " + this + " to buffs");
        // System.out.println(player.getActiveBuffs());
    }
    
}
