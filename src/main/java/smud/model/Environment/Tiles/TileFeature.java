package smud.model.Environment.Tiles;

import smud.model.MUDCharacter;
import smud.model.Item.MUDItem;

public abstract class TileFeature {
    protected Tile tile;
    protected String description;
    protected char symbol;

    public boolean occupy(MUDCharacter character){
        return tile.occupy(character);
    }

    public void storeItem(MUDItem item){
        tile.storeItem(item);
    }

    public String getDescription(){
        return description;
    }

    public char getSymbol(){
        return symbol;
    }
}
