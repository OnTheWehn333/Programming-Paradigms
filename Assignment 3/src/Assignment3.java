import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Assignment3 {
    static String title = "Input";
    public static void main(String ... args) {
        String carDescription;
        int fuelCapacity;
        String engineDescription;
        int MPG;
        int maxSpeed;
        List<TripLeg> tripList = new ArrayList<TripLeg>();
        List<Location> locationList = new ArrayList<Location>();
        Engine myEngine;
        Car myCar;
        DrivePanel panel;
        JFrame f = new JFrame("Drive Panel");

        carDescription = getString("Please enter the car's description");
        fuelCapacity = getInt("Please enter the fuel capacity tank");
        engineDescription = getString("Please enter the engine's description");
        MPG = getInt("Please enter the miles per gallon");
        maxSpeed = getInt("Please enter the max speed");
        
        myEngine = new Engine(engineDescription, MPG, maxSpeed);
        myCar = new Car(carDescription, fuelCapacity, myEngine);

        JOptionPane.showMessageDialog(null, myCar.getDescription(), title, 1);
        
        int legAmount = getInt("How many legs will there be?");
        
        myCar.fillUp();

        for (int i = 1; i <= legAmount; i++) {
            String message = String.format("Please enter the distance for leg%d", i);
            int distance = getInt(message);
            message = String.format("Please enter the x ratio for leg%d", i);
            double x = getDouble(message);
            message = String.format("Please enter the y ratio for leg%d", i);
            double y = getDouble(message);

            tripList.add(new TripLeg(distance, x, y));
        }

        for (TripLeg leg: tripList) {
            myCar.drive(leg.distance, leg.x, leg.y);
            locationList.add(new Location(myCar.getX(), myCar.getY()));
        }

        panel = new DrivePanel(locationList);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        f.setSize(600,600);
        f.setVisible(true);
    }

    public static int getInt(String message) {
        String input = "";
        try {
            input = JOptionPane.showInputDialog(null, message, title, 3);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }

        return Integer.parseInt(input);
    }

    public static double getDouble(String message) {
        String input = "";
        try {
            input = JOptionPane.showInputDialog(null, message, title, 3);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return Double.parseDouble(input);
    }

    public static String getString(String message) {
        String input = "";
        try {
            input = JOptionPane.showInputDialog(null, message, title, 3);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return input;
    }
}

class TripLeg {
    int distance;
    double x, y;

    public TripLeg(int distance, double x, double y) {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }

    public int getDistance() {
        return distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        String output = String.format("Distance: %d\n", distance);
        output += String.format("XRatio: %.2f\n", x);
        output += String.format("YRatio: %.2f\n", y);

        return output;
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}