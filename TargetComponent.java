import java.awt.Graphics; import java.awt.Graphics2D; import javax.swing.JComponent; import java.awt.Color;

/**
 * This component draw the target.
 */
public class TargetComponent extends JComponent{
     @Override
     public void paintComponent(Graphics g){
          Graphics2D g2 = (Graphics2D) g;
          Target target = new Target(500, 500);
          Target target1 = new Target(100, 100, Color.RED);

          target.draw(g2);
          target1.draw(g2);
     }
}
