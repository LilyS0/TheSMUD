package smud.model.Environment;

import smud.model.Environment.Tiles.ExitTile;

public class Hallway {
    private Room room1;
    private Room room2;
    private ExitTile exit1;
    private ExitTile exit2;

    public Hallway(Room room1, Room room2, ExitTile exit1, ExitTile exit2){
        this.room1 = room1;
        this.room2 = room2;
        this.exit1 = exit1;
        this.exit2 = exit2;
    }

    public Room getRoom1(){
        return room1;
    }

    public Room getRoom2(){
        return room2;
    }

    public ExitTile getExit1(){
        return exit1;
    }

    public ExitTile getExit2(){
        return exit2;
    }
}
