package smud.model.ComponentBuilder.RoomCreators;

import smud.model.Environment.Tiles.Tile;
import smud.model.Environment2.Room2;

public class PremadeRoomCreator implements RoomCreator{

    private Tile[][] tiles;

    public void setTiles(Tile[][] tiles){
        this.tiles = tiles;
    }

    @Override
    public Room2 createRoom(int id) {
        Room2 room = new Room2();
        room.setId(id);
        room.setTiles(tiles);
        return room;
    }
}
