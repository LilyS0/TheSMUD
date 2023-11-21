package smud.model.Item.Weapons;

public class Bow extends Weapon{
    /*
     * Represents a bow Weapon
     */

    public Bow(){
        this.damage = 3;
    }

    @Override
    public String toString(){
        return "Bow (attack: " + this.damage + ") ";
    }
}
