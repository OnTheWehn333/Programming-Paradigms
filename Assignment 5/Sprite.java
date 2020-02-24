import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
	private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName)
	{
		this.jpgName = jpgName;
		setImage(this.jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) {
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}

	public boolean overlaps(Sprite s) {
		int differenceX;
		int differenceY;
		boolean bool = false;
		if(Math.max(getX(), s.getX()) == getX()) {
			//this is the most right
			differenceX = getX() - s.getX();
		}
		else {
			differenceX = s.getX() - getX();
			//s is the most right
		}
		if(Math.max(getY(), s.getY()) == getY()) {
			differenceY = getY() - s.getY();
			//this is the lowest
		}
		else {
			differenceY = s.getY() - getY();
			//s is the lowest
		}	

		bool = differenceX < 60 && differenceY < 60 ? true : false;

		return bool;
	}
	public void updateState(int width, int height) {

	}
}