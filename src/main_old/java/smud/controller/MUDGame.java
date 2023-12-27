package smud.controller;

import java.io.IOException;
import java.util.Scanner;

import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Character.PlayerCharacter;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.Tile;
import smud.model.Environment.Tiles.TrapTile;
import smud.model.Environment.map.InfiniteMap;
import smud.model.Environment.map.MUDMap;
import smud.model.Environment.map.PremadeMap;
import smud.model.Environment.room.Room;

public class MUDGame{
    /*
     * Main class to run the program. Controls the main gameplay loop.
     * 
     * @author Ty Platow
     */
    private MUDMap map;
    private PlayerController playerController;
    private Scanner scanner = new Scanner(System.in);
    private boolean isDay;
    private int turns;

    public MUDGame(String filepath, String playerName, String playerDescription, boolean isInfinite) throws IOException, MUDException{

        if(isInfinite){
            this.map = new InfiniteMap();
        }
        else{
            this.map = new PremadeMap(filepath);
        }
        this.playerController = new PlayerController(new PlayerCharacter(playerName, playerDescription), map);
        this.playerController.getCurrRoom(map).getTile(getPlayerX(), getPlayerX()).occupy(getPlayer());
        this.isDay = true;
        this.turns = 1;
    }

    public void takeTurn() throws MUDException{

        //options during turn: move to adjacent tile if its not blocked, attack one adjacent creature, move through an exit, examine/interact with item(s) on their tile, disarm adjacent traps, at end of turn player is attacked by adjacent creatures.
        turns ++;
        playerController.useBuffs();
        System.out.println(playerController.getCurrRoom(map));
        Tile[] adjacentTiles = playerController.getAdjacentTiles(map);
        System.out.println(playerController.getCharacter());
        System.out.println("Move[w,a,s,d] Inventory[i]");
        String action;
        if(scanner.hasNextLine() == false || scanner == null){
            scanner = new Scanner(System.in);
            action = scanner.nextLine().toLowerCase();
        }else{
            action = scanner.nextLine().toLowerCase();
        }
        

        
        if(action.equals("x")){
            System.out.println("Turn ended");
        }
        else if(action.equals("i")){
            System.out.println("Inventory: " + playerController.getCharacter().getInventory());
            System.out.println("Enter the location of the item you wish to use or 0 to exit: ");
            int location = 0;

            try{
                location = scanner.nextInt();
            }
            catch(Exception e){
                
            }

            if(location > 0){
                playerController.applyItem(location);
                System.out.println("Item applied!");
            }
        }
        else{
            playerController.makeMove(action, map);
        }

        for(Tile tile: adjacentTiles){
            if(tile instanceof CharacterTile){
                CharacterTile ct = (CharacterTile)tile;
                MUDCharacter enemy = ct.getCharacter();
                getPlayer().takeDamage(enemy.getAttack());
            }
            if(tile instanceof TrapTile){
                TrapTile tt = (TrapTile)tile;
                tt.detect();
            }
        }

        if(turns%10 == 0){
            updateTime();
            if(isDay){
                System.out.println("It is now daytime");
            }
            else{
                System.out.println("It is now night time");
            }
        }
    }

    public int getPlayerX(){
        return playerController.getX();
    }

    public int getPlayerY(){
        return playerController.getY();
    }

    public Room getPlayerRoom(){
        return playerController.getCurrRoom(map);
    }

    public MUDMap getMap(){
        return map;
    }

    public PlayerCharacter getPlayer(){
        return playerController.getCharacter();
    }

    public PlayerController getController(){
        return playerController;
    }

    public int getTurns(){
        return turns;
    }

    public boolean isDay(){
        return isDay;
    }

    public void updateTime() {
        isDay = !isDay;
        
    }

    public boolean gameOver(){
        try {
            if(playerController.getCurrRoom(map) == map.getEndRoom() && map.getEndRoom().roomCleared()){
                return true;
            }
        }catch (Exception e){
            
        }
        return false;
    }
}
