package smud.model.Environment.Tiles;

import java.util.Map;
import java.util.Random;

import smud.model.MUDCharacter;
import smud.model.MUDException;
import smud.model.NPC;
import smud.model.Environment.Room;
import smud.model.Item.MUDItem;

public abstract class TileFeature {
    protected int xCor;
    protected int yCor;
    protected Tile tile;
    protected String description;
    protected char symbol;
    protected MUDCharacter occupant;
    protected boolean canEnter;
    private static final Random random = new Random();

    public boolean occupy(MUDCharacter character) {
        if(canEnter && occupant == null){
            occupant = character;
            canEnter = false;
            return true;
        }else{
            return false;
        }
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

    public MUDCharacter getOccupant(){
        return occupant;
    }

    public int getXCor(){
        return xCor;
    }

    public int getYCor(){
        return yCor;
    }

    public static TileFeature createTile(String symbol,  Map<Integer, Room> rooms, int x, int y) throws MUDException{

        //symbols: E,C,T,X,O,I

        if(symbol.equals("E")){
            return new EmptyTile(x, y);
        } 
        else if(symbol.equals("C")){
            return new CharacterTile(new NPC(), x, y);
        }
        else if(symbol.equals("T")){
            return new TrapTile(random.nextInt(21)+5, x, y);
        }
        else if(symbol.startsWith("X")){
            int id = Character.getNumericValue(symbol.charAt(1));
            return new ExitTile(id, x, y);
        }
        else if(symbol.equals("O")){
            return ObstacleTile.createRandomObstacleTile(x,y);
        }
        else if(symbol.equals("I")){
            return new ItemTile(MUDItem.getRandomItems(), x, y);
        }
        else{
            //should throw MUD exception instead
            throw new MUDException("Invalid Symbol");
        }
    }
}
