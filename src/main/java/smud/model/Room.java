package smud.model;
/**
 * A Map consists of many Rooms, each with varying attributes. A Room is then made of Tiles.
 * 
 * @author Sydney Wilson
 */
public class Room {
    // *structure of this V E R Y subject to change, for now a 2D 
    // array seems like a sort of decent solution similar to how you would create ex. a checkerboard
    // for a game of checkers, but there is probably a much more optimal solution i have forgotten*

    // public Tile[][] tiles;
    
    // width and height in terms of Tiles would then be the size of the array

    // Exit is not currently a type of Tile in our ConsensusDomainModel, but i think it 
    // would be optimal to do so (will further discuss in meeting)

    // definitely use 2D array for Room 

    public String description;

    public String getDescription() {
        return this.description;
    }
}
