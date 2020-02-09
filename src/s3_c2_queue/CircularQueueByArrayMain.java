package s3_c2_queue;

public class CircularQueueByArrayMain {
    public static void main(final String[] args) {
        System.out.println("Creating an empty queue...");
        final CircularQueueByArray queue = new CircularQueueByArray(5);

        System.out.println("\nEnqueuing 5 values in the queue...");
        for (int i = 1; i <= 5; i++) {
            queue.enQueue(i * 10);
        }
        queue.printArray();
        queue.enQueue(60);
        queue.deQueue();
        queue.deQueue();
        queue.peekOperation();
        queue.enQueue(60);
        queue.printArray();
        queue.enQueue(70);
        queue.peekOperation();
        queue.enQueue(80);
        queue.printArray();
        queue.deQueue();
        queue.printArray();
        queue.deleteStack();
    }
}
