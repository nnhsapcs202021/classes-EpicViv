import javax.swing.JFrame; import java.awt.*;

public class EllipseViewer {
     public static void main(String[] args) {
          JFrame frame = new JFrame();

          frame.setSize(1000, 1000);
          frame.setTitle("Target");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          EllipseComponent component = new EllipseComponent();
          frame.add(component);

          frame.setVisible(true);
     }
}