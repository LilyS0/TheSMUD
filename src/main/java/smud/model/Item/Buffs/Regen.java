package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

public class Regen extends Buff{
    /*
     * Represents health regen Buff
     * Gives the player health back overtime
     */

    public Regen(){
        this.buffAmount = random.nextInt(3)+1;
        this.value = buffAmount * 5;
        this.buffType = "Regen";
        this.turns = 10;
    }

    @Override
    public String toString(){
        return "Regen Buff (+" + buffAmount + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.addBuff(this);
    }

    @Override
    public void useBuff(PlayerCharacter player){
        player.addHealth(buffAmount);
        useTurn();
    }


    
}
