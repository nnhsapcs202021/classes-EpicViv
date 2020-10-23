import java.awt.Graphics2D; import java.awt.geom.Ellipse2D; import java.awt.Color;

public class Ellipse{
     private int x;
     private int y;
     private int width;
     private int height;
     private Color color;

     public Ellipse(int wid, int hei){
          this.x = 0;
          this.y = 0;
          this.width = wid;
          this.height = hei;
          this.color = Color.RED;
     }

     public void draw(Graphics2D g2){
          Ellipse2D.Double ellipse = new Ellipse2D.Double(this.x, this.y, this.width, this.height);

          g2.draw(ellipse);
          g2.setPaint(this.color);
          g2.fill(ellipse);

     }
}