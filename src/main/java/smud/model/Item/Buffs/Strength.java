package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

public class Strength extends Buff{
    /*
     * Represents a strength buff
     * adds some value to the players attack stat
     */

    public Strength(){
        this.buffAmount = 5;
        this.buffType = "Strenght";
        this.turns = random.nextInt(5)+1;
    }

    @Override
    public String toString(){
        return "Strength Buff";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.addBuff(this);
    }
}
