package smud.model.Item.Weapons;

import smud.model.Character.PlayerCharacter;

public class Sword extends Weapon{
    /*
     * Represents a sword Weapon
     */

    public Sword(){
        this.damage = 5;
    }

    @Override
    public String toString(){
        return "Sword (attack: " + this.damage + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setWeapon(this);
    }
}


