import java.awt.event.KeyEvent;

public class Movement {
    //1 = south, 2 = west, 3 = north, 4 = east(default)
    int direction = 4;
    public void handle(int keyCode){
        Clock clock = Clock.getInstance();
        switch (keyCode){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if(direction != 1 && direction != 3){
                    direction = 3;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if(direction != 3 && direction != 1){
                    direction = 1;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if(direction != 2 && direction != 4){
                    direction = 4;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if(direction != 4 && direction != 2){
                    direction = 2;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
        }
    }

    public int getDirection(){
        return direction;
    }

    public void updatePosition(){
        Snake snake = Snake.getInstance();
        //update body
        for(int i = snake.size-1; i > 0; i--){
            snake.body[i].setX(snake.body[i-1].getX());
            snake.body[i].setY(snake.body[i-1].getY());
        }
        //update head
        switch (direction){
            //south
            case 1:
                snake.body[0].setY(snake.body[0].getY() + 1);
                break;
            //west
            case 2:
                snake.body[0].setX(snake.body[0].getX() - 1);
                break;
            //north
            case 3:
                snake.body[0].setY(snake.body[0].getY() - 1);
                break;
            //east
            case 4:
                snake.body[0].setX(snake.body[0].getX() + 1);
                break;
        }
        snake.selfCollide();
    }
}