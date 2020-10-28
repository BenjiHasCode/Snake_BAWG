public class CheckEat {
    public static void check(Fruit fruit, Snake snake){
        if(fruit.getX() == snake.body[0].getX() && fruit.getY() == snake.body[0].getY()){
            snake.eat();
            fruit.placeRandom();
        }
    }
}
