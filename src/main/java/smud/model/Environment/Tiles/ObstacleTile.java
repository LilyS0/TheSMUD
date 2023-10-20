package smud.model.Environment.Tiles;

import smud.model.MUDCharacter;

public class ObstacleTile extends TileFeature{
    
    public ObstacleTile(String description){
        this.description = description;
        this.symbol = 'O';
    }

    @Override
    public boolean occupy(MUDCharacter character){
        return false;
    }

    public String getDescription(){
        return description;
    }
}
