import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * This class draws a picture of a house.
 *
 * @author Vivek Ily
 * @version November 13th, 2020
 */

public class House {

     private int bodyWidth;
     private int bodyHeight;
     private int roofWidth;
     private int roofHeight;
     private int center;
     private Color color;





     /**
      * This constructor creates a House object and initializes the width, height, x coordinate of the center, and the color of the House.
      * @param wid the width of the House.
      * @param hei the height of the House.
      * @param cen the x coordinate of the center of the House.
      * @param col the color of the House.
      */
     public House(int wid, int hei, int cen, Color col){
          this.bodyWidth = wid;
          this.bodyHeight = hei;
          this.roofWidth = (int)(wid * 1.4);
          this.roofHeight = (int)(this.roofWidth / 2.5);
          this.center = cen;
          this.color = col;
     }





     /**
      * Defines the shapes of the House and draws them on the canvas.
      * @param g2 the graphics context.
      */
     public void draw(Graphics2D g2){
          Rectangle2D.Double body = new Rectangle2D.Double(this.center - (1.0 * this.bodyWidth/2), Building.HORIZON - this.bodyHeight, this.bodyWidth, this.bodyHeight);

          g2.setPaint(Color.BLACK);

          g2.draw(body);
          g2.fill(body);

          Polygon roof = new Polygon(new int[] {this.center - (this.roofWidth / 2), this.center + (this.roofWidth / 2), this.center}, new int[] {Building.HORIZON - this.bodyHeight, Building.HORIZON - this.bodyHeight, Building.HORIZON - this.bodyHeight - this.roofHeight}, 3);
          g2.drawPolygon(roof);
          g2.fillPolygon(roof);

          g2.setPaint(new Color(254, 153, 73));
          g2.draw(new Rectangle2D.Double(body.getX(), body.getY(), body.getWidth(), body.getHeight()));
          g2.draw(new Rectangle2D.Double(body.getX() + 1, body.getY() + 1, body.getWidth() - 2, body.getHeight() - 2));

          Polygon roof2 = new Polygon(new int[] {this.center - (this.roofWidth / 2), this.center + (this.roofWidth / 2), this.center}, new int[] {Building.HORIZON - this.bodyHeight, Building.HORIZON - this.bodyHeight, Building.HORIZON - this.bodyHeight - this.roofHeight}, 3);
          Polygon roof3 = new Polygon(new int[] {this.center - (this.roofWidth / 2) + 2, this.center + (this.roofWidth / 2) - 2, this.center}, new int[] {Building.HORIZON - this.bodyHeight - 1, Building.HORIZON - this.bodyHeight - 1, Building.HORIZON - this.bodyHeight - this.roofHeight + 1}, 3);
          g2.draw(roof2); g2.draw(roof3);

     }
}