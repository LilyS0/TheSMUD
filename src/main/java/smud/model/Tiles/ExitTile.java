package smud.model.Tiles;

import smud.model.MUDCharacter;
import smud.model.Room;

public class ExitTile extends TileFeature{
    private Room target;
    
    public ExitTile(Room target){
        this.target = target;
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
}
