package smud.model.Item.Food;

import smud.model.Item.Consumable;

public abstract class Food implements Consumable{
    /*
     * Represents a Food Item that a player can consume to regain some health
     */

    protected int health;
    protected int value;
    private static Food[] children = {new Apple(), new Bread(), new Steak()};

    public int getStat(){
        return health;
    }

    public int getValue(){
        return value;
    }

    public static Food[] getChildren(){
        return children;
    }
}
