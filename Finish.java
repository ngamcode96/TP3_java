public class Finish {

    public static boolean hasFinish = false;

    public static synchronized boolean read() {
        return hasFinish;
    }

    public static synchronized void write(boolean hasFinish) {
        Finish.hasFinish = hasFinish;
    }
}
