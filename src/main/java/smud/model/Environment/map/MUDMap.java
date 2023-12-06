package smud.model.Environment.map;

import java.util.Map;

import smud.model.Environment.room.Room;
import smud.persistence.Mementos.MapMemento;

public interface MUDMap {
    public Room getStartRoom();
    public Room getEndRoom();
    public Map<Integer, Room> getRooms();
    public void setMemento(MapMemento memento);
    public MapMemento createMemento();
}
