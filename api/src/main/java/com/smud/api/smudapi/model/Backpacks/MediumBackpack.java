package com.smud.api.smudapi.model.Backpacks;

import com.smud.api.smudapi.model.Items.Item;

/*
 * a medium backpack that can hold 30 items
 */

public class MediumBackpack extends Backpack{
    
    public MediumBackpack(){
        this.size = 30;
        this.items = new Item[this.size];
    }
}
