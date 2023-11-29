package smud.view;

import java.io.IOException;

import smud.controller.MUDGame;
import smud.model.MUDException;
import smud.model.Character.PlayerCharacter;

public class ptui {
    
    private MUDGame game;


    public ptui(String filepath, String playerName, String playerDescription) throws IOException, MUDException{
        this.game = new MUDGame(filepath, playerName, playerDescription);
    }

    public MUDGame getGame(){
        return game;
    }

    public static void main(String[] args){

        String filepath = "src/main/java/smud/model/Environment/maps/map2.txt";
        String playerName = "Player 1";
        String playerDescription = "A worthy challenger";
        ptui ui;
        
        try {
            ui = new ptui(filepath, playerName, playerDescription);
        } catch (IOException | MUDException e) {
            ui = null;
            e.printStackTrace();
        }

        MUDGame game = ui.getGame();
        PlayerCharacter player = game.getPlayer();

        int turns = 1;

        

        while(player.isAlive() && !game.gameOver()){

            System.out.println("Turn " + turns);

            try {
                turns ++;
                game.takeTurn(); 
            } catch (MUDException e) {
                System.out.println("Invalid move");
            }
        }
        System.out.println("Game Over!");   
    }
}
