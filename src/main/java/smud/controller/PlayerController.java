package smud.controller;

import java.util.ArrayList;

import smud.model.MUDException;
import smud.model.PlayerCharacter;
import smud.model.Environment.Room;
import smud.model.Environment.SMUDMap;
import smud.model.Environment.Tiles.TileFeature;

public class PlayerController {

    private PlayerCharacter character;
    private SMUDMap map;
    private Room currRoom;
    private int x;
    private int y;

    public PlayerController(PlayerCharacter character, SMUDMap map){
        this.character = character;
        this.map = map;
        this.currRoom = map.getStartRoom();
        this.x = 0;
        this.y = 0;
    }

    public void moveUp() throws MUDException{

        TileFeature target = currRoom.getTile(x, y-1);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            y--;
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void moveDown() throws MUDException{

        TileFeature target = currRoom.getTile(x, y+1);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            y++;
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void moveRight() throws MUDException{

        TileFeature target = currRoom.getTile(x+1, y);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            x++;
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void moveLeft() throws MUDException{

        TileFeature target = currRoom.getTile(x-1, y);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            x--;
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void makeMove(String dir) throws MUDException{
        if(dir.equals("w")){
            moveUp();
        }
        else if(dir.equals("s")){
            moveDown();
        }
        else if(dir.equals("a")){
            moveLeft();
        }
        else if(dir.equals("d")){
            moveRight();
        }
        else{
            throw new MUDException("Invalid move direction");
        }
    }

    public ArrayList<TileFeature> getAdjacentTiles(){

        ArrayList<TileFeature> tiles = new ArrayList<>();
        
        tiles.add(currRoom.getTile(x+1, y));
        tiles.add(currRoom.getTile(x-1, y));
        tiles.add(currRoom.getTile(x, y+1));
        tiles.add(currRoom.getTile(x, y-1));

        return tiles;
    }

    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public PlayerCharacter getCharacter(){
        return character;
    }

    public Room getCurrRoom(){
        return currRoom;
    }

    public void setCurrRoom(Room room){
        this.currRoom = room;
    }

    public SMUDMap getMap(){
        return map;
    }

}
