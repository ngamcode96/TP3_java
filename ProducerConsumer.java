
public class ProducerConsumer {
    public static void main(String[] args) {

        Buffer B = new Buffer();
        Thread Prod = new Thread(new Producer(B));
        Thread Cons = new Thread(new Consumer(B));

        Cons.start();
        Prod.start();

    }
}
