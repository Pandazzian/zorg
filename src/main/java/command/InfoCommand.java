package command;

import interfaces.Informative;
import map.GameMap;
import player.Inventory;
import player.Player;

/**
 * Created by pandazzian on 1/4/2018 AD.
 */
public class InfoCommand implements Command, Informative {
    Player player;
    Inventory inventory;
    GameMap gameMap;
    public InfoCommand(Player player,GameMap gameMap){
        this.player=player;
        this.inventory=player.getInventory();
        this.gameMap=gameMap;
    }
    @Override
    public void apply() {
        this.player.getInfo();
        this.player.getInventory().getInfo();
        this.gameMap.getCurrentRoom().getInfo();
    }

    @Override
    public void getInfo() {
        System.out.println("info");
        System.out.println(
                "\tprint out information of the player and the room that the player is currently in. \n" +
                        "\t\ti. Player stats, e.g. HP/HP Max, attack power, etc.\n" +
                        "\t\tii. Room information, e.g. Monster stats (if any), item stats (if any), doors, etc.");
    }
}
