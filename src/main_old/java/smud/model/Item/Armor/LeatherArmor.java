package smud.model.Item.Armor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Armor.LeatherArmor", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class LeatherArmor extends Armor{
    /*
     * Represents leather Armor 
     */
    
    @JsonProperty
    String name = "LeatherArmor";

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
