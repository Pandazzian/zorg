package command;

import interfaces.Informative;
import map.GameMap;

/**
 * Created by pandazzian on 1/4/2018 AD.
 */
public class MoveCommand implements Command, Informative {
    String direction;
    GameMap gameMap;
    public MoveCommand(String direction, GameMap gameMap){
        this.direction = direction;
        this.gameMap = gameMap;
    }

    @Override
    public void apply() {
        gameMap.goTo(this.direction);
    }

    @Override
    public void getInfo() {
        System.out.println(String.format("move %s",direction));
        System.out.println(
                "\tmove to the "+direction
        );
    }
}
