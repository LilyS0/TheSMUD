package smud.persistence;

import smud.controller.PlayerController;
import smud.model.Environment.map.MUDMap;

public interface GameDAO {
    public MUDMap getMap();
    public PlayerController getPlayerController();
    public boolean isDay();
    public int turns();
}
