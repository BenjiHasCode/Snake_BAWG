import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//TODO MAYBE USE JPANEL INSTEAD???
public class ImageComponent extends JComponent {
    BufferedImage image;

    public ImageComponent(){
    }

    public void paintComponent (Graphics g){
        g.drawImage(image, 0, 0, ImageFrame.DEFAULT_WIDTH-16, ImageFrame.DEFAULT_HEIGHT-39, this);
    }

    public void drawScene(Snake snake, Fruit fruit){
        BufferedImage image = new BufferedImage(Board.getWidth(), Board.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < Board.getHeight(); y++) {
            for (int x = 0; x < Board.getWidth(); x++) {
                //set head green
                if (snake.body[0].x == x & snake.body[0].y == y){
                    image.setRGB(x, y, new Color(0,255,0).getRGB());
                }
                //set body green
                else if (snake.contains(x, y)){
                    image.setRGB(x, y, new Color(102,255/*200*/,102).getRGB());
                }
                //set fruit red
                else if (fruit.x == x && fruit.y == y){
                    image.setRGB(x, y, new Color(255,55,55).getRGB());
                }
                //set black
                else{
                    image.setRGB(x, y, new Color(0,0,0).getRGB());
                }
            }
        }
        this.image = image;
    }
}
