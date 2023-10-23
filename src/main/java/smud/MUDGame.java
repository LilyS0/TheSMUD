package smud;

import java.util.Scanner;

import smud.model.MUDException;

public class MUDGame {
    /*
     * Main class to run the program. Controls the main gameplay loop.
     * 
     * @author Ty Platow
     */

    public static void main(String[] args) {
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        //PlayerCharacter pc
        
        /*
         * get user input to start a new game/load existing file (file loading subsystem)
         * 
         * while game is not over:
         *      on player's turn:
         *          get user input to make choice between movement, attacking, picking up/use items or disarming traps
         *              if trying to move:
         *                  call occupy method on tile they are trying to move to
         *                      if returns false, let them choose what to do again
         *                      if the player's new square is next to a trap, roll 50% chance to detect it (this part might wind up somewhere else in the code)
         *                      if stepped on the exit tile in the last room, game is over
         *              if item was used:
         *                  start a turn countdown for the duration of the buff
         *              if attacking:
         *                  make sure player is in range (more range for different weapons?)
         *                  call player character's attack method with target
         *              if disarming trap:
         *                  call disarm method on the trapped tile
         *          once turn is over, increment the turn countdown for active buffs
         *      after player's turn:
         *          if player is standing next to an enemy, call enemy's attack method targeting player character
         *      check if player died, if they did game is over
         */

        while(!gameOver){
            //player's turn
            while(true){
                System.out.println("Turn " + turn);
                System.out.println("Would you like to (M)ove, (A)ttack, (P)ick up items, Access your (I)nventory, (D)isarm a trap, or save and (Q)uit the game?");
                String response = scanner.nextLine();
                response = response.toUpperCase();
                if(response.equals("M")){
                    // move
                    // if we just moved next to a trap tile, roll 50% chance that we detect it
                    break;
                }else if(response.equals("A")){
                    // attack
                    break;
                }else if(response.equals("P")){
                    // for each item in character.location.items add to character inventory
                    break;
                }else if(response.equals("I")){
                    // print each item in inventory with an associated number, get a number input and use that item
                    break;
                }else if(response.equals("D")){
                    // try{
                    //     //character.location.disarm()
                    // }catch(MUDException e){

                    // }
                    break;
                }else if(response.equals("Q")){
                    // save to a file
                    gameOver = true;
                    break;
                }else{
                    System.out.println("Unknown command: " + response);
                }
            }
            // for each buff in character.buffs
            //      if buff type is regen, restore health
            //      buff.turnsLeft--;
            // enemy turn
            // for tile in bordering tiles:
            //      if occupied by NPC, they attack us
            
            /* if(!pc.isAlive()){
                gameOver = true;
                break;
            }
            */
            turn++;
        }
        scanner.close();
    }
}
