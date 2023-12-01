package smud.model.Environment.room;

import java.util.ArrayList;

import smud.model.Character.MUDCharacter;
import smud.model.Environment.Tiles.TileFeature;

public interface Room {
    public TileFeature getTile(int x, int y);
    public ArrayList<MUDCharacter> getEnemies();
    public boolean roomCleared();
    public TileFeature[][] getTiles();
    public void addExit(Room room);
}