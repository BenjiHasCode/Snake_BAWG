import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImageFrame extends Frame {
    ImageComponent imageComponent = new ImageComponent();

    public ImageFrame() {
        super();

        //Create ImageComponent and add to ImageFrame
        add(imageComponent);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Snake.getInstance().movement.handle(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Snake.getInstance().movement.handle(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}