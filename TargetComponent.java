import java.awt.Graphics; import java.awt.Graphics2D; import javax.swing.JComponent;

/**
 * This component draw the target.
 */
public class TargetComponent extends JComponent{
     @Override
     public void paintComponent(Graphics g){
          Graphics2D g2 = (Graphics2D) g;
          Target target = new Target(500, 500);

          g2.fillOval(50, 50, 10, 10);
          target.draw(g2);
     }
}
