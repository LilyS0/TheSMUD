package smud.model.Environment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import smud.model.Cards.NPC;

public class Room implements DungeonElement{

    private Set<Room> neighbors;
    private Tile[][] tiles;

    public Room(){

        Random random = new Random();
        int width = random.nextInt(8, 13);
        int height = random.nextInt(8, 13);

        this.tiles = new Tile[height][width];
        this.neighbors = new HashSet<>();
    }

    @Override
    public void updateTime(boolean isDay) {
        for(Tile[] row: tiles){
            for(Tile tile: row){
                tile.updateTime(isDay);
            }
        }
    }

    public void addNeighbor(Room neighbor){
        neighbors.add(neighbor);
        neighbor.addNeighbor(this);
    }

    //setters

    public void setTiles(Tile[][] tiles){
        this.tiles = tiles;
    }

    // getters

    @Override
    public ArrayList<NPC> getMonsters() {

        ArrayList<NPC> monsters = new ArrayList<>();

        for(Tile[] row: tiles){
            for(Tile tile: row){
                monsters.add(tile.getMonster());
            }
        }

        return monsters;
    }

    @Override
    public ArrayList<DungeonElement> getChildren() {
        ArrayList<DungeonElement> children = new ArrayList<>();

        for(Tile[] row: tiles){
            for(Tile tile: row){
                children.add(tile);
            }
        }

        return children;
    }

    public Set<Room> getNeighbors() {
        return neighbors;
    }
    
}
