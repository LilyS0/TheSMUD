package smud.persistence.Mementos;

import java.util.Map;

import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.room.Room;

public class PremadeMapMemento extends MapMemento{

    private Map<Integer, ExitTile> exits;


    public PremadeMapMemento(Room startRoom, Room endRoom, Map<Integer, Room> rooms, Map<Integer, ExitTile> exits){
        this.startRoom = startRoom;
        this.endRoom = endRoom;
        this.rooms =rooms;
        this.exits = exits;
    }

    public Map<Integer, ExitTile> getExits(){
        return exits;
    }

    public void setExits(Map<Integer, ExitTile> exits){
        this.exits = exits;
    }
    
}
