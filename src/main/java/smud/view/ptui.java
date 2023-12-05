package smud.view;

import java.io.IOException;

import smud.controller.MUDGame;
import smud.model.Account;
import smud.model.MUDException;
import smud.model.Character.PlayerCharacter;

public class ptui {
    
    private Account user;

    public ptui(){}

    public MUDGame getGame(){
        return user.getCurrentGame();
    }

    public void newAccount(String username, String password){
        this.user = new Account(username, password);
    }

    public void setAccount(Account user){
        this.user = user;
    }

    public Account getUser(){
        return user;
    }

    public void startNewGame(String filepath, String description, boolean isInfinite) throws IOException, MUDException{
        MUDGame newGame;

        try {
            newGame = new MUDGame(filepath, user.getUsername(), description, isInfinite);
        } catch (Exception e) {
            System.out.println("Error making game: " + e);
            newGame = null;
        }

        user.startNewGame(newGame);
        user.setPlayer(newGame.getController());
    }

    public static void main(String[] args){

        String username = "login";
        String password = "password123";
        String playerDescription = "Dungeon crawler";
        String filepath = "src/main/java/smud/model/Environment/map/maps/map2.txt";
        boolean isInfinite = false;

        ptui ui = new ptui();

        if(ui.getUser() == null){
            System.out.println("Enter new username and password");
            //make scanner
            ui.newAccount(username, password); 
        }

        try {
            ui.startNewGame(filepath, playerDescription, isInfinite);
        } catch (Exception e) {
            System.out.println("Couldn't start new game: " + e);
        }

        MUDGame game = ui.getGame();
        Account user = ui.getUser();

        if(game != null){
            System.out.println("Resume game in progress?");
            //make scanner
        }
        else{
            try {
                ui.startNewGame(filepath, playerDescription, isInfinite);
            } catch (Exception e) {
                System.out.println("Error making game: " + e);
            }
        }

        PlayerCharacter player = game.getPlayer();

        while(true){

            while(player.isAlive() && !game.gameOver()){
                System.out.println("Turn " + game.getTurns());
                try {
                    game.takeTurn(); 
                } catch (MUDException e) {
                    System.out.println("Invalid move");
                }
            }

            System.out.println("Game Over!");

            int lives = 0;

            if(player.isAlive()){
                System.out.println("You deafeated all the enenies and won!");
            }
            else{
                System.out.println("L + Ratio");
                lives = 1;
            }

            user.updateStats(1, lives, player.getEnemiesSlain(), player.getGold(), player.getItemsFound());

            System.out.println("Play again? Y/N");

            //make scanner
            String playAgain = "n";

            if(playAgain.toLowerCase().equals("y")){
                try{
                    ui.startNewGame(filepath, playerDescription, isInfinite);
                    game = ui.getGame();
                    user = ui.getUser();
                } 
                catch (Exception e){
                    System.out.println("Couldn't start new game: " + e);
                }
            }
            else{
                break;
            }

        }
    }
}
