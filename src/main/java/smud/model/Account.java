package smud.model;

import smud.controller.MUDGame;
import smud.controller.PlayerController;
import smud.persistence.Mementos.AccountMemento;

/**
 * An account will track the users progress, as well as hold data necessary for persistence.
 * An account is accessed by entering the correct credentials.
 *
 * @author Sydney Wilson
 */
public class Account {
    private String username;
    private String hashedPassword;
    private PlayerController player;
    private int gamesPlayed;
    private int livesLost;
    private int monstersSlain;
    private int totalGold;
    private int itemsFound;
    private MUDGame currentGame;
    private MUDGame infinite;

    public Account(String username, String password) {
        this.username = username;
        this.hashedPassword = hashPassword(password);
    }

    public boolean authenticate(String password) {
        String hashedInputPassword = hashPassword(password);
        return hashedInputPassword.equals(hashedPassword);
    }

    public boolean changePassword(String oldPW, String newPW){
        if(authenticate(oldPW)){
            this.hashedPassword = hashPassword(newPW);
            System.out.println("Password changed successfully");
            return true;
        }
        else{
            System.out.println("Incorrect password");
            return false;
        }
    }

    public static String hashPassword(String password) {
        int prime = 7;
        int hash = 0;

        for (int i = 0; i < password.length(); i++) {
            hash = prime * hash + password.charAt(i);
        }

        return Integer.toHexString(hash);
    }

    public void updateStats(int games, int lives, int monsters, int gold, int items){
        this.gamesPlayed += games;
        this.livesLost += lives;
        this.monstersSlain += monsters;
        this.totalGold += gold;
        this.itemsFound += items;
    }

    public void setMemento(AccountMemento memento){
        this.username = memento.getUsername();
        this.hashedPassword = memento.getHashedPassword();
        this.player = memento.getPlayer();
        this.gamesPlayed = memento.getGamesPlayed();
        this.livesLost = memento.getLivesLost();
        this.monstersSlain = memento.getMonstersSlain();
        this.totalGold = memento.getTotalGold();
        this.itemsFound = memento.getItemsFound();
        //this.currentGame = memento.getCurrentGame();
        //this.infinite = memento.getInfinite();
    }

    public AccountMemento createMemento(){
        return new AccountMemento(username, hashedPassword, player, gamesPlayed, livesLost, monstersSlain, totalGold, itemsFound, null, null);
    }

    public void joinInfiniteGame(MUDGame game){
        this.infinite = game;
    }

    public void startNewGame(MUDGame game){
        this.currentGame = game;
    }

    public void setPlayer(PlayerController player){
        this.player = player;
    }

    public PlayerController getPlayer(){
        return this.player;
    }
    
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getLivesLost() {
        return livesLost;
    }

    public int getMonstersSlain() {
        return monstersSlain;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public int getItemsFound() {
        return itemsFound;
    }

    public String getUsername() {
        return username;
    }

    public MUDGame getCurrentGame() {
        return currentGame;
    }

    public MUDGame getInfiniteGame() {
        return infinite;
    }

    public static void main(String[] args) {
        String username = "sydney";
        String pword = "abcdefg";
        Account a = new Account(username, pword);
        boolean works = a.authenticate(pword);
        System.out.println(works);
    }
}