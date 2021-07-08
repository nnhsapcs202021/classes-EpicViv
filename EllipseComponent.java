import java.awt.Graphics; import java.awt.Graphics2D; import javax.swing.JComponent; import java.awt.Color;

public class EllipseComponent extends JComponent{
     @Override
     public void paintComponent(Graphics g){
          Graphics2D g2 = (Graphics2D) g;
          Ellipse ell = new Ellipse(this.getWidth(), this.getHeight());

          ell.draw(g2);
     }
}
