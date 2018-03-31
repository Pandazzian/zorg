/**
 * Created by pandazzian on 23/1/2018 AD.
 */
import command.*;
import items.Item;
import map.GameMap;
import map.GameMapFactory;
import player.Player;
import player.PlayerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Map<String,Command> commandMap;
    private Scanner sc = new Scanner(System.in);
    private String input;
    private Player player;
    private GameMap gameMap;
    private int level;

    Game(){
        System.out.println("Hello,Welcome to Zorg:finding da wae of da devul");
        setupMenu();
    }

    private void setupMenu(){
        this.commandMap=new HashMap<>();

        // create start command
        this.commandMap.put("start",new StartCommand());
        // create exit command;
        this.commandMap.put("quit",new ExitCommand());
        this.commandMap.put("invalid",new InvalidCommand());

    }

    public void play(){
        setup();
        for(;;){
            loop();
        }
    }


    private void setup(){
        this.commandMap.get("start").apply();
        this.player= PlayerFactory.create();
        System.out.println("The game has begun.");
        this.level = 1;
        this.commandMap.put("attack with",new AttackCommand(this.player));
        this.commandMap.put("take",new TakeCommand(this.player));
        this.commandMap.put("drop",new DropCommand(this.player));
        setupMap();


    }

    private void setupMap(){
        System.out.println("Setting a new map Lv."+this.level);
        this.gameMap = GameMapFactory.createMap(this.level);
        this.commandMap.put("info",new InfoCommand(this.player,gameMap));
        this.commandMap.put("move north",new MoveCommand("north",gameMap));
        this.commandMap.put("move south",new MoveCommand("south",gameMap));
        this.commandMap.put("move west",new MoveCommand("west",gameMap));
        this.commandMap.put("move east",new MoveCommand("east",gameMap));
        this.commandMap.put("help",new HelpCommand(this.commandMap));

    }

    private void loop(){
        if(this.player.isAlive()){
            if(gameMap.isCleared()){
                this.level++;
                if(this.level>=3){
                    System.out.println("*********    You found da wae    ************");
                    System.out.println("*********  You are the new queen ************");
                    this.commandMap.get("quit").apply();
                }
                setupMap();
            }
            System.out.print(">");
            input=sc.nextLine();
            System.out.println("");

            if(input.equals("take")){
                TakeCommand takeCommand = (TakeCommand) this.commandMap.get("take");
                takeCommand.setRoom(this.gameMap.getCurrentRoom());
                takeCommand.apply();
            }
            else if(input.startsWith("attack with")){
                String itemNumber = input.substring(11);
                AttackCommand attackCommand =  (AttackCommand) this.commandMap.get("attack with");
                attackCommand.setRoom(this.gameMap.getCurrentRoom());
                if(!itemNumber.equals("")) {
                    int inventoryNum = Integer.valueOf(itemNumber.substring(1));
                    attackCommand.armWith(inventoryNum);
                }
                attackCommand.apply();
                attackCommand.unArmed();

            }
            else if(input.startsWith("drop")){
                String itemNumber = input.substring(4);
                if(!itemNumber.equals("")) {
                    int inventoryNum = Integer.valueOf(itemNumber.substring(1));
                    DropCommand dropCommand = (DropCommand)this.commandMap.get("drop");
                    dropCommand.dropItem(inventoryNum);
                    dropCommand.apply();
                }
                else {
                    this.commandMap.get("invalid").apply();
                }
            }
            else if(this.commandMap.get(input)!=null){
                this.commandMap.get(input).apply();
            }
            else{
                this.commandMap.get("invalid").apply();
            }
        }
        else{
            System.out.println("You are ded");
            this.commandMap.get("quit").apply();
        }
    }

}
