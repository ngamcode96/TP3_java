public class Buffer {
    public final static int size = 4;
    private String[] data;
    private int counter = 0;

    public Buffer() {
        this.data = new String[Buffer.size];
    }

    public boolean isEmpty() {
        return this.counter == 0;
    }

    public boolean isFull() {
        return this.counter == Buffer.size;
    }

    public synchronized void add(String S)
            throws ArrayIndexOutOfBoundsException {
        this.data[this.counter++] = S;
    }

    public synchronized String get()
            throws ArrayIndexOutOfBoundsException {
        return this.data[--this.counter];
    }
}