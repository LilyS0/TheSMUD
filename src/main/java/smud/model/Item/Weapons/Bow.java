package smud.model.Item.Weapons;

import smud.model.Character.PlayerCharacter;

public class Bow extends Weapon{
    /*
     * Represents a bow Weapon
     */

    public Bow(){
        this.damage = 3;
        this.value = 15;
    }

    @Override
    public String toString(){
        return "Bow (attack: " + this.damage + ")";
    }

    @Override
    public void applyItem(PlayerCharacter player) {
        player.setWeapon(this);
    }
}
