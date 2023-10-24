package smud.model.Environment.Tiles;

import smud.model.MUDCharacter;
import smud.model.Environment.Room;

public class ExitTile extends TileFeature{
    private Room target;
    private int targetID;
    
    public ExitTile(int targetID){
        this.targetID = targetID;
        this.description = "Exit Tile";
        this.symbol = 'X';
    }
    
    @Override
    public boolean occupy(MUDCharacter character){
        if(tile.occupy(character)){
            //set character's location to target room's start location
            return true;
        }else{
            return false;
        }
    }

    public int getTargetID(){
        return targetID;
    }

    public void addTarget(Room target){
        this.target = target;
    }

    public Room getTarget(){
        return target;
    }
}
