package command;

import interfaces.Informative;
import items.Item;
import map.Room;
import player.Player;

public class TakeCommand implements Command, Informative{
    Room room;
    Player player;
    public TakeCommand(Player player){
        this.player = player;
    }
    public void setRoom(Room room){
        this.room = room;
    }
    @Override
    public void apply() {
        if(this.room.hasLoot()){
            this.player.getInventory().add(this.room.getLoot());
            this.room.removeLoot();
        }else{
            System.out.println("No Item in this room");
        }

    }

    @Override
    public void getInfo() {
        System.out.println("take");
        System.out.println("\ttake command is used to pick up the item in the current room");
    }
}
