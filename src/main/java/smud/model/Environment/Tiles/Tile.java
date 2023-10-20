package smud.model.Environment.Tiles;

import smud.model.MUDCharacter;
import smud.model.Item.MUDItem;

public interface Tile {
    public boolean occupy(MUDCharacter character);
    public void storeItem(MUDItem item);
}
