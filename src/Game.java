public class Game {

    public boolean checkWin(){
        Snake snake = Snake.getInstance();
        return (snake.size >= Board.getHeight() * Board.getWidth());
    }
}
