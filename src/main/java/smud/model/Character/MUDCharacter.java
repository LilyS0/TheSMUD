package smud.model.Character;

import smud.model.Item.MUDItem;

/**
 * Interface that contains information shared by both NPC and PlayerCharacter.
 * 
 * @author Sydney Wilson
 */
public abstract class MUDCharacter {
    protected String name;
    protected String description;
    protected int health;
    protected Inventory inventory;
    protected int attack;
    protected int defense;
    protected MUDItem[] items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int amount){
        health += amount;
    }

    public int getAttack() {
        return attack;
    }

    public void addAttack(int amount){
        attack += amount;
    }

    public void subtractAttack(int amount){
        attack -= amount;
    }

    public int getDefense() {
        return defense;
    }

    public void addDefense(int amount){
        defense += amount;
    }

    public void subtractDefense(int amount){
        defense -= amount;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addItemsToInv(MUDItem[] items){
        for(MUDItem item: items){
            inventory.addItem(item);
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void takeDamage(int attackValue){
        int damage = attackValue-this.getDefense();
        if(damage <= 0){
            damage = 1;
        }
        if(damage < health){
            health -= damage;
        }
        else{
            health = 0;

            String result = "";

            for(MUDItem item: items){
                result += item + ", ";
            }
            
            System.out.println(name + " has dropped " + result);
        }
        
    }

    public MUDItem[] getItems(){
        return items;
    }

    public void setItems(MUDItem[] items){
        this.items = items;
    }

    public void attack(MUDCharacter target){
        target.takeDamage(this.getAttack());
    }

}
