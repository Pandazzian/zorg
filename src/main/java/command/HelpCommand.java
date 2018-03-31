package command;

import interfaces.Informative;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command, Informative{
    Map<String,Command> commandMap;
    public HelpCommand( Map<String,Command> commandMap){
        this.commandMap=commandMap;
    }
    @Override
    public void apply() {
        System.out.println("All Commands --------");
        for (Command command:commandMap.values()) {
            try {
                Informative informative = (Informative)command;
                informative.getInfo();
            }
            catch (Exception e){
                //do nothing
            }
        }
        System.out.println("---------------------");
    }

    @Override
    public void getInfo() {
        System.out.println("help");
        System.out.println("\tstate all possible command");
    }
}
