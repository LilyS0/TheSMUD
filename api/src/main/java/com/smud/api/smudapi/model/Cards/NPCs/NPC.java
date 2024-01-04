package com.smud.api.smudapi.model.Cards.NPCs;


import com.smud.api.smudapi.model.Cards.Card;
import com.smud.api.smudapi.model.Items.Item;

/*
 * <<concrete state>> in state pattern for card subsytem
 * represents an NPC that a player and fight or interact with
 */
 
public abstract class NPC implements Card{
    protected String name;
    protected Item[] items;
    protected boolean isDay;

    @Override
    public void updateTime(boolean isDay){
        this.isDay = isDay;
    }

    @Override
    public NPC getMonster(){
        return this;
    }

    @Override
    public boolean canOccupy(){
        return false;
    }

    //getters

    public boolean isDay() {
        return isDay;
    }

    public Item[] getItems() {
        return items;
    }

    public String getName(){
        return name;
    }
}
