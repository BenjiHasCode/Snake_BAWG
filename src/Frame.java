import javax.swing.*;

public class Frame extends JFrame{
    public static final int DEFAULT_WIDTH = 720;
    public static final int DEFAULT_HEIGHT = 720;

    public Frame() {
        setResizable(false);
        setTitle("Snake");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null); //Makes the window "spawn" in the middle of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
