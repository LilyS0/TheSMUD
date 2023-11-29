package smud.model.Item.Weapons;

import smud.model.Character.PlayerCharacter;

public class Axe extends Weapon{
    /*
     * Represents an axe Weapon 
     */
    public Axe(){
        this.damage = 7;
    }

    @Override
    public String toString(){
        return "Axe (attack: " + this.damage + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setWeapon(this);
    }
}
