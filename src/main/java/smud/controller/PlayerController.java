package smud.controller;

import smud.model.MUDException;
import smud.model.Character.PlayerCharacter;
import smud.model.Environment.Room;
import smud.model.Environment.MUDMap;
import smud.model.Environment.Tiles.TileFeature;

public class PlayerController {

    private PlayerCharacter character;
    private MUDMap map;
    private Room currRoom;
    private int x;
    private int y;

    public PlayerController(PlayerCharacter character, MUDMap map){
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
            target.interact(this);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this);
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
            target.interact(this);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this);
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
            target.interact(this);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this);
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
            target.interact(this);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this);
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

    public TileFeature[] getAdjacentTiles(){

        TileFeature[] tiles = new TileFeature[4];
        
        tiles[0] = currRoom.getTile(x+1, y);
        tiles[1] = currRoom.getTile(x-1, y);
        tiles[2] = currRoom.getTile(x, y+1);
        tiles[3] = currRoom.getTile(x, y-1);

        return tiles;
    }

    public int getX(){
        return x;
    }

    public void setX(int newX) throws MUDException{
        TileFeature target = currRoom.getTile(newX, y);
        if(target != null && target.occupy(character)){
            x = newX;
        }
        else{
            throw new MUDException("Can't move there");
        } 
    }
    
    public int getY(){
        return y;
    }

    public void setY(int newY) throws MUDException{
        TileFeature target = currRoom.getTile(x, newY);
        if(target != null && target.occupy(character)){
            y = newY;
        }
        else{
            throw new MUDException("Can't move there");
        }
        
    }

    public PlayerCharacter getCharacter(){
        return character;
    }

    public Room getCurrRoom(){
        return currRoom;
    }

    public void setCurrRoom(Room room, int newX, int newY) throws MUDException{
        this.currRoom = room;
        setX(newX);
        setY(newY);
    }

    public MUDMap getMap(){
        return map;
    }

}
