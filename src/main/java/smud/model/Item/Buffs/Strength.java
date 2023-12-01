package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

public class Strength extends Buff{
    /*
     * Represents a strength buff
     * adds some value to the players attack stat
     */

    public Strength(){
        this.buffAmount = random.nextInt(5)+5;
        this.buffType = "Strenght";
        this.turns = 10;
        this.activated = false;
    }

    @Override
    public String toString(){
        return "Strength Buff (+" + buffAmount + ")";
    }

    @Override
    public void useBuff(PlayerCharacter player){
        player.addAttackBuff(buffAmount);
        useTurn();
    }

    @Override
    public void removeBuff(PlayerCharacter player) {
        player.subAttackBuff(buffAmount);
        player.removeBuff(this);
    }
}
