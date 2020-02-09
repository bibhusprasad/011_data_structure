package s3_c2_queue;

public class LinearQueueByArrayMain {
    public static void main(final String[] args) {
        System.out.println("Creating an empty queue...");
        final LinearQueueByArray queue = new LinearQueueByArray(5);

        System.out.println("Enqueuing 6 values in the queue...");
        for (int i = 1; i <= 6; i++) {
            queue.enQueue(i * 10);
        }

        System.out.println("Peek value from queue...");
        queue.peekOperation();

        System.out.println("Dequeue 6 values from queue...");
        for (int i = 0; i <= 5; i++) {
            queue.deQueue();
        }

        System.out.println("Deleting the entire Queue...");
        queue.deleteQueue();
    }
}
