package smud.model.Environment;

import java.util.ArrayList;

import smud.model.Cards.NPC;

/*
 * <<component>> in the composite pattern for environment subsystem
 * represents a part of the dungeon (tile, room, board, whole dungeon)
 */

public interface DungeonElement {
    public void updateTime(boolean isDay);
    public ArrayList<NPC> getMonsters();
    public ArrayList<DungeonElement> getChildren();
}
