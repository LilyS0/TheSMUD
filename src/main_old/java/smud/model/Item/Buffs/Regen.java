package smud.model.Item.Buffs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import smud.model.Character.PlayerCharacter;

@JsonTypeInfo(property="smud.model.Item.Buffs.Regen", use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)

public class Regen extends Buff{
    /*
     * Represents health regen Buff
     * Gives the player health back overtime
     */

    @JsonProperty
    String name = "Regen";

    public Regen(){
        this.buffAmount = random.nextInt(10)+1;
        this.value = buffAmount * 5;
        this.buffType = "Regen";
        this.turns = 10;
    }

    @Override
    public String toString(){
        return "Regen Buff (+" + buffAmount + ")";
    }

    @Override
    public void useBuff(PlayerCharacter player){
        player.addHealthBuff(buffAmount);
        useTurn();
    }

    @Override
    public void removeBuff(PlayerCharacter player) {
        player.subHealthBuff(buffAmount);
        player.removeBuff(this);
    }
}
