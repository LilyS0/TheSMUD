package smud.model.Environment.room;

import java.util.Random;

import smud.model.Character.NPC;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.InfiniteExitTile;
import smud.model.Environment.Tiles.ItemTile;
import smud.model.Environment.Tiles.ObstacleTile;
import smud.model.Environment.Tiles.TileFeature;
import smud.model.Environment.Tiles.TrapTile;
import smud.model.Item.MUDItem;

public class InfiniteRoom extends Room{

    private InfiniteRoom next;
    private InfiniteRoom previous;
    private final Random RANDOM = new Random();
    private final int MAX_OBSTICLES = 4;
    private final int MAX_TRAPS = 2;
    private final int MAX_ENEMIES = 3;
    private final int MAX_ITEMS = 2;

    public InfiniteRoom(InfiniteRoom previous){
        this.next = null;
        this.previous = previous;
        this.tiles = makeTiles();
        this.height = tiles.length;
        this.width = tiles[0].length;

        if(this.previous == null){
            this.id = 1;
        }
        else{
            this.id = previous.getID()+1;
        }
    }

    private TileFeature[][] makeTiles(){

        int width = RANDOM.nextInt(4, 7);
        int height = RANDOM.nextInt(4, 7);
        TileFeature[][] tiles = new TileFeature[height][width];

        //Load with all empty tiles

        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                tiles[y][x] = new EmptyTile(x, y);
            }
        }

        //Make exits

        //exit to previous room in the bottom middle if previous room exists
        if(previous != null){
            TileFeature exitToPrev = new InfiniteExitTile(this, previous, width/2, height-1);
            tiles[height-1][width/2] = exitToPrev;
        }

        //exit to the next room at the top middle
        TileFeature exitToNext = new InfiniteExitTile(this, next, width/2, 0);
        tiles[0][width/2] = exitToNext;

        //Make obsticles
        int obsticlesNum = RANDOM.nextInt(MAX_OBSTICLES);
        for(int i=0; i<obsticlesNum; i++){

            //chose random location
            int x = RANDOM.nextInt(width);
            int y = RANDOM.nextInt(height);

            //find a new location if that one is taken or adjacent to exit
            while(!(tiles[y][x] instanceof EmptyTile) || exitAdjacent(x, y)){
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
            while(!(tiles[y][x] instanceof EmptyTile) || exitAdjacent(x, y)){
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
            while(!(tiles[y][x] instanceof EmptyTile) || exitAdjacent(x, y)){
                x = RANDOM.nextInt(width);
                y = RANDOM.nextInt(height);
            }

            //place new obsticle tile
            int attack = RANDOM.nextInt(5,11);
            tiles[y][x] = new TrapTile(attack, x, y);
        }

        //Make obsticles
        int itemsNum = RANDOM.nextInt(MAX_ITEMS);
        for(int i=0; i<itemsNum; i++){

            //chose random location
            int x = RANDOM.nextInt(width);
            int y = RANDOM.nextInt(height);

            //find a new location if that one is taken or adjacent to exit
            while(!(tiles[y][x] instanceof EmptyTile) || exitAdjacent(x, y)){
                x = RANDOM.nextInt(width);
                y = RANDOM.nextInt(height);
            }

            //place new obsticle tile
            tiles[y][x] = new ItemTile(MUDItem.getRandomItems(), x, y);
        }     
        return tiles;
    }

    public boolean exitAdjacent(int x, int y){

        TileFeature[] adjacent = new TileFeature[4];

        TileFeature up = getTile(x, y-1);
        TileFeature down = getTile(x, y+1);
        TileFeature left = getTile(x-1, y);
        TileFeature right = getTile(x+1, y);
        
        adjacent[0] = up;
        adjacent[1] = down;
        adjacent[2] = left;
        adjacent[3] = right;

        for(TileFeature tile: adjacent){
            if(tile instanceof ExitTile){
                return true;
            }
        }

        return false;
    }

    public InfiniteRoom getNext(){
        return next;
    }

    public InfiniteRoom getPrevious(){
        return previous;
    }

    @Override
    public void addExit(Room room) {
        throw new UnsupportedOperationException("Can't do that here");
    }
    
}
