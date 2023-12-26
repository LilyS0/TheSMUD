package smud.model.Environment2;

import java.util.HashMap;
import java.util.Map;

import smud.model.Environment.MapComponent;

public class MUDMap2 implements MapComponent{

    private Map<Integer, Room2> rooms;

    public MUDMap2(){
        this.rooms = new HashMap<>();
    }

    public void addRoom(int id, Room2 room){
        rooms.put(id, room);
    }

    public Room2 getRoom(int id){
        return rooms.get(id);
    }

    @Override
    public void updateTime(boolean isDay) {
        for(int id: rooms.keySet()){
            rooms.get(id).updateTime(isDay);
        }
    }
}
