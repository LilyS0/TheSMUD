package smud.model.ComponentBuilder;

import smud.model.Environment.Tiles.Tile;
import smud.model.Environment2.MUDMap2;
import smud.model.Environment2.Room2;

public interface ComponentBuilder {
    public MUDMap2 createMap();
    public Room2 createRoom(int id);
    public Tile createTile(int x, int y);
}
