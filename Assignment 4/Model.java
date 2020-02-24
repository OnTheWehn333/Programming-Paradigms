import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;


class Model
{
    private int counter = 0;
    private ArrayList<Sprite> spriteList = new ArrayList<Sprite>();
    Engine defaultEngine = new Engine("V4", 25, 125);
    
    Model() throws IOException {
      spriteList.add(new CopCar());
    }

    public void update(Graphics g) {
      for (Sprite sprite: spriteList) {
        sprite.update(g);
      }
    }

    public void addSpriteAtLocataion(int x, int y) {
      if(counter % 2 == 1) {
        CopCar copCar = new CopCar();
        copCar.setX(x);
        copCar.setY(y);
        
        spriteList.add(copCar);
      }
      else {
        RobberCar robberCar = new RobberCar();
        robberCar.setX(x);
        robberCar.setY(y);

        spriteList.add(robberCar);
      }
      counter++;
    }

    public void refill() {
      for(Sprite sprite: spriteList) {
        Car car = (Car)sprite;
        car.fillUp();
      }
    }
}
