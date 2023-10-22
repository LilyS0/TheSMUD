package smud.model;
/**
 * NPC implements the Character class amnd inherits the functionality associated with it, and adds
 * additional information associated with the NPC such as nocturnal/diurnal.
 * 
 * @author Sydney Wilson
 */
public class NPC extends MUDCharacter{
    public boolean isNocturnal;

    public boolean getNocturnal() {
        return this.isNocturnal;
    }

    
}
