package smud.model.Environment;

import java.util.ArrayList;

import smud.model.Cards.NPC;

public abstract class Area implements DungeonElement{
    
    protected Tile[][] tiles;

    @Override
    public void updateTime(boolean isDay) {
        for(Tile[] row: tiles){
            for(Tile tile: row){
                tile.updateTime(isDay);
            }
        }
    }

    //setters

    public void setTiles(Tile[][] tiles){
        this.tiles = tiles;
    }

    //getters

    public Tile getTile(int x, int y){
        return tiles[y][x];
    }

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
}
