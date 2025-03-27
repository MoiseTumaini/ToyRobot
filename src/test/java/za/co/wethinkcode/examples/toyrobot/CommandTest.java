package za.co.wethinkcode.examples.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    void getHelpName(){
        Command test = new HelpCommand();
        assertEquals("help", test.getName());
    }

    @Test
    void getName(){
        Command test = new Command("test");
        assertEquals("test", test.getName());
    }

    @Test
    void getNameAndArgment() {
        Command test = new Command("test", "100");
        assertEquals("test", test.getName());
        assertEquals("100", test.getArgument());
    }

    @Test
    void getForwardName(){
        ForwardCommand test = new ForwardCommand("100");
        assertEquals("forward", test.getName());
        assertEquals("100", test.getArgument());
    }

}
