package smud.model.Environment.map;

import java.util.HashMap;
import java.util.Map;

import smud.model.Environment.room.InfiniteRoom;
import smud.model.Environment.room.Room;

public class InfiniteMap implements MUDMap{

    private InfiniteRoom startRoom;
    private Map<Integer, Room> rooms;

    public InfiniteMap(){
        this.rooms = new HashMap<>();
        this.startRoom = new InfiniteRoom(null);
        rooms.put(startRoom.getID(), startRoom);
    }

    @Override
    public Room getStartRoom() {
        return startRoom;
    }

    @Override
    public Map<Integer, Room> getRooms(){

        InfiniteRoom room = startRoom;

        while(room.getNext() != null){
            rooms.put(room.getNext().getID(), room.getNext());
            room = room.getNext();
        }

        return rooms;
    }

    @Override
    public Room getEndRoom() {
        throw new UnsupportedOperationException("No end room in infinite map");
    }
}
