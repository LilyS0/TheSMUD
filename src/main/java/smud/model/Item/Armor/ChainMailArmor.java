package smud.model.Item.Armor;

import smud.model.Character.PlayerCharacter;

public class ChainMailArmor extends Armor{
    /*
     * Represents chain mail Armor
     */

    public ChainMailArmor(){
        this.defense = 3;
    }

    @Override
    public String toString(){
        return "Chain Mail Amror (defense: " + this.defense + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setArmor(this);
    }
}
