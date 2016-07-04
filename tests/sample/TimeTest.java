package sample;

import org.junit.Before;
import org.testng.annotations.Test;

import static org.junit.Assert.*;


public class TimeTest {

    private Time time;

    @Before
    public void setUp() throws Exception {
        time = new Time();
    }

    @Test
    public void metersIntoFeetConversion() throws Exception {
        assertEquals(551, time.getSpeed());
    }

}