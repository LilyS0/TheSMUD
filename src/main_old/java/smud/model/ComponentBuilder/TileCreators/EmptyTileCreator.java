package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.Tile;

public class EmptyTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new EmptyTile(x, y);
    }
}
