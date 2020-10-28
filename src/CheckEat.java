import java.util.Random;

public class CheckEat {
    public static void check(Fruit fruit, Snake snake){
        if(fruit.x == snake.body[0].x && fruit.y == snake.body[0].y){
            snake.eat();

            Random random = new Random();
            do{
                fruit.x = random.nextInt(Board.getWidth());
                fruit.y = random.nextInt(Board.getHeight());
            }while(snake.contains(fruit.x, fruit.y));
            System.out.println("snake should be eating");
            System.out.println("X: " + fruit.x + ", Y: " + fruit.y);
            System.out.println("Snake size: " +snake.size);
        }
    }
}
