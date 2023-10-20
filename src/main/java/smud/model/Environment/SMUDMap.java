package smud.model.Environment;

import java.util.HashSet;
import java.util.Set;

/**
 * A Map is made up of 2+ Rooms, which are made of Tiles.
 * 
 * @author Sydney Wilson
 */
public class SMUDMap {

    private Room startRoom;
    private Room endRoom;
    private Set<Room> rooms;
    private boolean isDay;

    public SMUDMap(String filepath){
        this.rooms = new HashSet<>();
        this.isDay = true;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void connectRooms(Room r1, Room r2){
        r1.addExit(r2);
        r2.addExit(r1);
    }

    public void changeTime(){
        isDay = !isDay();
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

    public Set<Room> getRooms(){
        return rooms;
    }
}
