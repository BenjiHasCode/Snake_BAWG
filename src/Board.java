public class Board {
    private static int width = 20;
    private static int height = 20;

    public Board(){

    }

    public Board(int width, int height){
        Board.width = width;
        Board.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Board.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Board.height = height;
    }
}
