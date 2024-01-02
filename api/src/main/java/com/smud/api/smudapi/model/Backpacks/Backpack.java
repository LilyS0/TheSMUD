package com.smud.api.smudapi.model.Backpacks;

import com.smud.api.smudapi.model.Items.Item;

/*
 * represents a backpack that the player holds to store items
 */

public abstract class Backpack {

    protected int size;
    protected Item[] items;

    public int getSize() {
        return size;
    }
    public Item[] getItems() {
        return items;
    } 
}
