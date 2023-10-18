package model.Tiles;

import java.util.Collection;

import model.Item.MUDItem;

public class ItemTile extends TileFeature{
    public ItemTile(Collection<MUDItem> items){
        for(MUDItem item : items){
            tile.storeItem(item);
        }
    }
}
