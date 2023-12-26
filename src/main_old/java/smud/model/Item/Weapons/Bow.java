package smud.model.Item.Weapons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Weapons.Bow", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Bow extends Weapon{
    /*
     * Represents a bow Weapon
     */

    @JsonProperty
    String name = "Bow";

    public Bow(){
        this.damage = 3;
        this.value = 15;
    }

    @Override
    public String toString(){
        return "Bow (attack: " + this.damage + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setWeapon(this);
    }
}
