package smud.model.Environment.Tiles;

import java.util.ArrayList;

import smud.model.MUDCharacter;
import smud.model.PlayerCharacter;
import smud.model.Item.MUDItem;

public class EmptyTile extends TileFeature implements Tile{
    private boolean canEnter;
    private MUDCharacter occupant;
    private ArrayList<MUDItem> items;

    public EmptyTile(int x, int y){
        this.xCor = x;
        this.yCor = y;
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
            //System.out.println("wow");
            if(occupant instanceof PlayerCharacter){
                this.symbol = 'P';
            }
            //System.out.println(symbol);
            return true;
        }else{
            return false;
        }
    }

    public MUDCharacter getOccupant() {
        return occupant;
    }

    public void clearOccupant(){
        occupant = null;
        symbol = ' ';
        canEnter = true;
    }

    @Override
    public void storeItem(MUDItem item) {
        this.items.add(item);
    }
}
