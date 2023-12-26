package smud.model.Cards;

/*
 * <<concrete state>> in state pattern for card subsytem
 * represents an obsticle card that blocks a player from moving to the tile that it is on
 */

public abstract class Obsticle implements Card{
    private String name;
    private int health;

    @Override
    public void updateTime(boolean isDay){
        throw new UnsupportedOperationException("Can't update time on an obsticle");
    }

    public int getHealth() {
        return health;
    }

    public String getName(){
        return name;
    }
}
