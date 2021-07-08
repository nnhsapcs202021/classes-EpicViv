import javax.swing.*;

public class TargetViewer {

     public static void main(String[] args) {
          JFrame frame = new JFrame();

          frame.setSize(1000, 1000);
          frame.setTitle("Target");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          TargetComponent component = new TargetComponent();
          frame.add(component);

          frame.setVisible(true);

     }
}
