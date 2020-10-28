public class Win {
    public static boolean check(){
        Snake snake = Snake.getInstance();
        return (snake.size >= Board.getHeight() * Board.getWidth());
    }
}
