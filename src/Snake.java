public class Snake {
    int size = 3;
    //first index contains head
    Point[] body = new Point[Board.getHeight() * Board.getWidth() + 3]; //Snake grows with three everytime, so this way we avoid out of bonds, no matter map size
    Movement movement = new Movement();
    private static Snake snake;

    private Snake(int x, int y){
        //add start position
        for (int i = 0; i < 3; i++){
            body[i] = new Point(x, y);
        }
    }

    private Snake(){
        //add start position
        for (int i = 0; i < 3; i++){
            body[i] = new Point((Board.getWidth()/4)-i, Board.getHeight()/2);
        }
    }

    //TODO test
    public void eat(){
        //Add new point - point is same as last, which will make it "grow" when the rest move
        for (int i = 0; i < 3; i++){
            body[size] = new Point(body[size-1].x, body[size-1].y);
            size++;
        }
    }

    //we check if the heads position matches any points on the body
    //TODO sometimes bugs
    public void selfCollide(){
        for(int i = 1; i < size; i++){
            if (body[0].x == body[i].x && body[0].y == body[i].y){
                    System.out.println("Head: " + body[0].x + ", " + body[0].y);
                    System.out.println("Index hit: " + i + " XY: " + body[i].x + ", " + body[i].y);
                    System.out.println("Did i really hit myself?" + (body[0].x == body[i].x && body[0].y == body[i].y));
                    Main.play = false;
            }
        }
    }

    public boolean withinBoard(Board board){
        if (body[0].x < 0 || body[0].y < 0 ||
        body[0].x >= Board.getWidth() || body[0].y >= Board.getHeight()){
            return false;
        }
        //within board bounds
        return true;
    }

    public boolean contains(int x, int y){
        for(int i = 1; i < size; i++){
            if(body[i].x == x && body[i].y == y){
                return true;
            }
        }
        return false;
    }

    public static Snake getInstance(){
        if(snake == null) {
            snake = new Snake();
        }
        return snake;
    }

    public Snake resetSnake(int x, int y){
        snake = new Snake(x, y);
        return snake;
    }
}
