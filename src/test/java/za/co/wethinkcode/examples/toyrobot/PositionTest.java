package za.co.wethinkcode.examples.toyrobot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {

    @Test
    public void shouldKnowXandY(){
        Position p = new Position(10,20);
        assertEquals(10, p.getX());
        assertEquals(20, p.getY());
    }
}
