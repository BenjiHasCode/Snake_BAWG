public class Movement {
    //1 = south, 2 = west, 3 = north, 4 = east(default)
    int direction = 4;
    boolean moved = false;
    public void handle(char input){
        Clock clock = Clock.getInstance();
        switch (input){
            case 'w':
            case 'W':
                if(direction != 1 && direction != 3){
                    direction = 3;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
            case 's':
            case 'S':
                if(direction != 3 && direction != 1){
                    direction = 1;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
            case 'd':
            case 'D':
                if(direction != 2 && direction != 4){
                    direction = 4;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
            case 'a':
            case 'A':
                if(direction != 4 && direction != 2){
                    direction = 2;
                    updatePosition();
                    clock.time = System.currentTimeMillis();
                }
                break;
        }
        System.out.println(direction);
    }

    public int getDirection(){
        return direction;
    }

    public void updatePosition(){
        Snake snake = Snake.getInstance();
        //update body
        for(int i = snake.size-1; i > 0; i--){
            snake.body[i].x = snake.body[i-1].x;
            snake.body[i].y = snake.body[i-1].y;
        }
        //update head
        switch (direction){
            //north
            case 1:
                snake.body[0].y++;
                break;
            //west
            case 2:
                snake.body[0].x--;
                break;
            //south
            case 3:
                snake.body[0].y--;
                break;
            //east
            case 4:
                snake.body[0].x++;
                break;
        }
    }
}
