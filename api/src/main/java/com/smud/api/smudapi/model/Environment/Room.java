package com.smud.api.smudapi.model.Environment;

import java.util.ArrayList;
import java.util.Random;

/*
 * <<composite>> of tiles in composite pattern for environment subsystem
 * represents a room in the infinite dungeon
 */

public class Room extends Area{

    private ArrayList<Room> neighbors;

    public Room(){

        Random random = new Random();
        int width = random.nextInt(8, 13);
        int height = random.nextInt(8, 13);

        this.tiles = new Tile[height][width];
        this.neighbors = new ArrayList<>();
    } 

    public void addNeighbor(Room neighbor){
        neighbors.add(neighbor);
        neighbor.addNeighbor(this);
    }

    // getters

    public ArrayList<Room> getNeighbors() {
        return neighbors;
    }
    
}
