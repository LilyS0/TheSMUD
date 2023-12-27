package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.ShrineTile;
import smud.model.Environment.Tiles.Tile;

public class ShirneTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new ShrineTile(x, y);
    }
    
}
