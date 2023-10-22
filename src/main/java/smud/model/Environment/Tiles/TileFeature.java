package smud.model.Environment.Tiles;

import java.util.ArrayList;

import smud.model.MUDCharacter;
import smud.model.Item.MUDItem;

public abstract class TileFeature {
    protected Tile tile;
    protected String description;
    protected char symbol;

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

    public static TileFeature createTile(String symbol){

        //symbols: E,C,T,X,O,I

        if(symbol.equals("E")){
            return new EmptyTile();
        } 
        else if(symbol.equals("C")){
            return new CharacterTile(null);
        }
        else if(symbol.equals("T")){
            return new TrapTile(0);
        }
        else if(symbol.startsWith("X")){
            return new ExitTile(null);
        }
        else if(symbol.equals("O")){
            return new ObstacleTile(null);
        }
        else if(symbol.equals("I")){
            return new ItemTile(null);
        }
        else{
            return new EmptyTile();
        }
    }
}
