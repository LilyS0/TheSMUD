package smud.model.Item.Weapons;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import smud.model.Item.Equipable;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({@Type(value = Axe.class, name = "Axe"), @Type(value = Bow.class, name = "Bow"), @Type(value = Sword.class, name = "Sword")})


public abstract class Weapon implements Equipable {

    /*
     * Represents a Weapon Item that a player can equip to their weapon slot
     */

    @JsonProperty
    String name = "Weapon";

    @JsonProperty ("stat")
    protected int damage;
    protected int value;
    private static Weapon[] children = {new Axe(), new Bow(), new Sword()};

    public int getStat(){
        return damage;
    }

    public int getValue(){
        return value;
    }
    
    public static Weapon[] getChildren(){
        return children;
    }
}
