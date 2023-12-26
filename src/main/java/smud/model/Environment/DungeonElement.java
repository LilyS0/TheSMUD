package smud.model.Environment;

import java.util.ArrayList;

import smud.model.Cards.NPC;

public interface DungeonElement {
    public void updateTime(boolean isDay);
    public ArrayList<NPC> getMonsters();
    public ArrayList<DungeonElement> getChildren();
}
