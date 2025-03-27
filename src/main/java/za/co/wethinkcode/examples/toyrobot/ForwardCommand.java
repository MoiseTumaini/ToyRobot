package za.co.wethinkcode.examples.toyrobot;

public class ForwardCommand extends Command{
    public ForwardCommand(){
        super("forward");
    }
    public ForwardCommand(String argument){
        super("forward", argument);
    }


}
