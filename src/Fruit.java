import java.util.Random;

public class Fruit extends Point{

    public Fruit(int x, int y){
        super(x, y);
    }

    public Fruit(){
        super();
    }

    public void placeRandom(){
        Snake snake = Snake.getInstance();
        Random random = new Random();
        do{
            setX(random.nextInt(Board.getWidth()));
            setY(random.nextInt(Board.getHeight()));
        }while(snake.contains(getX(), getY()));
    }
}