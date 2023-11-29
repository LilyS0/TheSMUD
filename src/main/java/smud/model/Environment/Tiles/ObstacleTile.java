package smud.model.Environment.Tiles;

import java.util.Random;

import smud.model.Character.MUDCharacter;

public class ObstacleTile extends TileFeature{

    private static final String[] obsticles = {"Rock", "Plant", "Spike", "Wall", "Pit"};
    private static final Random random = new Random();
    
    public ObstacleTile(String description, int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.description = description;
        this.defaultSymbol = 'O';
        this.symbol = defaultSymbol;
    }

    @Override
    public boolean occupy(MUDCharacter character){
        return false;
    }

    public String getDescription(){
        return description;
    }

    public static ObstacleTile createRandomObstacleTile(int x, int y){
        return new ObstacleTile(obsticles[random.nextInt(obsticles.length)], x, y);
    }
}
