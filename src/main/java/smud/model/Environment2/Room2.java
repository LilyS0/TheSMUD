package smud.model.Environment2;

import smud.model.Environment.MapComponent;
import smud.model.Environment.Tiles.Tile;

public class Room2 implements MapComponent{

    private Tile[][] tiles;
    private int id;

    public Room2(){}

    public Tile getTile(int x, int y){
        return tiles[y][x];
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void updateTime(boolean isDay) {
        for(Tile[] row: tiles){
            for(Tile tile: row){
                tile.updateTime(isDay);
            }
        }
    }
    
}
