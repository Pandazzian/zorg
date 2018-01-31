package command;

import command.Command;

import java.util.List;

/**
 * Created by pandazzian on 24/1/2018 AD.
 */
public class StartCommand implements Command{
    @Override
    public void apply() {
        System.out.println("initiallizing game");
    }

}
