package smud.model.Environment.Tiles;

import smud.controller.PlayerController;
import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Environment.map.MUDMap;
import smud.model.Environment.room.InfiniteRoom;

public class InfiniteExitTile extends Tile{
    private InfiniteRoom current;
    private InfiniteRoom next;
    private int targetX;
    private int targetY;

    public InfiniteExitTile(InfiniteRoom current, InfiniteRoom next, int x, int y){
        this.current = current;
        this.xCor = x;
        this.yCor = y;
        this.symbol = 'X';
        setTargetCoords();
    }

    @Override
    public boolean occupy(MUDCharacter character){
        if(current.roomCleared()){
            return true;
        }
        return false;
    }

    @Override
    public void interact(PlayerController player, MUDMap map){

        if(next == null){
            next = new InfiniteRoom(current);
        }

        if(current.roomCleared()){
            try {
                player.setCurrRoom(next, targetX, targetY, map);
                System.out.println("Now in room " + next.getID());
            } catch (MUDException e) {
                System.out.println("Can't go there");
            }
        }
        else{
            System.out.println("Come back when the room is cleared");
        }
    }

    private void setTargetCoords(){
        if(this.next != null){
            this.targetX = next.getWidth()/2;
            if(this.yCor == current.getHeight()-1){
                this.targetY = 0;
            }
            else{
                this.targetY = next.getHeight()-1;
            }
        }
    }
}
