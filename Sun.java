import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * This class draws a picture of a sun on the canvas.
 *
 * @author Vivek Ily
 * @version November 13th, 2020
 */

public class Sun {

     private int xCoord;
     private int yCoord;
     private int radius;
     private static int rValue = 255;
     private static int gValue = 167;
     private static int bValue = 0;





     /**
      * This default constructor creates a new Sun object and initializes the starting x and y coordinate and the radius of the Moon
      */
     public Sun(){
          this.xCoord = 800;
          this.yCoord = 200;
          this.radius = 50;
     }





     /**
      * Returns the x coordinate of the Sun at that point in the progression of the cityscape animation.
      * @return x coordinate of the Sun.
      */
     public int getXCoord(){return this.xCoord;}

     /**
      * Sets the x coordinate to the specified value. This is used to change the horizontal position of the Sun in the nextFrame() method.
      * @param newX the new value for the x coordinate.
      */
     public void setXCoord(int newX){this.xCoord = newX;}

     /**
      * Sets the y coordinate to the specified value. This is used to change the vertical position of the Sun in the nextFrame() method.
      * @param newY the new value for the y coordinate.
      */
     public void setYCoord(int newY){this.yCoord = newY;}

     /**
      * Returns the amount of green in the color of the sun.
      * @return the g value of the RGB color of the sun.
      */
     public int getGValue(){return gValue;}

     /**
      * Sets the amount of green in the color of the sun to the specified value. This is used to change the color of the sun in the nextFrame() method.
      * @param gAmount the new g value of the RGB color of the sun.
      */
     public void setGValue(int gAmount){gValue = gAmount;}

     /**
      * Defines the shapes of the Sun and draws them on the canvas.
      * @param g2 the graphics context.
      */
     public void draw(Graphics2D g2){
          Ellipse2D.Double sun = new Ellipse2D.Double(this.xCoord - this.radius, Building.HORIZON - this.yCoord + this.radius, this.radius, this.radius);
          Ellipse2D.Double sunReflected = new Ellipse2D.Double(this.xCoord - this.radius, Building.HORIZON + this.yCoord - 2 * this.radius, this.radius, this.radius);

          g2.setPaint(new Color(rValue, gValue, bValue));
          g2.draw(sun);
          g2.fill(sun);

          g2.draw(sunReflected);
          g2.fill(sunReflected);

     }

}