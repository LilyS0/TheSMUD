package smud.model.Items.Weapons;

/*
 * <<concrete state>> in state pattern for item subsystem
 * represents a weapon that a player can equip to add to their attack stat
 */

public abstract class Weapon implements Item{
    private int attack;
    private String name;

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
}
