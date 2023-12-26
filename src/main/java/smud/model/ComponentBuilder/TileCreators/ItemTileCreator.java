package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.ItemTile;
import smud.model.Environment.Tiles.Tile;

public class ItemTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new ItemTile(x, y);
    }
    
}
