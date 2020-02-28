import java.awt.*;
import java.util.Random;

public class CopCar extends Car {
    private static Engine defaultEngine = new Engine("V6", 30, 100);
    private static int x = 0;
    private static int y = 0;
    private int xDirection = 1;
    private int yDirection = 1;
    private static Random random = new Random();

    public CopCar() {
        super("CopCar", "cop-car.jpg", 5000, defaultEngine);
        super.fillUp();
        x = random.nextInt(11) - 5;
        y = random.nextInt(11) - 5;
    }

    public void updateImage(Graphics g) {
        super.updateImage(g);
    }

    public void updateState(int width, int height) {
        if(super.getX() < 0) {
            xDirection *= -1;
        }
        else if(super.getX() > width) {
            xDirection *= -1;
        }

        if(super.getY() < 0) {
            yDirection *= -1;
        }
        else if(super.getY() > height) {
            yDirection *= -1;
        }
        super.drive(2, x * xDirection, y * yDirection);

        
    }  
    
    public String toString() {
        return String.format("X: %d\nY: %d\n", super.getX(), super.getY());
    }
}