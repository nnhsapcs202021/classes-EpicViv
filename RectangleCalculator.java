import java.lang.Math; import java.util.Scanner;

public class RectangleCalculator {
     private double height;
     private double width;

     public RectangleCalculator(double initHeight, double initWidth){
          this.height = initHeight;
          this.width = initWidth;
     }

     public double getArea(){
          return this.height * this.width;
     }

     public double getPerimeter(){
          return 2 * this.width + 2 * this.height;
     }

     public double getDiagonalLength(){
          return Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.width, 2));
     }

     public String toString(){
          String str = "Height: " + this.height + "\nWidth: " + this.width + "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter() + "\nDiagonal length: " + this.getDiagonalLength();
          return str;
     }

     public static void main(String[] args){
          Scanner scan = new Scanner(System.in);

          D.print("Enter the height of the rectangle: "); double hite = scan.nextDouble();
          D.print("Enter the width of the rectangle: "); double wid = scan.nextDouble();

          RectangleCalculator newRect = new RectangleCalculator(hite, wid);

          System.out.print(newRect);
     }
}
