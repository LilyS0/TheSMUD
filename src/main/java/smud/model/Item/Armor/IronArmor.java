package smud.model.Item.Armor;

import smud.model.Character.PlayerCharacter;

public class IronArmor extends Armor{
    /* 
     * Represents iron Armor
     */

    public IronArmor(){
        this.defense = 5;
        this.value = 25;
    }
    
    @Override
    public String toString(){
        return "Iron Amror (defense: " + this.defense + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setArmor(this);
    }
}
