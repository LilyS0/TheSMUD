package smud.model.Environment.Tiles;

import smud.controller.PlayerController;
import smud.model.Character.MUDCharacter;
import smud.model.Item.MUDItem;

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
            symbol = 'P';
            character.addItemsToInv(startingOccupant.getItems());
            startingOccupant.setItems(new MUDItem[0]);
            return true;
        }else{
            // the guy who started here is still alive, can't go there yet
            return false;
        }
    }

    @Override
    public void interact(PlayerController player){
        int damage = player.getCharacter().getAttack();
        startingOccupant.takeDamage(damage);

        System.out.println(startingOccupant.getName() + " has " + startingOccupant.getHealth() + " health");
    }

    @Override
    public void clearOccupant(){
        occupant = null;
        canEnter = true;
        if(!startingOccupant.isAlive()){
            symbol = ' ';
        }
        else{
            symbol = defaultSymbol;
        }
    }
    
    public MUDCharacter getCharacter(){
        return startingOccupant;
    }
}
