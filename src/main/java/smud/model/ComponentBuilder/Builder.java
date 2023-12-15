package smud.model.ComponentBuilder;

import smud.model.ComponentBuilder.TileCreators.TileCreator;
import smud.model.Environment.Tiles.Tile;
import smud.model.Environment2.MUDMap2;
import smud.model.Environment2.Room2;

public class Builder implements ComponentBuilder{

    TileCreator tileCreator;


    public Builder(){

    }

    public void setTileCreator(TileCreator creator){
        this.tileCreator = creator;
    }

    @Override
    public MUDMap2 createMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMap'");
    }

    @Override
    public Room2 createRoom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRoom'");
    }

    @Override
    public Tile createTile(int x, int y) {
        return tileCreator.createTile(x, y);
    }
    
}
