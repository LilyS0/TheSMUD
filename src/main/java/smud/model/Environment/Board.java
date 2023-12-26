package smud.model.Environment;

import smud.model.SMUDCharacter;
import smud.model.Cards.Card;

/*
 * <<composite>> of tiles in composite pattern for environment subsystem
 * a board that players play against each other on in online PvP
 */

public class Board extends Area{

    private SMUDCharacter player1;
    private SMUDCharacter player2;
    private final int BOARD_SIZE = 13;
    private final int MIDDLE = (BOARD_SIZE/2)+1;

    public Board(SMUDCharacter player1, SMUDCharacter player2){
        this.player1 = player1;
        this.player2 = player2;
        this.tiles = new Tile[BOARD_SIZE][BOARD_SIZE];
        tiles[BOARD_SIZE-1][MIDDLE].occupy(player1);
        tiles[1][MIDDLE].occupy(player1);
    }
    
    public void placeCard(Card card, int x, int y){
        tiles[y][x].placeCard(card);
    }

    //getters

    public SMUDCharacter getPlayer1() {
        return player1;
    }

    public SMUDCharacter getPlayer2() {
        return player2;
    }
}
