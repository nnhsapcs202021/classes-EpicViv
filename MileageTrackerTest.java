import static org.junit.Assert.*; import org.junit.After; import org.junit.Before; import org.junit.Test;

/**
 * The test class MileageTrackerTest.
 *
 * @author Vivek Ily
 * @version 6 October, 2020
 */

public class MileageTrackerTest{

     /**
      * Default constructor for test class MileageTrackerTest
      */
     public MileageTrackerTest(){

     }

     /**
      * Sets up the test fixture.
      *
      * Called before every test case method.
      */
     @Before
     public void setUp(){

     }

     /**
      * Tears down the test fixture.
      *
      * Called after every test case method.
      */
     @After
     public void tearDown(){

     }

     @Test
     public void testIncrementMilesDriven(){
          MileageTracker testTracker = new MileageTracker();
          testTracker.incrementMilesDriven(10);
          double amount = testTracker.getMilesDriven();

          /*
           * The assertEquals method verifies that the expected value isequal to the actual (returned) value. if not, the test fails.
           *        Specify the expected value first and the actual value second.
           *        For values of type double (only for doubles), specify a third value which is the epsilon.
           *             (i.e., how close is close enough to be equal)
           */

          assertEquals(10, amount, 1e-6);

          testTracker.incrementMilesDriven(5);
          amount = testTracker.getMilesDriven();
          assertEquals(15, amount, 1e-6);
     }

     @Test
     public void testFuelConsumed(){
          MileageTracker testTracker = new MileageTracker();
          testTracker.incrementFuelConsumed(10);
          double amount = testTracker.getFuelConsumed();

          assertEquals(10, amount, 1e-6);

          testTracker.incrementFuelConsumed(1.5);
          amount = testTracker.getFuelConsumed();
          assertEquals(11.5, amount, 1e-6);
     }
}