package smud.model.Environment;
/**
 * A Map consists of many Rooms, each with varying attributes. A Room is then made of Tiles.
 * 
 * @author Sydney Wilson
 * @author Lily Susman
 */

import java.util.HashSet;
import java.util.Set;

import smud.model.Environment.Tiles.TileFeature;

public class Room {
    // *structure of this V E R Y subject to change, for now a 2D 
    // array seems like a sort of decent solution similar to how you would create ex. a checkerboard
    // for a game of checkers, but there is probably a much more optimal solution i have forgotten*

    // public Tile[][] tiles;
    
    // width and height in terms of Tiles would then be the size of the array

    // Exit is not currently a type of Tile in our ConsensusDomainModel, but i think it 
    // would be optimal to do so (will further discuss in meeting)

    // definitely use 2D array for Room

    private TileFeature[][] tiles;
    private int height;
    private int width;
    private int id;
    private Set<Room> exits;
    private String description;
    private String display;
    private boolean isEndRoom;

    public Room(TileFeature[][] tiles, int id, boolean isEndRoom){

        this.id = id;
        this.tiles = tiles;
        this.isEndRoom = isEndRoom;
        this.width = tiles[0].length;
        this.height = tiles.length;
        this.exits = new HashSet<>();
        this.description = "A room with: \n";
        this.display = "";

        for(TileFeature[] row: tiles){
            for(TileFeature tile: row){
                //this.description += "  " + tile.getDescription() + "\n";
                this.display += "[" + tile.getSymbol() + "] ";
            }
            this.display += "\n";
        }

    }

    public boolean isEndRoom(){
        return isEndRoom;
    }

    public TileFeature getTile(int x, int y){
        return tiles[y][x];
    }

    public void addExit(Room room){
        exits.add(room);
    }

    public boolean isConnected(Room room){
        return exits.contains(room);
    }

    public Set<Room> getExits(){
        return exits;
    }

    public String getDescription(){
        return description;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return display;
    }

    @Override
    public int hashCode(){
        return tiles.hashCode() + description.hashCode();
    }
   
}
