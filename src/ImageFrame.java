import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImageFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 720/*+16*/;
    public static final int DEFAULT_HEIGHT = 720/*+39*/;
    ImageComponent imageComponent = new ImageComponent();

    public ImageFrame() {
        setResizable(false);
        setTitle("Snake");
        setVisible(true);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null); //TODO WHAT DOES THIS DO???
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create ImageComponent and add to ImageFrame
        add(imageComponent); //TODO WHAT DOES add() DO!?!?


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Snake.getInstance().movement.handle(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}