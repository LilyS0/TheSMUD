package com.smud.api.smudapi.model.Backpacks;

import com.smud.api.smudapi.model.Items.Item;

/*
 * a small backpack that can hold 15 items
 */

public class SmallBackpack extends Backpack{

    public SmallBackpack(){
        this.size = 15;
        this.items = new Item[this.size];
    }
}
