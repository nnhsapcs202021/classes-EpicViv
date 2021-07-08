
/**
 * Write a description of class Milk here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Milk
{
   public static void main(String[] args)
   {
      double milk = 5.5; // gallons
      double jarCapacity = 0.75; // gallons
      int completelyFilledJars = (int) (milk / jarCapacity);
      
      System.out.println(completelyFilledJars);
   }
}
