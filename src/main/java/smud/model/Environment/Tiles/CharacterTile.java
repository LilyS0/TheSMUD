package smud.model.Environment.Tiles;

import smud.model.MUDCharacter;

public class CharacterTile extends TileFeature{
    private MUDCharacter startingOccupant;
    
    public CharacterTile(MUDCharacter character){
        this.startingOccupant = character;
        this.symbol = 'C';
        this.description = "Character Tile";
        tile.occupy(character);
    }

    @Override
    public boolean occupy(MUDCharacter character){
        if(!startingOccupant.isAlive()){
            // he's dead now, should be able to go
            return occupy(character);
        }else{
            // the guy who started here is still alive, can't go there yet
            return false;
        }
    }
    
    public MUDCharacter getCharacter(){
        return startingOccupant;
    }
}
