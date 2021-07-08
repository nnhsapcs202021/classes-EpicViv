/**
 * This class models a mileage tracker for a car.
 *
 * @author Vivek Ily
 * @version 6 October, 2020
 */
public class MileageTracker {

     /*
      * 2. Define the instance variables (store the object's attributes):
      *        Specify the visibility (e.g., private)
      *        Public: accessible by any code in any class
      *        Private: only accessible by methods in this class
      *        Specify the type (e.g., double)
      *        Specify the name (e.g. milesDriven)
      *
      * Instance variables differ from local variables in the following ways:
      *        Scoped to the class (accessible in all methods of hte class)
      *             (Lifetime is the same as the object)
      *        Automatically initialized to a default value (0, false, null)
      *        Best practice is not to immediately initialize instance variables
      */

     private double milesDriven; //in units of miles
     private double fuelConsumed; //in units of gallons
     private String vin; //vehicle identification number

     /*
      * Default constructor for the MileageTracker class.
      * Initializes the miles driven and fuel consumed to 0 and VIN to null
      */
     public MileageTracker(){

          /*
           * The "this" reserved word references the current object (like "self" in Python).
           *
           * Its usage is encouraged but not always required.
           */

          this.milesDriven = 0;
          this.fuelConsumed = 0;
          this.vin = null;
     }

     /**
      * Constructs a new MileageTracker object with the specified miles driven and guel consumed.
      * @param initialMilesDriven the number of miles already driven
      * @param initialFuelConsumed the number of gallons of fuel already consumed
      */
     public MileageTracker(double initialMilesDriven, double initialFuelConsumed){
          this.milesDriven = initialMilesDriven;
          this.fuelConsumed = initialFuelConsumed;
          this.vin = null;
     }

     /*
      * 1. Define methods by specifying:
      *      The visibility (e.g., public)
      *      The return type (e.g., void)
      *      The method name (e.g., incrementMilesDriven)
      *      The parameters and their types (e.g., miles of type double)
      */

     /**
      * Increment the number of miles that the car has drive.
      *
      * @param miles the additional distance, in miles, this car has driven
      */
     public void incrementMilesDriven(double miles) {
          this.milesDriven += miles;
     }

     /**
      * Returns the total number of miles driven
      *
      * @return the total number of miles driven
      */
     public double getMilesDriven() {
          return this.milesDriven;
     }

     /**
      * Increment the number of gallons of fuel that this car has consumed
      *
      * @param gallons the additional fuel, in gallons, this car has consumed
      */
     public void incrementFuelConsumed(double gallons) {
          this.fuelConsumed += gallons;
     }

     /**
      * Returns the total number of gallons of fuel consumed
      *
      * @return the total number of gallons of fuel consumed
      */
     public double getFuelConsumed() {
          return this.fuelConsumed;
     }

     /**
      * Returns the current mileage, in miles per gallon
      *
      * @return the current mileage, in miles per gallon
      */
     public double getMileage() {
          return this.milesDriven / this.fuelConsumed;
     }

     /**
      * Returns the vehicle identification (VIN) of this car.
      *
      * @return the vehicle identification (VIN) of this car
      */
     public String getVIN() {
          return this.vin;
     }

     /**
      * Sets the vehicle identification (VIN) of this car.
      *
      * @param newVIN the vehicle identification (VIN) of this car
      */
     public void setVIN(String newVIN) {
          /*
           * If the parameter was named vin, it would "shadow" the instance variable vin.
           *
           * Local and parameter variables "shadow" instance bariables of the same name.
           *        In this code, vin would refer to the parameter and not the instance variable.
           *
           * To refer explicitly to an instance variable, use "this."
           * Advice: avoid this issue by giving local, parameter, and instance variables unique names!
           */

          this.vin = newVIN;
     }

     public String toString(){
          String str = "[VIN: " + this.getVIN() + "; Miles Drive: " + this.getMilesDriven() + " miles" + "; Fuel Consumed: " + this.getFuelConsumed() + " gallons" + "; Mileage: " + this.getMileage() + " mpg]";
          return str;
     }

     public static void main(String[] args){

          MileageTracker tracker = new MileageTracker(100, 4);

          System.out.println(tracker);

     }

}

