package smud.view;

import java.io.IOException;

import smud.model.MUDException;
import smud.model.Environment.Room;
import smud.model.Environment.SMUDMap;

public class ptui {
    
    private SMUDMap map;


    public ptui() throws IOException, MUDException{
        this.map = new SMUDMap("src/main/java/smud/maps/map1.txt");
    }

    public SMUDMap getMap(){
        return map;
    }

    public static void main(String[] args) throws IOException, MUDException {
        
        ptui ui = new ptui();
        SMUDMap map = ui.getMap();
        Room startingRoom = map.getRoom(1);

        System.out.println(startingRoom);
        System.out.println("You begin your journey");
        //options during turn: move to adjacent tile if its not blocked, attack one adjacent creature, move through an exit, examine/interact with item(s) on their tile, disarm adjacent traps, at end of turn player is attacked by adjacent creatures.

    }
}
