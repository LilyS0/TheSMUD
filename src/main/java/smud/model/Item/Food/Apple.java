package smud.model.Item.Food;

import smud.model.Character.PlayerCharacter;

public class Apple extends Food{
    /*
     * Represents an apple Food Item 
     */

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
