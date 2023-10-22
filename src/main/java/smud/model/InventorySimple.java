package smud.model;
import java.util.ArrayList;
import java.util.List;

import smud.model.Item.MUDItem;

/**
 * Inventory uses the Composite Design Pattern to create a part-whole hierarchy of Items to be stored for use 
 * by the PlayerCharacter or NPC.
 * 
 * @author Sydney Wilson
 */
public class InventorySimple {

    private int bags = 1;
    private List<MUDItem> inventory = new ArrayList<>();
    
    public void add(MUDItem item) {
        if(inventory.size() < bags*6){
            inventory.add(item);
        }else{
            // too full
        }
        
    }

    public void remove(MUDItem item) {
        inventory.remove(item);
    }

    public void addBag(){
        if(this.bags < 6){
            this.bags++;
        }
    }
    // Item types vary (seen in Item branch), but all implement Item interface, Inventory also implements
    // Item interface, and manages an ArrayList
    // ex. inventory.add(new Item(*armor*))

}
