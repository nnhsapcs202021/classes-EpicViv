import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * This class draw a picture of a building, such as a skyscraper.
 *
 * @author Vivek Ily
 * @version November 13th, 2020
 */

public class Building{

     public static final int HORIZON = 350;
     private final double WIDTH_TO_HEIGHT_RATIO = 0.3;
     private double buildingWidth;
     private double buildingHeight;
     private Color buildingColor;
     private int numOfAntennas;
     private int xCoord;





     /**
      * Default constructor with no parameters that builds a building with a width of 50 and height of 70 that is gray in color and has no antennas.
      *
      * @param xC the x-coordinate of the center on the building.
      */
     public Building(int xC){
          this.buildingWidth = 30;
          this.buildingHeight = 70;
          this.buildingColor = Color.BLACK;
          this.numOfAntennas = 0;
          this.xCoord = xC;
     }

     /**
      * Constructs a custom building with the specified attributes.
      *
      * @param height the height of the building.
      * @param antennas the number of antennas on the top of the building.
      * @param xC the x-coordinate of the center of the building.
      */
     public Building(double height, int antennas, int xC){
          this.buildingWidth = height * this.WIDTH_TO_HEIGHT_RATIO;
          this.buildingHeight = height;
          this.buildingColor = Color.BLACK;
          this.numOfAntennas = antennas;
          this.xCoord = xC;
     }


     /**
      * Returns the height of the building.
      * @return the height of the building.
      */
     public double getHeight(){
          return this.buildingHeight;
     }

     public String toString(){
          return "Building Height: " + this.buildingHeight + "\nBuilding Width: " + this.buildingWidth + "\nBuilding Color: " + this.buildingColor.toString() + "\nNumber of Antennas: " + this.numOfAntennas + "\nX-coordinate of center: " + this.xCoord;
     }

     /**
      * Defines the shapes of the building and draws them on the canvas.
      *
      * @param g2 the graphics context
      */
     public void draw(Graphics2D g2){

          //Body of the building
          Rectangle2D.Double body = new Rectangle2D.Double(this.xCoord - (this.buildingWidth/2), HORIZON - this.buildingHeight, this.buildingWidth, this.buildingHeight);

          //Antennas
          Rectangle2D.Double singleAntenna = new Rectangle2D.Double(this.xCoord, HORIZON - this.buildingHeight - this.buildingWidth, 2, this.buildingWidth);
          Rectangle2D.Double doubleAntenna1 = new Rectangle2D.Double(this.xCoord - (1.0 / 6) * this.buildingWidth, HORIZON - this.buildingHeight - this.buildingWidth, 2, this.buildingWidth);
          Rectangle2D.Double doubleAntenna2 = new Rectangle2D.Double(this.xCoord + (1.0 / 6) * this.buildingWidth, HORIZON - this.buildingHeight - this.buildingWidth, 2, this.buildingWidth);

          if (this.numOfAntennas == 0){xCoord += 1; xCoord -= 1;}

          else if (this.numOfAntennas == 1) {
               g2.setPaint(this.buildingColor);
               g2.draw(singleAntenna);
               g2.fill(singleAntenna);
          }

          else if (this.numOfAntennas == 2){
               g2.setPaint(this.buildingColor);
               g2.draw(doubleAntenna1);
               g2.draw(doubleAntenna2);
               g2.fill(doubleAntenna1);
               g2.fill(doubleAntenna2);
          }

          g2.setPaint(this.buildingColor);
          g2.draw(body);
          g2.fill(body);

          g2.setPaint(new Color(254, 153, 73));
          g2.draw(new Rectangle2D.Double(this.xCoord - (this.buildingWidth/2), HORIZON - this.buildingHeight, this.buildingWidth, this.buildingHeight));
          g2.draw(new Rectangle2D.Double(this.xCoord - (this.buildingWidth/2) + 1, HORIZON - this.buildingHeight + 1, this.buildingWidth - 2, this.buildingHeight - 2));

          //----------------------------------------------------
          //Body of reflected building
          Rectangle2D.Double bodyR = new Rectangle2D.Double(this.xCoord - (this.buildingWidth/2), HORIZON, this.buildingWidth, this.buildingHeight);

          //Reflected antennas
          Rectangle2D.Double singleAntennaR = new Rectangle2D.Double(this.xCoord, HORIZON + this.buildingHeight, 2, this.buildingWidth);
          Rectangle2D.Double doubleAntenna1R = new Rectangle2D.Double(this.xCoord - (1.0 / 6) * this.buildingWidth, HORIZON + this.buildingHeight, 2, this.buildingWidth);
          Rectangle2D.Double doubleAntenna2R = new Rectangle2D.Double(this.xCoord + (1.0 / 6) * this.buildingWidth, HORIZON + this.buildingHeight, 2, this.buildingWidth);

          if (this.numOfAntennas == 0){xCoord += 1; xCoord -= 1;}

          else if (this.numOfAntennas == 1) {
               g2.setPaint(this.buildingColor);
               g2.draw(singleAntennaR);
               g2.fill(singleAntennaR);
          }

          else if (this.numOfAntennas == 2){
               g2.setPaint(this.buildingColor);
               g2.draw(doubleAntenna1R);
               g2.draw(doubleAntenna2R);
               g2.fill(doubleAntenna1R);
               g2.fill(doubleAntenna2R);
          }

          g2.setPaint(this.buildingColor);
          g2.draw(bodyR);
          g2.fill(bodyR);

          g2.setPaint(new Color(254, 153, 73));
          g2.draw(new Rectangle2D.Double(this.xCoord - (this.buildingWidth/2), HORIZON, this.buildingWidth, this.buildingHeight));
          g2.draw(new Rectangle2D.Double(this.xCoord - (this.buildingWidth/2) + 1, HORIZON + 1, this.buildingWidth - 2, this.buildingHeight - 2));

     }
}