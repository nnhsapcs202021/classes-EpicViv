import javax.swing.*;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 *
 * @author Vivek Ily
 * @version November 13th, 2020
 */
public class CityscapeViewer
{
     // the cityscape will be animated for 875 milliseconds
     static final int ANIMATION_TIME = 875;
     static final int FRAME_WIDTH = 800;
     static final int FRAME_HEIGHT = 600;

     /**
      * main method for the program which creates and configures the frame for the program
      *
      * @param args  not used
      *
      */
     public static void main(String[] args) throws InterruptedException
     {
          // create and configure the frame (window) for the program
          JFrame frame = new JFrame();

          frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
          frame.setTitle("Cityscape");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          // a frame contains a single component; create the Cityscape component and add it to the frame
          CityscapeComponent component = new CityscapeComponent();
          frame.add(component);

          // make the frame visible which will result in the paintComponent method being invoked on the component.
          frame.setVisible(true);

          // animate the cityscape
          for( int seconds = 0; seconds < ANIMATION_TIME; seconds++ )
          {
               component.nextFrame();
               Thread.sleep( 10 );
          }

          System.out.println("Done with animation.");



     }

}