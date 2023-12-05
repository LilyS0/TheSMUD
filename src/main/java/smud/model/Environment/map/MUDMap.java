package smud.model.Environment.map;

import java.util.Map;

import smud.model.Environment.room.Room;

public interface MUDMap {
    public Room getStartRoom();
    public Room getEndRoom();
    public Map<Integer, Room> getRooms();
}
