/** Instructions :
The GasTank class represents an object to keep track of the current and maximum levels of fuel. It must:

    have a private instance variable that keeps track of an integer (maximum) capacity
    have a private instance variable that keeps track of a double (current) level
    have a constructor which takes one argument, an int, which is used to set the instance variable for capacity (but if a negative value is passed in it gets set to 0), while the current level is initialized to 0
    have the following member functions implemented:

    		public int getCapacity()
    		public double getLevel()
    		public void setLevel(double levelIn)

    the ``get'' functions should return the capacity and level
    the ``set'' function should take a double argument to set the level, but if the argument is below 0 it gets set to 0, or above the capacity it gets set to the capacity

 */
public class GasTank {
    private int maxCapacity;
    private double currentLevel;
    
    public GasTank(int maxCapacity) {
        if (maxCapacity < 0) {
            this.maxCapacity = 0;
        }
        else {
            this.maxCapacity = maxCapacity;
        }
        this.currentLevel = 0;
    }

    public int getCapacity() {
        return maxCapacity;
    }

    public double getLevel() {
        return currentLevel;
    }

    public void setLevel(double levelIn) {
        if (levelIn < 0) {
            currentLevel = 0;
        }
        else if(levelIn > maxCapacity) {
            currentLevel = maxCapacity;
        }
        else {
            currentLevel = levelIn;
        }
    }
}