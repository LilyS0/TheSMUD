package smud.model.Item.Food;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Food.Steak", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Steak extends Food{
    /*
     * Represents a steak Food Item
     */

    @JsonProperty
    String name = "Steak";

    public Steak(){
        this.health = 5;
        this.value = 25;
    }

    @Override
    public String toString(){
        return "Steak";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.eatFood(this);
    }

}
