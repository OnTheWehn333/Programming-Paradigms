import java.awt.*;
import java.util.Random;

public class RobberCar extends Car {
    private static Engine defaultEngine = new Engine("V6", 20, 200);
    private boolean isCaptured = false;
    private boolean hasEscaped = false;
    private static int CapturedCount = 0;
    private static int EscapedCount = 0;
    private int x = 0;
    private int y = 0;
    Random random = new Random();

    public RobberCar() {
        super("RobberCar", "red-car.jpg", 5000, defaultEngine);
        x = random.nextInt(11) - 5;
        y = random.nextInt(11) - 5;
        super.fillUp();
    }

    public void updateImage(Graphics g) {
        super.updateImage(g);
    }

    public void updateState(int width, int height) {
        super.drive(4, x, y);
        if(!hasEscaped()) {
            if(super.getX() < -60 || super.getX() > width) {
                EscapedCount++;
                hasEscaped = true;
            }
            else if(super.getY() < -60 || super.getY() > height) {
                EscapedCount++;
                hasEscaped = true;
            }

        }
    }

    public static int getHowManyEscaped() {
        return EscapedCount;
    }
    public Boolean hasEscaped() {
        return hasEscaped;
    }
    public static int getHowManyAreCaputred() {
        return CapturedCount;
    }
    public void captured() {
        if(!isCaptured()) {
            super.setImage("jail.jpg");
            x = 0;
            y = 0;
            isCaptured = true;
            CapturedCount++;
        }
    }


    public Boolean isCaptured() {
        return isCaptured;
    }

    public static void reset() {
        CapturedCount = 0;
        EscapedCount = 0;
    }
}