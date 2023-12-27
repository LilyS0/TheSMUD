package smud.model.Item.Buffs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Buffs.Strength", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Strength extends Buff{
    /*
     * Represents a strength buff
     * adds some value to the players attack stat
     */

    @JsonProperty
    String name = "Strength";

    public Strength(){
        this.buffAmount = random.nextInt(5)+5;
        this.value = buffAmount * 5;
        this.buffType = "Strenght";
        this.turns = 10;
        this.activated = false;
    }

    @Override
    public String toString(){
        return "Strength Buff (+" + buffAmount + ")";
    }

    @Override
    public void useBuff(PlayerCharacter player){
        player.addAttackBuff(buffAmount);
        useTurn();
    }

    @Override
    public void removeBuff(PlayerCharacter player) {
        player.subAttackBuff(buffAmount);
        player.removeBuff(this);
    }
}
