package smud.controller;

import smud.model.MUDException;
import smud.model.Character.PlayerCharacter;
import smud.model.Environment.Tiles.TileFeature;
import smud.model.Environment.map.MUDMap;
import smud.model.Environment.room.Room;
import smud.model.Item.MUDItem;

public class PlayerController {

    private PlayerCharacter character;
    //private MUDMap map;
    private int currRoomID;
    private int x;
    private int y;

    public PlayerController(){
        
    }

    public PlayerController(PlayerCharacter character, MUDMap map){
        this.character = character;
        //this.map = map;
        this.currRoomID = map.getStartRoom().getID();
        this.x = 0;
        this.y = 0;
    }

    public void moveUp(MUDMap map) throws MUDException{

        Room currRoom = getCurrRoom(map);

        TileFeature target = currRoom.getTile(x, y-1);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            y--;
            target.interact(this, map);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this, map);
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void moveDown(MUDMap map) throws MUDException{

       Room currRoom = getCurrRoom(map);

        TileFeature target = currRoom.getTile(x, y+1);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            y++;
            target.interact(this, map);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this, map);
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void moveRight(MUDMap map) throws MUDException{

        Room currRoom = getCurrRoom(map);

        TileFeature target = currRoom.getTile(x+1, y);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            x++;
            target.interact(this, map);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this, map);
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void moveLeft(MUDMap map) throws MUDException{

        Room currRoom = getCurrRoom(map);

        TileFeature target = currRoom.getTile(x-1, y);
        if(target != null && target.occupy(character)){
            currRoom.getTile(x, y).clearOccupant();
            x--;
            target.interact(this, map);
        }
        else if(target != null && !target.occupy(character)){
            target.interact(this, map);
        }
        else{
            throw new MUDException("Can't move there");
        }

    }

    public void makeMove(String dir, MUDMap map) throws MUDException{
        if(dir.equals("w")){
            moveUp(map);
        }
        else if(dir.equals("s")){
            moveDown(map);
        }
        else if(dir.equals("a")){
            moveLeft(map);
        }
        else if(dir.equals("d")){
            moveRight(map);
        }
        else{
            throw new MUDException("Invalid move direction");
        }
    }

    public TileFeature[] getAdjacentTiles(MUDMap map){

        TileFeature[] tiles = new TileFeature[4];
        Room currRoom = map.getRoom(currRoomID);
        
        tiles[0] = currRoom.getTile(x+1, y);
        tiles[1] = currRoom.getTile(x-1, y);
        tiles[2] = currRoom.getTile(x, y+1);
        tiles[3] = currRoom.getTile(x, y-1);

        return tiles;
    }

    public int getX(){
        return x;
    }

    public void setX(int newX, MUDMap map) throws MUDException{

        Room currRoom = getCurrRoom(map);
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

    public void setY(int newY, MUDMap map) throws MUDException{

        Room currRoom = getCurrRoom(map);
        TileFeature target = currRoom.getTile(x, newY);

        if(target != null && target.occupy(character)){
            y = newY;
        }
        else{
            throw new MUDException("Can't move there");
        }
        
    }

    public void applyItem(int index){

        MUDItem item;

        try {
            item = character.getInventory().getInventory().remove(index-1);
        } catch (Exception e) {
            System.out.println("Invalid location");
            item = null;
        }
        System.out.println("Item: " + item);

        item.applyItem(character);
    }

    public void useBuffs(){
        character.useBuffs();
    }

    public PlayerCharacter getCharacter(){
        return character;
    }

    public Room getCurrRoom(MUDMap map){
        return map.getRooms().get(currRoomID);
    }

    public void setCurrRoom(Room room, int newX, int newY, MUDMap map) throws MUDException{
        this.currRoomID = room.getID();
        // setX(newX);
        // setY(newY);
        this.x = newX;
        this.y = newY;
        System.out.println("Now in room " + currRoomID);
    }
}
