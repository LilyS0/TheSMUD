package smud.persistence.Mementos;

import java.util.Map;

import smud.model.Environment.room.Room;

public abstract class MapMemento {
    
    protected Room startRoom;
    protected Room endRoom;
    protected Map<Integer, Room> rooms;


    public Room getStartRoom(){
        return startRoom;
    }

    public void setStartRoom(Room room){
        this.startRoom = room;
    }

    public Room getEndRoom(){
        return endRoom;
    }

    public void setEndRoom(Room room){
        this.endRoom = room;
    }

    public Map<Integer, Room> getRooms(){
        return rooms;
    }

    public void setRooms(Map<Integer, Room> rooms){
        this.rooms = rooms;
    }


}
