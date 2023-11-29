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
    public void applyItem(PlayerCharacter player) {
        player.addBuff(this);
    }

    @Override
    public void useBuff(PlayerCharacter player) {
        if(!activated){
            player.addAttack(buffAmount);
            activated = true;
        }
        useTurn();
        if(turns == 0){
            player.subtractAttack(buffAmount);
        }
    }
}
