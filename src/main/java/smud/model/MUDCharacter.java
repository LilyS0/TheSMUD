package smud.model;
/**
 * Interface that contains information shared by both NPC and PlayerCharacter.
 * 
 * @author Sydney Wilson
 */
public interface MUDCharacter {
    public String getName();

    public String getDescription();

    public int getHealth();

    public int getAttack();

    public int getDefense();

    public boolean isAlive();

    public void attack(MUDCharacter character);

    public void defend();
}
