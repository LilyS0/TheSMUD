package smud.persistence.Mementos;

import smud.controller.MUDGame;
import smud.controller.PlayerController;

public class AccountMemento {
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

    public AccountMemento(String username, String hashedPassword, PlayerController player, int gamesPlayed, int livesLost, int monstersSlain, int totalGold, int itemsFound, MUDGame currentGame, MUDGame infinite){
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.player = player;
        this.gamesPlayed = gamesPlayed;
        this.livesLost = livesLost;
        this.monstersSlain = monstersSlain;
        this.totalGold = totalGold;
        this.itemsFound = itemsFound;
        this.currentGame = currentGame;
        this.infinite = infinite;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public PlayerController getPlayer() {
        return player;
    }
    public void setPlayer(PlayerController player) {
        this.player = player;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    public int getLivesLost() {
        return livesLost;
    }
    public void setLivesLost(int livesLost) {
        this.livesLost = livesLost;
    }
    public int getMonstersSlain() {
        return monstersSlain;
    }
    public void setMonstersSlain(int monstersSlain) {
        this.monstersSlain = monstersSlain;
    }
    public int getTotalGold() {
        return totalGold;
    }
    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }
    public int getItemsFound() {
        return itemsFound;
    }
    public void setItemsFound(int itemsFound) {
        this.itemsFound = itemsFound;
    }
    public MUDGame getCurrentGame() {
        return currentGame;
    }
    public void setCurrentGame(MUDGame currentGame) {
        this.currentGame = currentGame;
    }
    public MUDGame getInfinite() {
        return infinite;
    }
    public void setInfinite(MUDGame infinite) {
        this.infinite = infinite;
    }
}
