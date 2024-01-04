package com.smud.api.smudapi.model;

import java.util.ArrayList;
import com.smud.api.smudapi.model.Cards.Card;



/*
 * represents the player that plays the game, keeps track of the players cards and stats
 */

public class Player {

    private SMUDCharacter character;
    private int gold;
    private int gems;
    private ArrayList<Card> cards;
    private int gamesPlayed;
    private int gamesWon;
    private int roomsCleared;

    public Player(SMUDCharacter character){
        this.character = character;
        this.gold = 0;
        this.gems = 0;
        this.cards = new ArrayList<>();
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.roomsCleared = 0;
    }

    public void addGold(int gold){
        this.gold += gold;
    }

    public void addGems(int gems){
        this.gems += gems;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void addCards(ArrayList<Card> cards){
        this.cards.addAll(cards);
    }

    public void gameWon(){
        gamesPlayed ++;
        gamesWon ++;
    }

    public void gameLost(){
        gamesPlayed ++;
    }

    public void clearedRoom(){
        roomsCleared ++;
    }

    //getters

    public SMUDCharacter getCharacter() {
        return character;
    }
    public int getGold() {
        return gold;
    }
    public int getGems() {
        return gems;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public int getGamesWon() {
        return gamesWon;
    }
    public int getRoomsCleared() {
        return roomsCleared;
    }

}
