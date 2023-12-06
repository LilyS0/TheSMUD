package smud.model.Item.Food;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Food.Bread", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Bread extends Food{
    /*
     * Represents a bread Food Item
     */

    @JsonProperty
    String name = "Bread";

    public Bread(){
        this.health = 3;
        this.value = 15;
    }

    @Override
    public String toString(){
        return "Bread";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.eatFood(this);
    }

}
