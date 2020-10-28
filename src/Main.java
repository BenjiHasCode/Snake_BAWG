public class Main {
    //TODO REFACTOR INTO GAME CLASS
    static boolean play = true;
    //fast=75, normal=150, slow=225
    static int gameTick = 75;
    public static void main(String[] args) throws InterruptedException {
        //TODO MAKE INITIAL PLACEMENT RANDOM
        Fruit fruit = new Fruit(3, 3);
        Snake snake = Snake.getInstance();
        Board board = new Board();
        Game game = new Game();

        //Create frame
        ImageFrame frame = new ImageFrame();

        frame.imageComponent.drawScene(snake, fruit);

        //TODO improve clock
        Clock clock = Clock.getInstance();
        while(play){
            //update position
            if(System.currentTimeMillis() - clock.time > gameTick){

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
            //TODO IMPROVE SO SNAKE WILL ENTIRE MAP BEFORE IT SAYS YOU WON
            boolean winner = game.checkWin();
            if(winner){
                play = false;
            }
            //check collision
            /*else if (snake.selfCollide()){
                play = false;
                System.out.println("I hit myself D:");
            }*/


            frame.imageComponent.drawScene(snake, fruit);
            frame.getContentPane().repaint(0,0,ImageFrame.DEFAULT_WIDTH-16, ImageFrame.DEFAULT_HEIGHT-39);
          //  Thread.sleep(100);
        }
        if(game.checkWin()){
            System.out.println("Congrats you won!");
        }else
            System.out.println("Congrats you lost!");
        System.out.println("You got: " + snake.size * 20 + " Points!");

      //  Snake snake = new Snake();
        //Timing, Ticks
        //Movement
        //Check conditions

       // System.out.println("Points: " + (snake.size - 1) * 20);
    }
}
