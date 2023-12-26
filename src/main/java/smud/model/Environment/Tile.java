package smud.model.Environment;

import java.util.ArrayList;

import smud.model.SMUDCharacter;
import smud.model.Cards.Card;
import smud.model.Cards.NPC;

public class Tile implements DungeonElement{

    private Card card;
    private SMUDCharacter character;

    public Tile(){
        this.card = null;
        this.character = null;
    }

    public void occupy(SMUDCharacter character){
        if(card != null && character == null){
            if(card.canOccupy()){
                this.character = character;
            }
        }
        else if(card == null && character == null){
            this.character = character;
        }
        else{
            //throw smud exception
        }
    }

    @Override
    public void updateTime(boolean isDay) {
        if(card != null){
            card.updateTime(isDay);
        }
    }

    @Override
    public ArrayList<NPC> getMonsters() {
        throw new UnsupportedOperationException("Unimplemented method 'getMonsters'");
    }

    @Override
    public ArrayList<DungeonElement> getChildren() {
        throw new UnsupportedOperationException("Unimplemented method 'getChildren'");
    }

    //setters

    public void setCard(Card card) {
        if(card == null){
            this.card = card;
        }
        else{
            // throw smud exception
        } 
    }

    //getters

    public Card getCard() {
        return card;
    }

    public SMUDCharacter getCharacter() {
        return character;
    }
}
