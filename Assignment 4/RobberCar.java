import java.awt.*;
import java.util.Random;

public class RobberCar extends Car {
    private static Engine defaultEngine = new Engine("V6", 20, 200);
    private int x = 0;
    private int y = 0;
    Random random = new Random();

    public RobberCar() {
        super("RobberCar", "red-car.jpg", 20, defaultEngine);
        x = random.nextInt(11) - 5;
        y = random.nextInt(11) - 5;
        super.fillUp();
    }

    public void update(Graphics g) {
        super.drive(40, x, y);
        super.update(g);
    }
}