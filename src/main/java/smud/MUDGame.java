package smud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import smud.controller.PlayerController;
import smud.model.MUDCharacter;
import smud.model.MUDException;
import smud.model.PlayerCharacter;
import smud.model.Environment.Room;
import smud.model.Environment.MUDMap;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.ItemTile;
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
        System.out.println(buildPrompString());
        String action = scanner.nextLine().toLowerCase();
        ArrayList<TileFeature> adjacentTiles = playerController.getAdjacentTiles();

        if(action.equals("x")){
            System.out.println("Turn ended");
        } 
        else if (action.equals("e")){
            boolean exitAdjacent = false;
            for(TileFeature tile: adjacentTiles){
                if(tile instanceof ExitTile){
                    exitAdjacent = true;
                    ExitTile exit = (ExitTile)tile;
                    System.out.println("Moving to room + " + exit.getTarget().getId());
                    playerController.setCurrRoom(exit.getTarget());
                }
            }
            if(!exitAdjacent){
                throw new MUDException("No exit there");
            }
        }
        else if(action.equals("t")){
            boolean trapAdjacent = false;
            for(TileFeature tile: adjacentTiles){
                if(tile instanceof TrapTile){
                    trapAdjacent = true;
                    TrapTile trap = (TrapTile)tile;
                    trap.disarm(player);
                }
            }
            if(!trapAdjacent){
                throw new MUDException("No trap there");
            }
        }
        else if(action.equals("f")){
            boolean npcAdjacent = false;
            for(TileFeature tile: adjacentTiles){
                if(tile instanceof CharacterTile){
                    npcAdjacent = true;
                    CharacterTile npcTile = (CharacterTile)tile;
                    player.attack(npcTile.getCharacter());
                    npcTile.getCharacter().attack(player);
                }
            }
            if(!npcAdjacent){
                throw new MUDException("No NPC there");
            }
        }
        else{
            playerController.makeMove(action);
            
        }
    }

    public String buildPrompString(){
        ArrayList<TileFeature> adjacentTiles = playerController.getAdjacentTiles();
        String promptString = "This turn you can: \n";

        for(TileFeature tile: adjacentTiles){
        
            if(tile instanceof TrapTile){

                TrapTile trapTile = (TrapTile)tile;
                if(trapTile.isDetected()){
                    promptString += "Disarm a trap (t), ";
                }
            }
            else if(tile instanceof EmptyTile || tile instanceof ItemTile){

                promptString += "Move (w,a,s,d), ";
            }
            else if(tile instanceof ExitTile){

                ExitTile exit = (ExitTile)tile;
                promptString += "Exit to room " + exit.getTarget().getId() + " (e),";
            }
            else if(tile instanceof CharacterTile){

                CharacterTile charTile = (CharacterTile)tile;
                MUDCharacter npc = charTile.getCharacter();
                promptString += "Attack an enemy with " + npc.getAttack() + " attack " + npc.getDefense() + " defense and " + npc.getHealth() + " health (f), ";

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
