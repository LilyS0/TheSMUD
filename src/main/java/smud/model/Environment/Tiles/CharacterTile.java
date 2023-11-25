package smud.model.Environment.Tiles;

import smud.controller.PlayerController;
import smud.model.MUDCharacter;

public class CharacterTile extends TileFeature{
    private MUDCharacter startingOccupant;
    
    public CharacterTile(MUDCharacter character, int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.startingOccupant = character;
        this.defaultSymbol = 'C';
        this.symbol = defaultSymbol;
        this.description = "Character Tile";
        //tile.occupy(character);
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

    @Override
    public void interact(PlayerController player){
        int damage = player.getCharacter().getAttack();
        startingOccupant.takeDamage(damage);
    }
    
    public MUDCharacter getCharacter(){
        return startingOccupant;
    }
}
