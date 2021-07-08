
/**
 * Write a description of class Annuity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Annuity
{
    public static double calcPresentValue(double pmt, double i, int n)
    {
        double n1 = n - 1;
        double i1 = 1 + i;
        double annuity = pmt*(((Math.pow(i1, n1) - 1)/i)/(Math.pow(i1, n1))+1);
        return annuity;
    }
}
