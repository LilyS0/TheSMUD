package model.Item.Buffs;

public class Regen extends Buff{
    /*
     * Represents health regen Buff
     * Gives the player health back overtime
     */

    public Regen(){
        this.buffAmount = 5;
        this.buffType = "Regen";
    }
    
}
