package smud.model.Item.Armor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Armor.IronArmor", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class IronArmor extends Armor{
    /* 
     * Represents iron Armor
     */

    @JsonProperty
    String name = "IronArmor";

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
