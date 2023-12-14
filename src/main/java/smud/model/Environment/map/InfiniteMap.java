package smud.model.Environment.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import smud.model.Environment.MapComponent;
import smud.model.Environment.room.InfiniteRoom;
import smud.model.Environment.room.Room;
import smud.persistence.Mementos.InfiniteMapMemento;
import smud.persistence.Mementos.MapMemento;

public class InfiniteMap implements MUDMap{

    private InfiniteRoom startRoom;
    private Map<Integer, Room> rooms;

    public InfiniteMap(){
        this.rooms = new HashMap<>();
        this.startRoom = new InfiniteRoom(null);
        rooms.put(startRoom.getID(), startRoom);
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
    public Room getRoom(int id){
        Room room = rooms.get(id);
        if(room == null){
            room = new InfiniteRoom(startRoom);
            rooms.put(id, room);
        }
        return room;
    }

    @Override
    public Room getStartRoom() {
        return startRoom;
    }

    @Override
    public Room getEndRoom() {
        throw new UnsupportedOperationException("No end room in infinite map");
    }

    @Override
    public void setMemento(MapMemento memento) {
        if(memento instanceof InfiniteMapMemento){
            InfiniteMapMemento m = (InfiniteMapMemento)memento;
            this.startRoom = m.getStartRoom();
            this.rooms = m.getRooms();
        }
    }

    @Override
    public MapMemento createMemento() {
        return new InfiniteMapMemento(startRoom, rooms);
    }



    @Override
    public Collection<MapComponent> getChildren() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChildren'");
    }



    @Override
    public void updateTime(boolean isDay) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTime'");
    }
}
