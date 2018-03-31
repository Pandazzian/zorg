package command;

import interfaces.Informative;
import map.Room;
import player.Player;

public class DropCommand implements Command, Informative{
    private Player player;
    private int inventoryItemNumber;
    public DropCommand(Player player){
        this.player = player;
    }
    public void dropItem(int number){
        this.inventoryItemNumber = number;
    }
    @Override
    public void apply() {
        this.player.getInventory().remove(this.inventoryItemNumber);
    }

    @Override
    public void getInfo() {
        System.out.println("drop <Inventory Item number>");
        System.out.println("\tdrop item which have the same input item number from the player inventory.");
    }
}
