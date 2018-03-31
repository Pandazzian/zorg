package command;

public class InvalidCommand implements Command {

    @Override
    public void apply() {
        System.out.println("Invalid Command");
    }
}
