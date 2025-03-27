package za.co.wethinkcode.examples.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CommandTest {
    @Test
    void executeForward(){
        Robot robot = new Robot("CrashTestDummy");
        Command forward10 = Command.create("forward 10");
        assertTrue(forward10.execute(robot));
        Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
        assertEquals(expectedPosition, robot.getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void executeHelp() {
        Robot robot = new Robot("CrashTestDummy");
        Command help = Command.create("help");
        assertTrue(help.execute(robot));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'", robot.getStatus());
    }

    void executeShutDown() {
        Robot robot = new Robot("CrashTestDummy");
        Command help = Command.create("off");
        assertTrue(help.execute(robot));
        assertEquals("Shut down robot", robot.getStatus());
    }


//    @Test
//    void createCommand(){
//        Command forward = Command.create("forward 10");
//        assertEquals("forward", forward.getName());
//        assertEquals("10", forward.getArgument());
//
//        Command shutdown = Command.create("off");
//        assertEquals("off",shutdown.getName());
//
//        Command help = Command.create("help");
//        assertEquals("help",help.getName());
//    }
//
//    @Test
//    void createInvalidCommand(){
//        try{
//            Command forward = Command.create("say hello");
//            fail("Should have thrown an exception");
//        } catch (IllegalArgumentException e){
//            assertEquals("Unsupported command: say hello", e.getMessage());
//        }
//    }
}
