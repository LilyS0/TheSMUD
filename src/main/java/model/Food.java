package model;

public abstract class Food implements Consumable{
    /*
     * Represents a Food Item that a player can consume to regain some health
     */

    private int health;

    public int getStat(){
        return health;
    }
}
