package smud.model.Backpacks;

import smud.model.Items.Item;

/*
 * a large backpack that holds 50 items
 */

public class LargeBackpack extends Backpack{

    public LargeBackpack(){
        this.size = 50;
        this.items = new Item[this.size];
    }
}
