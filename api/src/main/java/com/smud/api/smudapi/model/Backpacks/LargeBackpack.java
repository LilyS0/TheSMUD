package com.smud.api.smudapi.model.Backpacks;

import com.smud.api.smudapi.model.Items.Item;

/*
 * a large backpack that holds 50 items
 */

public class LargeBackpack extends Backpack{

    public LargeBackpack(){
        this.size = 50;
        this.items = new Item[this.size];
    }
}
