package smud.model.Item.Armor;

public class ChainMailArmor extends Armor{
    /*
     * Represents chain mail Armor
     */

    public ChainMailArmor(){
        this.defense = 3;
    }

    @Override
    public String toString(){
        return "Chain Mail Amror (defense: " + this.defense + ") ";
    }
}
