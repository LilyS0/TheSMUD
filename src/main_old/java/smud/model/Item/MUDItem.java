package smud.model.Item;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import smud.model.Character.PlayerCharacter;
import smud.model.Item.Armor.Armor;
import smud.model.Item.Buffs.Buff;
import smud.model.Item.Food.Food;
import smud.model.Item.Weapons.Weapon;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({@Type(value = Armor.class, name = "Armor"), @Type(value = Buff.class, name = "Buff"), @Type(value = Food.class, name = "Food"), @Type(value = Weapon.class, name = "Weapon")})

public interface MUDItem {
    /* 
     * Represents an Item that a player can pick up and use
     */

    public int getStat();

    public int getValue();

    public void applyItem(PlayerCharacter player);

    public static MUDItem getRandomItem(){

        MUDItem[] armor = Armor.getChildren();
        MUDItem[] weapons = Weapon.getChildren();
        MUDItem[] buffs = Buff.getChildren();
        MUDItem[] food = Food.getChildren();

        MUDItem[][] items = {armor, weapons, buffs, food};
        //MUDItem[][] items = {buffs};
        
        Random random = new Random();
        int type = random.nextInt(items.length);
        int item = random.nextInt(items[type].length);

        return items[type][item];
    }

    public static MUDItem[] getRandomItems(){

        Random random = new Random();
        int itemAmount = random.nextInt(3);
        itemAmount ++;
        MUDItem[] items = new MUDItem[itemAmount];

        for(int i=0; i<itemAmount; i++){
            items[i] = getRandomItem();
        }

        return items;
    }

    @Override
    public String toString();

}
