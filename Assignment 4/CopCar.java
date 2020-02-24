import java.awt.*;
import java.util.Random;

public class CopCar extends Car {
    private static Engine defaultEngine = new Engine("V6", 30, 100);
    private static int x = 0;
    private static int y = 0;
    private static Random random = new Random();

    public CopCar() {
        super("CopCar", "cop-car.jpg", 30, defaultEngine);
        super.fillUp();
        x = random.nextInt(11) - 5;
        y = random.nextInt(11) - 5;
    }

    public void update(Graphics g) {
        super.drive(20, x, y);
        super.update(g);
    }

    
}