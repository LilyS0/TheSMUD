package model;

public interface Consumable extends Item{
    /*
     * Represents an Item that a player can consume one time to give some stat boost
     */
    public int getStat();
}
