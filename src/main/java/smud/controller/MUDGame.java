package smud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Character.NPC;
import smud.model.Character.PlayerCharacter;
import smud.model.Environment.Room;
import smud.model.Environment.MUDMap;
import smud.model.Environment.Tiles.CharacterTile;
import smud.model.Environment.Tiles.TileFeature;
import smud.model.Environment.Tiles.TrapTile;

public class MUDGame implements DayNightSubject{
    /*
     * Main class to run the program. Controls the main gameplay loop.
     * 
     * @author Ty Platow
     */
    private MUDMap map;
    private PlayerCharacter player;
    private PlayerController playerController;
    private final Scanner scanner = new Scanner(System.in);
    private boolean isDay;
    private int turns;
    private ArrayList<DayNightObserver> dayNightObservers;


    public MUDGame(String filepath, String playerName, String playerDescription) throws IOException, MUDException{

        this.map = new MUDMap(filepath);
        this.player = new PlayerCharacter(playerName, playerDescription);
        this.playerController = new PlayerController(player, map);
        this.playerController.getCurrRoom().getTile(getPlayerX(), getPlayerX()).occupy(player);
        this.isDay = true;
        this.turns = 1;
        this.dayNightObservers = new ArrayList<>();
        registerAll();
    }

    public void takeTurn() throws MUDException{

        //options during turn: move to adjacent tile if its not blocked, attack one adjacent creature, move through an exit, examine/interact with item(s) on their tile, disarm adjacent traps, at end of turn player is attacked by adjacent creatures.
        turns ++;
        playerController.useBuffs();
        System.out.println(playerController.getCurrRoom());
        TileFeature[] adjacentTiles = playerController.getAdjacentTiles();
        System.out.println("Health: " + player.getHealth() + ", Attack: " + player.getAttack() + ", Defense: " + player.getDefense() + ", Buffs: " + player.getActiveBuffs() + ", Inventory Capacity: " + player.getInventory().getRatio());
        System.out.println("Move[w,a,s,d] Inventory[i]");
        String action = scanner.nextLine().toLowerCase();

        
       
        if(action.equals("x")){
            System.out.println("Turn ended");
        }
        else if(action.equals("i")){
            System.out.println("Inventory: " + playerController.getCharacter().getInventory());
            System.out.println("Enter the location of the item you wish to use or 0 to exit: ");
            int location = scanner.nextInt();

            if(location > 0){
                playerController.applyItem(location);
                System.out.println("Item applied!");
            }
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
        return playerController.getCurrRoom();
    }

    public MUDMap getMap(){
        return map;
    }

    public PlayerCharacter getPlayer(){
        return player;
    }

    public boolean isDay(){
        return isDay;
    }

    private void registerAll(){
        for(Room room: map.getRooms().values()){
            for(MUDCharacter chr: room.getEnemies()){
                register((NPC)chr);
            }
        }
    }

    @Override
    public void register(DayNightObserver observer) {
        dayNightObservers.add(observer);
    }

    @Override
    public void deregitser(DayNightObserver observer) {
        dayNightObservers.remove(observer);
    }

    @Override
    public void updateTime() {
        isDay = !isDay;
        for(DayNightObserver obs: dayNightObservers){
            obs.updateTime(isDay);
        }
    }

    public boolean gameOver(){
        if(playerController.getCurrRoom() == map.getEndRoom() && map.getEndRoom().roomCleared()){
            return true;
        }
        return false;
    }
}
