package smud.model.Cards.Traps;

import smud.model.Cards.Card;
import smud.model.Cards.NPCs.NPC;

/*
 * <<concrete state>> in state pattern for card subsytem
 * represents a trap card that deals some effect to a player that steps on it
 */

public abstract class Trap implements Card{
    private String name;
    private int health;

    @Override
    public NPC getMonster(){
        throw new UnsupportedOperationException("No monster here");
    }

    @Override
    public void updateTime(boolean isDay){
        throw new UnsupportedOperationException("Can't update time on a trap");
    }

    public int getHealth() {
        return health;
    }

    public String getName(){
        return name;
    }
}
