package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.MerchantTile;
import smud.model.Environment.Tiles.Tile;

public class MerchantTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new MerchantTile(x, y);
    }
    
}
