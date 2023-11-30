package smud.model.Item;

import smud.model.Character.PlayerCharacter;

public interface Consumable extends MUDItem{
    /*
     * Represents an Item that a player can consume one time to give some stat boost
     */
    public int getStat();
    public int getValue();

    public void applyItem(PlayerCharacter player);
}
