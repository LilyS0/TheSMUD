package smud.model.ComponentBuilder;

import smud.model.ComponentBuilder.RoomCreators.RoomCreator;
import smud.model.ComponentBuilder.TileCreators.TileCreator;
import smud.model.Environment.Tiles.Tile;
import smud.model.Environment2.MUDMap2;
import smud.model.Environment2.Room2;

public class Builder implements ComponentBuilder{

    TileCreator tileCreator;
    RoomCreator roomCreator;

    public void setTileCreator(TileCreator creator){
        this.tileCreator = creator;
    }

    public void setRoomCreator(RoomCreator creator){
        this.roomCreator = creator;
    }

    @Override
    public MUDMap2 createMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMap'");
    }

    @Override
    public Room2 createRoom(int id) {
        return roomCreator.createRoom(id);
    }

    @Override
    public Tile createTile(int x, int y) {
        return tileCreator.createTile(x, y);
    }
    
}
