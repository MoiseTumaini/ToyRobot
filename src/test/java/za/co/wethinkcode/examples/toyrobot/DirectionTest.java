package za.co.wethinkcode.examples.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static za.co.wethinkcode.examples.toyrobot.Direction.*;

public class DirectionTest {

    @Test
    public void changeToSouth(){
        Robot robot = new Robot("Moise");
        robot.turnTo(SOUTH);
        assertEquals(SOUTH,robot.getCurrentDirection());
    }
}
