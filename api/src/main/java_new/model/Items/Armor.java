package smud.model.Items;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents armor that the player an equip to add on to their defense stat
 */

public abstract class Armor implements Item{
    private int defense;
    private String name;

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }
}
