package smud.model.Environment.Tiles;

import smud.controller.PlayerController;
import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Item.MUDItem;

/*
 * WHAT WE STILL NEED:
 *  IN OTHER FILES:
 *  WAY TO SET MERCHANT IN A ROOM TO CLOSED WHEN ROOM NOT CLEARED
 *  WAY TO SET MERCHANTS CLOSED WHEN NIGHT TIME
 *  WAY TO SET MERCHANTS OPEN WHEN CLEARED + DAY TIME
 *  IN THIS FILE:
 *  INTERACT METHOD, READING INPUT AND PASS TO BUYITEM
 *      WHILE LOOP, INPUT == exit TO BREAK
 *      ELSE PASS INPUT TO BUYITEM, IF IT THROWS EXCEPTION HANDLE IT
 */

public class MerchantTile extends TileFeature{
    private MUDItem[] forSale;
    private boolean open;
    
    public MerchantTile(int x, int y){
        this.forSale = new MUDItem[]{MUDItem.getRandomItem(), MUDItem.getRandomItem(), MUDItem.getRandomItem()};
        this.open = false;
        this.defaultSymbol = 'M';
        this.symbol = defaultSymbol;
        this.xCor = x;
        this.yCor = y;
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
            for(int i=0; i<forSale.length; i++){
                System.out.println(i + ": " + forSale[i] + " - " + forSale[i].getValue() + " gold"); //e.g. 0: Sword - 25 gold
            }
            /*
             * read an input
             * try{
             *      buyItem(input);
             * }catch(MUDException e){
             *      System.out.println("Invalid item. Please enter 0, 1, or 2.");
             * }
             */
        }else{
            System.out.println("The merchant is closed.");
        }
    }
}
