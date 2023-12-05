package smud.model.Item;

import smud.model.Character.PlayerCharacter;

public interface Equipable extends MUDItem{
    /*
     * Represents an Item that a player can equip to a slot in their inventory
     */
    public int getStat();
    public int getValue();

    public void applyItem(PlayerCharacter player);
}
