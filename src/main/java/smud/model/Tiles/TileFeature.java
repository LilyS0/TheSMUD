package model.Tiles;

import model.MUDCharacter;
import model.Item.MUDItem;

public abstract class TileFeature {
    protected Tile tile;

    public boolean occupy(MUDCharacter character){
        return tile.occupy(character);
    }

    public void storeItem(MUDItem item){
        tile.storeItem(item);
    }
}
