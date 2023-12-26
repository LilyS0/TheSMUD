package smud.model.Items;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents a tool that a player can use to break obsticles and traps
 */

public abstract class Tool implements Item{
    private int strength;
    private String name;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}
