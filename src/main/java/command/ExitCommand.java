package command;

/**
 * Created by pandazzian on 24/1/2018 AD.
 */
public class ExitCommand implements Command {

    @Override
    public void apply() {
        System.exit(0);
    }
}
