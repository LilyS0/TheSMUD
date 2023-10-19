package model.Tiles;

import model.MUDCharacter;
import model.Item.MUDItem;

public interface Tile {
    public boolean occupy(MUDCharacter character);
    public void storeItem(MUDItem item);
}
