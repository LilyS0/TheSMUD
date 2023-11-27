package smud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Character.PlayerCharacter;
import smud.model.Environment.Room;
import smud.model.Environment.MUDMap;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.TileFeature;
import smud.model.Environment.Tiles.TrapTile;

public class MUDGame {
    /*
     * Main class to run the program. Controls the main gameplay loop.
     * 
     * @author Ty Platow
     */
    private MUDMap map;
    private PlayerCharacter player;
    private PlayerController playerController;
    private final Scanner scanner = new Scanner(System.in);


    public MUDGame(String filepath, String playerName, String playerDescription) throws IOException, MUDException{

        this.map = new MUDMap(filepath);
        this.player = new PlayerCharacter(playerName, playerDescription);
        this.playerController = new PlayerController(player, map);
        this.playerController.getCurrRoom().getTile(getPlayerX(), getPlayerX()).occupy(player);
    }

    public void takeTurn() throws MUDException{

        //options during turn: move to adjacent tile if its not blocked, attack one adjacent creature, move through an exit, examine/interact with item(s) on their tile, disarm adjacent traps, at end of turn player is attacked by adjacent creatures.
        System.out.println(playerController.getCurrRoom());
        ArrayList<TileFeature> adjacentTiles = playerController.getAdjacentTiles();
        System.out.println("Health: " + player.getHealth() + ", Attack: " + player.getAttack() + ", Defense: " + player.getDefense() + ", Buffs: " + player.getActiveBuffs() + ", Inventory: " + player.getInventory());
        System.out.println(buildPrompString(adjacentTiles));
        String action = scanner.nextLine().toLowerCase();

        
       
        if(action.equals("x")){
            System.out.println("Turn ended");
        }
        else if(action.equals("i")){
            System.out.println("Inventory: " + playerController.getCharacter().getInventory());
        }
        else{
            playerController.makeMove(action);
        }

        for(TileFeature tile: adjacentTiles){
            if(tile instanceof CharacterTile){
                CharacterTile ct = (CharacterTile)tile;
                MUDCharacter enemy = ct.getCharacter();
                player.takeDamage(enemy.getAttack());
            }
        }

        
        
    }

    public String buildPrompString(ArrayList<TileFeature> adjacentTiles){
        String promptString = "This turn you can: \n";
        boolean move = false;

        for(TileFeature tile: adjacentTiles){
        
            if(tile instanceof TrapTile){

                TrapTile trapTile = (TrapTile)tile;
                if(trapTile.isDetected()){
                    promptString += "Disarm a trap, ";
                }
            }
            else if(tile instanceof EmptyTile && !move){
                move = true;
                promptString += "Move (w,a,s,d), ";
            }
            else if(tile instanceof ExitTile){

                ExitTile exit = (ExitTile)tile;
                promptString += "Exit to room " + exit.getTarget().getId() + ",";
            }
            else if(tile instanceof CharacterTile){

                CharacterTile charTile = (CharacterTile)tile;
                MUDCharacter npc = charTile.getCharacter();
                promptString += "Attack an enemy with " + npc.getAttack() + " attack, " + npc.getDefense() + " defense and " + npc.getHealth() + " health, ";

            }
        }

        promptString += "or you can choose to end your turn (x)";

        return promptString;
    }

    public int getPlayerX(){
        return playerController.getX();
    }

    public int getPlayerY(){
        return playerController.getY();
    }

    public Room getPlayerRoom(){
        return playerController.getCurrRoom();
    }

    public MUDMap getMap(){
        return map;
    }

    public PlayerCharacter getPlayer(){
        return player;
    }
}
