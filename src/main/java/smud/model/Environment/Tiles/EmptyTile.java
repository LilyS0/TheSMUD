package smud.model.Environment.Tiles;

import java.util.ArrayList;

import smud.model.MUDCharacter;
import smud.model.Item.MUDItem;

public class EmptyTile extends TileFeature{
    private boolean canEnter;
    private MUDCharacter occupant;
    private ArrayList<MUDItem> items;

    public EmptyTile(){
        this.canEnter = true;
        this.occupant = null;
        this.items = new ArrayList<>();
        this.symbol = ' ';
        this.description = "Empty Tile";
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
