package com.smud.api.smudapi.model.Cards.Obsticles;

import com.smud.api.smudapi.model.Cards.Card;
import com.smud.api.smudapi.model.Cards.NPCs.NPC;

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

    @Override
    public NPC getMonster(){
        throw new UnsupportedOperationException("No monster here");
    }

    public int getHealth() {
        return health;
    }

    public String getName(){
        return name;
    }
}
