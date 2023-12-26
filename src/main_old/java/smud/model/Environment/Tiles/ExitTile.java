package smud.model.Environment.Tiles;

import smud.controller.PlayerController;
import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Environment.map.MUDMap;
import smud.model.Environment.room.Room;

public class ExitTile extends Tile{
    private Room target;
    private int targetID;
    private int targetX;
    private int targetY;
    
    public ExitTile(int targetID, int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.targetID = targetID;
        this.description = "Exit Tile";
        this.defaultSymbol = 'X';
        this.symbol = defaultSymbol;
        this.canEnter = true;
    }

    public ExitTile(int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.targetID = 0;
        this.description = "Exit Tile";
        this.defaultSymbol = 'X';
        this.symbol = defaultSymbol;
        this.canEnter = true;
    }
    
    @Override
    public boolean occupy(MUDCharacter character){
        symbol = 'P';
        return true;
    }

    @Override
    public void interact(PlayerController player, MUDMap map){
        try {
            player.setCurrRoom(target, targetX, targetY, map);
        } catch (MUDException e) {
            System.out.println("Can't go there");
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

    public int getTargetX(){
        return targetX;
    }

    public void setTargetX(int x){
        targetX = x;
    }

    public int getTargetY(){
        return targetY;
    }

    public void setTargetY(int y){
        targetY = y;
    }
}
