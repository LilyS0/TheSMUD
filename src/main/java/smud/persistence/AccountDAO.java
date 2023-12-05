package smud.persistence;

import smud.controller.MUDGame;
import smud.controller.PlayerController;
import smud.model.Account;

public interface AccountDAO {

    public Account getAccount(String username);
    public Account createAccount(String username);
    public Account loginAccount(String username);
    public boolean logoutAccount(String username);
    public PlayerController getPlayer(String username);
    public int getGamesPlayed(String username);
    public int getLivesLost(String username);
    public int getMonstersSlain(String username);
    public int getTotalGold(String username);
    public int getItemsFound(String username);
    public MUDGame getCurrentGame(String username);
    
}
