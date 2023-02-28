import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<String> Q = new ArrayBlockingQueue<>(3);

        Thread Consumer1 = new Thread(new Consumer(Q, "Consumer 1"));
        Thread Consumer2 = new Thread(new Consumer(Q, "Consumer 2"));
        Thread Consumer3 = new Thread(new Consumer(Q, "Consumer 3"));
        Thread Consumer4 = new Thread(new Consumer(Q, "Consumer 4"));
        Thread Consumer5 = new Thread(new Consumer(Q, "Consumer 5"));

        Thread Prod = new Thread(new Producer(Q));

        Consumer1.start();
        Consumer2.start();
        Consumer3.start();
        Consumer4.start();
        Consumer5.start();

        Prod.start();

    }

}
