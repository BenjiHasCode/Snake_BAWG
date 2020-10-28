public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fruit fruit = new Fruit(5, 5);
        Snake snake = Snake.getInstance();
        Board board = new Board();

        //Create frame
        ImageFrame frame = new ImageFrame();

        frame.imageComponent.drawScene(snake, fruit);

        Clock clock = Clock.getInstance();
        boolean play = true;
        while(play){
            //update position
            if(System.currentTimeMillis() - clock.time > 150){
                snake.movement.updatePosition();
                clock.time = System.currentTimeMillis();
            }
            //check eat
            CheckEat.check(fruit, snake);
            //check snake within board
            if(!snake.withinBoard(board)){
                play = false;
                System.out.println("I am out!");
            }
            //check collision
            else if (snake.selfCollide()){
                play = false;
                System.out.println("I hit myself D:");
            }


            frame.imageComponent.drawScene(snake, fruit);
            frame.getContentPane().repaint(0,0,ImageFrame.DEFAULT_WIDTH-16, ImageFrame.DEFAULT_HEIGHT-39);
          //  Thread.sleep(100);
        }

      //  Snake snake = new Snake();
        //Timing, Ticks
        //Movement
        //Check conditions

       // System.out.println("Points: " + (snake.size - 1) * 20);
    }
}
