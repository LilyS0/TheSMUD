package smud.model.Item.Armor;

import smud.model.Character.PlayerCharacter;

public class LeatherArmor extends Armor{
    /*
     * Represents leather Armor 
     */
    
    public LeatherArmor(){
        this.defense = 1;
        this.value = 5;
    }

    @Override
    public String toString(){
        return "Leather Amror (defense: " + this.defense + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setArmor(this);
    }
}
