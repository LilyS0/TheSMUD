package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.Tile;
import smud.model.Environment.Tiles.TrapTile;

public class TrapTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new TrapTile(x, y);
    }
    
}
