package smud.model.Item.Armor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Armor.ChainMailArmor", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class ChainMailArmor extends Armor{
    /*
     * Represents chain mail Armor
     */

    @JsonProperty
    String name = "ChainMailArmor";

    public ChainMailArmor(){
        this.defense = 3;
        this.value = 15;
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
