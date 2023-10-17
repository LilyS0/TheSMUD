package model;
/**
 * A Map is made up of 2+ Rooms, which are made of Tiles.
 * 
 * @author Sydney Wilson
 */
public class Map {
    // public Room startRoom;
    // public Room endRoom;
    // public Room[][] rooms;
    public long time = System.currentTimeMillis(); // there might also be a better way to go about this, but this way is reliable at least

    // *again with the 2D array, there's gotta be a better solution but for now that's
    // gonna be the placeholder*

    // revisit gcis124 haunted house assignment for inspo on how to handle room/map -> used a weighted graph*/graph in general
    public boolean isNight;

    public void timeChange() {
        // if this.time - other time = 5 min or whatever then change time
    }
}
