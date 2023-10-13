package model.Item.Food;

import model.Item.Consumable;

public abstract class Food implements Consumable{
    /*
     * Represents a Food Item that a player can consume to regain some health
     */

    protected int health;

    public int getStat(){
        return health;
    }
}
