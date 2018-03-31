package player;

import interfaces.Informative;
import items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandazzian on 28/1/2018 AD.
 */
public class Inventory implements Informative{

    public static final int INVENTORY_CAP = 20;
    private List<Item> items;

    public Inventory(){
        this.items=new ArrayList<>();
    }

    //add item to inventory
    public boolean add(Item item){
        if(this.isFull()){
            //do something;
            System.out.println("player.Inventory is full");
            return false;
        }
        else{
            items.add(item);
            System.out.println("Item is added to inventory");
            return true;
        }
    }

    //remove item from inventory
    public void remove(int itemIndex){
        if(items.isEmpty()){
            System.out.println("Nothing to remove");
        }
        else if(!(itemIndex>=0&&itemIndex<items.size())){
            System.out.println(String.format("There is no item at %d",itemIndex));
        }
        else{
            items.remove(itemIndex);
            System.out.println("Item is drop");
        }
    }

    public void getInfo(){
        System.out.println("player.Inventory -----------");
        if(items.size()>0){
            for (int i = 0; i < items.size(); i++) {
                System.out.printf(String.format("Item %d - ", i));
                items.get(i).getInfo();
            }
        }
        else{
            System.out.println("There is nothing in your inventory");
        }
        System.out.println("---------------------");
    }

    public Item getItem(int itemIndex) {
        if(0<=itemIndex&&itemIndex<items.size()){
            return items.get(itemIndex);
        }
        return null;
    }

    //return true if the inventory is full else return false
    public boolean isFull(){
        return items.size()==INVENTORY_CAP;
    }
}
