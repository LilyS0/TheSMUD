package smud.persistence.JSON;

import smud.controller.MUDGame;
import smud.controller.PlayerController;
import smud.model.Account;
import smud.persistence.AccountDAO;

public class JSONAccountDAO implements AccountDAO{

    @Override
    public Account getAccount(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccount'");
    }

    @Override
    public Account createAccount(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }

    @Override
    public Account loginAccount(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginAccount'");
    }

    @Override
    public boolean logoutAccount(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logoutAccount'");
    }

    @Override
    public PlayerController getPlayer(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayer'");
    }

    @Override
    public int getGamesPlayed(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGamesPlayed'");
    }

    @Override
    public int getLivesLost(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLivesLost'");
    }

    @Override
    public int getMonstersSlain(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMonstersSlain'");
    }

    @Override
    public int getTotalGold(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalGold'");
    }

    @Override
    public int getItemsFound(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItemsFound'");
    }

    @Override
    public MUDGame getCurrentGame(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentGame'");
    }
    
}
