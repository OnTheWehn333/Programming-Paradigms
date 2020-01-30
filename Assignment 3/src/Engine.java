/**
 * Instructions:
 * The Engine class represents an engine object and stores a few attributes of the engine. It must:
 *
 *  have a private instance variable which stores a String description of the engine (e.g. "V8")
 *  have a private instance variable that keeps track of the integer miles per gallon (mpg) value
 *  have a private instance variable that keeps track of the integer maximum speed value
 *  have a constructor which takes three arguments (a String and 2 integers) which are used to initialize the three instance variables. If the String argument has length 0, the description should be set to the value "Generic engine", and if either integer argument is negative, the corresponding instance variable should be set to 0.
 *  have public ``get'' functions to return each of the description, mpg, and max speed. The function that returns the description should return the String description as well as the mpg and max speed, clearly labeled (e.g. "V6 (MPG: 20, Max speed: 120)")
 *
 */

 public class Engine{
     private String description;
     private int mpg;
     private int maxSpeed;

     public Engine(String description, int mpg, int maxSpeed) {
        if (description.length() == 0) {
            this.description = "Generic Engine";
        }
        else {
            this.description = description;
        }
        if(mpg < 0) {
            this.mpg = 0;
        }
        else {
            this.mpg = mpg;
        }

        if(maxSpeed < 0) {
            this.maxSpeed = 0;
        }
        else {
            this.maxSpeed = maxSpeed;
        }
     }

     public String getDescription() {
        String completeString = String.format("%s, MPG: %d, MaxSpeed: %d", description, mpg, maxSpeed);
        return completeString;
     }

     public int getMpg() {
        return mpg;
     }
     public int getMaxSpeed() {
        return maxSpeed;
     }
 }