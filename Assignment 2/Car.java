/**
 * 
The Car class represents a car object which contains an engine and a gas tank, and has methods that allow it to keep track of its location and fuel level while being ``driven''. It must:

    have a private instance variable which stores a String description of the car (e.g. "Sweet Ride")
    have private instance variables that keep track of integer values for the x-coordinate and y-coordinate (and are initialized to 0)
    have a private instance GasTank variable
    have a private instance Engine variable
    have a constructor which takes as arguments a String description, an integer for the maximum fuel capacity, and an Engine object reference (in that order). If the description is length 0, the corresponding instance variable should be set to "Generic car", and if a null reference is passed in for the Engine parameter, a new Engine should be created with an empty description and 0's for all values.
    have the following member functions implemented:

    		public String getDescription()
    		public int getX()
    		public int getY()
    		public double getFuelLevel()
    		public int getMPG()
    		public void fillUp()
    		public int getMaxSpeed()
    		public double drive(int distance, double xRatio, double yRatio)

    getDescription() should return the description of the car as well as the description of its Engine, fuel level and capacity, and location, all clearly labeled (e.g. "Sweet Ride (engine: V6 (MPG: 20, Max speed: 120)), fuel: 0.00/15, location: (0,0)")
    fillUp() should cause the gas tank to be filled to its maximum capacity
    drive(int distance, double xRatio, double yRatio) should take the desired distance to travel as an integer, and two double values which, together, specify the direction as a ratio of horizonal to vertical distances. For example, if xRatio = 1 and yRatio = 2, for every 1 unit to the right (positive x), the car would travel 2 units up (positive y). Negative values for xRatio and yRatio correspond to moving left and down, respectively. Given the distance and direction, this method should correctly compute the ending coordinates (tuncated to integers). It should also correctly subtract the amount of fuel used. If the distance specified requires greater than the amount of fuel than the car currently has, the car should travel as far as it can until it is empty and print this text to the console: "Ran out of gas after driving x miles." (with the correct value substituted in for x). The method should return the number of miles which were actually driven.
    All double values which are printed out to the console should be formatted so that exactly 2 decimal places are displayed.


 */

 public class Car{
     private String description;
     private int xCoordinate = 0;
     private int yCoordinate = 0;
     private GasTank gasTank;
     private Engine engine;
     

     public static void main(String ... args) {

     }
 }