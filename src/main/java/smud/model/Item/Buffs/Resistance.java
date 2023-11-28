package smud.model.Item.Buffs;

import smud.controller.PlayerController;
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
    public void applyItem(PlayerCharacter player) {
        player.addBuff(this);
    }

    @Override
    public void useBuff(PlayerController player) {
        if(!activated){    
            player.getCharacter().addDefense(buffAmount);
            activated = true;
        }
        useTurn();
        if(turns == 0){
            player.getCharacter().subtractDefense(buffAmount);
        }
    }
}
