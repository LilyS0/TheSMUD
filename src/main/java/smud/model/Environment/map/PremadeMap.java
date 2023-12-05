package smud.model.Environment.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import smud.model.MUDException;
import smud.model.Environment.Tiles.ExitTile;
import smud.model.Environment.Tiles.TileFeature;
import smud.model.Environment.room.PremadeRoom;
import smud.model.Environment.room.Room;

/**
 * A Map is made up of 2+ Rooms, which are made of Tiles.
 * 
 * @author Sydney Wilson
 * @author Lily Susman
 */
public class PremadeMap implements MUDMap{

    private Room startRoom;
    private Room endRoom;
    private Map<Integer, Room> rooms;
    private Map<Integer, ExitTile> exits;
    private boolean isDay;
    private FileReader fileReader;
    private BufferedReader reader;

    public PremadeMap(String filepath) throws IOException, MUDException{

        this.rooms = new HashMap<>();
        this.exits = new HashMap<>();
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

                Room room = PremadeRoom.createRoom(roomList, id, exits, rooms);
                if(id == 1){
                    startRoom = room;
                }
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
                        ExitTile targetExit = exits.get(id);
                        exit.setTargetX(targetExit.getXCor());
                        exit.setTargetY(targetExit.getYCor());
                    }
                }
            }
            if(id == rooms.size()){
                endRoom = rooms.get(id);
            }
        }
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

    public Map<Integer, ExitTile> getExits(){
        return exits;
    }

    public static void main(String[] args) {
        
        try {
            PremadeMap map = new PremadeMap("src/main/java/smud/maps/map1.txt");
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