package smud.model.Environment.Tiles;

import java.util.Random;

import smud.model.MUDCharacter;

public class ObstacleTile extends TileFeature{

    private static final String[] obsticles = {"Rock", "Plant", "Spike", "Wall", "Pit"};
    private static final Random random = new Random();
    
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

    public static ObstacleTile createRandomObstacleTile(){
        return new ObstacleTile(obsticles[random.nextInt(obsticles.length)]);
    }
}
