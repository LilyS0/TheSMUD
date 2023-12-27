package smud.model.Item.Weapons;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Weapons.Sword", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Sword extends Weapon{
    /*
     * Represents a sword Weapon
     */

    @JsonProperty
    String name = "Sword";

    public Sword(){
        this.damage = 5;
        this.value = 25;
    }

    @Override
    public String toString(){
        return "Sword (attack: " + this.damage + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setWeapon(this);
    }
}


