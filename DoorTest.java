

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DoorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DoorTest
{
    /**
     * Default constructor for test class DoorTest
     */
    public DoorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testSetName()
    {
        Door door1 = new Door("White door", true, "White", 17.9, 8.2);
        String name = "White door";
        door1.setName("White door");
        String name2 = door1.getName();
        assertEquals("White door", name2);
    }
    
    @Test
    public void testSetIsOpen()
    {
        Door door1 = new Door("White door", true, "White", 17.9, 8.2);
        boolean state = true;
        door1.setState(false);
        boolean state2 = door1.getState();
        assertEquals(false, state2);
    }
    
    @Test
    public void testSetColor()
    {
        Door door1 = new Door("White door", true, "White", 17.9, 8.2);
        String color = "White";
        door1.setColor("Red");
        String color2 = door1.getColor();
        assertEquals("Red", color2);
    }
}
