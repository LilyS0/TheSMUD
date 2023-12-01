package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

public class Regen extends Buff{
    /*
     * Represents health regen Buff
     * Gives the player health back overtime
     */

    public Regen(){
        this.buffAmount = random.nextInt(10)+1;
        this.buffType = "Regen";
        this.turns = 10;
    }

    @Override
    public String toString(){
        return "Regen Buff (+" + buffAmount + ")";
    }

    @Override
    public void useBuff(PlayerCharacter player){
        player.addHealthBuff(buffAmount);
        useTurn();
    }

    @Override
    public void removeBuff(PlayerCharacter player) {
        player.subHealthBuff(buffAmount);
        player.removeBuff(this);
    }
}
