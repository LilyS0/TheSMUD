package smud.model.Item.Food;

public class Bread extends Food{
    /*
     * Represents a bread Food Item
     */

    public Bread(){
        this.health = 3;
    }

    @Override
    public String toString(){
        return "Bread";
    }
}
