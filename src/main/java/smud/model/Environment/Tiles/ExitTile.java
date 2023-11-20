package smud.model.Environment.Tiles;

import smud.model.MUDCharacter;
import smud.model.Environment.Room;

public class ExitTile extends TileFeature{
    private Room target;
    private int targetID;
    private int targetX;
    private int targetY;
    
    public ExitTile(int targetID, int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.targetID = targetID;
        this.description = "Exit Tile";
        this.symbol = 'X';
    }
    
    @Override
    public boolean occupy(MUDCharacter character){
        return false;
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
