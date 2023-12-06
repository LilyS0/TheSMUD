package smud.persistence;

import java.util.Map;

import smud.persistence.Mementos.AccountMemento;

public interface AccountDAO {

    public AccountMemento getAccountMemento(String username);
    public Map<String, AccountMemento> getAccountMementos();
    public void addAccountMemento(AccountMemento memento);
    public void saveData();
    public void loadData();
    
}
