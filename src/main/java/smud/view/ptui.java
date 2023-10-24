package smud.view;

import java.io.IOException;

import smud.model.Environment.SMUDMap;

public class ptui {
    
    private SMUDMap map;


    public ptui() throws IOException{
        this.map = new SMUDMap("src/main/java/smud/maps/map1.txt");
    }
}
