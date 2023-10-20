package smud.model;
/**
 * Interface that contains information shared by both NPC and PlayerCharacter.
 * 
 * @author Sydney Wilson
 */
// MAKE THIS AN INTEFACE
public abstract class MUDCharacter {
    public String name;
    public String description;
    public int health;
    public int attack;
    public int defense;

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
        return this.health;
    }

    public int getDefense() {
        return this.defense;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    // OTHER METHODS WILL INCLUDE:
    // attack(enemy), defend() 
}