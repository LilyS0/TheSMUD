package smud.persistence.Mementos;

import java.util.Map;

import smud.model.Environment.room.InfiniteRoom;
import smud.model.Environment.room.Room;

public class InfiniteMapMemento extends MapMemento{

    private InfiniteRoom startRoom;

    public InfiniteMapMemento(InfiniteRoom startRoom, Map<Integer, Room> rooms){
        this.startRoom = startRoom;
        this.rooms = rooms;
    }

    @Override
    public InfiniteRoom getStartRoom(){
        return this.startRoom;
    }

    public void setStartRoom(InfiniteRoom room){
        this.startRoom = room;
    }
    
}
