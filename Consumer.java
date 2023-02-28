public class Consumer implements Runnable {
    private Buffer B;

    public Consumer(Buffer B) {
        this.B = B;
    }

    public void run() {
        while (true) {
            synchronized (B) {
                while (!B.isFull()) {
                    try {
                        B.wait();
                    } catch (InterruptedException E) {
                        System.out.println(E);
                    }
                }
                for (int i = 1; i <= Buffer.size; i++) {
                    System.out.println("[receive] " + B.get());
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException E) {
                    }
                }
                B.notifyAll();
            }
        }
    }
}