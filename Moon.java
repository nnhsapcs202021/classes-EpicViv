import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 * This class draws a picture of a moon that comes from the right when the screen is nearly black.
 *
 * @author Vivek Ily
 * @version November 13th, 2020
 */
public class Moon {

     private int xCoord;
     private int yCoord;
     private Color color;





     /**
      * This default constructor creates a new Moon object and initializes the starting x and y coordinates of the Moon.
      */
     public Moon(Color col){
          this.xCoord = 3250;
          this.yCoord = 80;
          this.color = col;
     }





     /**
      * Returns the x coordinate of the Moon at that point in the progression of the cityscape animation.
      * @return x coordinate of the Moon.
      */
     public int getXCoord(){return this.xCoord;}

     /**
      * Sets the x coordinate to the specified value. This is used to change the position of the Moon in the nextFrame() method.
      * @param newX the new value for the x coordinate.
      */
     public void setXCoord(int newX){this.xCoord = newX;}

     /**
      * Defines the shapes of the Moon and draws them on the canvas.
      * @param g2 the graphics context.
      */
     public void draw(Graphics2D g2){

          Ellipse2D.Double big = new Ellipse2D.Double(this.xCoord, this.yCoord, 100, 100);
          Ellipse2D.Double small = new Ellipse2D.Double(this.xCoord + 25, this.yCoord - 25, 100, 100);
          Ellipse2D.Double halo = new Ellipse2D.Double(this.xCoord - 25, this.yCoord - 25, 150, 150);

          if(this.color == Color.WHITE) {
               for (int i = 0; i < 75; i++) {
                    g2.setPaint(new Color(255, 255, 255, (int) (0.1 * (112.5 - (1.5 * i)))));
                    g2.fill(new Ellipse2D.Double(this.xCoord + 40 - (2 * i), this.yCoord + 60 - (2 * i), 4 * i, 4 * i));
               }
          }
          else{
               for (int i = 0; i < 75; i++) {
                    g2.setPaint(new Color(255, 0, 0, (int) (0.1 * (112.5 - (1.5 * i)))));
                    g2.fill(new Ellipse2D.Double(this.xCoord + 40 - (2 * i), this.yCoord + 60 - (2 * i), 4 * i, 4 * i));
               }
          }

          Area result = new Area(big);
          Area clippingArea = new Area(small);
          result.subtract(clippingArea);

          g2.setPaint(this.color);
          g2.fill(result);

     }
}
