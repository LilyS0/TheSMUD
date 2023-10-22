package smud.model.Environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import smud.model.Environment.Tiles.TileFeature;

/**
 * A Map is made up of 2+ Rooms, which are made of Tiles.
 * 
 * @author Sydney Wilson
 */
public class SMUDMap {

    private Room startRoom;
    private Room endRoom;
    private Set<Room> rooms;
    private boolean isDay;
    private FileReader fileReader;
    private BufferedReader reader;

    public SMUDMap(String filepath) throws IOException{

        this.rooms = new HashSet<>();
        this.isDay = true;
        this.fileReader = new FileReader(filepath);
        this.reader = new BufferedReader(fileReader);

        String line = reader.readLine();

        while(line != null){
            if(line.startsWith("r")){

                int id = Character.getNumericValue(line.charAt(1));   
                ArrayList<ArrayList<String>> roomList = new ArrayList<>();
                ArrayList<String> lineList = new ArrayList<>();
                line = reader.readLine();

                while(!line.startsWith("r")){
                    for(String symbol: line.split(",")){
                        lineList.add(symbol);
                    }
                    roomList.add(lineList);
                    line = reader.readLine();
                }

                Room room = createRoom(roomList, id);
                rooms.add(room);
            }
        }

        reader.close();
        fileReader.close();
    }

    public Room createRoom(ArrayList<ArrayList<String>> roomList, int id){

        int width = roomList.get(0).size();
        int height = roomList.size();

        TileFeature[][] tiles = new TileFeature[height][width];
        TileFeature[] row;

        for(int i=0; i<height; i++){
            for(int k=0; k<width; k++){
                String symbol = roomList.get(i).get(k);
            }
        }

        return null;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void connectRooms(Room r1, Room r2){
        r1.addExit(r2);
        r2.addExit(r1);
    }

    public void changeTime(){
        isDay = !isDay();
    }

    public Room getStartRoom(){
        return startRoom;
    }

    public Room getEndRoom(){
        return endRoom;
    }

    public boolean isDay(){
        return isDay;
    }

    public Set<Room> getRooms(){
        return rooms;
    }

    public static void main(String[] args) {
        

    }
}
