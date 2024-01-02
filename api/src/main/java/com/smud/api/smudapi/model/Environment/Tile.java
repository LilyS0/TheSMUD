package com.smud.api.smudapi.model.Environment;

import java.util.ArrayList;

import com.smud.api.smudapi.model.SMUDCharacter;
import com.smud.api.smudapi.model.Cards.Card;
import com.smud.api.smudapi.model.Cards.NPCs.NPC;



/*
 * <<leaf>> in composite pattern for environment subsystem
 * represents one tile of a board or room that can hold a character or a card
 */

public class Tile implements DungeonElement{

    private Card card;
    private SMUDCharacter character;

    public Tile(){
        this.card = null;
        this.character = null;
    }

    public Tile(Card card){
        this.card = card;
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

    public void placeCard(Card card){
        if(this.card == null && this.character == null){
            this.card = card;
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

    public NPC getMonster(){
        return card.getMonster();
    }

    public Card getCard() {
        return card;
    }

    public SMUDCharacter getCharacter() {
        return character;
    }
}
