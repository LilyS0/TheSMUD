package smud.model.Item.Armor;

public class IronArmor extends Armor{
    /* 
     * Represents iron Armor
     */

    public IronArmor(){
        this.defense = 5;
    }
    
    @Override
    public String toString(){
        return "Iron Amror (defense: " + this.defense + ") ";
    }
}
