import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 *
 * @author Vivek Ily
 * @version November 13th, 2020
 */
public class CityscapeComponent extends JComponent{

     // define the objects in your Cityscape as instance variables
     // ...

     static int alpha;

     private Sun sun1;
     private Cloud cld;
     private Cloud cld2;
     private Cloud cld5;
     private Cloud cld10;
     private Cloud cld11;

     private Building b15;
     private Building b14;
     private Building b12;
     private Building b5;
     private Building b11;
     private Building b8;
     private Building b9;
     private Building b13;
     private Building b7;
     private Building b4;
     private Building b3;
     private Building b10;
     private Building b6;
     private Building b2;
     private Building b1;

     private House h1;
     private House h2;
     private House h3;
     private House h4;
     private House h5;
     private House h6;
     private House h7;
     private House h8;
     private House h9;
     private House h10;
     private House h11;
     private House h12;
     private House h13;
     private House h14;
     private House h15;
     private House h16;
     private House h17;
     private House h18;
     private House h19;
     private House h20;
     private House h21;
     private House h22;

     private Moon moon;

     private Rectangle2D brightness;
     private boolean cldFlag;
     private int sandThickness;





     // define the CityscapeComponent constructor and initialize all instance variables
     // ...

     /**
      * This constructor initializes all of the instance variables as objects using their respective constructors.
      */
     public CityscapeComponent(){

          this.sun1 = new Sun();
          this.cld = new Cloud((int) (Math.random()*250 + 100), 100, 50);
          this.cld2 = new Cloud((int) (Math.random()*250 + 100), 100, 50);
          this.cld5 = new Cloud((int) (Math.random()*250 + 100), 100, 50);
          this.cld10 = new Cloud((int) (Math.random()*250 + 100), 100, 50);
          this.cld11 = new Cloud((int) (Math.random()*250 + 100), 100, 50);


          this.b15 = new Building(400);
          this.b14 = new Building((int)(Math.random()*116 + 50), 0, 371);
          this.b12 = new Building((int)(Math.random()*116 + 50), 0, 438);
          this.b5 = new Building((int)(Math.random()*116 + 50), 1, 346);
          this.b11 = new Building((int)(Math.random()*116 + 50), 0, 344);
          this.b8 = new Building((int)(Math.random()*116 + 50), 0, 386);
          this.b9 = new Building((int)(Math.random()*116 + 50), 1, 475);
          this.b13 = new Building((int)(Math.random()*116 + 50), 1, 309);
          this.b7 = new Building((int)(Math.random()*116 + 50), 0, 338);
          this.b4 = new Building((int)(Math.random()*116 + 50), 0, 450);
          this.b3 = new Building((int)(Math.random()*116 + 50), 1, 370);
          this.b10 = new Building((int)(Math.random()*116 + 50), 0, 333);
          this.b6 = new Building((int)(Math.random()*116 + 50), 1, 435);
          this.b2 = new Building((int)(Math.random()*116 + 50), 2, 400);
          this.b1 = new Building((int)(Math.random()*116 + 50), 2, 450);


          this.h1 = new House(20, 20, 25, Color.PINK);
          this.h2 = new House(20, 20, 50, Color.PINK);
          this.h3 = new House(20, 20, 75, Color.PINK);
          this.h4 = new House(20, 20, 100, Color.PINK);
          this.h5 = new House(20, 20, 125, Color.PINK);
          this.h6 = new House(20, 20, 150, Color.PINK);
          this.h7 = new House(20, 20, 175, Color.PINK);
          this.h8 = new House(20, 20, 200, Color.PINK);
          this.h9 = new House(20, 20, 225, Color.PINK);
          this.h10 = new House(20, 20, 250, Color.PINK);
          this.h11 = new House(20, 20, 275, Color.PINK);
          this.h12 = new House(20, 20, 505, Color.PINK);
          this.h13 = new House(20, 20, 530, Color.PINK);
          this.h14 = new House(20, 20, 555, Color.PINK);
          this.h15 = new House(20, 20, 580, Color.PINK);
          this.h16 = new House(20, 20, 605, Color.PINK);
          this.h17 = new House(20, 20, 630, Color.PINK);
          this.h18 = new House(20, 20, 655, Color.PINK);
          this.h19 = new House(20, 20, 680, Color.PINK);
          this.h20 = new House(20, 20, 705, Color.PINK);
          this.h21 = new House(20, 20, 730, Color.PINK);
          this.h22 = new House(20, 20, 755, Color.PINK);

          //generates a red moon 10% of the time
          double moonColorRandom = Math.random();
          Color moonColor;
          if(moonColorRandom <= 0.1){
               moonColor = Color.RED;
          }
          else{
               moonColor = Color.WHITE;
          }
          this.moon = new Moon(moonColor);
          //Tools.print(moonColor);
          if(moonColor.toString().charAt(23) == '0'){
               Tools.print("Moon Color: RED");
          }
          else{
               Tools.print("Moon Color: WHITE");
          }
          //--------------

          alpha = 0;
          this.brightness = new Rectangle2D.Double(-50, -50, CityscapeViewer.FRAME_WIDTH + 50, CityscapeViewer.FRAME_HEIGHT + 50);
          this.cldFlag = false;
          this.sandThickness = 50;
     }






     /**
      * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
      * It does not need to be invoked explicitly.
      *
      * @param g a reference to the Graphics object used for all drawing operations
      *
      */
     @Override
     public void paintComponent(Graphics g)
     {
          Graphics2D g2 = (Graphics2D) g;

          // invoke the draw method on each object in your Cityscape
          // ...


          //Upper part of background
          for(int i = Building.HORIZON; i >= 0; i--){
               Color sunset = new Color(11, 22, 146);
               g2.setPaint(sunset);
               g2.draw(new Line2D.Double(0, i, 800, i));
          }

          //Lower part of background
          for(int i = Building.HORIZON; i <= CityscapeViewer.FRAME_HEIGHT; i++) {
               Color sunset = new Color(81, 184, 241);
               g2.setPaint(sunset);
               g2.draw(new Line2D.Double(0, i, 800, i));
          }

          //draw sun
          sun1.draw(g2);

          //draw clouds
          cld.draw(g2); cld2.draw(g2); cld5.draw(g2); cld10.draw(g2); cld11.draw(g2);

          //orders the building according to height
          Building[] buildings = new Building[16];
          buildings[1] = this.b1;
          buildings[2] = this.b2;
          buildings[3] = this.b3;
          buildings[4] = this.b4;
          buildings[5] = this.b5;
          buildings[6] = this.b6;
          buildings[7] = this.b7;
          buildings[8] = this.b8;
          buildings[9] = this.b9;
          buildings[10] = this.b10;
          buildings[11] = this.b11;
          buildings[12] = this.b12;
          buildings[13] = this.b13;
          buildings[14] = this.b14;
          buildings[15] = this.b15;

          int c = 0;
          while (c < 100) {
               for (int i = 2; i < 16; i++) {
                    Building first = buildings[i - 1];
                    Building second = buildings[i];
                    if (buildings[i].getHeight() > buildings[i - 1].getHeight()) {
                         buildings[i - 1] = second;
                         buildings[i] = first;
                    }
               }
               c++;
          }

          //draw buildings in order of height
          for (int i = 1; i < 16; i++){
               buildings[i].draw(g2);
          }

          //draw houses
          h1.draw(g2); h2.draw(g2); h3.draw(g2); h4.draw(g2); h5.draw(g2); h6.draw(g2); h7.draw(g2); h8.draw(g2); h9.draw(g2); h10.draw(g2); h11.draw(g2); h12.draw(g2); h13.draw(g2); h14.draw(g2); h15.draw(g2); h16.draw(g2); h17.draw(g2); h18.draw(g2); h19.draw(g2); h20.draw(g2); h21.draw(g2); h22.draw(g2);

          //sand
          for(int i = Building.HORIZON; i <= Building.HORIZON + this.sandThickness; i++){
               Color sunset = new Color(216, 176, 115);
               g2.setPaint(sunset);
               g2.draw(new Line2D.Double(0, i, 800, i));
          }

          g2.setPaint(new Color(0, 0, 0, alpha));
          g2.draw(brightness);
          g2.fill(brightness);

          g2.setPaint(Color.WHITE);
          moon.draw(g2);

     }

     /**
      * Animate the cityscape by updating the objects such that they appear to be animated when they are next drawn.
      */
     public void nextFrame()
     {
          // update the objects in the cityscape so they are animated
          // ...

          int r = 500;
          sun1.setXCoord(sun1.getXCoord() - 1);
          sun1.setYCoord((int)(Math.sqrt((-1 * Math.pow(sun1.getXCoord(), 2)) + 800 * sun1.getXCoord() + 562500) - 600));

          if(sun1.getGValue() > 0) {
               sun1.setGValue((int) (0.20875 * sun1.getXCoord()));
          }

          if(cld11.getXCoord() >= 650){
               this.cldFlag = true;
          }

          if(cld11.getXCoord() < 650 && !this.cldFlag) {
               cld.setXCoord(cld.getXCoord() + 1);
               cld2.setXCoord(cld2.getXCoord() + 1);
               cld5.setXCoord(cld5.getXCoord() + 1);
               cld10.setXCoord(cld10.getXCoord() + 1);
               cld11.setXCoord(cld11.getXCoord() + 1);
          }

          else if(cld11.getXCoord() <= 650 && this.cldFlag) {
               cld.setXCoord(cld.getXCoord() - 1);
               cld2.setXCoord(cld2.getXCoord() - 1);
               cld5.setXCoord(cld5.getXCoord() - 1);
               cld10.setXCoord(cld10.getXCoord() - 1);
               cld11.setXCoord(cld11.getXCoord() - 1);
               if(cld.getAlpha() > 0) {
                    cld.setAlpha(cld.getAlpha() - 1);
                    cld2.setAlpha(cld2.getAlpha() - 1);
                    cld5.setAlpha(cld5.getAlpha() - 1);
                    cld10.setAlpha(cld10.getAlpha() - 1);
                    cld11.setAlpha(cld11.getAlpha() - 1);
               }
          }

          if(alpha < 255) {
               alpha = (int) (0.31875 * (800 - sun1.getXCoord()));
          }

          moon.setXCoord(moon.getXCoord() - 3);

          // request that the Java Runtime repaints this component by invoking its paintComponent method
          //  do not explicitly invoke the paintComponent method
          repaint();
     }

}