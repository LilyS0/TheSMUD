package smud.model.Item.Food;

import smud.model.Character.PlayerCharacter;

public class Steak extends Food{
    /*
     * Represents a steak Food Item
     */

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
