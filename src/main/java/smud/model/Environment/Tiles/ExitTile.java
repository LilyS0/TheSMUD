package smud.model.Environment.Tiles;

import smud.model.MUDCharacter;
import smud.model.Environment.Room;

public class ExitTile extends TileFeature{
    private Room target;
    
    public ExitTile(Room target){
        this.target = target;
        this.description = "Exit Tile";
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

    public Room getTarget(){
        return target;
    }
}
