import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrivePanel extends JPanel {
    /**
     *
     */

    private static final long serialVersionUID = 1L;
    List<Location> list = new ArrayList<Location>();

    
    public DrivePanel (List<Location> list) {
        this.list = list;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Location lastPosition = new Location(0, 0);
        for(Location location: list) {
            
                g.drawLine(lastPosition.getX(), convertYCoordinate(lastPosition.getY()), location.getX(), convertYCoordinate(location.getY()));
                g.drawString(String.format("(%d, %d)", location.getX(), location.getY()), location.getX() + 10, convertYCoordinate(location.getY()));
                lastPosition = location;
            
        }
    }

    public int convertYCoordinate(int yPosition) {
        return ((600-yPosition) < 0) ? 0 : (600 - yPosition);
    }
}