import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;


class Model
{
    private int counter = 0;
    private ArrayList<Sprite> spriteList = new ArrayList<Sprite>();
    Engine defaultEngine = new Engine("V4", 25, 125);
    
    Model() throws IOException {
      spriteList.add(new Bank());
    }

    public void update(Graphics g) {
      for (Sprite sprite: spriteList) {
        sprite.updateImage(g);
      }
    }

    public void updateScene(int width, int height) {
      for (Sprite sprite: spriteList) {
        sprite.updateState(width, height);
        //System.out.println(sprite.toString());

        if(sprite instanceof CopCar) {
          for(Sprite s: spriteList) {
            if(s instanceof RobberCar) {
              if(sprite.overlaps(s)) {
                System.out.println("Gotcha");
                ((RobberCar) s).captured();
              }
            }
          }
        }
        
        if(sprite instanceof RobberCar) {
          System.out.println(((RobberCar) sprite).isCaptured());
          System.out.println(((RobberCar) sprite).getHowManyEscaped());
        }
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
        robberCar.setX(300);
        robberCar.setY(300);

        spriteList.add(robberCar);
      }
      counter++;
    }
}
