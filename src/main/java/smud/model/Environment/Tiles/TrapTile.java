package smud.model.Environment.Tiles;

import java.util.Random;

import smud.model.MUDCharacter;
import smud.model.MUDException;

public class TrapTile extends TileFeature{
    private int attack;
    private boolean armed;
    Random rng = new Random();

    public TrapTile(int attack){
        this.attack = attack;
        this.armed = true;
        this.description = "Trap Tile";
        this.symbol = 'T';
    }
    
    @Override
    public boolean disarm(MUDCharacter character) throws MUDException{
        if(armed){
            if(rng.nextInt(2) < 1){
                System.out.println("You disarmed the trap.");
                armed = false;
                return true;
            }else{
                System.out.println("You failed to disarm the trap!");
                // cause damage with attack stat then set trap inactive
                character.takeDamage(attack);
                armed = false;
                return false;
            }
        }else{
            System.out.println("The trap is not active.");
            return true;
        }
    }

    @Override
    public boolean occupy(MUDCharacter character){
        if(this.armed){
            System.out.println("You triggered a trap!");
            // cause damage
            character.takeDamage(attack);
            return tile.occupy(character);
        }else{
            // trap inactive, nothing happens
            return tile.occupy(character);
        }
    }

    public int getAttack(){
        return attack;
    }

    boolean armed(){
        return this.armed;
    }
}
