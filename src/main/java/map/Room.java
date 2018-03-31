package map;

import interfaces.Informative;
import items.Item;
import monster.Monster;

/**
 * Created by pandazzian on 28/1/2018 AD.
 */
public class Room implements Informative{
    Item loot;
    Monster monster;
    String roomName;
    public Room(String roomName){
        this.roomName = roomName;
    }

    public void addMonster(Monster monster){
        this.monster = monster;

    }
    public void addLoot(Item loot){
        this.loot = loot;
    }
    public void removeLoot(){
        this.loot=null;
    }
    public void removeMonster(){
        this.monster=null;
    }
    public boolean hasMonster(){
        return monster!=null;
    }
    public boolean hasLoot(){
        return loot!=null;
    }
    public boolean isEmpty(){
        return !this.hasLoot() && !this.hasMonster();
    }
    public void getInfo() {
        System.out.println(String.format("Room %s -------------", this.roomName));
        if (this.isEmpty()) {
            System.out.println("This room is Empty");
        }
        if (this.hasLoot()) {
            System.out.println("Loot:");
            this.loot.getInfo();
        }
        if (this.hasMonster()) {
            System.out.println("Monster:");
            this.monster.getInfo();
        }
        System.out.println("---------------------");
    }

    public Item getLoot() {
        return loot;
    }

    public Monster getMonster() {
        return monster;
    }
}
