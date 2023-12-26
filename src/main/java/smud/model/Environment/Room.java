package smud.model.Environment;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Room extends Area{

    private Set<Room> neighbors;

    public Room(){

        Random random = new Random();
        int width = random.nextInt(8, 13);
        int height = random.nextInt(8, 13);

        this.tiles = new Tile[height][width];
        this.neighbors = new HashSet<>();
    } 

    public void addNeighbor(Room neighbor){
        neighbors.add(neighbor);
        neighbor.addNeighbor(this);
    }

    // getters

    public Set<Room> getNeighbors() {
        return neighbors;
    }
    
}
