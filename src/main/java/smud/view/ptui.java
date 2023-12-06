package smud.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import smud.controller.MUDGame;
import smud.model.Account;
import smud.model.MUDException;
import smud.model.Character.PlayerCharacter;
import smud.persistence.JSON.JSONAccountDAO;
import smud.persistence.Mementos.AccountMemento;

public class ptui {
    
    private Account user;

    public ptui(){}

    public MUDGame getGame(){
        return user.getCurrentGame();
    }

    public void newAccount(Scanner scan){
        System.out.println("Enter New Username: ");
        String username = scan.nextLine();
        System.out.println("Enter New Password: ");
        String password = scan.nextLine();

        user = new Account(username, password);
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

        String filepath = "src/main/java/smud/model/Environment/map/maps/map2.txt";
        boolean isInfinite;
        JSONAccountDAO accountDAO = new JSONAccountDAO();
        ptui ui = new ptui();
        Scanner scan = new Scanner(System.in);

        accountDAO.loadData();
        Map<String, AccountMemento> accountMementos = accountDAO.getAccountMementos();
        Map<String, Account> accounts =  new HashMap<>();
    
        for(String key: accountMementos.keySet()){
            Account acc = new Account("", "");
            acc.setMemento(accountMementos.get(key));
            accounts.put(key, acc);
        }


        if(accountMementos.size() == 0){
            //prompt user to create account
            ui.newAccount(scan);
        }
        else{
            while(ui.getUser() == null){
                System.out.println("Login or Create Account? ");
                String choice = scan.nextLine().toLowerCase().strip();

                if(choice.equals("create")){
                    ui.newAccount(scan);
                }
                else if(choice.equals("login")){
                    System.out.println("Enter username: ");
                    String username = scan.nextLine();
                    Account account;
                    try {
                        account = accounts.get(username);
                        System.out.println("Enter password: ");
                        String password = scan.nextLine();
                        if(!account.authenticate(password)){
                            System.out.println("Incorrect password");
                            account = null;
                        }
                    } catch (Exception e) {
                        System.out.println("Incorrect username");
                        account = null;
                    }
                    ui.setAccount(account);
                }
                else{
                    System.out.println("Not an option");
                }
            }   
        }

        System.out.println("Enter a player description: ");
        String playerDescription = scan.nextLine();

        System.out.println("Infinite game? (Y/N)");
        String choice = scan.nextLine().toLowerCase().strip();
        if(choice.equals("y")){
            isInfinite = true;
        }
        else{
            isInfinite = false;
        }

        try {
            ui.startNewGame(filepath, playerDescription, isInfinite);
        } catch (Exception e) {
            System.out.println("Couldn't start new game: " + e);
        }

        MUDGame game = ui.getGame();
        Account user = ui.getUser();
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
            String playAgain = scan.nextLine().toLowerCase().strip();

            if(playAgain.equals("y")){
                try{
                    System.out.println("Infinite game? (Y/N)");
                    choice = scan.nextLine().toLowerCase().strip();
                    if(choice.equals("y")){
                        isInfinite = true;
                    }
                    else{
                        isInfinite = false;
                    }
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

        AccountMemento accountMemento = user.createMemento();

        accountDAO.addAccountMemento(accountMemento);
        accountDAO.saveData();
        scan.close();
    }
}
