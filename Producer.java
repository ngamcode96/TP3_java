import java.io.File;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue<String> Q;

    public Producer(BlockingQueue<String> Q) {
        this.Q = Q;
    }

    public void run() {

        try {
            File directory = new File("data");
            for (File f : directory.listFiles()) {
                this.Q.put(f.getPath());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}