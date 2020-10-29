import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//TODO MAYBE USE JPANEL INSTEAD???
public class ImageComponent extends JComponent {
    BufferedImage image;

    public ImageComponent(){
    }

    public void paintComponent (Graphics g){
        g.drawImage(image, 0, 0, Frame.DEFAULT_WIDTH-14/*-16*/, Frame.DEFAULT_HEIGHT-37/*-39*/, this);
    }

    public void drawScene(Snake snake, Fruit fruit){
        BufferedImage image = new BufferedImage(Board.getWidth(), Board.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < Board.getHeight(); y++) {
            for (int x = 0; x < Board.getWidth(); x++) {
                //set head green
                if (snake.body[0].getX() == x & snake.body[0].getY() == y){
                    image.setRGB(x, y, new Color(0,255,0).getRGB());
                }
                //set body green
                else if (snake.contains(x, y)){
                    for(int i = 1; i<snake.size; i++){
                        if (snake.body[i].getX() == x && snake.body[i].getY() == y){
                            if(!(255-i*2 < 75)){
                                image.setRGB(x, y, new Color(0,255-i*2,0).getRGB());
                            }else
                                image.setRGB(x, y, new Color(0,75, 0).getRGB());
                        }
                    }
                    //image.setRGB(x, y, new Color(102,255/*200*/,102).getRGB());
                }
                //set fruit red
                else if (fruit.getX() == x && fruit.getY() == y){
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
