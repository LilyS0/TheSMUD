package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.Tile;

public interface TileCreator {
    public Tile createTile(int x, int y);
}
