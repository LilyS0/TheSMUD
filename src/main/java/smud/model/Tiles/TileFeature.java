package smud.model.Tiles;

import smud.model.MUDCharacter;
import smud.model.Item.MUDItem;

public abstract class TileFeature {
    protected Tile tile;

    public boolean occupy(MUDCharacter character){
        return tile.occupy(character);
    }

    public void storeItem(MUDItem item){
        tile.storeItem(item);
    }
}
