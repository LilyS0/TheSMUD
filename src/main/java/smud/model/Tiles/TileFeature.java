package smud.model.Tiles;

import smud.model.MUDCharacter;
import smud.model.MUDException;
import smud.model.Item.MUDItem;

public abstract class TileFeature {
    protected Tile tile;

    public boolean occupy(MUDCharacter character){
        return tile.occupy(character);
    }

    public void storeItem(MUDItem item){
        tile.storeItem(item);
    }

    public boolean disarm() throws MUDException{
        throw(new MUDException("Can't disarm. No trap present."));
    }
}
