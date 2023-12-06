package smud.persistence.JSON;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import smud.persistence.MapDAO;
import smud.persistence.Mementos.MapMemento;

public class JSONMapDAO implements MapDAO{

    private final ObjectMapper mapper = new ObjectMapper();
    private final String FILEPATH = "src/data/maps.json";
    private Set<MapMemento> maps;

    public JSONMapDAO(){
        this.maps = new HashSet<>();
    }

    @Override
    public Set<MapMemento> getMapMementos() {
        return maps;
    }

    @Override
    public void addMapMemento(MapMemento map) {
        maps.add(map);
    }

    @Override
    public void saveData() {
        try {
            mapper.writeValue(new File(FILEPATH), maps);
        } catch (Exception e) {
            System.out.println("Couldn't save data: ");
            e.printStackTrace();
        }
    }

    @Override
    public void loadData() {
        try {
            maps = mapper.readValue(new File(FILEPATH), new TypeReference<Set<MapMemento>>() {});
        } catch (Exception e) {
            System.out.println("Couldn't load data: ");
            e.printStackTrace();
        } 
    }
}
