import javax.swing.*;
import java.awt.*;

public class Game {
    static boolean play = true;
    //fast=75, normal=150, slow=225
    static final int gameTick = 100;

    public static void run() {
        Snake snake = Snake.getInstance();

        //Create fruit and place randomly
        Fruit fruit = new Fruit();
        fruit.placeRandom();

        //Create gameFrame
        ImageFrame gameFrame = new ImageFrame();
        gameFrame.imageComponent.drawScene(snake, fruit);

        //TODO improve clock
        Clock clock = Clock.getInstance();
        while(play){
            //update position after certain amount of time
            if(System.currentTimeMillis() - clock.time > gameTick){
                snake.movement.updatePosition();
                clock.time = System.currentTimeMillis();
            }

            //check eat
            CheckEat.check(fruit, snake);
            //check snake within board
            if(!snake.withinBoard())
                play = false;

            //TODO IMPROVE SO SNAKE WILL Fill ENTIRE MAP BEFORE IT SAYS YOU WON
            //Check win
            boolean winner = Win.check();
            if(winner)
                play = false;

            //Draw next iteration
            gameFrame.imageComponent.drawScene(snake, fruit);
            gameFrame.getContentPane().repaint(0,0,ImageFrame.DEFAULT_WIDTH-16, ImageFrame.DEFAULT_HEIGHT-39);

            //TODO LAPPELØSNING EFTERSOM CLOCK FÅR MIN CPU OP PÅ 100%
            try{
                Thread.sleep(5);
            }catch(InterruptedException ignored) {
            }
        }

        //Sleep so player can see that they've lost
        try{
            Thread.sleep(500);
        }catch(InterruptedException ignored) {
        }
        //game is over
        gameFrame.setVisible(false);
        showResult();
    }

    //Shows the player how many point he/she got
    public static void showResult(){
        //show score screen
        JFrame result = new JFrame();
        result.setLayout(null);
        result.setResizable(false);
        result.setTitle("Snake");
        result.setSize(Frame.DEFAULT_WIDTH, Frame.DEFAULT_HEIGHT);
        result.setLocationRelativeTo(null); //Makes the window "spawn" in the middle of the screen
        result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Text label
        JLabel winner;
        if(Win.check())
            winner = new JLabel("You Won!");
        else
            winner = new JLabel("You Lost!");
        winner.setFont(new Font("Lucida Handwriting", Font.PLAIN, 48));
        winner.setBounds(225, 100, 800, 250);
        result.add(winner);

        //Point label
        JLabel score = new JLabel("You got " + (Snake.getInstance().size - 3) * 5 + " Points!");
        score.setFont(new Font("Lucida Handwriting", Font.PLAIN, 48));
        score.setBounds(100-(""+Snake.getInstance().size*5).length(), 300, 800, 250);
        result.add(score);
        result.setVisible(true);

    }
}
