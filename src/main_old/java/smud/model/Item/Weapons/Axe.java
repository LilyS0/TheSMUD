package smud.model.Item.Weapons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Weapons.Axe", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Axe extends Weapon{
    /*
     * Represents an axe Weapon 
     */

    @JsonProperty
    String name = "Axe";

    public Axe(){
        this.damage = 7;
        this.value = 35;
    }

    @Override
    public String toString(){
        return "Axe (attack: " + this.damage + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setWeapon(this);
    }
}
