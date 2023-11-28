package smud.model.Item.Food;

import smud.model.Character.PlayerCharacter;

public class Bread extends Food{
    /*
     * Represents a bread Food Item
     */

    public Bread(){
        this.health = 3;
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
