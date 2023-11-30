package smud.model.Environment.Tiles;

import smud.controller.PlayerController;
import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Item.MUDItem;

public class MerchantTile extends TileFeature{
    private MUDItem[] forSale;
    private boolean open;
    
    public MerchantTile(){
        forSale = new MUDItem[]{MUDItem.getRandomItem(), MUDItem.getRandomItem(), MUDItem.getRandomItem()};
        open = false;
    }

    public boolean isOpen(){
        return open;
    }

    public void setOpen(boolean newOpen){
        open = newOpen;
    }

    public void buyItem(PlayerController player, int index) throws MUDException{
        if(index < 0 || index > 2){
            throw new MUDException("Invalid index provided to merchant buyItem");
        }else{
            if(player.getCharacter().getGold() > forSale[index].getValue()){
                player.getCharacter().getInventory().addItem(forSale[index]);
            }else{
                System.out.println("Not enough gold!");
            }
        }
    }
    
    @Override
    public boolean occupy(MUDCharacter character) {
        return false;
    }

    @Override
    public void interact(PlayerController player) throws MUDException {
        if(open){
            System.out.println("You have " + player.getCharacter().getGold() + " gold.");
        }else{
            System.out.println("The merchant is closed.");
        }
    }
}
