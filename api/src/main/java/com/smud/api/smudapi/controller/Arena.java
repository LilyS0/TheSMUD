package com.smud.api.smudapi.controller;

import com.smud.api.smudapi.model.SMUDCharacter;
import com.smud.api.smudapi.model.Environment.Board;

public class Arena implements SMUDController{
    private Board board;

    public Arena(SMUDCharacter player1, SMUDCharacter player2){
        this.board = new Board(player1, player2);
    }
}
