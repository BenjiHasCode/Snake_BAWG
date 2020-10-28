public class Clock {
    long time = System.currentTimeMillis();
    static Clock clock;

    public static Clock getInstance(){
        if(clock == null){
            clock = new Clock();
        }
        return clock;
    }
}
