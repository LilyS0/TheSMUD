package smud.model.Cards;

/*
 * <<concrete state>> in state pattern for card subsytem
 * represents a trap card that deals some effect to a player that steps on it
 */

public abstract class Trap implements Card{
    private String name;
    private int health;

    public int getHealth() {
        return health;
    }

    public String getName(){
        return name;
    }
}
