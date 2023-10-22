package smud;

public class MUDGame {
    /*
     * Main class to run the program. Controls the main gameplay loop.
     * 
     * @author Ty Platow
     */

    public static void main(String[] args) {
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
    }
}
