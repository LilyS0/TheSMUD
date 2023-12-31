package smud.model.Cards;

import smud.model.Cards.NPCs.NPC;

/*
 * <<state>> in state pattern for card subsytem
 * represents a card that a player can collect in PvE mode and use in PvP mode
 */

public interface Card {
    public void updateTime(boolean isDay);
    public boolean canOccupy();
    public NPC getMonster();
}
