package smud.model.ComponentBuilder.RoomCreators;

import java.util.Random;

import smud.model.Character.NPC;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.ItemTile;
import smud.model.Environment.Tiles.ObstacleTile;
import smud.model.Environment.Tiles.Tile;
import smud.model.Environment.Tiles.TrapTile;
import smud.model.Environment2.Room2;
import smud.model.Item.MUDItem;

public class GeneratedRoomCreator implements RoomCreator{

    private final Random RANDOM = new Random();
    private final int MAX_OBSTICLES = 4;
    private final int MAX_TRAPS = 2;
    private final int MAX_ENEMIES = 3;
    private final int MAX_ITEMS = 2;

    private Tile[][] createTiles(){
        int width = RANDOM.nextInt(4, 7);
        int height = RANDOM.nextInt(4, 7);
        Tile[][] tiles = new Tile[height][width];

        //Load with all empty tiles

        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                tiles[y][x] = new EmptyTile(x, y);
            }
        }

        int obsticlesNum = RANDOM.nextInt(MAX_OBSTICLES);
        for(int i=0; i<obsticlesNum; i++){

            //chose random location
            int x = RANDOM.nextInt(width);
            int y = RANDOM.nextInt(height);

            //find a new location if that one is taken or adjacent to exit
            while(!(tiles[y][x] instanceof EmptyTile)){
                x = RANDOM.nextInt(width);
                y = RANDOM.nextInt(height);
            }

            //place new obsticle tile
            tiles[y][x] = new ObstacleTile("An obsticle", x, y);
        }

        //Make enemies
        int enemiesNum = RANDOM.nextInt(MAX_ENEMIES);
        for(int i=0; i<enemiesNum; i++){

            //chose random location
            int x = RANDOM.nextInt(width);
            int y = RANDOM.nextInt(height);

            //find a new location if that one is taken or adjacent to exit
            while(!(tiles[y][x] instanceof EmptyTile)){
                x = RANDOM.nextInt(width);
                y = RANDOM.nextInt(height);
            }

            //place new obsticle tile
            tiles[y][x] = new CharacterTile(new NPC(), x, y);
        }

        //Make traps
        int trapsNum = RANDOM.nextInt(MAX_TRAPS);
        for(int i=0; i<trapsNum; i++){

            //chose random location
            int x = RANDOM.nextInt(width);
            int y = RANDOM.nextInt(height);

            //find a new location if that one is taken or adjacent to exit
            while(!(tiles[y][x] instanceof EmptyTile)){
                x = RANDOM.nextInt(width);
                y = RANDOM.nextInt(height);
            }

            //place new obsticle tile
            int attack = RANDOM.nextInt(5,11);
            tiles[y][x] = new TrapTile(attack, x, y);
        }

        //Make items
        int itemsNum = RANDOM.nextInt(MAX_ITEMS);
        for(int i=0; i<itemsNum; i++){

            //chose random location
            int x = RANDOM.nextInt(width);
            int y = RANDOM.nextInt(height);

            //find a new location if that one is taken or adjacent to exit
            while(!(tiles[y][x] instanceof EmptyTile)){
                x = RANDOM.nextInt(width);
                y = RANDOM.nextInt(height);
            }

            //place new obsticle tile
            tiles[y][x] = new ItemTile(MUDItem.getRandomItems(), x, y);
        }     

        return tiles;
    }

    @Override
    public Room2 createRoom(int id) {
        Room2 room = new Room2();
        room.setId(id);
        room.setTiles(createTiles());
        return room;
    }
    
}
