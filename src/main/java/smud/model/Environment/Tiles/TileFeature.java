package smud.model.Environment.Tiles;

import java.util.Map;
import java.util.Random;

import smud.model.MUDCharacter;
import smud.model.MUDException;
import smud.model.NPC;
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

    public static TileFeature createTile(String symbol,  Map<Integer, Room> rooms) throws MUDException{

        //symbols: E,C,T,X,O,I

        if(symbol.equals("E")){
            return new EmptyTile();
        } 
        else if(symbol.equals("C")){
            return new CharacterTile(new NPC());
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
            //should throw MUD exception instead
            throw new MUDException("Invalid Symbol");
        }
    }
}
