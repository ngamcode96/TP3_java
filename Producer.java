class Producer implements Runnable {
    private Buffer B;

    public Producer(Buffer B) {
        this.B = B;
    }

    public void run() {
        int n = 0;
        while (true) {
            synchronized (this.B) {
                while (!B.isEmpty()) {
                    // Wait until being notified
                    try {
                        B.wait();
                    } catch (InterruptedException E) {
                        System.out.println(E);
                    }
                }
                for (int i = 1; i <= Buffer.size; i++) {
                    n++;
                    System.out.println("[sending] Message " + n);
                    this.B.add("Message " + n);
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException E) {
                    }
                }
                B.notifyAll();
            }
        }
    }
}