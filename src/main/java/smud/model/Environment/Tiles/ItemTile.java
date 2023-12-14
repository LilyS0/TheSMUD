package smud.model.Environment.Tiles;

import smud.controller.PlayerController;
import smud.model.Environment.map.MUDMap;
import smud.model.Item.MUDItem;

public class ItemTile extends Tile{

    private MUDItem[] items;

    public ItemTile(MUDItem[] items, int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.items = items;
        this.tile = new EmptyTile(x,y);
        this.description = "Item Tile";
        this.defaultSymbol = 'I';
        this.symbol = defaultSymbol;
        this.canEnter = true;
    }

    public MUDItem[] getItems(){
        return items;
    }

    @Override
    public void interact(PlayerController player, MUDMap map){
        for(MUDItem item: items){
            player.getCharacter().getInventory().addItem(item);
        }
        items = new MUDItem[0];
    }

    @Override
    public void clearOccupant(){
        occupant = null;
        canEnter = true;

        if(items.length == 0){
            symbol = ' ';
        }
        else{
            symbol = defaultSymbol;
        }
    }

}
