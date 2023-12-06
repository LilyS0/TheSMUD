package smud.model.Character;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import smud.model.Item.MUDItem;

/**
 * Inventory uses the Composite Design Pattern to create a part-whole hierarchy of Items to be stored for use 
 * by the PlayerCharacter or NPC.
 * 
 * @author Sydney Wilson
 */
public class Inventory {

    @JsonProperty("ratio")
    private String ratio;

    @JsonProperty("inventorySize")
    private int inventorySize;

    private List<MUDItem> inventory;
    private final int INVENTORY_CAPACITY = 40;

    // constructor, for constructing
    // not sure if there needs to be anything (items) passed in, since they start out w an empty inventory i believe
    public Inventory() {
        this.inventory = new ArrayList<>();
        this.ratio = "";
    }

    // am i reinventing the gosh dang wheel yes no
    public int getInventorySize() {
        inventorySize = inventory.size();
        return inventorySize;
    }

    // checks if the inventory has 1) enough items (=) or 2 too many items (>, shouldn't happen though idk)
    private boolean checkAtCapacity() {
        return getInventorySize() >= INVENTORY_CAPACITY;
    }

    

    public List<MUDItem> getInventory() {
        return this.inventory;
    }

    public void addItem(MUDItem item) {
        // if the inventory is not at capacity, add the item
        if (!checkAtCapacity()){ // there is something funky going on here idk what, will investigate
            inventory.add(item);
        }
        // otherwise, don't
    }

    // ex. inventory.add(new Item(*armor*))
    public void removeItem(MUDItem item) {
        inventory.remove(item);
    }

    // getRatioed (needs a better name guys sorry)
    // meets the requirement that the user can see how many items they have/max capacity
    public String getRatio() {
        int totalItems = inventory.size();
        ratio = totalItems + " / " + INVENTORY_CAPACITY;

        return ratio;
    }

    @Override
    public String toString(){
        String result = "";

        for(int i=0; i<inventory.size(); i++){
            result += "[" + (i+1) + "]" + inventory.get(i) + ", ";
        }

        return result;
    }
}
