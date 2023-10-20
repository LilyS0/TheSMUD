package smud.model.Environment;
/**
 * A Map consists of many Rooms, each with varying attributes. A Room is then made of Tiles.
 * 
 * @author Sydney Wilson
 */

import java.util.ArrayList;

import smud.model.Environment.Tiles.ExitTile;
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
    private ArrayList<Room> exits;
    
    private String description;
    private String display;

    public Room(TileFeature[][] tiles){

        this.tiles = tiles;
        this.width = tiles[0].length;
        this.height = tiles.length;
        this.description = "A room with: \n";

        for(TileFeature[] row: tiles){
            for(TileFeature tile: row){
                if(tile.getDescription().equals("Exit Tile")){
                    ExitTile exit = (ExitTile)tile;
                    exits.add(exit.getTarget());
                }
                this.description += "  " + tile.getDescription() + "\n";
            }
        }

    }
    
    public String getDescription(){
        return description;
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
