package za.co.wethinkcode.examples.toyrobot;

public class Command {
    private final String name;
    private String argument;


    public Command(String name){
        this.name = name;
    }

    public Command(String name, String argument) {
        this(name);
        this.argument = argument.trim();
    }

    public String getName(){
        return name;
    }

    public String getArgument(){
        return argument;
    }
}
