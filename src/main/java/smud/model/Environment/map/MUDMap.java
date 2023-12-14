package smud.model.Environment.map;

import java.util.Map;

import smud.model.Environment.MapComponent;
import smud.model.Environment.room.Room;
import smud.persistence.Mementos.MapMemento;

public interface MUDMap extends MapComponent{
    public Room getStartRoom();
    public Room getEndRoom();
    public Room getRoom(int id);
    public Map<Integer, Room> getRooms();
    public void setMemento(MapMemento memento);
    public MapMemento createMemento();
}
