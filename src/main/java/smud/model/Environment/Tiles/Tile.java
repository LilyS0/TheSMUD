package smud.model.Environment.Tiles;

import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Item.MUDItem;

public interface Tile {
    public boolean occupy(MUDCharacter character);
    public void storeItem(MUDItem item);
    public MUDCharacter getOccupant();
    public boolean disarm(MUDCharacter character) throws MUDException;
}
