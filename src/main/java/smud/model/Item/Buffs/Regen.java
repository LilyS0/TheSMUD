package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

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

    @Override
    public String toString(){
        return "Regen Buff";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.addBuff(this);
    }


    
}
