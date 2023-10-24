package smud.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import smud.model.Environment.Room;
import smud.model.Environment.Tiles.ItemTile;
import smud.model.Environment.Tiles.TileFeature;
import smud.model.Item.MUDItem;
import smud.model.Item.Armor.Armor;
import smud.model.Item.Buffs.Buff;
import smud.model.Item.Weapons.Weapon;
import smud.model.Item.Food.Food;
/**
 * PlayerCharacter implements the Character interface, and adds additionaly functionality
 * such as Weapon and Armor associated with character.
 * 
 * @author Sydney Wilson
 */
public class PlayerCharacter extends MUDCharacter {
    private Weapon weapon;
    private Armor armor;
    private ArrayList<Buff> activeBuffs;
    private Room currRoom;
    private int xCor;
    private int yCor;
    private Set<TileFeature> adjacentTiles;
    private final Scanner scan = new Scanner(System.in);
// The name and description are supplied by the user when the PC is created.
// A weapon slot into which one weapon can be equipped. If a weapon is already equipped, it is dropped.
// An armor slot into which one piece of armor can be equipped. If a piece of armor is already equipped, it is dropped.

// method graveyard: setHealth, setAttack/setDefense (KEEP METHOD, delete instances => might need for use in conjunction with )
// eventually gonna have to part w inventory functions bc the prompt says so
    public PlayerCharacter(String name, String description) {

        this.health = 100;
        this.attack = 10;
        this.defense = 0;
        this.name = name;
        this.description = description;
        this.inventory = new Inventory();
        this.activeBuffs = new ArrayList<>();
        this.adjacentTiles = new HashSet<>();
    }

    public PlayerCharacter(String name, String description, int health, Weapon weapon, Armor armor, ArrayList<Buff> activeBuffs, Room currRoom, int xCor, int yCor, Inventory inventory){
        this.defense = 0;
        this.attack = 10;
        this.health = health;
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.activeBuffs = activeBuffs;
        this.weapon = weapon;
        this.armor = armor;
        this.currRoom = currRoom;
        this.xCor = xCor;
        this.yCor = yCor;
    }

    @Override
    public int getAttack() {
        if(this.weapon != null){
            return this.attack + this.weapon.getStat();
        }else{
            return this.attack;
        }
    }

    @Override
    public int getDefense() {
        if(this.armor != null){
            return this.defense + this.armor.getStat();
        }else{
            return this.defense;
        }
    }

    public Room getCurrRoom(){
        return currRoom;
    }

    public void setCurrRoom(Room room){
        this.currRoom = room;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Armor getArmor(){
        return armor;
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }

    public int getXCor(){
        return xCor;
    }

    public void setXCor(int x){
        this.xCor = x;
    }

    public int getYCor(){
        return yCor;
    }

    public void setYCor(int y){
        this.yCor = y;
    }

    public void occupyLocation(){
        System.out.println(currRoom.getTile(xCor, yCor).occupy(this));
        System.out.println(currRoom.getTile(xCor, yCor).getOccupant());
        currRoom.getTile(xCor, yCor).occupy(this);
    }

    public ArrayList<Buff> getActiveBuffs(){
        return activeBuffs;
    }

    public void addBuff(Buff buff){
        activeBuffs.add(buff);
    }

    public void examineItems(MUDItem[] items) throws MUDException{
        
        for(MUDItem item: items){
            if(item instanceof Food){
                health += item.getStat();
            }
            else if(item instanceof Buff){
                activeBuffs.add((Buff)item);
            }
            else if(item instanceof Armor){
                System.out.println("Swap current armor with " + armor.getStat() + " defense for armor with " + item.getStat() + " defense? [Y/N]");
                if(scan.nextLine().toLowerCase().equals("y")){
                    setArmor((Armor)item);
                }
            }
            else if(item instanceof Weapon){
                System.out.println("Swap current weapon with " + weapon.getStat() + " attack for weapon with " + item.getStat() + " attack? [Y/N]");
                if(scan.nextLine().toLowerCase().equals("y")){
                    setWeapon((Weapon)item);
                }
            }
            else{
                throw new MUDException("Damn son where'd u find that?");
            }
        }
    }

    public Set<TileFeature> getAdjacentTiles(){
        updateAdjacentTiles();
        return adjacentTiles;
    }

    public void updateAdjacentTiles(){

        ArrayList<TileFeature> adjacent = new ArrayList<>();

        if(xCor + 1 < currRoom.getWidth()){
            adjacent.add(currRoom.getTile(xCor + 1, yCor));
        }
        if(xCor - 1 >= 0){
            adjacent.add(currRoom.getTile(xCor - 1, yCor));
        }
        if(yCor + 1 < currRoom.getHeight()){
            adjacent.add(currRoom.getTile(xCor, yCor + 1));
        }
        if(yCor - 1 >= 0){
            adjacent.add(currRoom.getTile(xCor, yCor - 1));
        }

        adjacentTiles.clear();
        adjacentTiles.addAll(adjacent);
    }

    public void checkForItems() throws MUDException{

        TileFeature tile = currRoom.getTile(xCor, yCor);

        if(tile instanceof ItemTile){
            
            ItemTile itemTile = (ItemTile)tile;
            examineItems(itemTile.getItems());
        }
    }

    public void moveVert(int dir) throws MUDException{

        if(dir != -1 || dir != 1){
            throw new MUDException("Invalid move amount");
        }

        if(currRoom.getTile(xCor, yCor+dir).occupy(this)){
            yCor += dir;
        } else {
            throw new MUDException("Can't move there!");
        }

        checkForItems();

    }

    public void moveHoriz(int dir) throws MUDException{

        if(dir != -1 || dir != 1){
            throw new MUDException("Invalid move amount");
        }

        if(currRoom.getTile(xCor + dir, yCor).occupy(this)){
            xCor += dir;
        } else {
            throw new MUDException("Can't move there!");
        }

        checkForItems();
        
    }

    public void makeMove(String dir) throws MUDException{
        if(dir.equals("w")){
            moveVert(-1);
        }
        else if(dir.equals("s")){
            moveVert(1);
        }
        else if(dir.equals("a")){
            moveHoriz(-1);
        }
        else if(dir.equals("d")){
            moveHoriz(1);
        }
        else{
            throw new MUDException("Invalid direction");
        }
    }
    
    public static void main(String[] args) {
        PlayerCharacter notAlex = new PlayerCharacter("Not Alex", "This is not NPC Alex");
        System.out.println(notAlex.getName());
        System.out.println(notAlex.getHealth());
    }
}
