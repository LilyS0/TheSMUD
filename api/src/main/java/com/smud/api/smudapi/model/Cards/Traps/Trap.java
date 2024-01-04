package com.smud.api.smudapi.model.Cards.Traps;

import com.smud.api.smudapi.model.Cards.Card;
import com.smud.api.smudapi.model.Cards.NPCs.NPC;

/*
 * <<concrete state>> in state pattern for card subsytem
 * represents a trap card that deals some effect to a player that steps on it
 */

public abstract class Trap implements Card{
    protected String name;
    protected int health;

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
