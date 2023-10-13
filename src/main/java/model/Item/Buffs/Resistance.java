package model.Item.Buffs;

public class Resistance extends Buff{
    /*
     * Represents a resistance buff
     * adds some value to the players defense stat
     */

    public Resistance(){
        this.buffAmount = 5;
        this.buffType = "Resistance";
    }
}
