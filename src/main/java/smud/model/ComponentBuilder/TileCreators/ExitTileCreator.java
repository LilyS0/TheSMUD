package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.Tile;

public class ExitTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new ExitTile(x, y);
    }
    
}
