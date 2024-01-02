package com.smud.api.smudapi.model.Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.smud.api.smudapi.model.Cards.NPCs.NPC;



/*
 * <<composite>> of rooms in composite pattern for environment subsystem
 * an infinitately generated dungeon that a player can explore to collect loot
 */

public class Dungeon implements DungeonElement{

    public Map<Room, ArrayList<Room>> rooms;
    public Room startRoom;

    public Dungeon(){
        this.rooms = new HashMap<>();
        this.startRoom = new Room(); 
    }

    public void addRoom(Room previous, Room next){
        rooms.put(next, next.getNeighbors());
        rooms.get(previous).add(next);
    }

    @Override
    public void updateTime(boolean isDay) {
        for(Room room: rooms.keySet()){
            room.updateTime(isDay);
        }
    }

    //getters

    @Override
    public ArrayList<NPC> getMonsters() {

        ArrayList<NPC> monsters = new ArrayList<>();

        for(Room room: rooms.keySet()){
            monsters.addAll(room.getMonsters());
        }

        return monsters;
    }

    @Override
    public ArrayList<DungeonElement> getChildren() {

        ArrayList<DungeonElement> children = new ArrayList<>();

        for(Room room: rooms.keySet()){
            children.add(room);
        }

        return children;
    } 

    public Map<Room, ArrayList<Room>> getRooms() {
        return rooms;
    }
}
