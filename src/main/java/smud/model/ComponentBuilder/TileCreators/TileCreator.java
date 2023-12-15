package smud.model.ComponentBuilder;

import smud.model.Environment.Tiles.Tile;

public interface TileCreator {
    public Tile createTile(int x, int y);
}
