package smud.persistence;

import java.util.Map;

import smud.model.Environment.room.Room;

public interface MapDAO {
    public Room getStartRoom();
    public Room getEndRoom();
    public Map<Integer, Room> getRooms();
}
