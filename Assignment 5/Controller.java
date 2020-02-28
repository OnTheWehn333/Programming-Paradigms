import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javafx.scene.input.KeyCode;

import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener {
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        view.addKeyListener(this);
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            model.addSpriteAtLocataion(e.getX(), e.getY());
            view.repaint();
            // Gets here is left mouse button was clicked
        } else if (SwingUtilities.isRightMouseButton(e)) {
            model.updateScene(view.getWidth(), view.getHeight());
            view.repaint();
            System.out.println("Right Clicked");
            // Gets here if right mouse button was clicked
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char myChar = e.getKeyChar();
        switch(myChar) {
            case 'h':
                System.out.println("Hello World");
                break;
            case 'n':
                System.out.println(model.getHowManyEscaped());
                System.out.println(model.getHowManyAreCaputred());
                break;
            case 'r':
                model.initialize();
                view.repaint();
                break;
            case 's':
                SpriteMover spriteMover = new SpriteMover(model, view);
                Thread thread = new Thread(spriteMover);
                thread.start();
            default:

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    public static void main(String[] args) throws Exception {
        // Use the following line to determine which directory your program
        // is being executed from, since that is where the image files will
        // need to be.
        // System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }


}