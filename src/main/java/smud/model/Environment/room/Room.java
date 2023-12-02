package smud.model.Environment.room;

import java.util.ArrayList;

import smud.model.Character.MUDCharacter;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.TileFeature;

public abstract class Room {

    protected TileFeature[][] tiles;
    protected int height;
    protected int width;
    protected int id;
    protected ArrayList<MUDCharacter> enemies;
    protected String description;

    public abstract void addExit(Room room);

    public boolean roomCleared(){
        System.out.println(getEnemies().size() + " enemies left");

        if(getEnemies().size() == 0){
            return true;
        }
        return false;
    }

    public ArrayList<MUDCharacter> getEnemies(){
        ArrayList<MUDCharacter> enemies = new ArrayList<>();

        for(TileFeature[] row: tiles){
            for(TileFeature tile: row){
                if(tile instanceof CharacterTile){
                    CharacterTile ct = (CharacterTile)tile;
                    if(ct.getCharacter().isAlive()){
                        enemies.add(ct.getCharacter());
                    }  
                }
            }
        }

        return enemies;
    }

    public TileFeature getTile(int x, int y){
        try{
            return tiles[y][x];
        }  
        catch (Exception e) {
            return null;
        }
    }

    public TileFeature[][] getTiles(){
        return tiles;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getID(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        String display = "";

        for(TileFeature[] row: tiles){
            for(TileFeature tile: row){
                this.description += "  " + tile.getDescription() + "\n";
                display += "[" + tile.getSymbol() + "] ";
            }
            display += "\n";
        }
        return display;
    }

    @Override
    public int hashCode(){
        return tiles.hashCode() + description.hashCode();
    }
    
}