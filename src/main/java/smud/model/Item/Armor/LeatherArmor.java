package smud.model.Item.Armor;

public class LeatherArmor extends Armor{
    /*
     * Represents leather Armor 
     */
    
    public LeatherArmor(){
        this.defense = 1;
    }

    @Override
    public String toString(){
        return "Leather Amror (defense: " + this.defense + ") ";
    }
}
