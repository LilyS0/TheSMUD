package smud.model.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Map is made up of 2+ Rooms, which are made of Tiles.
 * 
 * @author Sydney Wilson
 */
public class SMUDMap {

    private Room startRoom;
    private Room endRoom;
    private Map<Room, List<Room>> hallways;
    private boolean isDay;

    public SMUDMap(String filepath){
        this.hallways = new HashMap<>();
        this.isDay = true;
    }

    public void changeTime(){
        this.isDay = !isDay();
    }

    public Room getStartRoom(){
        return startRoom;
    }

    public Room getEndRoom(){
        return endRoom;
    }

    public boolean isDay(){
        return isDay;
    }

    public Map<Room, List<Room>> getAllHallways(){
        return hallways;
    }

    public List<Room> getConnectedRooms(Room room){
        return hallways.get(room);
    }
}
