package smud.model.Item.Food;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import smud.model.Item.Consumable;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({@Type(value = Apple.class, name = "Apple"), @Type(value = Bread.class, name = "Bread"), @Type(value = Steak.class, name = "Steak")})


public abstract class Food implements Consumable{
    /*
     * Represents a Food Item that a player can consume to regain some health
     */

    @JsonProperty
    String name = "Food";

    @JsonProperty ("stat")
    protected int health;
    protected int value;
    private static Food[] children = {new Apple(), new Bread(), new Steak()};

    public int getStat(){
        return health;
    }

    public int getValue(){
        return value;
    }

    public static Food[] getChildren(){
        return children;
    }
}
