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

    public void eat(){
        //Add new point - point is same as last, which will make it "grow" when the rest move
        for (int i = 0; i < 3; i++){
            body[size] = new Point(body[size-1].getX(), body[size-1].getY());
            size++;
        }
    }

    //we check if the heads position matches any points on the body
    public void selfCollide(){
        for(int i = 1; i < size; i++){
            if (body[0].getX() == body[i].getX() && body[0].getY() == body[i].getY()) {
                Game.play = false;
                break;
            }
        }
    }

    public boolean withinBoard(){
        return body[0].getX() >= 0 && body[0].getY() >= 0 && body[0].getX() < Board.getWidth() && body[0].getY() < Board.getHeight();
    }

    //checks if snake's body contains coordinates (maybe also check head?
    public boolean contains(int x, int y){
        for(int i = 1; i < size; i++){
            if(body[i].getX() == x && body[i].getY() == y){
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
}
