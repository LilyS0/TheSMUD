package smud.model.Environment.room;
/**
 * A Map consists of many Rooms, each with varying attributes. A Room is then made of Tiles.
 * 
 * @author Sydney Wilson
 * @author Lily Susman
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import smud.model.MUDException;
import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.Tile;

public class PremadeRoom extends Room{
    // *structure of this V E R Y subject to change, for now a 2D 
    // array seems like a sort of decent solution similar to how you would create ex. a checkerboard
    // for a game of checkers, but there is probably a much more optimal solution i have forgotten*

    // public Tile[][] tiles;
    
    // width and height in terms of Tiles would then be the size of the array

    // Exit is not currently a type of Tile in our ConsensusDomainModel, but i think it 
    // would be optimal to do so (will further discuss in meeting)

    // definitely use 2D array for Room

    private Set<Room> exits;
    private boolean isEndRoom;

    public PremadeRoom(Tile[][] tiles, int id, boolean isEndRoom){

        this.id = id;
        this.tiles = tiles;
        this.isEndRoom = isEndRoom;
        this.width = tiles[0].length;
        this.height = tiles.length;
        this.exits = new HashSet<>();
        this.description = "a room with: \n";
    }

    public boolean isEndRoom(){
        return isEndRoom;
    }

    public static Room createRoom(ArrayList<ArrayList<String>> roomList, int id, Map<Integer, ExitTile> exits, Map<Integer, Room> rooms){

        int width = roomList.get(0).size();
        int height = roomList.size();

        Tile[][] tiles = new Tile[height][width];
        

        for(int i=0; i<height; i++){
            Tile[] row = new Tile[width];
            for(int k=0; k<width; k++){
                try {
                    Tile tile = Tile.createTile(roomList.get(i).get(k), rooms, k, i);
                    row[k] = tile;
                    if(tile instanceof ExitTile){
                        ExitTile exit = (ExitTile)tile;
                        exits.put(exit.getTargetID(), exit);
                    }
                } catch (MUDException e) {
                    row[k] = new EmptyTile(k, i);
                    System.out.println("Unable to create tile at x:" + k + "y:" + i  + ": \n  " + e);
                }
            }
            tiles[i] = row;
        }

        return new PremadeRoom(tiles, id, false);
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
}
