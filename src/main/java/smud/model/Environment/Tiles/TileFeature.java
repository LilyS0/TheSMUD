package smud.model.Environment.Tiles;

import java.util.Map;
import java.util.Random;

import smud.model.MUDCharacter;
import smud.model.Environment.Room;
import smud.model.Item.MUDItem;

public abstract class TileFeature {
    protected Tile tile;
    protected String description;
    protected char symbol;
    private static final Random random = new Random();

    public boolean occupy(MUDCharacter character){
        return tile.occupy(character);
    }

    public void storeItem(MUDItem item){
        tile.storeItem(item);
    }

    public String getDescription(){
        return description;
    }

    public char getSymbol(){
        return symbol;
    }

    public static TileFeature createTile(String symbol,  Map<Integer, Room> rooms){

        //symbols: E,C,T,X,O,I

        if(symbol.equals("E")){
            return new EmptyTile();
        } 
        else if(symbol.equals("C")){
            return new CharacterTile(null);
        }
        else if(symbol.equals("T")){
            return new TrapTile(random.nextInt(21)+5);
        }
        else if(symbol.startsWith("X")){
            int id = Character.getNumericValue(symbol.charAt(1));
            return new ExitTile(rooms.get(id));
        }
        else if(symbol.equals("O")){
            return ObstacleTile.createRandomObstacleTile();
        }
        else if(symbol.equals("I")){
            return new ItemTile(MUDItem.getRandomItems());
        }
        else{
            return new EmptyTile();
        }
    }
}
