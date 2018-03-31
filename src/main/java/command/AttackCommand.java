package command;

import interfaces.Informative;
import items.Item;
import items.Weapon;
import map.Room;
import player.Player;

public class AttackCommand implements Command, Informative{
    private Player player;
    private Room room;
    private int inventoryItemNumber;
    public AttackCommand(Player player){
        this.player = player;
        this.unArmed();
    }
    public void setRoom(Room room){
        this.room = room;
    }
    public void armWith(int number){
        this.inventoryItemNumber = number;
    }
    public void unArmed(){
        this.inventoryItemNumber = -1;
    }
    @Override
    public void apply() {
        if(this.room.hasMonster()){
            Item item = this.player.getInventory().getItem(inventoryItemNumber);
            if(item==null){
                this.room.getMonster().isAttacked(this.player.getAttackPower());
            }else{
                Weapon weapon = (Weapon) item;
                weapon.attack(this.room.getMonster(),this.player);
            }

            // after attack

            if(this.room.getMonster().isAlive()){
                this.room.getMonster().getInfo();
                System.out.println("Monster attack back");
                this.player.isAttacked(this.room.getMonster().getAttackPoint());
            }
            else{
                System.out.println("Monster is ded");
            }
        }
        else{
            System.out.println("There is no monster in this room");
        }
    }

    @Override
    public void getInfo() {
        System.out.println("attack with <Inventory Item number>>");
        System.out.println("\tattack a monster in the current room with item which have the same input item\n" +
                "\tnumber from the player inventory. attack with bear hand if left Inventory Item number blank");
    }
}
