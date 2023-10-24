package smud.model.Environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import smud.model.MUDException;
import smud.model.Environment.Tiles.EmptyTile;
import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.Tile;
import smud.model.Environment.Tiles.TileFeature;

/**
 * A Map is made up of 2+ Rooms, which are made of Tiles.
 * 
 * @author Sydney Wilson
 * @author Lily Susman
 */
public class SMUDMap {

    private Room startRoom;
    private Room endRoom;
    private Map<Integer, Room> rooms;
    private boolean isDay;
    private FileReader fileReader;
    private BufferedReader reader;

    public SMUDMap(String filepath) throws IOException, MUDException{

        this.rooms = new HashMap<>();
        this.isDay = true;
        this.fileReader = new FileReader(filepath);
        this.reader = new BufferedReader(fileReader);

        String line = reader.readLine();

        while(line != null){
            if(line.startsWith("r")){

                int id = Character.getNumericValue(line.charAt(1));   
                ArrayList<ArrayList<String>> roomList = new ArrayList<>();
                
                line = reader.readLine();

                if(line.equals(null)){
                    break;
                }

                while(line != null && !line.startsWith("r")){
                    ArrayList<String> lineList = new ArrayList<>();
                    for(String symbol: line.split(",")){
                        lineList.add(symbol);
                    }
                    roomList.add(lineList);
                    line = reader.readLine();
                }

                Room room = createRoom(roomList, id);
                rooms.put(id, room);
            }
        }

        reader.close();
        fileReader.close();

        if(rooms.size() < 2){
            throw new MUDException("Not enough rooms");
        }

        for(int id: rooms.keySet()){
            Room r = rooms.get(id);
            for(TileFeature[] row: r.getTiles()){
                for(TileFeature tile: row){
                    if(tile instanceof ExitTile){
                        ExitTile exit = (ExitTile)tile;
                        exit.addTarget(rooms.get(exit.getTargetID()));
                    }
                }
            }
        }
    }

    public Room createRoom(ArrayList<ArrayList<String>> roomList, int id){

        int width = roomList.get(0).size();
        int height = roomList.size();

        TileFeature[][] tiles = new TileFeature[height][width];
        

        for(int i=0; i<height; i++){
            TileFeature[] row = new TileFeature[width];
            for(int k=0; k<width; k++){
                try {
                    row[k] = TileFeature.createTile(roomList.get(i).get(k), rooms);
                } catch (MUDException e) {
                    row[k] = new EmptyTile();
                    System.out.println("Unable to create tile at x:" + k + "y:" + i  + ": \n  " + e);
                }
            }
            tiles[i] = row;
        }

        return new Room(tiles, id, false);
    }

    public void addRoom(Room room, int id){
        rooms.put(id, room);
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

    public Map<Integer, Room> getRooms(){
        return rooms;
    }

    public Room getRoom(int id){
        return rooms.get(id);
    }

    public TileFeature getTile(int id, int x, int y){
        return rooms.get(id).getTile(x, y);
    }

    public static void main(String[] args) {
        
        try {
            SMUDMap map = new SMUDMap("src/main/java/smud/maps/map1.txt");
            Map<Integer, Room> rooms = map.getRooms();

            for(int id: rooms.keySet()){
                System.out.println(rooms.get(id));
                System.out.println("============================================");   
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (MUDException e){
            e.printStackTrace();
        }


    }
}
