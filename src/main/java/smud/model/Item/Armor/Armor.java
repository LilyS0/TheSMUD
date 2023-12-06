package smud.model.Item.Armor;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import smud.model.Item.Equipable;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({@Type(value = ChainMailArmor.class, name = "ChainMailArmor"), @Type(value = IronArmor.class, name = "IronArmor"), @Type(value = LeatherArmor.class, name = "LeatherArmor")})

public abstract class Armor implements Equipable{

    /*
     * Represents an Armor Item that a player can equip to their armor slot
     */

    @JsonProperty
    String name = "Armor";

    @JsonProperty ("stat")
    protected int defense;
    protected int value;
    private static Armor[] children = {new ChainMailArmor(), new IronArmor(), new LeatherArmor()};

    public int getStat(){
        return defense;
    }

    public int getValue(){
        return value;
    }

    public static Armor[] getChildren(){
        return children;
    }
    
}
