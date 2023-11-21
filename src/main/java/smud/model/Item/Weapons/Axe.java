package smud.model.Item.Weapons;

public class Axe extends Weapon{
    /*
     * Represents an axe Weapon 
     */
    public Axe(){
        this.damage = 7;
    }

    @Override
    public String toString(){
        return "Axe (attack: " + this.damage + ") ";
    }
}
