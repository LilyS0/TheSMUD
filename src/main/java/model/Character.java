/**
 * Interface that contains information shared by both NPC and PlayerCharacter.
 * 
 * @author Sydney Wilson
 */
public interface Character {
    public String name;
    public String decription;
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

    // OTHER METHODS WILL INCLUDE:
    // attack(enemy), defend() 
}
