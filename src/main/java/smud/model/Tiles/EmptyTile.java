package smud.model.Tiles;

import java.util.ArrayList;

import smud.model.MUDCharacter;
import smud.model.Item.MUDItem;

public class EmptyTile implements Tile{
    private boolean canEnter;
    private MUDCharacter occupant;
    private ArrayList<MUDItem> items;

    public EmptyTile(){
        this.canEnter = true;
        this.occupant = null;
        this.items = new ArrayList<>();
    }

    @Override
    public boolean occupy(MUDCharacter character) {
        if(canEnter && occupant == null){
            occupant = character;
            canEnter = false;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void storeItem(MUDItem item) {
        this.items.add(item);
    }
}
