package model;
/**
 * NPC implements the Character class amnd inherits the functionality associated with it, and adds
 * additional information associated with the NPC such as nocturnal/diurnal.
 * 
 * @author Sydney Wilson
 */
public class NPC extends Character{
    public boolean isNocturnal;

    public boolean getNocturnal() {
        return this.isNocturnal;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    @Override
    public int getHealth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHealth'");
    }

    @Override
    public int getAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAttack'");
    }

    @Override
    public int getDefense() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDefense'");
    }
}
