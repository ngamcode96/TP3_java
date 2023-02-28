import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private BlockingQueue<String> Q;
    private String consumerName;

    public Consumer(BlockingQueue<String> Q, String consumerName) {
        this.Q = Q;
        this.consumerName = consumerName;
    }

    public void run() {
        boolean T = (!Finish.read() && !Q.isEmpty());
        while (T) {

            try {
                String file_name = this.Q.poll(3, TimeUnit.SECONDS);
                if (file_name == null) {
                    Finish.write(true);
                    break;
                }
                String res = new BigInteger(1, Digest.md5(file_name)).toString(16);
                System.err.println("[" + this.consumerName + "] " + file_name + " : " + res);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}