package smud.model.Environment.Tiles;

import java.util.Random;
import smud.model.MUDException;
import smud.model.Character.MUDCharacter;

public class TrapTile extends TileFeature{
    private int attack;
    private boolean armed;
    private boolean detected;
    Random rng = new Random();

    public TrapTile(int attack, int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.attack = attack;
        this.armed = true;
        this.detected = false;
        this.description = "Trap Tile";
        this.defaultSymbol = '_';
        this.symbol = defaultSymbol;

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

    public void detect(){
        if(!detected && armed){
            if(rng.nextInt(2) < 1){
                System.out.println("Trap detected!");
                symbol = 'T';
                detected = true;
                armed = false;
            }
        }
    }

    @Override
    public boolean occupy(MUDCharacter character){
        if(detected){
            try {
                disarm(character);
            } catch (MUDException e) {
                e.printStackTrace();
            } 
        }
        else if(armed){
            character.takeDamage(attack);
            armed = false;
            detected = true;
        }

        symbol = 'P';
        return true;
    }

    public int getAttack(){
        return attack;
    }
}
