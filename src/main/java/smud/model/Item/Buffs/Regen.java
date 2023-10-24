package smud.model.Item.Buffs;

public class Regen extends Buff{
    /*
     * Represents health regen Buff
     * Gives the player health back overtime
     */

    public Regen(){
        this.buffAmount = 5;
        this.buffType = "Regen";
        this.turns = random.nextInt(5)+1;
    }
    
}
