package smud.model.Tiles;

import smud.model.MUDCharacter;

public class ObstacleTile extends TileFeature{
    private String description;
    
    public ObstacleTile(String description){
        this.description = description;
    }

    @Override
    public boolean occupy(MUDCharacter character){
        return false;
    }

    public String getDescription(){
        return description;
    }
}
