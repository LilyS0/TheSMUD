package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

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

    @Override
    public void applyItem(PlayerCharacter player) {
        player.addBuff(this);
    }
}
