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
public class Inventory implements MUDItem {
    public List<MUDItem> inventory = new ArrayList<>();
    public void add(MUDItem item) {
        inventory.add(item);
    }

    public void remove(MUDItem item) {
        inventory.remove(item);
    }
    // Item types vary (seen in Item branch), but all implement Item interface, Inventory also implements
    // Item interface, and manages an ArrayList
    // ex. inventory.add(new Item(*armor*))

    @Override
    public int getStat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStat'");
    }
}
