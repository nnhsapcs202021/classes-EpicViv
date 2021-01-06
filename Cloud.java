import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * This class draws a picture of a cloud in the sky.
 *
 * @author Vivek Ily
 * @version November 13th, 2020
 */
public class Cloud {

     private int xCoord;
     private int yCoord;
     private int width;
     private int height;
     private int alpha;





     /**
      * This constructor creates a Cloud object and initializes the x and y coordinates, width, height, and alpha of the Cloud.
      * @param xC the x coordinate of the Cloud.
      * @param wid the width of the Cloud.
      * @param hei the height of the Cloud.
      */
     public Cloud(int xC, int wid, int hei){
          this.xCoord = xC;
          this.yCoord = 5;
          this.width = wid;
          this.height = hei;
          this.alpha = 255;
     }





     /**
      * Returns the x coordinate of the Cloud at that point in the progression of the cityscape animation.
      * @return x coordinate of the Cloud.
      */
     public int getXCoord(){return this.xCoord;}

     /**
      * Sets the x coordinate to the specified value. This is used to change the position of the Cloud in the nextFrame() method.
      * @param xAmount the new value of the x coordinate.
      */
     public void setXCoord(int xAmount){this.xCoord = xAmount;}

     /**
      * Returns the alpha value (transparency) of the Cloud.
      * @return the alpha value of the Cloud.
      */
     public int getAlpha(){return this.alpha;}

     /**
      * Sets the alpha value (transparency) of the Cloud to the specified value.
      * @param alphaAmount the new alpha value.
      */
     public void setAlpha(int alphaAmount){this.alpha = alphaAmount;}

     /**
      * Defines the shapes of the Cloud and draws them on the canvas.
      * @param g2 the graphics context.
      */
     public void draw(Graphics2D g2){
          Ellipse2D.Double ell = new Ellipse2D.Double(this.xCoord, this.yCoord, this.width, this.height);

          g2.setPaint(new Color(255, 255, 255, this.alpha));
          g2.draw(ell);
          g2.fill(ell);

     }

}
