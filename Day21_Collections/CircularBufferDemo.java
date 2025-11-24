class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = 0;
        count = 0;
    }

    public void add(int x) {
        buffer[rear] = x;
        rear = (rear + 1) % size;
        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size;
        }
    }

    public void printBuffer() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }
}

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.add(4);
        cb.printBuffer(); 
    }
}
