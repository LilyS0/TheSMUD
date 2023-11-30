package smud.model.Item.Buffs;

import smud.model.Character.PlayerCharacter;

public class Resistance extends Buff{
    /*
     * Represents a resistance buff
     * adds some value to the players defense stat
     */


    public Resistance(){
        this.buffAmount = random.nextInt(5)+10;
        this.buffType = "Resistance";
        this.turns = 10;
        this.activated = false;
    }

    @Override
    public String toString(){
        return "Resistance Buff (+" + buffAmount + ")";
    }

    @Override
    public void useBuff(PlayerCharacter player) {
        if(!activated){    
            player.addDefense(buffAmount);
            activated = true;
        }
        useTurn();
        if(turns == 0){
            player.subtractDefense(buffAmount);
            player.removeBuff(this);
        }
    }
}
