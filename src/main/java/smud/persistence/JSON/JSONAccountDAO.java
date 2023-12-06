package smud.persistence.JSON;

import smud.persistence.AccountDAO;
import smud.persistence.Mementos.AccountMemento;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONAccountDAO implements AccountDAO{

    private final ObjectMapper mapper = new ObjectMapper();
    private final String FILEPATH = "src/data/accounts.json";
    private Map<String, AccountMemento> accounts;

    public JSONAccountDAO(){
        this.accounts = new HashMap<>();
    }

    @Override
    public AccountMemento getAccountMemento(String username) {
        return accounts.get(username);
    }

    @Override
    public Map<String, AccountMemento> getAccountMementos() {
        return accounts;
    }

    @Override
    public void addAccountMemento(AccountMemento memento) {
        accounts.put(memento.getUsername(), memento);
    }

    @Override
    public void saveData() {
        try {
            mapper.writeValue(new File(FILEPATH), accounts);
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't process data: ");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("File error: ");
            e.printStackTrace();
        }
    }

    @Override
    public void loadData() {
        try {
            accounts = mapper.readValue(new File(FILEPATH), new TypeReference<Map<String, AccountMemento>>() {});
        } catch (IOException e) {
            // System.out.println("File error: ");
            // e.printStackTrace();
        }
    }
}
