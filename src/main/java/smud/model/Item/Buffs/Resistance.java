package smud.model.Item.Buffs;

public class Resistance extends Buff{
    /*
     * Represents a resistance buff
     * adds some value to the players defense stat
     */

    public Resistance(){
        this.buffAmount = 5;
        this.buffType = "Resistance";
        this.turns = random.nextInt(5)+1;
    }

    @Override
    public String toString(){
        return "Resistance Buff";
    }
}
