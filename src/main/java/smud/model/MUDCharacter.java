package smud.model;
/**
 * Interface that contains information shared by both NPC and PlayerCharacter.
 * 
 * @author Sydney Wilson
 */
// MAKE THIS AN INTEFACE
public abstract class MUDCharacter {
    protected String name;
    protected String description;
    protected int health;
    protected int attack;
    protected int defense;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public boolean isAlive(){
        return this.health > 0;
    }
    
    public void takeDamage(int attackValue){
        int damage = attackValue-this.getDefense();
        if(damage <= 0){
            damage = 1;
        }
        this.health -= defense;
    }

    public void attack(MUDCharacter target){
        target.takeDamage(this.getAttack());
    }
}
