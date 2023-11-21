package smud.model.Item.Weapons;

public class Sword extends Weapon{
    /*
     * Represents a sword Weapon
     */

    public Sword(){
        this.damage = 5;
    }

    @Override
    public String toString(){
        return "Sword (attack: " + this.damage + ") ";
    }
}


