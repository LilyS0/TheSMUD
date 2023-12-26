package smud.model.ComponentBuilder.TileCreators;

import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.Tile;

public class CharacterTileCreator implements TileCreator{

    @Override
    public Tile createTile(int x, int y) {
        return new CharacterTile(x, y);
    }
}
