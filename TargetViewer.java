import javax.swing.JFrame;
import java.awt.*;

public class TargetViewer {

     public void main(String[] args){
          JFrame frame = new JFrame();

          frame.setSize(1000, 1000);
          frame.setTitle("Target");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          CarComponent component = new CarComponent();
          frame.add(component);

          frame.setVisible(true);

     }
}
