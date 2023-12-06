package smud.persistence;

import java.util.Set;

import smud.persistence.Mementos.MapMemento;

public interface MapDAO {
    public Set<MapMemento> getMapMementos();
    public void addMapMemento(MapMemento map);
    public void saveData();
    public void loadData();
}
