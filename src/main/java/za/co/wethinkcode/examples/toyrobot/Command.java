package za.co.wethinkcode.examples.toyrobot;

public abstract class Command {
    private final String name;
    private String argument;

    public Command(String name){
        this.name = name;
    }

    public Command(String name, String argument) {
        this(name);
        this.argument = argument.trim();
    }

    public static Command create(String instruction){
        String[] args = instruction.toLowerCase().trim().split(" ");

        switch (args[0]){
            case "off": // double check this when submitting (between "off" and "shutdown")
                return new ShutdownCommand();
            case "help":
                return new HelpCommand();
            case "forward":
                return new ForwardCommand(args[1]);
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }

    public String getName(){
        return name;
    }

    public String getArgument(){
        return argument;
    }

    public abstract boolean execute(Robot target);
}

//public abstract class Command {
//    public abstract boolean execute(Robot target);
//}
