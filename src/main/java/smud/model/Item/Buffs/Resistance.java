package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

public class Resistance extends Buff{
    /*
     * Represents a resistance buff
     * adds some value to the players defense stat
     */


    public Resistance(){
        this.buffAmount = random.nextInt(5)+10;
        this.value = buffAmount * 5;
        this.buffType = "Resistance";
        this.turns = 10;
    }

    @Override
    public String toString(){
        return "Resistance Buff (+" + buffAmount + ")";
    }

    @Override
    public void useBuff(PlayerCharacter player) {
        player.addDefenseBuff(buffAmount);
        useTurn();
    }

    @Override
    public void removeBuff(PlayerCharacter player) {
        player.subDefenseBuff(buffAmount);
        player.removeBuff(this);
    }
}
