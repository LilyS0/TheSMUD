package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.ObstacleTile;
import smud.model.Environment.Tiles.Tile;

public class ObsticleTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new ObstacleTile(x, y);
    }
    
}
