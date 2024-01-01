package smud.model.Items;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents food that the player can consume to give back health
 */

public abstract class Food implements Item{
    private String name;
    private int health;

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
}
