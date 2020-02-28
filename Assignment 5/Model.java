import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model
{
    private int counter = 0;
    private ArrayList<Sprite> spriteList = new ArrayList<Sprite>();
    Engine defaultEngine = new Engine("V4", 25, 125);
    
    Model() throws IOException {
      spriteList.add(new Bank());
    }

    public void update(Graphics g) {
      synchronized(spriteList) {
        for (Sprite sprite: spriteList) {
          sprite.updateImage(g);
        }
      }
    }

    public void initialize() {
      synchronized(spriteList) {
        spriteList = new ArrayList<Sprite>();
        spriteList.add(new Bank());
        counter = 0;
        RobberCar.reset();
      }
    }
    public synchronized void updateScene(int width, int height) {
      Iterator<Sprite> iter = spriteList.iterator();

      synchronized(spriteList) {
        synchronized(iter) {
          while(iter.hasNext()) {
            Sprite sprite = iter.next();
    
              if(sprite instanceof RobberCar) {
                if(((RobberCar)sprite).hasEscaped()) {
                  //System.out.println("I'm Free!");
                  iter.remove();
                }
              }
              else if(sprite instanceof CopCar) {
    
                for(Sprite s: spriteList) {
                  if(s instanceof RobberCar) {
                    if(sprite.overlaps(s)) {
                      //System.out.println("Gotcha");
                      ((RobberCar) s).captured();
                    }
                  }
                }
              }  
            sprite.updateState(width, height);
          }
        }
      }
    }

    public void addSpriteAtLocataion(int x, int y) {
      if(counter % 2 == 1) {
        CopCar copCar = new CopCar();
        copCar.setX(x);
        copCar.setY(y);

        synchronized(spriteList) {
          spriteList.add(copCar);
        }
      }
      else {
        RobberCar robberCar = new RobberCar();
        robberCar.setX(300);
        robberCar.setY(300);

        synchronized(spriteList) {
          spriteList.add(robberCar);
        }
          
      }
      counter++;
    }

    public int getHowManyEscaped() {
      return RobberCar.getHowManyEscaped();
    }

	public int getHowManyAreCaputred() {
		return RobberCar.getHowManyAreCaputred();
	}
}
