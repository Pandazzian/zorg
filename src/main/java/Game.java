/**
 * Created by pandazzian on 23/1/2018 AD.
 */
import command.Command;
import command.ExitCommand;
import command.StartCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Map<String,Command> commandMap;

    Game(){
        System.out.println("Hello,Welcome to Zorg:finding da wae of da devul");
        setupMenu();
    }

    private void setupMenu(){
        commandMap=new HashMap<>();
        //check for save if there is add data to continueCommannd;

        // create start command
        commandMap.put("start",new StartCommand());
        // create exit command;
        commandMap.put("exit",new ExitCommand());
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);
        String input;

        for(;;){
            System.out.println("Type\n\"start\": to start game.");
            System.out.print("\"exit\": to exit.\n>");
            input=sc.nextLine();

            if(commandMap.get(input)!=null){
                commandMap.get(input).apply();
                break;
            }
        }
        play();
    }

    private Player player;

    private void play(){
        setup();
        for(;;)loop();
    }

    private void setup(){
         player=PlayerFactory.create();
    }

    private void loop(){
        System.out.println("Game...");
    }
}
