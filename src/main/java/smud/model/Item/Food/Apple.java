package smud.model.Item.Food;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Food.Apple", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Apple extends Food{
    /*
     * Represents an apple Food Item 
     */

    @JsonProperty
    String name = "Apple";

    public Apple(){
        this.health = 1;
        this.value = 5;
    }

    @Override
    public String toString(){
        return "Apple";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.eatFood(this);
    }

}
