import items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandazzian on 28/1/2018 AD.
 */
public class Inventory {

    public static final int INVENTORY_CAP = 20;
    private List<Item> items;

    public Inventory(){
        this.items=new ArrayList<>();
    }

    //add item to inventory
    public void add(Item item){
        if(this.isFull()){
            //do something;
        }
        else{
            items.add(item);
        }
    }

    //remove item from inventory
    public void remove(){

    }

    //return true if the inventory is full else return false
    public boolean isFull(){
        return items.size()==INVENTORY_CAP;
    }
}
