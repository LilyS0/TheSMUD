package smud.model.Character;

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

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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
        }
        
    }

    public void attack(MUDCharacter target){
        target.takeDamage(this.getAttack());
    }

}
