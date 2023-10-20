package smud.model.Environment.Tiles;

import java.util.Collection;

import smud.model.Item.MUDItem;

public class ItemTile extends TileFeature{


    public ItemTile(Collection<MUDItem> items){
        for(MUDItem item : items){
            tile.storeItem(item);
        }
        this.description = "Item Tile";
        this.symbol = 'I';
    }
}
