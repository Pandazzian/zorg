package command;

import interfaces.Informative;

/**
 * Created by pandazzian on 24/1/2018 AD.
 */
public class ExitCommand implements Command, Informative {

    @Override
    public void apply() {
        System.exit(0);
    }

    @Override
    public void getInfo() {
        System.out.println("quit");
        System.out.println("\tquit game");
    }
}
