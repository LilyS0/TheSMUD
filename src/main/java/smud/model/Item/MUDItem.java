package smud.model.Item;

import java.util.Random;

import smud.model.Item.Armor.Armor;
import smud.model.Item.Buffs.Buff;
import smud.model.Item.Food.Food;
import smud.model.Item.Weapons.Weapon;

public interface MUDItem {
    /* 
     * Represents an Item that a player can pick up and use
     */
    public int getStat();

    public static MUDItem getRandomItem(){

        MUDItem[] armor = Armor.getChildren();
        MUDItem[] weapons = Weapon.getChildren();
        MUDItem[] buffs = Buff.getChildren();
        MUDItem[] food = Food.getChildren();

        MUDItem[][] items = {armor, weapons, buffs, food};
        
        Random random = new Random();
        int type = random.nextInt(items.length);
        int item = random.nextInt(items[type].length);

        return items[type][item];
    }

    public static MUDItem[] getRandomItems(){

        Random random = new Random();
        int itemAmount = random.nextInt(3);
        MUDItem[] items = new MUDItem[itemAmount];

        for(int i=0; i<itemAmount; i++){
            items[i] = getRandomItem();
        }

        return items;
    }

}
