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
import smud.model.Character.MUDCharacter;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.TileFeature;

public class PremadeRoom implements Room{
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
    private boolean isEndRoom;

    public PremadeRoom(TileFeature[][] tiles, int id, boolean isEndRoom){

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

    @Override
    public TileFeature getTile(int x, int y){
        try{
            return tiles[y][x];
        }  
        catch (Exception e) {
            return null;
        }
        
    }

    public ArrayList<MUDCharacter> getEnemies(){

        ArrayList<MUDCharacter> enemies = new ArrayList<>();

        for(TileFeature[] row: tiles){
            for(TileFeature tile: row){
                if(tile instanceof CharacterTile){
                    CharacterTile ct = (CharacterTile)tile;
                    if(ct.getCharacter().isAlive()){
                        enemies.add(ct.getCharacter());
                    }  
                }
            }
        }

        return enemies;
    } 

    public boolean roomCleared(){
        System.out.println(getEnemies().size() + " enemies left");

        if(getEnemies().size() == 0){
            return true;
        }
        return false;
    }

    public static Room createRoom(ArrayList<ArrayList<String>> roomList, int id, Map<Integer, ExitTile> exits, Map<Integer, Room> rooms){

        int width = roomList.get(0).size();
        int height = roomList.size();

        TileFeature[][] tiles = new TileFeature[height][width];
        

        for(int i=0; i<height; i++){
            TileFeature[] row = new TileFeature[width];
            for(int k=0; k<width; k++){
                try {
                    TileFeature tile = TileFeature.createTile(roomList.get(i).get(k), rooms, k, i);
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

    public static Room generateRoom(){
        return null;
    }

    public TileFeature[][] getTiles(){
        return tiles;
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
        String display = "";

        for(TileFeature[] row: tiles){
            for(TileFeature tile: row){
                this.description += "  " + tile.getDescription() + "\n";
                display += "[" + tile.getSymbol() + "] ";
            }
            display += "\n";
        }
        return display;
    }

    @Override
    public int hashCode(){
        return tiles.hashCode() + description.hashCode();
    }
}
