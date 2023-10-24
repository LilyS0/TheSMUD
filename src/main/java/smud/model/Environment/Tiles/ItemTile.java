package smud.model.Environment.Tiles;

import smud.model.Item.MUDItem;

public class ItemTile extends TileFeature implements Tile{

    private MUDItem[] items;

    public ItemTile(MUDItem[] items, int x, int y){
        this.xCor = x;
        this.yCor = y;
        this.items = items;
        this.tile = new EmptyTile(x,y);
        this.description = "Item Tile";
        this.symbol = 'I';
    }


    public MUDItem[] getItems(){
        return items;
    }

}
