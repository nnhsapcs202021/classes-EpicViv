import java.awt.Graphics2D; import java.awt.geom.Ellipse2D; import java.awt.Color;

/**
 * This class draws a picture of a Target.
 *
 * @author Vivek Ily
 * @version October 23rd, 2020
 *
 */

public class Target {
     private int x;
     private int y;
     private Color color;

     /**
      * Constructs the target with the defined center
      * @param initX x coordinate of center
      * @param initY y coordinate of center
      */

     public Target(int initX, int initY){
          this.x = initX;
          this.y = initY;
          this.color = Color.BLACK;
     }

     public Target(int initX, int initY, Color fillColor){
          this.x = initX;
          this.y = initY;
          this.color = fillColor;
     }

     public void draw(Graphics2D g2){
          Ellipse2D.Double ring1 = new Ellipse2D.Double(this.x - 100, this.y - 100, 200, 200);
          Ellipse2D.Double ring2 = new Ellipse2D.Double(this.x - 75, this.y - 75, 150, 150);
          Ellipse2D.Double ring3 = new Ellipse2D.Double(this.x - 50, this.y - 50, 100, 100);
          Ellipse2D.Double ring4 = new Ellipse2D.Double(this.x - 25, this.y - 25, 50, 50);

          g2.setPaint(this.color);
          g2.draw(ring1);
          g2.fill(ring1);

          g2.setPaint(Color.WHITE);
          g2.draw(ring2);
          g2.fill(ring2);

          g2.setPaint(this.color);
          g2.draw(ring3);
          g2.fill(ring3);

          g2.setPaint(Color.WHITE);
          g2.draw(ring4);
          g2.fill(ring4);


     }

}