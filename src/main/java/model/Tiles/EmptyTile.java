package model.Tiles;

import java.util.ArrayList;

import model.MUDCharacter;
import model.Item.MUDItem;

public class EmptyTile implements Tile{
    public boolean canEnter;
    public MUDCharacter occupant;
    public ArrayList<MUDItem> items;

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
}
