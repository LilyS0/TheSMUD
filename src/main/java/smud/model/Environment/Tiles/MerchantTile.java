package smud.model.Environment.Tiles;

import java.util.Scanner;

import smud.controller.PlayerController;
import smud.model.MUDException;
import smud.model.Character.MUDCharacter;
import smud.model.Item.MUDItem;

/**
 * Class to represent the new R2 Merchant tile. Holds an array of 3 random items to buy.
 * 
 * @author Ty Platow
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

    public void printItems(){
        for(int i=0; i<forSale.length; i++){
                System.out.println(i + ": " + forSale[i] + " - " + forSale[i].getValue() + " gold"); //e.g. 0: Sword - 25 gold
        }
        System.out.println("Type a number to buy that item or 'exit' to exit.");
    }
    
    @Override
    public boolean occupy(MUDCharacter character) {
        return false;
    }

    @Override
    public void interact(PlayerController player) throws MUDException {
        this.open = player.getCurrRoom().roomCleared();
        if(open){
            System.out.println("You have " + player.getCharacter().getGold() + " gold.");
            printItems();
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            while(!answer.toLowerCase().equals("exit")){
                try{
                    buyItem(player, Integer.parseInt(answer));
                }catch(Exception e){
                    System.out.println("Invalid input. Type a number to buy that item or 'exit' to exit.");
                }
                printItems();
            }
            input.close();

        }else{
            System.out.println("The merchant is closed.");
        }
    }
}
